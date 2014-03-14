package dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.User;

import com.ibatis.sqlmap.client.SqlMapClient;

import dao.config.DaoClient;

public class UserDAO{

	/**
	 * SqlMapClient instances are thread safe, so you only need one. In this
	 * case, we'll use a static singleton. So sue me. ;-)
	 */
	private static SqlMapClient sqlMapper = DaoClient.getSqlMapInstance();

	@SuppressWarnings("unchecked")
	public static List<User> selectUsers() throws SQLException {
		
		return sqlMapper.queryForList("Users.selectUsers");
	}

	public static User selectUserById(int id) throws SQLException {

		return (User) sqlMapper.queryForObject("Users.selectUserById", id);
	}
	
	/**
	 * Should be successful if no exception.
	 * @param user
	 * @throws SQLException
	 */
	public static void creatOneUser(User user) throws SQLException {
		
		sqlMapper.insert("Users.creatOneUser",user);
	}
	
	public static void deleteOneUserById(int id) throws SQLException{
		
		if (selectUserById(id)!= null) {
			sqlMapper.delete("Users.deleteOneUserById", id);
		} else {
			throw new SQLException("no such user id to delete");
		}
	}

	public static User findUserByName(String name) throws SQLException {
		return (User) sqlMapper.queryForObject("Users.findUserByName", name);
	}
	
	public static Integer countUserByName(String name) throws SQLException {
		return (Integer) sqlMapper.queryForObject("Users.countUserByName", name);
	}
	
	
	/**
	 * TODO: need cache it!!!
	 * TODO: untested.
	 * @param fromNumber
	 * @param count
	 * @return
	 * @throws SQLException
	 */
	@SuppressWarnings("unchecked")
	public static List<User> findLastUpdatedUsers(int fromNumber, int count) throws SQLException {
		
		Map<String, Integer> paraMap = new HashMap<String, Integer>();
		paraMap.put("fromNumber", fromNumber);
		paraMap.put("count", count);
		
		return (List<User>) sqlMapper.queryForList("Users.findLastUpdatedUsers", fromNumber, count);
	}
	
	
}
