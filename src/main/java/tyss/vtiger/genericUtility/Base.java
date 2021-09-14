package tyss.vtiger.genericUtility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import tyss.vtiger.pom.HomePage;
import tyss.vtiger.pom.LoginPage;

public class Base {
	public WebDriver driver;
	public FileUtility fileUtil;
	public ExcelUtility excelUtil;
	public HomePage hp;
	public WebdriverUtility webutil = new WebdriverUtility();

	@BeforeClass
	public void initBrowser() throws Throwable {
		//System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
		driver = new FirefoxDriver();
//		driver.manage().window().maximize();
		webutil.maxmizeWindow(driver);
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		webutil.implicitlywait(driver);
//		driver.get("http://localhost:8888/index.php?action=Login&module=Users");
		webutil.navigateToUrl(driver, fileUtil.getPropertyvalue("url"));
		hp = new HomePage(driver);

	}
	@BeforeMethod
	public void login() throws Throwable {
		fileUtil = new FileUtility(); 
		excelUtil = new ExcelUtility();
		//		excelUtil.getExcelData("xyz", 1, 1);

		LoginPage loginPage = new LoginPage(driver);

		loginPage.login(fileUtil.getPropertyvalue("userName"), fileUtil.getPropertyvalue("password"));
	}
	@AfterMethod
	public void logout() throws InterruptedException {
		hp.logingout();
	}
	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
	
	
}
