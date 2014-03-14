/*
 * 创建日期 2009-3-27
 *
 * TODO 要更改此生成的文件的模板，请转至
 * 窗口 － 首选项 － Java － 代码样式 － 代码模板
 */
package test.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.*;
import java.sql.SQLException;
import java.util.Date;

import model.User;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import service.UserService;
import service.exceptions.UserAlreadyExistException;

public class UserServiceTest {

	private UserService userService = null;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testLoginUserByName() {
		
		userService = UserService.getSingleton();
		System.out.println("testLoginUserByName>> "+userService.loginUserByName("guest", "aa"));
		assertEquals("dashJim@gmail.com", userService.loginUserByName("junxiang", "aa").getEmail());
	}
	
	@Test
	public void testRegistNewUser() throws UserAlreadyExistException, SQLException {
		userService = UserService.getSingleton();
		User user = new User();
		user.setName("test"+new Date().getMinutes());
		user.setPwd("aa");
	//	user.setCarID("1");
		assertTrue(userService.registNewUser(user));
		assertFalse(userService.registNewUser(user));
	}
	
	@Test
	public void testIsUserExsits() throws UserAlreadyExistException, SQLException {
		userService = UserService.getSingleton();
		assertTrue(userService.isUserExsits("Guest"));
		assertFalse(userService.isUserExsits("nobody"));
	}
	
	@Test
	public void testLoginUserByNameFails() {
		
		userService = UserService.getSingleton();
		assertNull(userService.loginUserByName("nobody", ""));
	}
	
	@Test
	public void testLoginUserByNameFailsWrongPWD() {
		
		userService = UserService.getSingleton();
		assertEquals(null,userService.loginUserByName("junxinag", ""));
	}
	
	@Test
	public void testGetUserFromXML() throws SQLException {
		
//		String xml = 
//			"<user>" +
//				"<name>junxiang</name>" +
//				"  <email>dashJim@gmail.com</email>" +
//				"  <carID>20</carID>" +
//				"  <img>some/url/234.img</img>" +
//				"  <id>4</id>" +
//				"  <createTime>2009-03-19 22:06:36.0 CST</createTime>" +
//				"  <level>1</level>" +
//			"</user>";
		
		//UserDAO.creatOneUser(userService.getUserFromXML(xml));
	}

}
