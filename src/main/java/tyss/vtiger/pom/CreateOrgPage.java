package tyss.vtiger.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tyss.vtiger.genericUtility.WebdriverUtility;

public class CreateOrgPage extends WebdriverUtility {
	
	public CreateOrgPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name='accountname']") private WebElement orgNameTxtField;

	@FindBy(name =  "industry") private WebElement industryDropDown;  

	@FindBy(xpath = "//input[@value='  Save  ']") private WebElement saveBtn;

	
	public WebElement getOrgNameTxtField() {
		return orgNameTxtField;
	}

	public WebElement getIndustryDropDown() {
		return industryDropDown;
	}
	
	public WebElement getSaveBtn() {
		return saveBtn;
	}


	public void createOrganizationWithIndustry(String orgNmae, String dropdownValue) {
		orgNameTxtField.sendKeys(orgNmae);
		selectFromDropDown(industryDropDown, dropdownValue);
		saveBtn.click();
	}

	
}
