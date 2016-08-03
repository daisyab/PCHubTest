/**
 * Tests the navigation bar links on the sign up form.
 * 
 * @author daisy
 * 
 */
package pchub;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pchub.utilities.Constants;

public class SignUpPageTest {
	
	private String signup; 
	private WebDriver driver;
	private String actualURL;
	
	@BeforeMethod
	public void beforeTest() {
		signup = Constants.signUp;
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(signup);
		driver.manage().window().maximize();
	}
	
	@Test(priority = 1)
	public void homePageLink() {
		WebElement webAppButton = driver.findElement(By.cssSelector("a[href='#home']"));
		webAppButton.click();
		actualURL = driver.getCurrentUrl();
		Assert.assertEquals(actualURL, Constants.expectedHomeURL);
	}
	
	@Test(priority = 2)
	public void webAppsLink() {
		WebElement webAppButton = driver.findElement(By.cssSelector("a[href='#web-apps']"));
		webAppButton.click();
		actualURL = driver.getCurrentUrl();
		Assert.assertEquals(actualURL, Constants.expectedWebAppURL);
	}

	@Test(priority = 3)
	public void mobileAppsLink() {
		WebElement mobileAppButton = driver.findElement(By.cssSelector("a[href='#mobile-apps']"));
		mobileAppButton.click();
		actualURL = driver.getCurrentUrl();
		Assert.assertEquals(actualURL, Constants.expectedMobileAppURL);			
	}
		
	@AfterMethod
	public void afterTest() {
		driver.quit();
	}
}
