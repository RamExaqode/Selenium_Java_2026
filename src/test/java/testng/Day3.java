package testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Day3 {

	@Test(dependsOnMethods = { "MobileLoginCarLoan" })
	public void webLoginCarLoan() {

		System.out.println("Web login Car");
	}

	@Test(enabled = true)
	public void MobileLoginCarLoan() {

		System.out.println("Mobile login Car");
	}

	@Test(enabled = false)
	public void tvLoginCarLoan() {

		System.out.println("Mobile login Car");
	}

	@Test(groups = { "smoke" })
	public void loginAPICarLoan() {

		System.out.println("loginAPICarLoan");
	}

}
