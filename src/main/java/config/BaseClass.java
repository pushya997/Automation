package config;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

import Pom.HomePage;
import Pom.LoginPage;
import genericUtility.ExcelFileUtility;
import genericUtility.PropertyFileUtility;
import genericUtility.javaUtility;
import genericUtility.webdriverUtility;

public class BaseClass {
	public WebDriver driver=null;
	public static WebDriver sdriver=null;
	public PropertyFileUtility plib= new PropertyFileUtility();
	public webdriverUtility wlib = new webdriverUtility();
	public ExcelFileUtility elib= new ExcelFileUtility();
	public javaUtility jlib=new javaUtility();
	
	
	@BeforeSuite(groups = {"Integration", "Smoke"})
	public void beforeSuite() {
		Reporter.log("db connection", true);
	}
	@AfterSuite(groups = {"Integration", "Smoke"})
	public void afterSuite() {
		Reporter.log("close db connection");
	}
	@BeforeTest(groups = {"Integration", "Smoke"})
	public void beforeTest() {
		Reporter.log("parallel execution",true);
	}
	@AfterTest(groups = {"Integration", "Smoke"})
	public void afterTest() {
		Reporter.log("parallel execution",true);
	}
	//@Parameters("BROWSER")

	@BeforeClass(groups = {"Integration", "Smoke"})
	
	public void beforeclass() throws IOException {
	// String BROWSER=browser;
	String BROWSER = plib.toReadtheDataFromProperties("Browser");
		if (BROWSER.equalsIgnoreCase("Chrome"))
			driver = new ChromeDriver();
		else if (BROWSER.equalsIgnoreCase("Edge"))
			driver = new EdgeDriver();
		else if (BROWSER.equalsIgnoreCase("Firefox"))
			driver = new FirefoxDriver();
		else if (BROWSER.equalsIgnoreCase("safari"))
			driver = new SafariDriver();
		sdriver=driver;//passing driver ref to static driver

	}
	@AfterClass(groups = {"Integration", "Smoke"})
	public void afterclass() {
		driver.quit();
	}
	@BeforeMethod(groups = {"Integration", "Smoke"})
	public void beforemethod() throws IOException {
		String URL = plib.toReadtheDataFromProperties("URL");
		String USERNAME = plib.toReadtheDataFromProperties("Username");
		String PASSWORD = plib.toReadtheDataFromProperties("Password");
		LoginPage lp=new LoginPage(driver);
		driver.manage().window().maximize();
		wlib.waitForPageToLoad(driver);
		driver.get(URL);
		lp.getUN().sendKeys(USERNAME);
		lp.getPWD().sendKeys(PASSWORD);
		lp.getSignInbtn().click();
	}
	@AfterMethod(groups = {"Integration", "Smoke"})
	public void aftermethod() {
		HomePage hp=new HomePage(driver);
		WebElement userIcon = hp.getUsericon();
		wlib.clickOnWebElement(driver, userIcon);
		hp.getLogout().click();


	}
	


}
