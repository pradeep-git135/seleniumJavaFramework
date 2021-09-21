package tyss.vtiger.test;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
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
	
	
	
	
	@AfterTest
	public void testAtest()
	{
		System.out.println("after test");
	}
	
	@AfterSuite
	public void testAfterSuite()
	{
		System.out.println("after suite");
	}

}
