package test;

import org.apache.log4j.Logger;
import org.junit.Test;

public class TestLogger
{
	public static Logger log = Logger.getRootLogger();
	
	@Test
	public void testLog() 
	{
		log.trace("trace msg");
		log.info("info msg");
		log.debug("debug msg");
		log.error("error msg");
	}
	
	public static void main(String[] args)
	{
		TestLogger obj = new TestLogger();
		obj.testLog();
		log.info("static msg");
	}
}
