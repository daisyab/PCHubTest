package pchub;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pchub.utilities.CommonCode;
import pchub.utilities.Constants;

public class WebAppTest extends CommonCode{
	
	@Test
	public void webapp() {
		WebElement webappButton = driver.findElement(By.cssSelector("a[href='#web-apps']"));
		webappButton.click();
		String actualURL = driver.getCurrentUrl();
		String expectedURL = Constants.expectedWebAppURL;
		Assert.assertEquals(expectedURL, actualURL);
	}
}