package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YourInfoPage extends BasePage {

	public YourInfoPage(WebDriver driver) {
		super(driver);
		
	}

	//locator
	
	@FindBy(xpath="//input[@id='first-name']") WebElement txt_firstName;
	@FindBy(xpath="//input[@id='last-name']") WebElement txt_lastName;
	@FindBy(xpath="//input[@id='postal-code']") WebElement txt_zipCode;
	@FindBy(xpath="//input[@id='continue']") WebElement btn_continue;
	
	//actions
	
	public void firstName(String fn) {
		txt_firstName.sendKeys(fn);
	}
	
	public void lastNae(String ln) {
		txt_lastName.sendKeys(ln);
	}
	
	public void zipCode(String zc) {
		txt_zipCode.sendKeys(zc);
	}
	
	public void continue_Click()	{
		btn_continue.click();
	}
}
