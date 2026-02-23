package testng;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DPexcel {
	@DataProvider
	public Object[][] logindetails() throws EncryptedDocumentException, IOException{
		FileInputStream fis=new FileInputStream("C:\\Users\\gpras\\OneDrive\\Desktop\\Dpe30.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet1");
		int rowcount = sh.getLastRowNum();
		Object[][] objarr = new Object[rowcount][2];
		for(int i=0;i<rowcount;i++) {
			objarr[i][0]=sh.getRow(i+1).getCell(0).getStringCellValue();
			objarr[i][1]=sh.getRow(i+1).getCell(1).getStringCellValue();
	}
		return objarr;
		
	}
	@Test(dataProvider = "logindetails")
	public void login(String username,String password) throws InterruptedException {
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://49.249.28.218:8098/");
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("inputPassword")).sendKeys(password);
	    Thread.sleep(2000);
	    driver.quit();
	}
	

}
