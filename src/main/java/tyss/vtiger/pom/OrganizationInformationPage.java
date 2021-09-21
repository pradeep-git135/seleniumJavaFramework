package tyss.vtiger.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInformationPage {
	public OrganizationInformationPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//span[contains(text(), '-  Organization Information')]") private WebElement orgInfoHeadder;
	public WebElement getOrgInfoHeadder() {
		return orgInfoHeadder;
	} 

}
