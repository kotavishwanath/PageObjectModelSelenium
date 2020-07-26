package co.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class Initial {
	public WebDriver driver;
	
	@Test
	public void main() {
		driver.findElement(By.id("email")).sendKeys("dagahtest123@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("Test@1234");
		driver.findElement(By.xpath("//input[@value='Log In']")).click();
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("CUB");
	}
	
	@BeforeMethod
	public void initializeWebDriver() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/VishwanathKota/Documents/WorkSpace/chromedriver");
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(4000);
		driver.get("https://www.facebook.com/");
	}
	
	@AfterMethod
	public void deInitializeDriver() {
		driver.quit();
	}
}
