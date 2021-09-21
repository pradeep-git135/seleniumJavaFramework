package tyss.vtiger.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tyss.vtiger.genericUtility.WebdriverUtility;

public class OrganizationPage extends WebdriverUtility{
	
	public OrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//img[@title='Create Organization...']") private WebElement createOrgImg;
	
	public WebElement getCreateOrgImg() {
		return createOrgImg;
	}
	
	public void clickOncreateOrgImg(){
		createOrgImg.click();
	}
	
	
	
	


}
