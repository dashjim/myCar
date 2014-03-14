/*
 * 创建日期 2010-7-13
 *
 */
package service.tool;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import model.CarBean;
import model.CarBeanExample;

import dao.CarBeanDAO;
import dao.CarBeanDAOImpl;
import dao.config.DaoClient;

public class ImportCarListCSV
{
	
	private CarBeanDAO carDao = new CarBeanDAOImpl(DaoClient.getSqlMapInstance());
	private static String errorline = "";
	
	public static void main(String[] args)
	{
		ImportCarListCSV importCarListCSV = new ImportCarListCSV();
		
		importCarListCSV.deleteData();
		
		importCarListCSV.readMyFile();
		//importCarListCSV.testselect();
		System.out.println(errorline);
		
	}
	
	private void deleteData()
	{
		
		CarBeanExample example = new CarBeanExample();
		example.createCriteria().andIdGreaterThan(0);
		try
		{
			carDao.deleteByExample(example );
		} catch (SQLException e)
		{
			// TODO 
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	private void testselect()
	{
		List<HashMap> carbean = new ArrayList<HashMap>();
		try
		{
			carbean = carDao.carBeanSql("SELECT distinct producer FROM mycar.carlist");
			System.out.println(carbean.size()+"-size");
			for (Iterator iterator = carbean.iterator(); iterator.hasNext();)
			{
				HashMap carBean2 = (HashMap) iterator.next();
				
				System.out.println(carBean2);
				
			}
		} catch (SQLException e)
		{
			// TODO 
			e.printStackTrace();
		}
	}
	
	private void readMyFile()
	{
		String record = null;
		int recCount = 0;
		try
		{
			FileReader fr = new FileReader(System.getProperty("user.dir")
					+ "\\src\\service\\tool\\carList.csv");
			BufferedReader br = new BufferedReader(fr);
			while ((record = br.readLine()) != null)
			{
				recCount++;
				saveToDB(record, recCount);
			}
			br.close();
			fr.close();
		} catch (IOException e)
		{
			e.printStackTrace();
			errorline +="error read";
		}
	}

	private void saveToDB(String line, int recCount)
	{
		CarBean car = new CarBean();
		String[] data = line.split(",");
		if (data.length == 9)
		{

			car.setProducer(data[0]);
			car.setModel(data[1]);
			car.setName(data[2]);
			car.setTrans(data[3]);
			car.setPower(Float.parseFloat(data[4]));
			car.setBadLPM(Float.parseFloat(data[5]));
			car.setGoodLPM(Float.parseFloat(data[6]));
			car.setAVGLPM(Float.parseFloat(data[7]));
			car.setFactor(Float.parseFloat(data[8]));

			System.out.println("Line " + line);
			try
			{
				carDao.insert(car);
			} catch (SQLException e)
			{
				// TODO
				errorline+= recCount +"::";
				
			}

		} else
		{
			errorline+= recCount +"::";
		}

	}

}
