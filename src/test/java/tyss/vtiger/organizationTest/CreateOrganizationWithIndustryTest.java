package tyss.vtiger.organizationTest;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import tyss.vtiger.genericUtility.Base;
import tyss.vtiger.genericUtility.JavaUtility;
import tyss.vtiger.pom.CreateOrgPage;
import tyss.vtiger.pom.HomePage;
import tyss.vtiger.pom.OrganizationInformationPage;
import tyss.vtiger.pom.OrganizationPage;

public class CreateOrganizationWithIndustryTest extends Base{
	
	OrganizationPage op = new OrganizationPage(driver);
	CreateOrgPage co = new CreateOrgPage(driver);
	OrganizationInformationPage oi = new OrganizationInformationPage(driver);
	
	@DataProvider
	public Object[][] getmultipledata() throws Throwable{
		return excelUtil.getExcelData("dataprovider");
	}
	
	@Test(dataProvider = "getmultipledata")
	public void createOrgWithIndustry(String orgNmae, String industryType) throws Throwable {
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizationLink();
		
	JavaUtility javautil = new JavaUtility();
//		String orgNmae = fileUtil.getPropertyvalue("orgNmae") + javautil.getRandom();
//		String industryType = fileUtil.getPropertyvalue("industry").trim();
//		System.out.println("orgname = "+orgNmae+"     "+"industry : "+industryType);
		
		op = new OrganizationPage(driver);
		op.clickOncreateOrgImg();
		
		co = new CreateOrgPage(driver);
		co.createOrganizationWithIndustry(orgNmae+javautil.getRandom(), industryType);
		
		oi = new OrganizationInformationPage(driver);
		assertTrue(oi.getOrgInfoHeadder().isDisplayed());
		
		
	}

}

