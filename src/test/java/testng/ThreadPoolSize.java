package testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class ThreadPoolSize {
	@Test(invocationCount = 6,threadPoolSize = 5)
	public void sample() {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.instagram.com/");
		Reporter.log("hello",true);
		driver.quit();
	}

}
