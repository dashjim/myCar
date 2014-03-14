/*
 * 创建日期 2009-7-12
 * TODO how to split the report calculate logic to another class. 
 */
package servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.GasRcd;
import model.Report;
import model.User;

import org.apache.activemq.command.Response;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;

import service.CalculatingService;
import service.GasRecordsService;
import service.ReportServeice;
import service.exceptions.LogedException;
import service.tool.BeanUtilsWrap;
import service.tool.Cfg;

public class GasFace extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	public static Logger log = Logger.getRootLogger();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{
		doPost(req, resp);
	}
	
	private final ReportServeice reportServeice = ReportServeice.getSingleton();
	private final GasRecordsService recordsService = GasRecordsService.getSingleton();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{
		if ("input".equals(req.getParameter("action")))
			saveGasRcd(req, resp);
		else
			req.getRequestDispatcher(Cfg.JSP.PAGE_404).forward(req, resp);
	}

	private CalculatingService calculat = CalculatingService.getSingleton();
	
	private void saveGasRcd(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException
	{
		User userVO = (User) req.getSession().getAttribute(Cfg.JSP.LOGIN_USER_VO);
		if (userVO != null && userVO.getId() > 0)
		{
			GasRcd gasRcd = new GasRcd();
			try //populate form to Bean
			{
				new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("fueledTimeString"));
				BeanUtils.populate(gasRcd, req.getParameterMap());
				log.debug("isFull value and from bean:" + req.getParameter("isFull")+ BeanUtilsWrap.describe(gasRcd));
				
				gasRcd.setUserId(userVO.getId());
				GasRcd lastGasRcd = (GasRcd) req.getSession().getAttribute(Cfg.JSP.LAST_RCD_VO);
				
				if(simpleCheckFormData(req, gasRcd, lastGasRcd)== false) 
					formBeanError("出错了！<a href=\""+req.getContextPath()+Cfg.JSP.PAGE_HELP+"\">查看帮助？</a>", req, resp, new LogedException(this.getClass(),"wrong form data for gas input!"));

				//we've finished data check and prepare
				else {
					startCalculateAll(req, resp, userVO, gasRcd, lastGasRcd);
				}
			} catch (Exception e){
				log.error("parse date error!" , e);
				formBeanError("出错啦：请检查输入的数据是否有误！<a href=\""+req.getContextPath()+Cfg.JSP.PAGE_HELP+"\">查看帮助？</a>", req, resp, e);
			} 
		}else {
			log.info("not login but try to input gas record!");
			UserFace.gotoLoginWithMsg(getServletContext(), req, resp, "你还没登录吗？");
		}
	}

	private void startCalculateAll(HttpServletRequest req,
			HttpServletResponse resp, User userVO, GasRcd gasRcd,
			GasRcd lastGasRcd) throws IOException
	{
		//lastfueledtime字段保留字段
		//TODO gasRcd.setLastFueledTime(lastGasRcd.getFueledTime());				
		
		//prepare data for calculating the report value.
		
		//start calculating the report value
		Report report = calculat.calculateReport(userVO.getId(), gasRcd, lastGasRcd);
		//if (null == report) noDataError(req, resp, gasRcd);
		
		//statrt calculating the GasRcd value
		calculat.calculatLPMForGasRcd(userVO.getId(), gasRcd, lastGasRcd);
		
		//update lastRcd in session
		req.getSession().setAttribute(Cfg.JSP.LAST_RCD_VO, gasRcd);
		//......and then save it to DB and forward it to page.
		resp.sendRedirect(req.getContextPath()+Cfg.SERVLET.NAME_REPORT);
	}
	
	/**
	 * do not check business logic.
	 * @param req
	 * @return
	 */
	private boolean simpleCheckFormData(HttpServletRequest req, GasRcd rcd, GasRcd lastRcd)
	{
		// TODO check the data types 
		log.debug("simpleCheckFormData"+ BeanUtilsWrap.describe(rcd));
		log.debug("simpleCheckFormData"+BeanUtilsWrap.describe(lastRcd));

		//NOT the first rcd 
		if (lastRcd != null && lastRcd.getId() >1 )
		{
			log.debug("user not first enter rcd");
			if (Math.abs(lastRcd.getTotalDistance() - rcd.getTotalDistance())< 20)
				return false;
		}else {
			log.info("user first enter rcd ");
		}
			
		//Check not null TODO return specific error msg here
		if (req.getParameter("fueledVolum") == null ||
				req.getParameter("isFull") == null ||
				req.getParameter("lastDistance") == null ||
				req.getParameter("totalDistance") == null||
				req.getParameter("money") == null)//for total fee.
		return false;//error
		else 
		return true;//no problem
	}

 
	@SuppressWarnings("unchecked")
	private void formBeanError(String msg, HttpServletRequest req,
			HttpServletResponse resp, Exception e)			
	{
		String param = new String();
		log.error("param number..." + req.getParameterMap().size());
		
		for (Enumeration<String> names = req.getParameterNames(); names.hasMoreElements() ;) 
		{
			String theName = names.nextElement();
			param += "\n>>>"+theName+ "<<<" + "::" + req.getParameter(theName);
		}
		
		log.error("error when populate the request para to form bean: " +param, e);
		req.setAttribute("errorMsg", msg);
		try
		{
			getServletContext().getRequestDispatcher(Cfg.JSP.PAGE_INPUT_RCD).forward(req, resp);
		} catch (Exception e1)
		{
			log.error("could not forward to inputRcd.jsp" + e1);
			try
			{
				resp.sendError(404);
			} catch (IOException e2){
				log.error("could not response 404" + e2);
			}
		}
	}
}
