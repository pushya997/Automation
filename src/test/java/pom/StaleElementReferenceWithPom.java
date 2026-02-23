package pom;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Pom.InstaLoginPage;

public class StaleElementReferenceWithPom {

	public static void main(String[] args) {
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.instagram.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		InstaLoginPage lp=new InstaLoginPage(driver);
		lp.getUN().sendKeys("pushya");
		lp.getPWD().sendKeys("12345");
		driver.navigate().refresh();
		lp.getUN().sendKeys("pushya");
		lp.getPWD().sendKeys("12345");

	}

}
