package tyss.vtiger.test;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(tyss.vtiger.genericUtility.ListnerIMP.class)
@Test(testName = "VTIG user login")
public class TestCase {

	@Test(description = "As a valid user I will login to app")
	public void login() {
		System.out.println("login");
	}
	
	@Test
	public void searchProduct() {
		System.out.println("search product");
		throw new SkipException("Search product skipped");
	}
	
	@Test
	public void logout() {
		System.out.println("logout");
		Assert.assertTrue(false);
	}
}
