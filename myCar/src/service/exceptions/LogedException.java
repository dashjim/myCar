/*
 * 创建日期 2009-7-15
 *
 */
package service.exceptions;

import org.apache.log4j.Logger;

public class LogedException extends Exception
{

	public LogedException(Class clazz, String msg)
	{
		super(msg);
		Logger log = Logger.getLogger(clazz);
		//TODO getMessage may not contain the stack trace.
		log.error(msg + " : "+ getMessage());
	}
}
