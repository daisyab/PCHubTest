/**
 * Automates the testing of the search bar functionality.
 * 
 * @author daisy
 */

package pchub;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pchub.utilities.CommonCodeSignIn;
import pchub.utilities.Constants;
import pchub.utilities.ExcelReader;

public class SearchBarTest extends CommonCodeSignIn {
	
	@Test(dataProvider = "search")
	public void search(String searchString) {
		
		WebElement searchbar = driver.findElement(By.id("search"));
		searchbar.clear();
		searchbar.sendKeys(searchString);
		
		WebElement searchButton = driver.findElement(By.name("button"));
		searchButton.click();
		
		WebElement homeButton = driver.findElement(By.cssSelector(Constants.homeButtonLocator));
		Assert.assertFalse(homeButton == null);
	}
	
	@DataProvider(name = "search")
	public Object[][] searchDataProvider() throws Exception {
		Object[][] connect = ExcelReader.connect(Constants.pathToExcel, Constants.searchSheetName);
	    Object[][] cellData = ExcelReader.read(connect);
		return cellData;
	}
}