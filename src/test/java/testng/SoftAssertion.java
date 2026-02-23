package testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertion {
	@Test
	public void pro() {
		String ExpectedResult="demo web shop";
		WebDriver driver= new ChromeDriver();
		driver.get("https://demowebshop.tricentis.com/");
		String ActualResult=driver.getTitle();
		SoftAssert soft=new SoftAssert();
		soft.assertEquals(ActualResult, ExpectedResult);
		Reporter.log("step1",true);
		Reporter.log("step2",true);
		soft.assertAll();
	}
		
		

}
