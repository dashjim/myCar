/*
 * 创建日期 2009-3-22
 *
 * TODO 要更改此生成的文件的模板，请转至
 * 窗口 － 首选项 － Java － 代码样式 － 代码模板
 */
package test.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.sql.SQLException;

import model.Car;
import model.CarExample;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import dao.CarDAO;
import dao.CarDAOImpl;
import dao.config.DaoClient;

public class CarDAOTest {
	
	private static CarDAO cardao; 
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		cardao = new CarDAOImpl(DaoClient.getSqlMapInstance());
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
	}

	@Test
	public void testCountByExample() throws SQLException {

		CarExample where = new CarExample();
		where.createCriteria().andIsMtEqualTo(true);
		
		assertNotNull(cardao.countByExample(where));

	}

	@Test
	public void testDeleteByExample() throws SQLException {
		
		CarExample where = new CarExample();
		where.createCriteria()
			.andIsMtEqualTo(true);
		System.out.println(cardao.deleteByExample(where));
	}

	@Test
	public void testDeleteByPrimaryKey() {
		fail("Not yet implemented");
	}

	@Test
	public void testInsert() throws SQLException {
		Car car = new Car();
		car.setIsMt(true);
		car.setPaiLiang("1.6");
		
		cardao.insertSelective(car);
	}

	@Test
	public void testInsertSelective() throws SQLException {
		Car car = new Car();
		car.setIsMt(true);
		car.setPaiLiang("1.6");
		
		cardao.insertSelective(car);
	}

	@Test
	public void testSelectByExample() {
		fail("Not yet implemented");
	}

	@Test
	public void testSelectByPrimaryKey() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateByExampleSelective() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateByExample() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateByPrimaryKeySelective() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateByPrimaryKey() {
		fail("Not yet implemented");
	}

}
