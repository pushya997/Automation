package Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InstaLoginPage {

	
		public InstaLoginPage(WebDriver driver) {
			PageFactory.initElements(driver,this);
		}
		@FindBy(name="username")
		private WebElement UN;
		
		@FindBy(name="password")
		private WebElement PWD;
		
		public WebElement getUN() {
			return UN;
		}
		
		public WebElement getPWD() {
			return PWD;
		}

	
	}


