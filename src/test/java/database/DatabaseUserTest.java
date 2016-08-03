/**
 * Database tests for the PCHub (users table)
 * 
 * @author daisy
 */
  
package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DatabaseUserTest extends DatabaseConnectionTest {

	@Test(priority = 1)
	public void readTest() throws SQLException {
		ResultSet result = statement.executeQuery("select * from users;");
		while (result.next()) {
			String id = result.getString("id");
			String name = result.getString("name");
			String nickname = result.getString("nickname");
			String country = result.getString("country");
			String state_or_province = result.getString("state_or_province");
			String city = result.getString("city");
			String profile_link = result.getString("profile_link");
			String additional_information = result.getString("additional_information");
			String created_at = result.getString("created_at");
			String updated_at = result.getString("updated_at");
			
			System.out.println("id	name	nickname	country		state/province		city	"
					+ "profile_link			additional_info		created			updated");
			
			System.out.print(id + "" + name + nickname + country + state_or_province + city + profile_link
					+ additional_information + created_at + updated_at);
		}
	}
	
	@Test(priority = 2)
	public void updateTest() throws SQLException {
		int result = statement.executeUpdate("update users set nickname = 'Raisa' where id = 1;");
		Assert.assertTrue(result == 1, "Table 'users' has been updated");
	}
	
	@Test(priority = 3)
	public void updateTest2() throws SQLException {
		int result = statement.executeUpdate("update users set city = 'Buea' where id = 3");
		Assert.assertTrue(result == 1, "Table 'users' has been updated");
		
	}
	
	@Test(priority = 4)
	public void updateTest3() throws SQLException {
		int result = statement.executeUpdate("update users set country = 'CM' where id = 1");
		Assert.assertTrue(result == 1, "Table 'users' has been updated");		
	}
	
	@Test(priority = 6)
	public void updateTest5() throws SQLException {
		int result = statement.executeUpdate("update users set nickname = '' where id = 1");
		Assert.assertTrue(result == 1, "Table 'users' has been updated");		
	}
	
	@Test(priority = 7)
	public void updateTest6() throws SQLException {
		int result = statement.executeUpdate("update users set city = 'buea' where id = 3");
		Assert.assertTrue(result == 1, "Table 'users' has been updated");		
	}
	
	@Test(priority = 8)
	public void updateTest7() throws SQLException {
		int result = statement.executeUpdate("update users set country = 'KH' where id = 1");
		Assert.assertTrue(result == 1, "Table 'users' has been updated");		
	}
	
	@Test(priority = 9)
	public void createTest() throws SQLException {
		int result = statement.executeUpdate("create table dummy_table(TABLE_ID INT PRIMARY KEY NOT NULL, "
				+ "DUMMY_NAME VARCHAR(50) NOT NULL);");
		Assert.assertNotNull(result, "Table 'dummy_table' has been created");
	}
	
	@Test(priority = 10)
	public void deleteTest() throws SQLException {
		int result = statement.executeUpdate("drop table dummy_table;");
		Assert.assertTrue(result == 0, "Table 'dummy_table' has been dropped.");
	}
}