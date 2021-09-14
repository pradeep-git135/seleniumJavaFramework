package tyss.vtiger.test;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class TdemoOne {
	
	@BeforeSuite
	public void testSuite()
	{
		System.out.println("before suite");
	}
	
	@BeforeTest
	public void testBtest()
	{
		System.out.println("before test");
	}
	
	@BeforeSuite
	public void testAfterSuite()
	{
		System.out.println("after suite");
	}

}
