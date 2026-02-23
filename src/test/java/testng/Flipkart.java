

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
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Flipkart {
	@DataProvider
	public Object[][] iphonedetails() throws EncryptedDocumentException, IOException{
		FileInputStream fis=new FileInputStream("C:\\Users\\gpras\\OneDrive\\Desktop\\Dpe30.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet2");
		int rowcount = sh.getLastRowNum();
		Object[][] objarr = new Object[rowcount][2];
		for(int i=0;i<rowcount;i++) {
			objarr[i][0]=sh.getRow(i+1).getCell(0).getStringCellValue();
			objarr[i][1]=sh.getRow(i+1).getCell(1).getStringCellValue();
	}
		return objarr;

}
	@Test(dataProvider = "iphonedetails")
	public void iphone(String brand,String productname) {
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.name("q")).sendKeys(productname);
		driver.findElement(By.xpath("//button[@class='_2iLD__']")).click();
	}
}
