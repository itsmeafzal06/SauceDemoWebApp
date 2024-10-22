package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CompletePage extends BasePage{

	public CompletePage(WebDriver driver) {
		super(driver);
	}

	//locators
	
	@FindBy(xpath="//div[@id='checkout_complete_container']//h2") WebElement txt_cnfmMessage;
	
	//actions
	
	public String confirmation_Message() {
		String st=txt_cnfmMessage.getText();
		return st;
	}
}
