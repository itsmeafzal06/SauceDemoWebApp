package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.loginPage;
import TestBase.BaseClass;
import utilities.DDTUtility;

public class TC001_SD_LoginTestDDT extends BaseClass {
	
	@Test(dataProvider="logindata", dataProviderClass = DDTUtility.class)
	void loginTest(String username,String password,String exp,String actual) {
		logger.info("**** Test TC001_SD_LoginTestDDT Starts ****");
		loginPage lp = new loginPage(driver);
		HomePage hp =new HomePage(driver);
		
	try {	
		
		logger.info("***Entering the DDT credientials***");
		lp.userId(username);
		lp.password(password);
		
		logger.info("***Clicking on the login button***");
		lp.login_btn();
	
		logger.info("***Validation Starts***");
		if(hp.HomePageUrl().equals(p.getProperty("homePageUrl"))) {
			
			hp.threeDots_click();
			hp.logout_click();
			logger.info("***Test Passed***");
			Assert.assertTrue(true);
			
		}
		
		else {
			lp.userIdClear();
			lp.passwordClear();
			
			logger.info("***Test Failed***");
			
			Assert.fail();
		}
			
		}catch(Exception e) {
			Assert.fail();
		}
	
	logger.info("**** Test TC001_SD_LoginTestDDT Ends ****");
	}

}
