package Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
 public HomePage(WebDriver driver) {
	 PageFactory.initElements(driver,this);
 }
@FindBy(linkText = "Campaigns")
private WebElement Campaign;

@FindBy(linkText = "Products")
private WebElement Products;

@FindBy(xpath = "//span[text()='Create Campaign']")
private WebElement CreateCampaign;

@FindBy(xpath = "//div[@class='user-icon']")
private WebElement Usericon;

@FindBy(xpath = "//div[text()='Logout ']")
private WebElement logout;

@FindBy(xpath = "//div[@role='alert']")
private WebElement toastmsg;

public WebElement getCampaign() {
	return Campaign;
}

public WebElement getProducts() {
	return Products;
}

public WebElement getCreateCampaign() {
	return CreateCampaign;
}

public WebElement getUsericon() {
	return Usericon;
}

public WebElement getLogout() {
	return logout;
}

public WebElement getToastmsg() {
	return toastmsg;
}

	}


