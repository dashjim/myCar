/*
 * 创建日期 2009-6-7
 *
 * TODO 要更改此生成的文件的模板，请转至
 * 窗口 － 首选项 － Java － 代码样式 － 代码模板
 */
package service.interfaces;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import service.exceptions.UserAlreadyExistException;

import model.User;

public interface UserServiceI {
	
	public User loginUserByName(String name, String pwd);
	
	public boolean logOutUserByName(String name);
	
	public boolean registNewUser(User user) throws UserAlreadyExistException, SQLException;
	
	public boolean isUserExsits(String name) throws Exception;
	
	public boolean updateUserProp(User user);
	
	public List<String> getRecentUpdatedUsers(int lineNumber);
}
