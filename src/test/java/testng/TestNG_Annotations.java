package testng;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNG_Annotations {

	@AfterTest
	public void afterTestMethod() {
		System.out.println("I will execute last");
	}

	@Test
	public void testMethod() {

		System.out.println("Test method");
	}

	@BeforeTest
	public void beforeTestMethod() {
		System.out.println("I will execute before all the tests");
	}

}
