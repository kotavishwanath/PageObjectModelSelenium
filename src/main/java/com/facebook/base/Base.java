package com.facebook.base;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.facebook.utilities.ExtendManager;

public class Base {
	public static WebDriver driver = null;
	
	public ExtendManager extManage = new ExtendManager();
	public ExtentTest extTest;
	public ExtentReports extReport;
	
	@BeforeSuite
	public void initialise() {
		extReport = extManage.createInstance("./Reports/extends.html");
//		extenet.attachReporter();
		System.setProperty("webdriver.chrome.driver", "/Users/VishwanathKota/Documents/WorkSpace/chromedriver");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		driver = new ChromeDriver(options);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");
	}
	
	@BeforeClass
	public void bc() {
		
		extTest = extReport.createTest("First Test");
		extTest.log(Status.INFO, "Test started");
	}
	
	@AfterClass
	public void ac() {
		extReport.flush();
	}
	
	@AfterSuite
	public void tearDownTest() {
		driver.quit();
	}
	
	public void clickAction(WebElement ele, String msg) {
		try {
			ele.click();
//			extTest.log(Status.PASS, msg);
		} catch (NoSuchElementException e) {
//			extTest.log(Status.FAIL, e.getMessage());
		}
	}
	
	public void enterText(WebElement ele, String str, String msg) {
		try {
			ele.sendKeys(str);
//			extTest.log(Status.PASS, msg);
		} catch (NoSuchElementException e) {
//			extTest.log(Status.FAIL, e.getMessage());
		}
	}
	
}
