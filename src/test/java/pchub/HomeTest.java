package pchub;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pchub.utilities.CommonCode;
import pchub.utilities.Constants;

public class HomeTest extends CommonCode {
	
	@Test
	public void homeTest() {
		WebElement homeButton = driver.findElement(By.cssSelector("a[href='#home']"));
		homeButton.click();
		String actualURL = driver.getCurrentUrl();
		String expectedURL = Constants.expectedHomeURL;
		Assert.assertEquals(expectedURL, actualURL);
	}
}