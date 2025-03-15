package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testbase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass{
	
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class,groups="Datadriven")//getting dp frm diff package
	public void verify_loginDDT(String email,String pwd,String exp) {
		logger.info("*****Starting TC3_LoginDST*****");
try {
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
	
		//LoginPage
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(email);
		lp.setPassword(pwd);
		lp.clickLogin();
	
		//MyAccount
		MyAccountPage macc=new MyAccountPage(driver);
		boolean targetPage=macc.isMyAccountPageExists();
		
		//valid data conditions
		if(exp.equalsIgnoreCase("Valid")){
			if(targetPage==true) {
				Assert.assertTrue(true);
				macc.clickLogout();
			}else {
				Assert.assertTrue(false);
			}
		}
		//invalid data conditions
		if(exp.equalsIgnoreCase("Invalid")){
			if(targetPage==true) {
				macc.clickLogout();
				Assert.assertTrue(false);
			}else {
				Assert.assertTrue(true);
			}
		}
}
		catch(Exception e) {
			Assert.fail();
		}
		logger.info("*****Finished TC3_LoginDST*****");
		driver.close();
	}
	
}
