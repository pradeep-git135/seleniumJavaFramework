package tyss.vtiger.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tyss.vtiger.genericUtility.WebdriverUtility;

public class HomePage extends WebdriverUtility {
	WebDriver driver;
//	WebdriverUtility webutil = new WebdriverUtility();
	
	public HomePage(WebDriver driver) {

//		this.driver= driver;
		PageFactory.initElements( driver, this);
		this.driver = driver;
	}
	@FindBy(xpath = "//a[text() = 'Contacts']") private WebElement contactsLink;

	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']") private WebElement logoutImg;

	@FindBy(xpath = "//a[. = 'Sign Out']") private WebElement signOutLink;
	
	@FindBy(xpath = "//a[. = 'Calendar']") private WebElement calenderLink;
	
	


	public WebElement getCalenderLink() {
		return calenderLink;
	}
	public WebElement getLogoutImg() {
		return logoutImg;
	}
	public WebElement getSignOutLink() {
		return signOutLink;
	}

	public WebElement getContactsLink() {
		return contactsLink;
	} 

	public void clickOnContactLink() {
		contactsLink.click();
	}
	public void logingout() throws InterruptedException {
		Thread.sleep(2000);
		mouseHover(driver, logoutImg);
		signOutLink.click();
	}

}
