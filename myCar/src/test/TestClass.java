/*
 * 创建日期 2009-7-12
 *
 */
package test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestClass
{
	public static void main(String[] args)
	{
		Date d = new Date();
		SimpleDateFormat df = new SimpleDateFormat();
		df.applyPattern("yyyy-MM-dd");
		System.out.println(df.format(d));
	}
}
