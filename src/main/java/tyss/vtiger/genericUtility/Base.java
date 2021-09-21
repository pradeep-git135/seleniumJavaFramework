package tyss.vtiger.genericUtility;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.google.common.io.Files;

import tyss.vtiger.pom.HomePage;
import tyss.vtiger.pom.LoginPage;

public class Base {
	public WebDriver driver;
	public static WebDriver staticdriver;
	public FileUtility fileUtil = new FileUtility();
	public ExcelUtility excelUtil = new ExcelUtility();
	public WebdriverUtility webutil = new WebdriverUtility();
	
	
//	@Parameters("browser")
	@BeforeClass(groups = "smoke")
//	public void initBrowser(@Optional("firefox") String browser) throws Throwable {
	public void initBrowser() throws Throwable {
		String browser = "chrome";
//		//System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}else {
			driver = new InternetExplorerDriver();
		}
		staticdriver = driver;
		webutil.maxmizeWindow(driver);
		webutil.implicitlywait(driver);
		webutil.navigateToUrl(driver, fileUtil.getPropertyvalue("url"));
	}
	@BeforeMethod(groups = "smoke")
	public void login() throws Throwable {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(fileUtil.getPropertyvalue("userName"), fileUtil.getPropertyvalue("password"));
	}
	@AfterMethod(groups = "smoke")
	public void logout() throws InterruptedException {
		 HomePage hp = new HomePage(driver);
		 hp.logingout();
	}
	@AfterClass(groups = "smoke")
	public void closeBrowser() {
		driver.close();
	}
	
//	public void takeScreenShot(String screenshotname) throws Throwable {
//		TakesScreenshot ts = (TakesScreenshot)driver;
//		File source = ts.getScreenshotAs(OutputType.FILE);
//		File destination = new File("./screenShots/"+screenshotname+".png");
////		Files.copy(source, destination);
//		
//	}
	
	public String getScreenshot(String name) throws Throwable {
		File srcfile = ((TakesScreenshot)staticdriver).getScreenshotAs(OutputType.FILE);
		String destinationpath = System.getProperty("user.dir")+"/screenshots/"+name+".png" ;
		File destination = new File(destinationpath);
		Files.copy(srcfile, destination);
		return destinationpath;
	}

	
}
