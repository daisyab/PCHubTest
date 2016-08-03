package pchub;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pchub.utilities.CommonCodeSignIn;
import pchub.utilities.Constants;

public class LogOutTest extends CommonCodeSignIn{
	
	@Test
	public void logout() {
		WebElement settingsButton = driver.findElement(By.xpath(Constants.settingsButton));
		settingsButton.click();
		
		WebElement signOutButton = driver.findElement(By.cssSelector("a[href='/users/sign_out']"));
		signOutButton.click();
		
		boolean r = driver.getPageSource().contains("Signed in successfully.");
		Assert.assertTrue(r);
	}
}