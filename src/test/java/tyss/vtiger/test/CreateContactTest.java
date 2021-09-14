package tyss.vtiger.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import tyss.vtiger.genericUtility.Base;
import tyss.vtiger.pom.CreateContactPage;
import tyss.vtiger.pom.HomePage;




public class CreateContactTest extends Base {
	//public WebdriverUtility webutil;
	//	public HomePage home;
	@Test
	public void createContact() throws Throwable{

		String expectedText="Last Name cannot be empty";

		HomePage home = new HomePage(driver);
		home.clickOnContactLink();
		CreateContactPage contact = new CreateContactPage(driver);
		String actualText=contact.createContact();


		Assert.assertEquals(actualText, expectedText);

		/*
		 * SoftAssert sf = new SoftAssert(); sf.assertEquals(actualText, expectedText);
		 * System.out.println("exection reachrd here");
		 */


	}


}


