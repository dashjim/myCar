/*
 * 创建日期 2009-7-26
 *
 */
package test.service;

import java.lang.reflect.InvocationTargetException;

import model.GasRcd;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import service.CalculatingService;

public class CalculatingTest
{
	static private GasRcd gasRcd = new GasRcd();
	private CalculatingService calculating = CalculatingService.getSingleton();
	private GasRcd lastGasRcd = new GasRcd();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception
	{
		gasRcd.setGasType("93");
		gasRcd.setFueledVolum(Float.valueOf("35.4"));
		gasRcd.setLastDistance(Short.valueOf("356"));
		gasRcd.setTotalDistance(Integer.valueOf("7022"));
		gasRcd.setIsFull(new Boolean(true));
		gasRcd.setMoney(Float.valueOf("6.1"));
		gasRcd.setUserId(Integer.valueOf(3));
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception
	{
	}

	@Test
	public void testCalculateReport()
	{
		calculating.calculateReport(3, gasRcd, null);
	}

	@Test
	public void testCalculatLPMForGasRcd() throws IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException
	{
		lastGasRcd.setFueledVolum(Float.valueOf("16"));
		lastGasRcd.setLastDistance(Short.valueOf("156"));
		lastGasRcd.setIsFull(new Boolean(true));
		lastGasRcd.setId(8);
		
		calculating.calculatLPMForGasRcd(3, gasRcd, lastGasRcd);
	}

}
