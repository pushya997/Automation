package testng;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Sample {
	@Test
	public void test1() {
		Reporter.log("testscript done", true);
	}
	@Test
	public void test2() {
		Reporter.log("testscript done2", true);
	}
	@Test
	public void test3() {
		Reporter.log("testscript done3", true);
	}
	@BeforeSuite
	public void beforeSuite() {
		Reporter.log("db connection", true);
	}
	@AfterSuite
	public void afterSuite() {
		Reporter.log("close db connection");
	}
	@BeforeTest
	public void beforeTest() {
		Reporter.log("parallel execution",true);
	}
	@AfterTest
	public void afterTest() {
		Reporter.log("parallel execution",true);
	}
	@BeforeClass
	public void beforeclass() {
		Reporter.log("launching browser",true);
	}
	@AfterClass
	public void afterclass() {
		Reporter.log("closing",true);
	}
	@BeforeMethod
	public void beforemethod() {
		Reporter.log("login to app",true);
	}
	@AfterMethod
	public void aftermethod() {
		Reporter.log("logout from app",true);
	}
	

}
