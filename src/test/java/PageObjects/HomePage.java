package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	//locators
	
	@FindBy(xpath="//button[@id='react-burger-menu-btn']") WebElement btn_3dots;
	@FindBy(xpath="//a[.='Logout']") WebElement btn_logout;
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']") WebElement btn_addToCart;
	@FindBy(xpath="//div[@class='inventory_list']/div[3]/div[2]/div[2]/div") WebElement txt_priceTag;
	@FindBy(xpath="//div[@id='shopping_cart_container']") WebElement btn_cart;

	//actions
	
	public void threeDots_click() {
		btn_3dots.click();
	}
	
	public void logout_click() {
		btn_logout.click();
	}
	
	public String HomePageUrl() {
		String hpUrl = driver.getCurrentUrl();
		return hpUrl;
	}
	
	public void addToCart_click() {
		btn_addToCart.click();
	}
	
	public String priceTag() {
		String tag=txt_priceTag.getText();
		return tag;
	}
	public void cart_btn() {
		btn_cart.click();
	}
}
