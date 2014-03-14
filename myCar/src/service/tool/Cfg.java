/*
 * 创建日期 2009-6-20
 *
 */
package service.tool;

public class Cfg
{
	/**
	 * to paginate the records
	 */
	public static final int GAS_RCD_LIST_SIZE = 8; 
	
	/**
	 * value to decide if user forget to input one/more record before.
	 */
	public static final int VALUE_TO_DECIDE_IF_OMMIT = 20;
	
	public static class JSP
	{
		/**
		 * session use
		 */
		public static final String LOGIN_USER_ID = "loginUserID";
	
		/**
		 * session use
		 */
		public static final String LOGIN_USER_VO = "loginUserVO";
		
		/**
		 * session use
		 */	
		public static final String REPORT_VO = "reportVO";
		
		/**
		 * session use
		 */
		public static final String RCD_VO_LIST = "rcdVOList";
		
		public static final String LAST_RCD_VO = "lastRcdVO";// the rcd the user last enters.
		public static final String PAGE_INPUT_RCD = "/m/inputRcd.jsp";
		public static final String PAGE_REPORT = "/m/report.jsp";
		public static final String PAGE_TWOLINKCHART = "/m/twolinechart.jsp";
		public static final String PAGE_LOGIN = "/m/login.jsp";
		public static final String PAGE_HELP= "/m/help.jsp";
		public static final String PAGE_404= "/m/404.jsp";
	}
	
	public static class SERVLET
	{
		public static final String NAME_REPORT= "/ReportFace";
		public static final String NAME_GAS_FACE= "/GasFace";
		public static final String NAME_USER_FACE= "/UserFace";
		public static final String NAME_REPORT_TWOLINE_CHART= "/ReportFace?chartType=twoLine";
	}
}
