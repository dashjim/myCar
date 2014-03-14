/*
 * 创建日期 2009-3-27
 *
 * TODO 要更改此生成的文件的模板，请转至
 * 窗口 － 首选项 － Java － 代码样式 － 代码模板
 */
package test;

import test.dao.UserDaoTest;
import test.service.UserServiceTest;
import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {

	public static Test suite() {
		
		 Class[] testClasses = { UserServiceTest.class, UserDaoTest.class };
		 TestSuite suite= new TestSuite(testClasses);
//		 TestSuite suite= new TestSuite();
//		 suite.addTest(new UserServiceTest());
		return suite;
	}
	
	
}
