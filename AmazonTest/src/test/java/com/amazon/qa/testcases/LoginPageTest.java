package com.amazon.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.qa.base.TestBase;
import com.amazon.qa.pages.HomePage;
import com.amazon.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		loginPage.getLoginPage();
	}
	@Test(priority=1)
	public void isUsernameEnabled() {
		Assert.assertTrue(loginPage.validateUsernameCanEnter());
	}
	@Test(priority=2)
	public void isPasswordEnabled() {
		Assert.assertTrue(loginPage.validatePasswordCanEnter());
	}
	@Test(priority=3)
	public void loginPageTitleTest() {
		String actual = loginPage.validateLoginPageTitle();
		Assert.assertEquals(actual, "Amazon Sign In");
	}
	@Test(priority=4)
	public void loginPageLogoTest() {
		Boolean flag = loginPage.validateAmazonLogo();
		Assert.assertTrue(flag);
	}
	@Test(priority=5)
	public void verifyLoginTest() {
	homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
