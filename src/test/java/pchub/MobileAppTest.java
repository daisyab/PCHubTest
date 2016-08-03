package pchub;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pchub.utilities.CommonCode;
import pchub.utilities.Constants;

public class MobileAppTest extends CommonCode {
	
	@Test
	public void mobileapp() {
		WebElement mobileButton = driver.findElement(By.cssSelector("a[href='#mobile-apps']"));
		mobileButton.click();
		String actualURL = driver.getCurrentUrl();
		String expectedURL = Constants.expectedMobileAppURL;
		Assert.assertEquals(expectedURL, actualURL);
	}
}