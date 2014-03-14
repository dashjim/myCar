/*
 * 创建日期 2010-7-4
 *
 */
package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.UnavailableException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import model.User;
import service.tool.Cfg;
import servlet.UserFace;

public class EncodingFilter implements Filter
{
	protected String encoding = null;
	protected FilterConfig filterConfig = null;
	public static Logger log = Logger.getRootLogger();
	public void destroy()
	{
		this.encoding = null;
		this.filterConfig = null;
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException
	{
		// Select and set (if needed) the character encoding to be used
		String encoding = selectEncoding(request);
		if (encoding != null)
		{
			request.setCharacterEncoding(encoding);
			response.setCharacterEncoding(encoding);
		}
		//loginFilter(request, response);
		// Pass control on to the next filter
		chain.doFilter(request, response);
	}

	public void init(FilterConfig filterConfig) throws ServletException
	{
		this.filterConfig = filterConfig;
		this.encoding = filterConfig.getInitParameter("encoding");
	}

	protected String selectEncoding(ServletRequest request)
	{
		return (this.encoding);
	}
	
	/**
	 * TODO more work here
	 * @param request
	 * @param response
	 * @return
	 */
	public int loginFilter(ServletRequest request, ServletResponse response) {
		//TODO make it a filter!
		HttpServletRequest rqst= (HttpServletRequest)request;
		HttpServletResponse rsps = (HttpServletResponse)response;
		if (rqst.getRequestURL().indexOf("login.jsp")>0)
		{
			log.debug("filte: to login page, let it go.");
			return 1;
		}
		User userVO = (User) rqst.getSession().getAttribute(Cfg.JSP.LOGIN_USER_VO);
		if (userVO == null || userVO.getId() <= 0) 
		{
			log.info("from filter: not login!");
			try
			{
				rsps.sendRedirect(rqst.getContextPath() + Cfg.JSP.PAGE_LOGIN);
			} catch (IOException e)
			{
				log.error("could not redirect to login page: "+e);
			}
		}
		return 0;
	}
	
}
