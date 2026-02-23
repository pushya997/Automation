package pom;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaleElementReferenceWithoutPom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.instagram.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement UN = driver.findElement(By.name("username"));
		WebElement PWD = driver.findElement(By.name("password"));
		UN.sendKeys("pushya");
		PWD.sendKeys("12345");
		driver.navigate().refresh();
		UN.sendKeys("pushya");
		PWD.sendKeys("12345");
		

	}

}
