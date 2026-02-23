package testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class HardAssertion {
	@Test
	public void pro() {
		String ExpectedResult="demo web shop";
		WebDriver driver= new ChromeDriver();
		driver.get("https://demowebshop.tricentis.com/");
		String ActualResult=driver.getTitle();
		Assert.assertEquals(ActualResult, ExpectedResult);
		Reporter.log("step1",true);
		Reporter.log("step2",true);
		
	}
}
