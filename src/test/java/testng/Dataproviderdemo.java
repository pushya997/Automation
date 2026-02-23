package testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Dataproviderdemo {
	@DataProvider
	public Object[][] logindetails() {
		Object[][] obj =new Object[3][2];
		obj[0][0]="pushya";
		obj[0][1]="pushya123";
		
		obj[1][0]="prasu";
		obj[1][1]="prasu123";
		
		obj[2][0]="saathu";
		obj[2][1]="saathu123";
		
		return obj;
		
	}
	@Test(dataProvider="logindetails")
	public void login(String username,String password) {
		System.out.println(username+"==="+password);
	}
	

}
