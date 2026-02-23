package hardcoding;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestCase3 {

	public static void main(String[] args) {
		System.setProperty("webdriver.edge.driver", "C:\\Users\\gpras\\OneDrive\\Desktop\\Q SPIDERS\\java selenium\\drivers\\msedgedriver.exe");

		WebDriver driver=new EdgeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://49.249.28.218:8098/");
		driver.findElement(By.id("username")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[@class='btn btn-primary btn-lg btn-block']")).click();
		driver.findElement(By.xpath("//span[text()='Create Campaign']")).click();
		driver.findElement(By.name("campaignName")).sendKeys("testA");
		WebElement targetSizeTF = driver.findElement(By.name("targetSize"));
			targetSizeTF.clear();
			targetSizeTF.sendKeys("5");
			Date d = new Date();
			SimpleDateFormat sim = new SimpleDateFormat("dd-MM-yyyy");
			String formatedDate = sim.format(d);
			Calendar calender = sim.getCalendar();
			calender.add(Calendar.DAY_OF_MONTH, 30);
			String requiredDate = sim.format(calender.getTime());
			driver.findElement(By.name("expectedCloseDate")).sendKeys(requiredDate);
			driver.findElement(By.xpath("//button[text()='Create Campaign']")).click();
			WebElement toastMsg = driver.findElement(By.xpath("//div[@role='alert']"));
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.visibilityOf(toastMsg));
			
			//Validation
			
			if(toastMsg.getText().contains("test"))
				System.out.println("Campaign Created");
			else
				System.out.println("Campaign Not Created");
			driver.findElement(By.xpath("//button[@aria-label='close']")).click();
				
			WebElement userIcon = driver.findElement(By.className("user-icon"));
			Actions action = new Actions(driver);
			action.click(userIcon).perform();
			WebElement logoutBtn = driver.findElement(By.xpath("//div[text()='Logout ']"));
			action.moveToElement(logoutBtn).click().perform();
			driver.quit();

	}

}
