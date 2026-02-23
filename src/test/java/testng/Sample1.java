package testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Sample1 {
	@Test
	public void pro() {
		String ExpectedResult="demo web shop";
		WebDriver driver= new ChromeDriver();
		driver.get("https://demowebshop.tricentis.com/");
		String ActualResult=driver.getTitle();
		System.out.println(ActualResult);
		if(ExpectedResult.equals(ActualResult)) {
			System.out.println("pass");
		}else {
			System.out.println("fail");
		}
	}

}
