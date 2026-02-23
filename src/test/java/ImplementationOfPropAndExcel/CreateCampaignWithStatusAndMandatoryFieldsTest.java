package ImplementationOfPropAndExcel;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import Pom.CreateCampaignPage;
import Pom.HomePage;
import Pom.LoginPage;
import genericUtility.ExcelFileUtility;
import genericUtility.PropertyFileUtility;
import genericUtility.webdriverUtility;

public class CreateCampaignWithStatusAndMandatoryFieldsTest {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.edge.driver", "C:\\Users\\gpras\\OneDrive\\Desktop\\Q SPIDERS\\java selenium\\drivers\\msedgedriver.exe");
		//reading common data from properties file
		PropertyFileUtility plib=new PropertyFileUtility();
		ExcelFileUtility elib= new ExcelFileUtility();
		webdriverUtility wlib=new webdriverUtility();
				String BROWSER = plib.toReadtheDataFromProperties("Browser");
				String URL = plib.toReadtheDataFromProperties("URL");
				String USERNAME = plib.toReadtheDataFromProperties("Username");
				String PASSWORD = plib.toReadtheDataFromProperties("Password");
				
				String CAMPAIGN_NAME = elib.toReadDataFromExcel("Sheet1", 1, 0);
				String TARGET_SIZE = elib.toReadDataFromExcel("Sheet1", 1, 1);
				String STATUS = elib.toReadDataFromExcel("Sheet1", 1, 2);
				
				WebDriver driver=null;
				
				if(BROWSER.equalsIgnoreCase("chrome"))
					driver=new ChromeDriver();
				else if (BROWSER.equalsIgnoreCase("edge"))
					driver=new EdgeDriver();
				else if(BROWSER.equalsIgnoreCase("firefox"))
					driver=new FirefoxDriver();
				else if(BROWSER.equalsIgnoreCase("safari"))
					driver=new SafariDriver();

				// Navigate to Ninza CRM
				driver.manage().window().maximize();
				wlib.waitForPageToLoad(driver);
				driver.get(URL);

				//login
				LoginPage lp=new LoginPage(driver);
				lp.getUN().sendKeys(USERNAME);
				lp.getPWD().sendKeys(PASSWORD);
				lp.getSignInbtn().click();
				
				//homepage
				HomePage hp=new HomePage(driver);
				hp.getCreateCampaign().click();
				
				//createcampaign
				CreateCampaignPage cmp=new CreateCampaignPage(driver);
				cmp.getCampaignname().sendKeys(CAMPAIGN_NAME);
				cmp.getCampaignStatus().sendKeys(STATUS);
				cmp.getTargetsize().clear();
				cmp.getTargetsize().sendKeys(TARGET_SIZE);
				cmp.getCreatecampaignButton().click();

				// Validation
				WebElement toastMsg = hp.getToastmsg();
				wlib.waitForVisibilityOfWebElement(driver, toastMsg);
				System.out.println(toastMsg.getText());
				if (toastMsg.getText().contains(CAMPAIGN_NAME))
					System.out.println("Campaign Created");
				else
					System.out.println("Campaign Not Created");
				driver.findElement(By.xpath("//button[@aria-label='close']")).click();

				// Logout
				WebElement userIcon = hp.getUsericon();
				wlib.clickOnWebElement(driver, userIcon);
				hp.getLogout().click();
				driver.quit();

		

	}

}
