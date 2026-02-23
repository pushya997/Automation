package Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProductPage {

	public CreateProductPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath = "//span[text()='Add Product']")
	WebElement Addproduct;
	
	@FindBy(name = "productName")
	WebElement Productname;
	
	@FindBy(name = "productCategory")
	WebElement Productcategory;
	
	@FindBy(name = "quantity")
	WebElement Quantity;
	
	@FindBy(name = "price")
	WebElement Price;
	
	@FindBy(name = "vendorId")
	WebElement Vendorid;
	
	@FindBy(xpath = "//button[text()='Add']")
	WebElement Addproductbutton;

	public WebElement getAddproduct() {
		return Addproduct;
	}

	public WebElement getProductname() {
		return Productname;
	}

	public WebElement getProductcategory() {
		return Productcategory;
	}

	public WebElement getQuantity() {
		return Quantity;
	}

	public WebElement getPrice() {
		return Price;
	}

	public WebElement getVendorid() {
		return Vendorid;
	}

	public WebElement getAddproductbutton() {
		return Addproductbutton;
	}
	
	
	
	
}
