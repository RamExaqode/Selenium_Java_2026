package testng;

import org.testng.annotations.Test;

public class TestNG_Grouping_Annotations {

	
	@Test(groups= {"smoke"})
	public void pLoan() {
		System.out.println("This method is for personal Loan");
	}
}
