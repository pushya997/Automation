package testng;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Enabled {
	@Test(enabled=false)
	public void hello() {
		Reporter.log("hello students");
	}
	@Test(enabled=true)
	public void goodnight() {
		Reporter.log("goodnight students");
	}
	@Test
	public void goodmorning() {
		Reporter.log("goodmorning students");
	}

}
