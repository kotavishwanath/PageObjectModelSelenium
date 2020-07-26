package com.favebook.tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.facebook.base.Base;
import com.facebook.pages.FBHomePage;
import com.facebook.pages.FBLoginPage;

public class FBLogInOutTest extends Base{
	@Test
	public void init() throws InterruptedException {
		extTest.log(Status.INFO, "Login Test started");
		FBLoginPage fbLogin = PageFactory.initElements(driver, FBLoginPage.class);
//		FBLoginPage fbLogin = new FBLoginPage(driver);
		fbLogin.enterEmail("dagahtest123@gmail.com");
		fbLogin.enterPassword("Test@1234");
		fbLogin.clickOnLoginButton();
		
//		driver.switchTo().alert().accept();
		
		FBHomePage fbHome = PageFactory.initElements(driver, FBHomePage.class); 
		Thread.sleep(4000);
		fbHome.clickSettingsButton();
		Thread.sleep(4000);
		fbHome.clickOnLogoutButton();
		
	}
}
