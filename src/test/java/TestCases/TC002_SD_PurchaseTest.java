package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.CompletePage;
import PageObjects.HomePage;
import PageObjects.OverviewPage;
import PageObjects.YourInfoPage;
import PageObjects.cartPage;
import PageObjects.loginPage;
import TestBase.BaseClass;

public class TC002_SD_PurchaseTest extends BaseClass{

	@Test
	void PurchaseTest() {
		
		loginPage lp = new loginPage(driver);
		HomePage hp = new HomePage(driver);
		cartPage cp = new cartPage(driver);
		YourInfoPage yip = new YourInfoPage(driver);
		OverviewPage ovp = new OverviewPage(driver);
		CompletePage cmp = new CompletePage(driver);
		
		logger.info("***Entering valid creds***");
		
		lp.userId(p.getProperty("userId"));
		lp.password(p.getProperty("password"));
		
		logger.info("***Clicking on login***");
	
		lp.login_btn();
		
		logger.info("***Adding item to cart***");
		
		hp.addToCart_click();
		
		logger.info("***Capturing price tag of the item for validation purpuse***");
		
		String tag=hp.priceTag();
		
		logger.info("***Clicking on cart icon***");
		
		hp.cart_btn();
		
		logger.info("***Validating Price from homePage and Cart Page***");
		
		if(tag.equals(cp.priceTagCO())) {
			
			logger.info("***Clicking on checkout button***");
			
			cp.checkout_btn();
			
			logger.info("***Entering customer's details for Purchase***");
			
			yip.firstName(randonString());
			yip.lastNae(randonString());
			yip.zipCode(randomNum());
			
			logger.info("***Clicking on continue button***");
			
			yip.continue_Click();
			
			logger.info("***Clicking on finish***");
			
			ovp.finish();
			
			logger.info("***Validating the confirmation Message***");
			
			System.out.println(cmp.confirmation_Message());
			
			Assert.assertEquals(cmp.confirmation_Message(),"Thank you for your order!");
		}
		else {
			logger.info("****Price in home Page is not matching price on checkout***");
			Assert.fail();
		}
	}
}
