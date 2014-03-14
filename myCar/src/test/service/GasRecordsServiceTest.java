/*
 * 创建日期 2009-6-9
 *
 * TODO 要更改此生成的文件的模板，请转至
 * 窗口 － 首选项 － Java － 代码样式 － 代码模板
 */
package test.service;

import java.util.List;

import model.GasRcd;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import service.GasRecordsService;

import com.ibatis.common.util.PaginatedList;

@SuppressWarnings("deprecation")
public class GasRecordsServiceTest
{
	static GasRecordsService obj;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception
	{
		obj = GasRecordsService.getSingleton();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception
	{
	}
//
//	@Test
//	public void testSaveRcd()
//	{
//		for (int i = 0; i < 6; i++)
//		{
//			GasRcd rcd = new GasRcd();
//			rcd.setUserId(3);
//			rcd.setFueledVolum(new Float(21.22));
//			rcd.setFueledTime(new Date());
//			obj.saveRcd(rcd);
//		}
//	}
	
	@Test
	public void getRcdLPMIsNull()
	{
		List l=obj.getRcdLPMIsNull(3);
		if (l==null)
		System.out.println("null");
		else
			System.out.println("not null");
		System.out.println("size:"+obj.getRcdLPMIsNull(3).size());
	}
	
	
	@Test
	public void testGetRcdForName()
	{
		PaginatedList list = obj.getRcdForName("junxiang", 5);
		
		System.out.println("page size: "+list.getPageSize());
		if (list.isFirstPage())
		{
			do
			{
				for (Object rcd : list)
				{
					GasRcd r = (GasRcd)rcd;
					System.out.println(r.getId());
				}
				System.out.println("another page");
			} while (list.nextPage());
		}
	}
	
	@Test
	public void testGetRcdForUid()
	{
		PaginatedList list = obj.getRcdsForUID(3, 5);
		
		System.out.println(list.size());
	}
}
