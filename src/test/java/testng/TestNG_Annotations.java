package testng;


import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;




public class TestNG_Annotations {

	@BeforeClass
	public void bfClass() {
		System.out.println("Before executing any method in the class");
	}
	
	@AfterTest
	public void afterTestMethod() {
		System.out.println("I will execute last");
	}
	
	@AfterSuite
	public void afSuite() {
		System.out.println("This method runs after suite Last number");

	}

	@Test(groups= {"smoke"})
	public void testMethod() {

		System.out.println("Test method");
	}
	
	@BeforeSuite
	public void bfSuite() {
		System.out.println("This method runs before suite No. 1");
	}

	@BeforeTest
	public void beforeTestMethod() {
		System.out.println("I will execute before all the tests");
	}
	
	@AfterClass
	public void afClass() {
		System.out.println("After executing any method in the class");
	}

}
