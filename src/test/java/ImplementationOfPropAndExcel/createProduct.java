package ImplementationOfPropAndExcel;


import java.io.IOException;
import java.util.Random;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import Pom.CreateProductPage;
import Pom.HomePage;
import Pom.LoginPage;
import genericUtility.ExcelFileUtility;
import genericUtility.PropertyFileUtility;
import genericUtility.webdriverUtility;

public class createProduct {

	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.edge.driver", "C:\\Users\\gpras\\OneDrive\\Desktop\\Q SPIDERS\\java selenium\\drivers\\msedgedriver.exe");

		PropertyFileUtility plib=new PropertyFileUtility();
		ExcelFileUtility elib= new ExcelFileUtility();
		webdriverUtility wlib=new webdriverUtility();
		String BROWSER = plib.toReadtheDataFromProperties("Browser");
		String URL = plib.toReadtheDataFromProperties("URL");
		String USERNAME = plib.toReadtheDataFromProperties("Username");
		String PASSWORD = plib.toReadtheDataFromProperties("Password");

		String PRODUCTNAME = elib.toReadDataFromExcel("Sheet3", 1, 0);
		String DROPDOWN1 = elib.toReadDataFromExcel("Sheet3", 1, 1);
		String QUANTITY = elib.toReadDataFromExcel("Sheet3", 1, 2);
		String PRICE = elib.toReadDataFromExcel("Sheet3", 1, 3);
		String DROPDOWN2 = elib.toReadDataFromExcel("Sheet3", 1, 4);
		
		
		WebDriver driver=null;
		
		if(BROWSER.equalsIgnoreCase("chrome"))
			driver=new ChromeDriver();
		else if (BROWSER.equalsIgnoreCase("edge"))
			driver=new EdgeDriver();
		else if(BROWSER.equalsIgnoreCase("firefox"))
			driver=new FirefoxDriver();
		else if(BROWSER.equalsIgnoreCase("safari"))
			driver=new SafariDriver();
		driver.manage().window().maximize();
		wlib.waitForPageToLoad(driver);
		driver.get(URL);
		
		//login
				LoginPage lp=new LoginPage(driver);
				lp.getUN().sendKeys(USERNAME);
				lp.getPWD().sendKeys(PASSWORD);
				lp.getSignInbtn().click();
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
		
		//driver.findElement(By.xpath("//option[text()='Vendor_05030 - (Electronics)']")).click();
		cpp.getAddproductbutton().click();
		
		WebElement toastMsg = hp.getToastmsg();
		wlib.waitForVisibilityOfWebElement(driver, toastMsg);
		System.out.println(toastMsg.getText());
		if (toastMsg.getText().contains(PRODUCTNAME))
			System.out.println("Product is Created");
		else
			System.out.println("Product is Not Created");
		
		WebElement userIcon = hp.getUsericon();
		wlib.clickOnWebElement(driver, userIcon);
		hp.getLogout().click();
		driver.quit();

	}

}
