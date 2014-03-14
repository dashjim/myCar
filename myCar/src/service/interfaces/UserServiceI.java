/*
 * �������� 2009-6-7
 *
 * TODO Ҫ���Ĵ����ɵ��ļ���ģ�壬��ת��
 * ���� �� ��ѡ�� �� Java �� ������ʽ �� ����ģ��
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
