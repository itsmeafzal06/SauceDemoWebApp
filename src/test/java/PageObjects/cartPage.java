package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class cartPage extends BasePage {

	public cartPage(WebDriver driver) {
		super(driver);
	}
	
	//locators
	
	@FindBy(xpath="//button[@id='checkout']") WebElement btn_checkout;
	@FindBy(xpath="//div[@class='inventory_item_price']") WebElement txt_priceTagCO;
	
	public void checkout_btn() {
		btn_checkout.click();
	}
	
	public String priceTagCO() {
		String tagCO=txt_priceTagCO.getText();
		return tagCO;
	}
	
	

}
