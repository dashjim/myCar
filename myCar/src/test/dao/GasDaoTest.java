/*
 * 创建日期 2009-7-19
 *
 */
package test.dao;


import java.sql.SQLException;
import java.util.Date;

import model.GasRcd;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import dao.GasRcdDAOImpl;
import dao.config.DaoClient;

public class GasDaoTest
{
	static GasRcdDAOImpl dao = new GasRcdDAOImpl(DaoClient.getSqlMapInstance());

	@BeforeClass
	public static void setUpBeforeClass() throws Exception
	{
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception
	{
	}
	
/*	@Test
	public void testUpdate() throws Exception 
	{
		GasRcd gasRcd = new GasRcd();
		gasRcd.setFueledTime(new Date());
		gasRcd.setLastFueledTime(new Date());
		
		dao.insertSelective(gasRcd);
		gasRcd = dao.selectByPrimaryKey(2);
		System.out.println(gasRcd.getLastDistance());
		gasRcd.setComment("updted");
		dao.updateByPrimaryKeySelective(gasRcd);
	}*/	
	@Test
	public void testDeleteLastGasRcdsForUid() throws Exception{
		
		dao.deleteLastRcdsForUserID(new Integer(1));
	}
	

}
