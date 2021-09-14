package tyss.vtiger.genericUtility;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.sql.Driver;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.google.common.io.Files;

public class WebdriverUtility {
	public void maxmizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}
	public void navigateToUrl(WebDriver driver, String url) {
		driver.get(url);
	}
	public void implicitlywait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	public void type(WebElement element, String value) {
		element.sendKeys(value);
	}
	public void scrollDown(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		int y = element.getLocation().getY();
		js.executeScript("window.scrollBy(0, "+y+")");
		
	}
	public void selectFromDropDown(WebElement element, int index) {
		Select s = new Select(element);
		s.selectByIndex(index);
	}
	public void selectFromDropDown(WebElement element, String value) {
		Select s = new Select(element);
		s.selectByVisibleText(value);
	}
	public void rightClick(WebDriver driver,  WebElement element) {
		Actions a = new Actions(driver);
		a.contextClick();
	}
	public void doubleClick(WebDriver driver,  WebElement element) {
		Actions a = new Actions(driver);
		a.doubleClick(element);
	}
	public void mouseHover(WebDriver driver,  WebElement element) {
		Actions a = new Actions(driver);
		a.moveToElement(element).build().perform();
	}
	public void dragAndDrop(WebDriver driver,  WebElement element,WebElement source, WebElement destination) {
		Actions a = new Actions(driver);
		a.dragAndDrop(source, destination);
	}
	public String getTextFromAlet(WebDriver driver){
		return driver.switchTo().alert().getText();
	}
	public void alertAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	public void alertDismiss(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	public void frameSwitch(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}
	public void frameSwitch(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}
	public void switchWindow(WebDriver driver, String title) {
		Set<String> whs = driver.getWindowHandles();
		for (String wh : whs) {
			driver.switchTo().window(wh);
			if(driver.getTitle().contains(title)) {
				break;
			}
		}
		
		
	}
//	public void switchBTWWindow(WebDriver driver) {
//		String currentWindow = driver.getWindowHandle();//parent
//		Set<String> whs = driver.getWindowHandles();
//		for (String wh : whs) {
//			driver.switchTo().window(wh);
//			if(!(wh.equals(currentWindow))) {
//				break;
//			}
//		}	
//	}
	public void takeScreenShot(WebDriver driver, String screenShot) throws Throwable {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File file = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File(".\\screenShots\\"+screenShot+".png");
		Files.copy(file, destination);
	}
	public void fileUpload(String filePath) throws Throwable {
		
		StringSelection filepath = new StringSelection(filePath);
		Toolkit t = Toolkit.getDefaultToolkit();
		Clipboard c = t.getSystemClipboard();
		c.setContents(filepath, null);
		
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
	public void nonInspectRobot(keyPress keyPress) throws Throwable {
		Robot r = new Robot();
		switch (keyPress) {
		case DOWN:
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);
			break;
		case UP:
			r.keyPress(KeyEvent.VK_UP);
			r.keyRelease(KeyEvent.VK_UP);
			break;
		case LEFT:
			r.keyPress(KeyEvent.VK_LEFT);
			r.keyRelease(KeyEvent.VK_LEFT);

			break;
		case RIGHT:
			r.keyPress(KeyEvent.VK_RIGHT);
			r.keyRelease(KeyEvent.VK_RIGHT);
			break;
		default:
			break;
		}
		

		
 
		
	}
	
}
enum keyPress {
	DOWN,
	UP,
	LEFT,
	RIGHT

}

