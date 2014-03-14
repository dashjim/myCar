/*
 * �������� 2009-3-18
 *
 * TODO Ҫ���Ĵ����ɵ��ļ���ģ�壬��ת��
 * ���� �� ��ѡ�� �� Java �� ������ʽ �� ����ģ��
 */
package test.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.sql.SQLException;

import model.User;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import dao.UserDAO;


public class UserDaoTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testSelectUsers() throws SQLException {
		assertNotNull(UserDAO.selectUsers());
	}

	@Test
	public void testCreatOneUser() throws SQLException {
		User user = new User();
		user.setCarID("20");
		user.setName("junxiang");
		user.setEmail("dashJim@gmail.com");
		user.setImg("some/url/234.img");
		user.setLevel("1");
		UserDAO.creatOneUser(user);
	}
	@Test
	public void testCreatOneUserChs() throws SQLException {
		User user = new User();
		user.setCarID("20");
		user.setName("����");
		user.setEmail("dashJim2@gmail.com");
		user.setImg("some/url/234.img");
		user.setLevel("1");
		UserDAO.creatOneUser(user);
	}
	@Test
	public void selectUserByChsName() throws SQLException {
		
		System.out.println(
				((User)(UserDAO.findUserByName("����"))).toXML());
	}
	
	@Test
	public void testNotFindUser() throws SQLException {
		assertNull(UserDAO.findUserByName("nobodyERROR"));
	}
	
	@Test(expected = SQLException.class) 
	public void testDeleteOneUserById() throws SQLException {
		UserDAO.deleteOneUserById(2000);
	}
	
	@Test
	public void testSelectUserById() throws SQLException {
		assertNotNull(UserDAO.selectUserById(2));
	}
	
	@Test
	public void selectUserByName() throws SQLException {
		
		System.out.println(
				((User)(UserDAO.findUserByName("junxiang"))).toXML());
	}
	
	@Test
	public void countUserByName() throws SQLException{
		System.out.println(UserDAO.countUserByName("junxinag"));
	}
	

	
}
