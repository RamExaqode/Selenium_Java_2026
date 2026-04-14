package testng;

import org.testng.annotations.Test;

public class Day1 {

	
	@Test(groups= {"smoke"})
	public void demo() {
		System.out.println("Hello TestNG");
		
	}
	
	
	@Test
	public void secondTestCase() {
		System.out.println("Second test case");
	}
}
