package Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCampaignPage 
{
	public CreateCampaignPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
@FindBy(name = "campaignName")
WebElement Campaignname;

@FindBy(name = "campaignStatus")
WebElement CampaignStatus;

@FindBy(name = "targetSize")
WebElement Targetsize;

@FindBy(name = "expectedCloseDate")
WebElement ExpectedClosedate;

@FindBy(xpath = "//button[text()='Create Campaign']")
WebElement CreatecampaignButton;

public WebElement getCampaignname() {
	return Campaignname;
}

public WebElement getCampaignStatus() {
	return CampaignStatus;
}

public WebElement getTargetsize() {
	return Targetsize;
}

public WebElement getExpectedClosedate() {
	return ExpectedClosedate;
}

public WebElement getCreatecampaignButton() {
	return CreatecampaignButton;
}



}
