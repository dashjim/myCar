package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.GasRcd;
import model.User;

import org.apache.log4j.Logger;

import service.GasRecordsService;
import service.UserService;
import service.exceptions.UserAlreadyExistException;
import service.interfaces.UserServiceI;
import service.tool.Cfg;
import service.tool.CookieHelper;
import service.tool.PrintMap;

/**
 * Servlet implementation class for Servlet: UserService
 *
 */
 public class UserFace extends javax.servlet.http.HttpServlet {
	 
	/**
	 * <code>serialVersionUID</code> ��ע��
	 */
	private static final long serialVersionUID = 1L;
	public static Logger log = Logger.getRootLogger();
	
	public UserFace() {
		super();
	}   	
	
	/**
	 * login from cookie
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void doCookieLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String namePwd = CookieHelper.getNamePwdCookie(request, response);
		log.debug("try to login form cookie: name and pwd:" + namePwd);
		
		String[] namePwdArray = namePwd.split(CookieHelper.COOKIE_SPLITER);
		request.setAttribute("userName", namePwdArray[0]);
		request.setAttribute("userPwd", namePwdArray[1]);
		doPost(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}  	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String action = request.getParameter("action");
		String requestCreatNewUser = request.getParameter("createNewUser");
		
		//TODO bellow log not work create
		log.debug("login request perameter: "+PrintMap.print(request.getParameterMap()));
		//check submit info
		User user = new User();
		
		String userName =request.getParameter("name");
		String pwd =request.getParameter("pwd");
		
		if (userName == null || "".equals(userName))
		{
			/** try to login form cookie*/
			userName = (String) request.getAttribute("userName");
			pwd = (String) request.getAttribute("userPwd");
			action = "login";
		}
		user.setName(userName);
		user.setPwd(pwd);
		
		if ("newUser".equalsIgnoreCase(requestCreatNewUser)){
			if (checkLoginInfoComplet(user))	{
				creatNewUser(user, request, response);
			}else {	gotoLoginWithMsg(getServletContext(), request, response, "请重试");	}
		}else if("login".equals(action)){//request to log in
			if (checkLoginInfoComplet(user))	{
				doLogin(request, response, userName, pwd);
			}else {	gotoLoginWithMsg(getServletContext(), request, response, "请重试");	}
		}else if ("forwardToInput".equals(action) && isUserLogin(request)) {//request from header url to Input page
			forwardToInput(request, response, (User)request.getSession().getAttribute(Cfg.JSP.LOGIN_USER_VO), request.getSession());
		}else{
			gotoLoginWithMsg(getServletContext(), request, response, "出错了！");//
			log.error("no action para, or not login");
		}
	}
	
	private boolean checkLoginInfoComplet(User user) {
		if (null == user.getName() || "".equalsIgnoreCase(user.getName()) || null == user.getPwd() || "".equalsIgnoreCase(user.getPwd()))
		{
			log.info("user login info not complete: "+user.getName()+" :: "+user.getPwd());
			return false;
		}
		return true;
	}
	private boolean creatNewUser(User user, HttpServletRequest request, HttpServletResponse response)
	{
		log.info("try to create new user with name: "+ user.getName());
		UserServiceI userService = UserService.getSingleton();
		boolean isUserCreated = false;
		try
		{
			isUserCreated = userService.registNewUser(user);
		} catch (UserAlreadyExistException e)
		{//error here
			gotoLoginWithMsg(getServletContext(), request, response, "�û���ռ�ã�");
			log.info("creat new user: name conflict");return false;			
		}catch (Exception e) {
			log.error("not able to recover the error when create new user, will forward them to error page, with error msg",e);
			gotoLoginWithMsg(getServletContext(), request, response, "����ˣ����ǻᾡ���޸���");return false;}
		if (!isUserCreated)
		{
			log.error("not able to recover the error when create new user, will forward them with error msg");
			gotoLoginWithMsg(getServletContext(), request, response, "����ˣ����ǻᾡ���޸���");return false;		
		}
		//success here
		gotoLoginWithMsg(getServletContext(), request, response, "��ϲ�����û������ɹ������¼��");
		return true;
	}

	/**
	 * help method can be used by outside
	 * @param req
	 * @return
	 */
	public static boolean isUserLogin(HttpServletRequest req)
	{
		User u = (User)req.getSession().getAttribute(Cfg.JSP.LOGIN_USER_VO);
		return u!= null? true:false;
	}

	private void doLogin(HttpServletRequest request, HttpServletResponse response, String name, String pwd) throws IOException
	{
		UserServiceI userService = UserService.getSingleton();
		User user = userService.loginUserByName(name, pwd);
		if (null != user)//login successfully
		{
			log.info("login successfully form ip:" +request.getLocalAddr() + " user name: " + request.getParameter("name"));
			HttpSession session = request.getSession();
			session.setAttribute(Cfg.JSP.LOGIN_USER_VO, user);
			
			CookieHelper.setNamePwdCookie(request, response, name, pwd);
			
			// bellow is to decide where to go. To show the rcd history or enter input page.
			if ("input".equals(request.getParameter("loginTarget")))
			{
				forwardToInput(request, response, user, session);
			}else if ("show".equals(request.getParameter("loginTarget")))
			{
				response.sendRedirect(request.getContextPath() + Cfg.SERVLET.NAME_REPORT);
			}else {
				forwardToInput(request, response, user, session);
			}
			
		}else {//login error
			gotoLoginWithMsg(getServletContext(), request, response, "出错了！请重试。");
		}
	}

	private void forwardToInput(HttpServletRequest request,
			HttpServletResponse response, User user, HttpSession session)
			throws IOException
	{
		//get historical data to facilitate the input.
		GasRecordsService rcdService = GasRecordsService.getSingleton();
		GasRcd lastRcd = rcdService.getLastRcdForUserID(user.getId());
		
		session.setAttribute(Cfg.JSP.LAST_RCD_VO, lastRcd);
		
		/*forward to gas input page
		 * the jsp will use jsp EL to show the data.
		 */
		response.sendRedirect(request.getContextPath() + Cfg.JSP.PAGE_INPUT_RCD);
	}
	
	/**
	 * TODO let jsp EL to use the from bean to display history data.
	 * @param context
	 * @param request
	 * @param response
	 * @param msg
	 * @throws IOException
	 */
	public static void gotoLoginWithMsg(ServletContext context, HttpServletRequest request,
			HttpServletResponse response, String msg)
	{
		log.info("login error form ip:" +request.getLocalAddr() + " user name: " + request.getParameter("name"));
		//forward to another page
		try
		{
			request.setAttribute("errorMsg", msg);
			context.getRequestDispatcher(Cfg.JSP.PAGE_LOGIN).forward(request, response);
		} catch (Exception e)
		{
			log.error("can not dispatch the request to error page", e);
			try
			{
				response.sendError(500);//TODO send to error page not response 500 here
			} catch (IOException e1)
			{
				log.error("can not send 500", e1);
			}
		}
	}   	  	    
}