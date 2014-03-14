package servlet.www;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CarBean;
import model.formVO.CarQueryObj;

import org.apache.log4j.Logger;
import org.eclipse.jdt.internal.compiler.ast.ThisReference;
import org.json.HTTP;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.ibatis.common.util.PaginatedList;

import service.FindCarService;
import service.tool.BeanUtilsWrap;
import service.tool.PrintMap;

/**
 * Servlet implementation class ListCar
 */
public class ListCarFace extends HttpServlet {
	private static final String PRVIOUS_PAGE = "prvious";
	private static final String NEXT_PAGE = "next";
	private static final long serialVersionUID = 1L;
	private Logger log = Logger.getLogger(this.getClass());
	
	//MVC config
	public static final String LSIT_CAR_JSP = "/w/listCar.jsp"; 
	public static final String SERVERT_PATH = "/ListCar"; 
	public static final String ACTION_NAME = "action"; 
    public static final String ACTION_VALUE_LIST = "list"; 
    //get car names according to the car producer name.
    public static final String ACTION_VALUE_GETCARS = "getcars"; 
    public static final String ACTION_VALUE_INIT = "init";
    
    // domain constant
	public static final String PRODUCER_NAMES = "producerNames";
	public static final String CAR_NAMES = "carNames";
	private static final String RESULT_CAR_LIST = "listResult";
	private static final String PAGE = "page"; 
	
    /**
     * @see HttpServletHttpServlet()
     */
    public ListCarFace() {
        super();
    }

	/**
	 * @see HttpServletdoGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * Actions here: 
	 * init -- display first page
	 * list -- sort
	 * 
	 * @see HttpServletdoPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter(ACTION_NAME);
		log.debug("enter doPost >>"+action);
		if (ACTION_VALUE_INIT.equalsIgnoreCase(action)) //init
		{
			initAction(request, response);	
			this.getServletContext().getRequestDispatcher(LSIT_CAR_JSP).forward(request, response);
		}else if (ACTION_VALUE_LIST.equalsIgnoreCase(action)) {
			listCarAction(request, response);
		}else if (ACTION_VALUE_GETCARS.equalsIgnoreCase(action)) {
			getCarNamesAction(request, response);
		}else {//default
			initAction(request, response);
			this.getServletContext().getRequestDispatcher(LSIT_CAR_JSP).forward(request, response);
		}
		log.debug("exist doPost to <<"+LSIT_CAR_JSP);
	}


	/**
	 * get car names according to the car producer name.
	 * TODO currently the query will get to much data then needed, we can use a specific SQL to increase the performance.
	 * @param request
	 * @param response
	 */
	private void getCarNamesAction(HttpServletRequest request,
			HttpServletResponse response)
	{
		CarQueryObj qo = new CarQueryObj();
		BeanUtilsWrap.populate(qo, request.getParameterMap());
		
		try	{
			qo.setProdcerName(java.net.URLDecoder.decode(qo.getProdcerName(),"UTF-8"));
			log.debug("utf8 decode: "+ qo.getProdcerName());
			
		} catch (UnsupportedEncodingException e2){log.error("could not encode: "+e2.toString());	}

		//TODO one instance here?
		FindCarService carService = new FindCarService();
		String[] resultList = null;
		try{
			resultList = carService.queryCarNames(qo);
		} catch (SQLException e)
		{
			log.error("DAO error while get the car names for: "+qo.getProdcerName()+e);
			try	{response.sendError(404);} catch (IOException e1){}
		}
		try	{
		JSONArray jsonArray = new JSONArray(resultList);
			response.getWriter().write(jsonArray.toString());
		} catch (Exception e)	{	log.error("could not send json response: "+e.toString());}
		
	}

	private void listCarAction(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		log.debug("enter listCarAction>>");
		CarQueryObj qo = new CarQueryObj();
		BeanUtilsWrap.populate(qo, request.getParameterMap());

		log.debug("list car form value:"+ new JSONObject(qo).toString());
		
		FindCarService carService = new FindCarService();
		PaginatedList resultCarList = null;
		if (NEXT_PAGE.equals(request.getParameter(PAGE)))//not fist time
		{
			resultCarList = (PaginatedList) request.getSession().getAttribute(RESULT_CAR_LIST);
			resultCarList.nextPage();
		} else if(PRVIOUS_PAGE.equals(request.getParameter(PAGE)))//not first time 
		{
			resultCarList = (PaginatedList) request.getSession().getAttribute(RESULT_CAR_LIST);
			resultCarList.previousPage();
		}else {//first time
			try
			{
				resultCarList = carService.queryCar(qo, qo.getPageSize());
				request.getSession().setAttribute(RESULT_CAR_LIST, resultCarList);
				if (resultCarList!= null)
				{
					log.debug("query result number: "+resultCarList.size());
				}
			} catch (SQLException e)
			{
				log.error("could not query car according to form input: ",e);
			}
		}
		try
		{
			JSONArray jsonArray = new JSONArray(resultCarList);
			//jsonArray.put(new TreeMap<String, Boolean>().put("isLastPage", resultCarList.isLastPage()));
			//jsonArray.put(new TreeMap<String, Boolean>().put("isFirstPage", resultCarList.isFirstPage()));
			
			log.debug("exsit listCarAction<<");
			response.getWriter().append(jsonArray.toString(2));
		} catch (JSONException e)
		{
			e.printStackTrace();
		}
		//response.getWriter().append(PrintMap.print(BeanUtilsWrap.describe(qo)));
	}

	private void initAction(HttpServletRequest request, HttpServletResponse response)
	{	
		log.debug("enter initAction>>");
		//application scope to offer a cross session cache!
		ServletContext application = this.getServletContext();
		String[] producerNames = (String[]) application.getAttribute(PRODUCER_NAMES);
		String[] carNames = (String[]) application.getAttribute(CAR_NAMES);
		
		if (producerNames==null && carNames== null)
		{	
			//not in cache
			log.debug("not in application cache");
			FindCarService carService = new FindCarService();
			producerNames = carService.getProducerNames();
			carNames = carService.getCarNames();
			log.debug("carName example: " + carNames[1]);
			application.setAttribute(PRODUCER_NAMES, producerNames);
			application.setAttribute(CAR_NAMES, carNames);
			request.setAttribute(PRODUCER_NAMES, producerNames);
			request.setAttribute(CAR_NAMES, carNames);
		}
		else
		{
			//in cache
			log.debug("has values in cache");
			request.setAttribute(PRODUCER_NAMES, producerNames);
			request.setAttribute(CAR_NAMES, carNames);
		}
		log.debug("exist initAction<<");
	}

}
