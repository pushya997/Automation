package testng;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Program1 {
	@Test
	public void a11() {
		Reporter.log("a11 executed",true);
	}
	@Test
	public void b11() {
		Reporter.log("b11 executed",true);
	}
	@Test
	public void c00() {
		Reporter.log("c00 executed",true);
	}
	@Test
	public void a12() {
		Reporter.log("a12 executed",true);
	}
	@Test
	public void d11() {
		Reporter.log("d11 executed",true);
	}
	@Test
	public void c10() {
		Reporter.log("c10    executed",true);
	}
}
