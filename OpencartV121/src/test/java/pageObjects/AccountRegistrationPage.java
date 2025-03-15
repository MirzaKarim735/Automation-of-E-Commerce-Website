package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountRegistrationPage extends BasePage{

	
	WebDriver driver;
	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}
	
@FindBy(xpath="//input[@id='input-firstname']")
WebElement txtFirstName;
	
@FindBy(xpath="//input[@id='input-lastname']")
WebElement txtLastName;	

@FindBy(xpath="//input[@id='input-email']")
WebElement txtemail;	

@FindBy(xpath="//input[@id='input-telephone']")
WebElement txtTelephone;

@FindBy(xpath="//input[@id='input-password']")
WebElement txtPassword;

@FindBy(xpath="//input[@id='input-confirm']")
WebElement txtConfrimPassword;

@FindBy(xpath="//input[@name='agree']")
WebElement chkPolicy;

@FindBy(xpath="//input[@value='Continue']")
WebElement btnContinue;

@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
WebElement msgConfrimation;


public void setFristName(String fname) {
	txtFirstName.sendKeys(fname);
}

public void setLastName(String lname) {
	txtLastName.sendKeys(lname);
}

public void setemail(String email) {
	txtemail.sendKeys(email);
}

public void setTelephone(String tel) {
	txtTelephone.sendKeys(tel);
}

public void setPassword(String pwd) {
	txtPassword.sendKeys(pwd);
}

public void setConfrimPassword(String pwd) {
	txtConfrimPassword.sendKeys(pwd);
}

public void setPrivacyPolicy() {
	chkPolicy.click();
}

public void clickContinue() {
	//sol1
	btnContinue.click();
	
	//sol2
	//btnContinue.submit();
	
	//sol3
	//Actions act=new Actions(driver);
	//act.moveToElement(btnContinue).click().perform();
	
	//sol4
	//JavascriptExecutor js=(JavascriptExecutor)driver;
	//js.executeScript("arguments[0].click();",btnContinue);
	
	//sol5
	//btnContinue.sendKeys(Keys.RETURN);
	
	//sol6
	//WebDriverWait mywait=new WebDriverWait(driver,Duration.ofSeconds(10));
	//mywait.until(ExpectedConditions.elementToBeClickable(btnContinue)).click();
}

public String getmsgConfrimation() {
	try {
		return (msgConfrimation.getText());
	}catch (Exception e) {
		return (e.getMessage());
	}
}



}
