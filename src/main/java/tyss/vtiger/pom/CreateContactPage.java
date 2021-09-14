package tyss.vtiger.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tyss.vtiger.genericUtility.WebdriverUtility;

public class CreateContactPage extends WebdriverUtility  {
	WebDriver driver;
	public CreateContactPage(WebDriver driver){
		 PageFactory.initElements(driver, this);
		 this.driver=driver;
	 }
	@FindBy(xpath = "//img[@title=\'Create Contact...\']") private WebElement createContactImg;
	@FindBy(xpath = "//input[@class=\'crmButton small save\']") private WebElement saveBtn;
	

	public WebElement getCreateContactImg() {
		return createContactImg;
	}
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public String createContact() {
		
		createContactImg.click();
		saveBtn.click();
		String text = getTextFromAlet(driver);
		alertAccept(driver);
		return text;
	}
}
