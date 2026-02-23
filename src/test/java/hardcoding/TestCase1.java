package hardcoding;

import java.awt.Toolkit;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TestCase1 {
 
	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.edge.driver", "C:\\Users\\gpras\\OneDrive\\Desktop\\Q SPIDERS\\java selenium\\drivers\\msedgedriver.exe");

		
		WebDriver driver=new EdgeDriver();
		
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://49.249.28.218:8098/");
		driver.findElement(By.id("username")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[text()='Sign In']")).click();
		Thread.sleep(2500);
		driver.findElement(By.xpath("//span[text()='Create Campaign']")).click();
		driver.findElement(By.name("campaignName")).sendKeys("test");
		WebElement targetSizeTF = driver.findElement(By.name("targetSize"));
			targetSizeTF.clear();
			targetSizeTF.sendKeys("50");
			driver.findElement(By.xpath("//button[text()='Create Campaign']")).click();
			
			//Validation
			WebElement toastMsg = driver.findElement(By.xpath("//div[@role='alert']"));
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.visibilityOf(toastMsg));
			//System.out.println(getText().contains("test"));
			if(toastMsg.getText().contains("test"))
				System.out.println("Campaign Created");
			else
				System.out.println("Campaign Not Created");
			driver.findElement(By.xpath("//button[@aria-label='close']")).click();
			
//			//Logout
//			WebElement userIcon = driver.findElement(By.className("user-icon"));
//			Actions action=new Actions(driver);
//			action.moveToElement(userIcon).perform();
//			WebElement logoutBtn = driver.findElement(By.xpath("//div[text()='Logout']"));
//			action.moveToElement(logoutBtn).click().perform();
			
			WebElement userIcon = driver.findElement(By.className("user-icon"));
			Actions action = new Actions(driver);
			action.click(userIcon).perform();
			WebElement logoutBtn = driver.findElement(By.xpath("//div[text()='Logout ']"));
			action.moveToElement(logoutBtn).click().perform();
			driver.quit();
			
//			//Close Browser
//			driver.quit();
		
		
		
	}

	
	}

