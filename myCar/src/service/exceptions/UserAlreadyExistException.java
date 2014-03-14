/*
 * 创建日期 2010-6-5
 *
 */
package service.exceptions;

public class UserAlreadyExistException extends Exception
{
	public UserAlreadyExistException(String msg)
	{
		super(msg);
	}
}
