package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginPage extends BasePage {

	public loginPage(WebDriver driver) {
		super(driver);
	}

	//locators
	
	@FindBy(xpath="//input[@id='user-name']") WebElement txt_userId;
	@FindBy(xpath="//input[@id='password']") WebElement txt_password;
	@FindBy(xpath="//input[@name='login-button']") WebElement btn_login;
	
	//Actions
	
	public void userId(String id) {
		txt_userId.sendKeys(id);
	}
	
	public void userIdClear() {
		txt_userId.clear();
	}
	
	public void password(String pw) {
		txt_password.sendKeys(pw);
	}
	
	public void passwordClear() {
		txt_password.clear();
	}
	
	public void login_btn() {
		btn_login.click();
	}
}
