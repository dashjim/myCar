/*
 * 创建日期 2010-6-5
 *
 */
package service.tool;

import java.util.Iterator;
import java.util.Map;

/**
 * TODO not working yet!!!
 * @author CofeMate
 */
public class PrintMap
{
	public static String print(Map map)
	{
		String s = "map: ";
		for (Iterator iterator = map.keySet().iterator(); iterator.hasNext();)
		{
			String aKey = (String) iterator.next();
			String value ="";
			try
			{
				value = (String)(map.get(aKey));
			} catch (Exception e)
			{
				value = "notString";
			}
			s+="[ "+aKey +","+value+"]";
		}
		return s;
	}
}
