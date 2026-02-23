package hardcoding;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class CreateCampaignWithCloseDateTest {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.edge.driver", "C:\\Users\\gpras\\OneDrive\\Desktop\\Q SPIDERS\\java selenium\\drivers\\msedgedriver.exe");

		WebDriver driver=new EdgeDriver();
	    driver.manage().window().maximize();
		driver.get("http://49.249.28.218:8098/");
		driver.findElement(By.id("username")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[@class='btn btn-primary btn-lg btn-block']")).click();
		Thread.sleep(2500);
		driver.findElement(By.xpath("//button[@class='btn btn-info']")).click();
		driver.findElement(By.name("campaignName")).sendKeys("abcdf");
		driver.findElement(By.name("targetSize")).sendKeys("4");
		driver.findElement(By.name("expectedCloseDate")).sendKeys("30-08-2025");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.xpath("//div[@class='user-icon']")).click();
		 driver.close();

	}

}
