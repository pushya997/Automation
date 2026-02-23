package genericUtility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class webdriverUtility {
	public WebDriver getDriver() {
		System.setProperty("webdriver.edge.driver",
				"C:\\Users\\gpras\\OneDrive\\Desktop\\Q SPIDERS\\java selenium\\drivers\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		return driver;
	}

	public void maximize(WebDriver driver) {
		driver.manage().window().maximize();

	}

	public void waitForPageToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	public void waitForVisibilityOfWebElement(WebDriver driver, WebElement element) {
		WebDriverWait webWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		webWait.until(ExpectedConditions.visibilityOf(element));
	}

	public void switchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}

	public void switchToFrame(WebDriver driver, String idorname) {
		driver.switchTo().frame(idorname);
	}

	public void switchToFrame(WebDriver driver, WebElement webElement) {
		driver.switchTo().frame(webElement);
	}
	public void select(WebElement element,int index ) {
		Select sel=new Select(element);
		sel.selectByIndex(index);
	}
	public void select(WebElement element,String value ) {
		Select sel=new Select(element);
		sel.selectByValue(value);
	}
	public void select1(WebElement element,String text ) {
		Select sel=new Select(element);
		sel.selectByVisibleText(text);

}
	public void mouseHoverOnWebelement(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	public void clickOnWebElement(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.moveToElement(element).click().perform();
	}
	public void DoubleclickOnWebElement(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.doubleClick(element).perform();
	}
	public void RightclickOnWebElement(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.contextClick(element).perform();
	}
	public void switchToAlertandAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	public void switchToAlertanddismiss(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	public void switchToAlertandSendkeys(WebDriver driver,String text) {
		driver.switchTo().alert().sendKeys(text);
	}
	public void switchToAlertandgetText(WebDriver driver) {
		driver.switchTo().alert().getText();
	}
}


