package testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNG_DataProvider {

	
	@Test (dataProvider="getData")
	public void mobileSignoutCarLoan( String username, String password) 
	{
		System.out.println(username);
		System.out.println(password);
		
	}
	
	
	@DataProvider
	public Object[][] getData() {

		
		/// 1st combination Username-Password
		// 2nd combination Username-Password
		// 3rd combination Username-Password
		Object[][] data = new Object[3][2];

		// 1st set
		data[0][0] = "firstUserName";
		data[0][1] = "firstUserPassword";

		// 2nd set
		data[1][0] = "secondUserName";
		data[1][1] = "secondUserPassword";

		// 3rd set
		data[2][0] = "thirdUserName";
		data[2][1] = "thirdUserPassword";
		return data;
	}
}
