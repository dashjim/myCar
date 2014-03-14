/*
 * 创建日期 2010-7-7
 *
 */
package service.tool;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;

//TODO should be able to delete cookie when logout.
public class CookieHelper
{
	static int MAX_AGE = 60 * 60 * 24 * 365;
	static public String COOKIE_SPLITER = ">>"; 
	static private Logger log = Logger.getLogger(CookieHelper.class);
	/*
	 * 写cookie
	 */
	static public void setNamePwdCookie(HttpServletRequest request,
			HttpServletResponse response, String name, String password)
	{
		try
		{
			name = java.net.URLEncoder.encode(name, "UTF-8");
		} catch (UnsupportedEncodingException e)
		{
			log.error("could not encode cookie: ",e);
		}
		Cookie namecookie = new Cookie("name", name);
		Cookie passwordcookie = new Cookie("password", password);
		// Cookie optioncookie = new Cookie("option","1");

		// 生命周期
		namecookie.setMaxAge(MAX_AGE);
		passwordcookie.setMaxAge(MAX_AGE);
		// optioncookie.setMaxAge(60*60*24*365);

		response.addCookie(namecookie);
		response.addCookie(passwordcookie);
		// response.addCookie(optioncookie);
	}

	/*
	 * 读cookie
	 * return would be -- name+">>"+password -- or null
	 */
	public static String getNamePwdCookie(HttpServletRequest request,
			HttpServletResponse response)
	{
		Cookie[] cookies = request.getCookies();
		if (cookies != null)
		{
			String name = "";
			String password = "";
			String option = ""; //not use for now
			for (int i = 0; i < cookies.length; i++)
			{
				Cookie c = cookies[i];
				if (c.getName().equalsIgnoreCase("name"))
				{
					name = c.getValue();
					try
					{
						name = java.net.URLDecoder.decode(name, "UTF-8");
					} catch (UnsupportedEncodingException e)
					{
						log.error("could not decode cookie: ", e);
					}
					
				} else if (c.getName().equalsIgnoreCase("password"))
				{
					password = c.getValue();
				} else if (c.getName().equalsIgnoreCase("option"))
				{
					option = c.getValue();
				}
			}
			return name+COOKIE_SPLITER+password;
		}
		return null;
	}
	
	public static void deleteCookie(HttpServletRequest request, HttpServletResponse response) {

		Cookie[] cookies = request.getCookies();
		if (cookies != null)
		{
			for (int i = 0; i < cookies.length; i++)
			{
				Cookie c = cookies[i];
				c.setMaxAge(0);
				response.addCookie(c);
			}
			
		}
	}
}
