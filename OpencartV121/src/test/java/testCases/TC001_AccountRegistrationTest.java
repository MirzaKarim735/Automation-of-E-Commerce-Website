package testCases;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testbase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {

	
	@Test(groups={"Regression","Master"})
	public void verify_account_registration() throws InterruptedException {
		
		logger.info("*****Starting TC001_AccountRegistrationTest*****");
		
		try {
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on Ly Account Link");

		hp.clickRegister();
		logger.info("Clicked on My Register Link");

		
		 AccountRegistrationPage regpage=new  AccountRegistrationPage(driver);	 
		 logger.info("Providing Customer Information");

		 regpage.setFristName(randomeString().toUpperCase());
		 regpage.setLastName(randomeString().toUpperCase());
		 regpage.setemail(randomeString()+"@gmail.com");
		 regpage.setTelephone(randomenumeric());
		 
		 
		 String password=randomealphanumeric();
		 
		 regpage.setPassword(password);
		 regpage.setConfrimPassword(password);
		 
		 regpage.setPrivacyPolicy();
		 regpage.clickContinue();
		 		 
		 logger.info("Validating Expected Message");
		 String confmsg = regpage.getmsgConfrimation();
		 Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		}
		catch(Exception e){
			logger.error("Test failed");
			logger.debug("debug logs...");
			Assert.fail();
		}
		driver.close();
		 
	}
	
	
}
