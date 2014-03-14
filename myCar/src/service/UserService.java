/*
 * 创建日期 2009-3-21
 */
package service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;

import model.User;
import service.exceptions.UserAlreadyExistException;
import service.interfaces.UserServiceI;

import com.thoughtworks.xstream.XStream;

import dao.UserDAO;

/**
 *	for login and something related with the user action. <br>
 *	
 * 	Contain all the methods which not belong to DB operation.
 * @author CofeMate
 *
 */
public class UserService implements UserServiceI {
	public static Logger log = Logger.getRootLogger();
	/**
	 * 
	 */
	public UserService() {
	}
	
	static private UserService obj = new UserService() ;
	
	//TODO need to use a safer singleton implementation
	static public UserService getSingleton(){ return obj;}
	
	public Boolean hasUserByID(String id) {
		//findUserByName(name);
		return null;
	}
	
	/**
	 * TODO: PWD can not be null;
	 * @param name
	 * @param pwd
	 * @return the User if login Successfully, and null if fail
	 */
	public User loginUserByName(String name, String pwd) {

		if (name == null || pwd == null) {return null;}
		
		try {
			User u = UserDAO.findUserByName(name);
			if (u != null) {
					return u.getPwd().equals(pwd)?u:null;		//pwd matchs or not
			} else {									//no such user at all		
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * this is a test
	 * @param xml
	 * @return
	 */
	public User getUserFromXML(String xml) {
		
		XStream xstream = new XStream();
		xstream.alias("user", User.class);
		return (User)(xstream.fromXML(xml));
	}


	public boolean isUserExsits(String name) throws UserAlreadyExistException, SQLException {
		if (name == null || "".equalsIgnoreCase(name))
		{
			log.info("no user name to check. need a user name.");
			throw new UserAlreadyExistException("isUserExsits: need a user name");
		}
		return (Integer)UserDAO.countUserByName(name)>0 ? true: false;
	}


	public boolean logOutUserByName(String name) {
		// TODO 自动生成方法存根
		return false;
	}
	
	/**
	 * Currently alow a user to regist with only a user name and id
	 * the user.carID is set to -1 to avoid db error.
	 * return return if success.
	 * TODO check has pwd and user name length
	 */
	public boolean registNewUser(User user) throws UserAlreadyExistException, SQLException {
		
		if (null == user.getName() || "".equalsIgnoreCase(user.getName()) || null == user.getPwd() || "".equalsIgnoreCase(user.getPwd()))
		{
			throw new SQLException("user information not complete");
		}
		
		if (isUserExsits(user.getName()))
		{
			log.info("registNewUser: user Exsit");
			throw new UserAlreadyExistException("user name conflict");
		}
		//to avoid db error
		if (user.getCarID() == null ||"".equalsIgnoreCase(user.getCarID()))	{user.setCarID("-1");}
		try
		{
			UserDAO.creatOneUser(user);
		} catch (SQLException e)
		{
			log.error("db error while create new user: ",e);
			throw e;
		}
		return true;
	}

	public List<String> getRecentUpdatedUsers(int lineNumber)
	{
		// TODO 自动生成方法存根
		return null;
	}

	public boolean updateUserProp(User user)
	{
		// TODO 
		return false;
	}
	
}
