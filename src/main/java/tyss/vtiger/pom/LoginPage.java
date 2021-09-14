package tyss.vtiger.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
//	initialising the locaters
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver,this);	
	}
	
	//	locating all the element
	@FindBy(xpath = "//input[@name='user_name']")
	private WebElement userNameTextfield;
	
	@FindBy(xpath = "//input[@name='user_password']")
	private WebElement passwordTextfield;
	
	@FindBy(id = "submitButton")
	private WebElement loginButton;
	
	//creating getter methods (read access)
    public WebElement getUserNameTextfield() {
		return userNameTextfield;
	}



	public WebElement getPasswordTextfield() {
		return passwordTextfield;
	}



	public WebElement getLoginButton() {
		return loginButton;
	}

	//bussiness logic
	public void login(String userName, String password) {
    	userNameTextfield.sendKeys(userName);
    	passwordTextfield.sendKeys(password);
    	loginButton.click();
    }
    
    
}
