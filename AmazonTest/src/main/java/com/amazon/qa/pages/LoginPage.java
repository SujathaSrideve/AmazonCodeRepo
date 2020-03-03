package com.amazon.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.qa.base.TestBase;
import com.amazon.qa.util.TestUtil;

public class LoginPage extends TestBase{
	
	//Page Repository: OR
	
	@FindBy(id="nav-link-accountList")
	WebElement Arrow;
	
	@FindBy(name="email")
	WebElement email;
	
	@FindBy(id="continue")
	WebElement Continue;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(id="signInSubmit")
	WebElement LoginBtn;
	
	@FindBy(xpath="//i[contains(@class,'a-icon a-icon-logo')]")
	WebElement AmzLogo;
	
	@FindBy(xpath="//h1[contains(@class,'a-spacing-small')]")
	WebElement LoginText;
	
	//constructor
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//get LoginPage
	public void getLoginPage() {
		Arrow.click();	
		}
	
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	public boolean validateAmazonLogo() {
		return AmzLogo.isDisplayed();
	}
	
	public boolean validateUsernameCanEnter() {
		return email.isEnabled();
	}
	
	public boolean validatePasswordCanEnter() {
		return password.isEnabled();
	}
	
	public HomePage login(String un, String pwd) {
		email.sendKeys(un);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT_ATTRIBUTE, TimeUnit.SECONDS);
		Continue.click();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT_ATTRIBUTE, TimeUnit.SECONDS);
		password.sendKeys(pwd);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT_ATTRIBUTE, TimeUnit.SECONDS);
		LoginBtn.click();
		driver.manage().timeouts().implicitlyWait(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		return new HomePage();
	}

}
