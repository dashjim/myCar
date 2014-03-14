/*
 * �������� 2009-7-13
 *
 */
package servlet;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Report;
import model.User;

import org.apache.log4j.Logger;

import service.GasRecordsService;
import service.ReportServeice;
import service.tool.BeanUtilsWrap;
import service.tool.Cfg;

import com.ibatis.common.util.PaginatedList;

@SuppressWarnings("deprecation")
public class ReportFace extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	static Logger log = Logger.getLogger(ReportFace.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) { doPost(req, resp);}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	{
		if ("deleteLastInput".equals(req.getParameter("action"))) {
			
			//delete last one
			User userVO = (User) req.getSession().getAttribute(Cfg.JSP.LOGIN_USER_VO);
			if(userVO==null)UserFace.gotoLoginWithMsg(getServletContext(), req, resp, "请登录");
			else {
				log.debug("enter deleteLastInput");
				GasRecordsService recordsService = GasRecordsService.getSingleton();
				recordsService.deleteLastInputForUid(userVO.getId());
				try
				{
					resp.sendRedirect(req.getContextPath()+Cfg.SERVLET.NAME_REPORT);
				} catch (IOException e)
				{
					e.printStackTrace();
				}
			}
		}
		//chartType is in the url -- /ReportFace?chartType=twoLine
		boolean willGoToTwoLineChart = "twoLine".equalsIgnoreCase(req.getParameter("chartType"))?true:false;
		//user login check 
		//TODO make it a filter!
		User userVO = (User) req.getSession().getAttribute(Cfg.JSP.LOGIN_USER_VO);
		if (userVO == null || userVO.getId() <= 0) 
		{
			log.info("not login but try to list gas record!");
			UserFace.gotoLoginWithMsg(getServletContext(), req, resp, "请登录！");
		}else 
		{// user is log in 
			if ("previous".equals(req.getParameter("pageDirection")))
			{
				PaginatedList list = (PaginatedList) req.getSession().getAttribute(Cfg.JSP.RCD_VO_LIST);
				list.previousPage();
			}else if ("next".equals(req.getParameter("pageDirection")))
			{
				PaginatedList list = (PaginatedList) req.getSession().getAttribute(Cfg.JSP.RCD_VO_LIST);
				list.nextPage();
			}else {// the first time request
				doList(userVO, req, resp);
			}
			if (willGoToTwoLineChart){
				forwardToTwoLineChart(req,resp);
			}else {	forwardToReportPage(req, resp);	}
		}
	}

	/**
	 * get user records and reports and list in page
	 * @param req
	 * @param resp
	 */
	private void doList(User user, HttpServletRequest req, HttpServletResponse resp)
	{
		log.debug("user bean in session: "+ BeanUtilsWrap.describe(user));
		ReportServeice reportServeice = ReportServeice.getSingleton();
		GasRecordsService gasRecordsService = GasRecordsService.getSingleton();
		
		Report report = reportServeice.getLastReportForUserID(user.getId());
		PaginatedList paginatedList = gasRecordsService.getRcdsForUID(user.getId(), Cfg.GAS_RCD_LIST_SIZE);
		
		if (report == null)	report = new Report();//for new user.
		
		log.debug("the Report to be listed in jsp: " + BeanUtilsWrap.describe(report));
		
		req.getSession().setAttribute(Cfg.JSP.REPORT_VO, report);
		req.getSession().setAttribute(Cfg.JSP.RCD_VO_LIST, paginatedList);
	}

	private void forwardToReportPage(HttpServletRequest req, HttpServletResponse resp)
	{
		try
		{
			getServletContext().getRequestDispatcher(Cfg.JSP.PAGE_REPORT).forward(req, resp);
		} catch (Exception e)
		{
			log.error("could not forward"+e);
		}
	}
	
	private void forwardToTwoLineChart(HttpServletRequest req,
			HttpServletResponse resp)
	{
		try	{
			getServletContext().getRequestDispatcher(Cfg.JSP.PAGE_TWOLINKCHART).forward(req, resp);
		} catch (Exception e){
			log.error("could not forward"+e);
		}
	}

}

//TODO not login check
//TODO pagination
//TODO list report.


