package com.demoqa;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class e2e_FlightTicketBooking {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		Set<Cookie> allCookies = driver.manage().getCookies();

	    // Print total count
	    System.out.println("Total Cookies: " + allCookies.size());

	    // Print each cookie
	    for (Cookie cookie : allCookies) {
	        System.out.println("-----------------------------");
	        System.out.println("Name     : " + cookie.getName());
	        System.out.println("Value    : " + cookie.getValue());
	        System.out.println("Domain   : " + cookie.getDomain());
	        System.out.println("Path     : " + cookie.getPath());
	        System.out.println("Expiry   : " + cookie.getExpiry());
	        System.out.println("isSecure : " + cookie.isSecure());
	        System.out.println("isHttpOnly: " + cookie.isHttpOnly());
	    }
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();

		driver.findElement(By.xpath("//a[contains(text(),'Pune (PNQ)')]")).click();

		driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).click();

		driver.findElement(By.xpath("(//a[contains(text(),'Tirupati (TIR)')])[2]")).click(); // Indexing in xpath

		driver.findElement(By.cssSelector("a[class='ui-state-default ui-state-active']")).click();

		WebElement Passengers = driver.findElement(By.id("divpaxinfo"));
		Passengers.click();

		System.out.println("Default Selected Passengers number is: " + Passengers.getText());

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// ✅ Wait for Adult button to be visible
		WebElement adult = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("hrefIncAdt")));

		/*
		 * int i=1; while (i<5) { adult.click(); //select 1+4 adults i++;
		 * 
		 * }
		 */

		for (int i = 1; i < 5; i++) {
			adult.click(); // select 1+4 adults

		}

		// Optional: wait for Child also
		WebElement child = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("hrefIncChd")));

		/*
		 * int j=1; while (j<4) { child.click(); //Select 3 Childs j++;
		 * 
		 * }
		 */

		for (int j = 1; j < 4; j++) {
			child.click(); // Select 3 Childs

		}

		driver.findElement(By.id("btnclosepaxoption")).click();

		System.out.println("Total Selected Passengers number is: " + Passengers.getText());

		WebElement currency = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select dropdown = new Select(currency);
		dropdown.selectByIndex(1);
		System.out.println(dropdown.getFirstSelectedOption().getText());

		dropdown.selectByVisibleText("USD");
		System.out.println(dropdown.getFirstSelectedOption().getText());
		dropdown.selectByValue("AED");
		System.out.println(dropdown.getFirstSelectedOption().getText());

		Thread.sleep(5000);
		WebElement Search_Flight = driver.findElement(By.id("ctl00_mainContent_btn_FindFlights"));
		Search_Flight.click();
	}

}
