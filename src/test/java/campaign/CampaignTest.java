package campaign;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Pom.CreateCampaignPage;
import Pom.HomePage;
import config.BaseClass;
@Listeners(listernerUtility.ListernerImplementation.class)
public class CampaignTest extends BaseClass {
	@Test(groups = "Smoke")
	public void CreateCampaignTest() throws EncryptedDocumentException, IOException {
		String CAMPAIGN_NAME = elib.toReadDataFromExcel("Sheet1", 1, 0);
		String TARGET_SIZE = elib.toReadDataFromExcel("Sheet1", 1, 1);
				
				//homepage
				HomePage hp=new HomePage(driver);
				hp.getCreateCampaign().click();
				
				//createcampaign
				CreateCampaignPage cmp=new CreateCampaignPage(driver);
				cmp.getCampaignname().sendKeys(CAMPAIGN_NAME);
				cmp.getTargetsize().clear();
				cmp.getTargetsize().sendKeys(TARGET_SIZE);
				cmp.getCreatecampaignButton().click();
				
				// Validation
				WebElement toastMsg = hp.getToastmsg();
				wlib.waitForVisibilityOfWebElement(driver, toastMsg);
				System.out.println(toastMsg.getText());
				String msg=toastMsg.getText();
				Assert.assertEquals(msg, "Campaign "+CAMPAIGN_NAME+" Successfully Added");
				
				
}

	
@Test(groups = "Smoke")
public void CreateCampaignWithStatusTest() throws EncryptedDocumentException, IOException {
	String CAMPAIGN_NAME = elib.toReadDataFromExcel("Sheet1", 1, 0);
	String TARGET_SIZE = elib.toReadDataFromExcel("Sheet1", 1, 1);
	String STATUS = elib.toReadDataFromExcel("Sheet1", 1, 2);		
			//homepage
			HomePage hp=new HomePage(driver);
			hp.getCreateCampaign().click();
			
			//createcampaign
			CreateCampaignPage cmp=new CreateCampaignPage(driver);
			cmp.getCampaignname().sendKeys(CAMPAIGN_NAME);
			cmp.getTargetsize().clear();
			cmp.getTargetsize().sendKeys(TARGET_SIZE);
			cmp.getCampaignStatus().sendKeys(STATUS);
			cmp.getCreatecampaignButton().click();
			
			// Validation
			WebElement toastMsg = hp.getToastmsg();
			wlib.waitForVisibilityOfWebElement(driver, toastMsg);
			System.out.println(toastMsg.getText());
			String msg=toastMsg.getText();
			Assert.assertEquals(msg, "Campaign "+CAMPAIGN_NAME+" Successfully Added");
			
}

@Test(groups = "Integration")
public void CreateCampaignWithExpectedDateTest() throws EncryptedDocumentException, IOException {
	String CAMPAIGN_NAME = elib.toReadDataFromExcel("Sheet1", 1, 0);
	String TARGET_SIZE = elib.toReadDataFromExcel("Sheet1", 1, 1);
	//homepage
	HomePage hp=new HomePage(driver);
	hp.getCreateCampaign().click();
	//createcampaign
	CreateCampaignPage cmp=new CreateCampaignPage(driver);
	cmp.getCampaignname().sendKeys(CAMPAIGN_NAME);
	cmp.getTargetsize().clear();
	cmp.getTargetsize().sendKeys(TARGET_SIZE);
	cmp.getExpectedClosedate().sendKeys(jlib.togetExpectedDate(30));
	cmp.getCreatecampaignButton().click();
	WebElement toastMsg = hp.getToastmsg();
	wlib.waitForVisibilityOfWebElement(driver, toastMsg);
	//Validation
	String msg=toastMsg.getText();
	Assert.assertEquals(msg, "Campaign "+CAMPAIGN_NAME+" Successfully Added");
	
}
}








