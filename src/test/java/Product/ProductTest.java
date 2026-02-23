package Product;

import java.io.IOException;
import java.util.Random;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Pom.CreateProductPage;
import Pom.HomePage;
import config.BaseClass;

@Listeners(listernerUtility.ListernerImplementation.class)
public class ProductTest extends BaseClass {
	@Test
	public void CreateProductTest() throws EncryptedDocumentException, IOException {
		

		String PRODUCTNAME = elib.toReadDataFromExcel("Sheet3", 1, 0);
		String DROPDOWN1 = elib.toReadDataFromExcel("Sheet3", 1, 1);
		String QUANTITY = elib.toReadDataFromExcel("Sheet3", 1, 2);
		String PRICE = elib.toReadDataFromExcel("Sheet3", 1, 3);
		String DROPDOWN2 = elib.toReadDataFromExcel("Sheet3", 1, 4);
	
		HomePage hp=new HomePage(driver);
		hp.getProducts().click();
		
		Random r = new Random();
		int randomcount = r.nextInt(1000);
		CreateProductPage cpp=new CreateProductPage(driver);
		cpp.getAddproduct().click();
		cpp.getProductname().sendKeys(PRODUCTNAME + randomcount);

		wlib.select1(cpp.getProductcategory(), DROPDOWN1);
		
		//driver.findElement(By.xpath("//option[text()='Electronics']")).click();
		cpp.getQuantity().clear();
		cpp.getQuantity().sendKeys(QUANTITY);
		
		cpp.getPrice().clear();
		cpp.getPrice().sendKeys(PRICE);
		
		wlib.select1(cpp.getVendorid(), DROPDOWN2);
		
		cpp.getAddproductbutton().click();
		
		WebElement toastMsg = hp.getToastmsg();
		wlib.waitForVisibilityOfWebElement(driver, toastMsg);
		System.out.println(toastMsg.getText());
		String msg=toastMsg.getText();
		Assert.assertEquals(msg,"Product "+PRODUCTNAME + randomcount+" Successfully Added");
		
		

	}


	}

//Product Tab65 Successfully Added
