package tyss.vtiger.test;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Listeners(tyss.vtiger.genericUtility.ListnerIMP.class)
public class DemoTestNG {
	@Test()
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
