/*
 * �������� 2009-3-27
 *
 * TODO Ҫ���Ĵ����ɵ��ļ���ģ�壬��ת��
 * ���� �� ��ѡ�� �� Java �� ������ʽ �� ����ģ��
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
