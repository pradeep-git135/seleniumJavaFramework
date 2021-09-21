package tyss.vtiger.test;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import tyss.vtiger.genericUtility.Base;

@Listeners(tyss.vtiger.genericUtility.ListnerIMP.class)
public class DemoTestNG extends Base {
	@Test(groups = "smoke")
	public void test1() {
		System.out.println("msg from test1");
		Assert.assertEquals(false, true);
	}
	@Test
	public void test2() {
		System.out.println("msg from test2");
		SoftAssert sa = new SoftAssert();
		sa.assertEquals("abc", "123");
//		sa.assertAll();
	}
	@Test
	public void test3() {
		System.out.println("msg from test3");
		throw new SkipException("test 3 is skipped");
	}

}
