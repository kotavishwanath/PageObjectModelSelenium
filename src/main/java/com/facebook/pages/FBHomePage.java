package com.facebook.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class FBHomePage {
	
	@FindBy(how=How.XPATH, using="//div[text()='Account Settings']") WebElement settingButton;
	@FindBy(how=How.LINK_TEXT, using="Log Out") WebElement logoutButton;
	
	public void clickSettingsButton() {
		settingButton.click();
	}
	
	public void clickOnLogoutButton() {
		logoutButton.click();
	}
}
