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
}
