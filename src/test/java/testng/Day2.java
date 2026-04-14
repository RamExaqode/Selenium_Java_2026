package testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Day2 {

	@Test
	public void webLoginPersonalLoan() {

		System.out.println("Web login Personal");
	}

	
	
	@Test
	public void MobileLoginPersonalLoan() {

		System.out.println("Mobile login Personal");
	}
	
	@Test (groups= {"smoke"})
	public void loginAPIPersonalLoan() {

		System.out.println("loginAPICarPersonal");
	}
}
