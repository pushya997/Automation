package testng;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Program2 {
	@Test
	public void createAccount() {
		Reporter.log("account is created",true);
	}
	@Test
	public void updateAccount() {
		Reporter.log("account is updated",true);
	}
	@Test
	public void deleteAccount() {
		Reporter.log("account is deleted",true);
	}

}
