package com.facebook.pages;

import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.facebook.base.Base;

public class FBLoginPage {
		
	Base base = new Base();
	
	@FindBy(how=How.XPATH, using="//input[@id='email']") WebElement emailTextField;
	@FindBy(how=How.XPATH, using="//input[@type='password'][@id='pass']") WebElement passwordTextField;
	@FindBy(how=How.XPATH, using="//input[@type='submit'][@value='Log In']") WebElement loginButton;
	
	public void enterEmail(String email) {
		base.enterText(emailTextField, email, "emailTextField");
	}

	
	public void enterPassword(String pwd) {
//		passwordTextField.sendKeys(pwd);
		base.enterText(passwordTextField, pwd, "passwordTextField");
	}
	
	public void clickOnLoginButton() {
//		loginButton.click();
		base.clickAction(loginButton, "loginButton");
	}
}
