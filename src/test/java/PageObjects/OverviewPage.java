package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OverviewPage extends BasePage{

	public OverviewPage(WebDriver driver) {
		super(driver);
	}

	//locators
	
	@FindBy(xpath="//button[@id='finish']") WebElement btn_finish;
	
	//actions
	
	public void finish() {
		btn_finish.click();
	}
}
