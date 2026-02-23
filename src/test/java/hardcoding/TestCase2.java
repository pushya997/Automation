package hardcoding;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestCase2 {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.edge.driver", "C:\\Users\\gpras\\OneDrive\\Desktop\\Q SPIDERS\\java selenium\\drivers\\msedgedriver.exe");
		WebDriver driver=new EdgeDriver();
		

				// Navigate to Ninza CRM
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
				driver.get("http://49.249.28.218:8098/");

				// Login to Ninza CRM
				driver.findElement(By.id("username")).sendKeys("rmgyantra");
				driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
				driver.findElement(By.xpath("//button[text()='Sign In']")).click();

				// Create Campaign With Manadatory fields & Status
				driver.findElement(By.xpath("//span[text()='Create Campaign']")).click();
				driver.findElement(By.name("campaignName")).sendKeys("test");
				driver.findElement(By.name("campaignStatus")).sendKeys("active");
				WebElement targetSizeTF = driver.findElement(By.name("targetSize"));
				targetSizeTF.clear();
				targetSizeTF.sendKeys("50");
				driver.findElement(By.xpath("//button[text()='Create Campaign']")).click();

				// Validation
				WebElement toastMsg = driver.findElement(By.xpath("//div[@role='alert']"));
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
				wait.until(ExpectedConditions.visibilityOf(toastMsg));
				System.out.println(toastMsg.getText());
				if (toastMsg.getText().contains("test"))
					System.out.println("Campaign Created");
				else
					System.out.println("Campaign Not Created");
				driver.findElement(By.xpath("//button[@aria-label='close']")).click();

				// Logout
				WebElement userIcon = driver.findElement(By.className("user-icon"));
				Actions action = new Actions(driver);
				action.moveToElement(userIcon).perform();
				WebElement logoutBtn = driver.findElement(By.xpath("//div[text()='Logout ']"));
				action.moveToElement(logoutBtn).click().perform();

				// Close Browser
				driver.quit();

	}

}
