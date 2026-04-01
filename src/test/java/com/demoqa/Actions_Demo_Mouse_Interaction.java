package com.demoqa;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Actions_Demo_Mouse_Interaction extends BaseTest {

	WebDriver driver;
	Actions actions;
	WebDriverWait wait;

//	// Setup method (initialize browser)
//	public void setUp() {
//		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.get("https://www.amazon.com/");
//		actions = new Actions(driver);
//		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//	}

	// Method 1: Hover on Account & Lists
	public void hoverOnAccount() {
		// Wait until element is visible
		WebElement account = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='nav-link-accountList']")));

		// Perform hover
		actions.moveToElement(account).perform();
	}

	// Method 2: Search For Product
	public void SearchForProduct() {

		WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("twotabsearchtextbox")));

		searchBox.sendKeys("iphone");
		searchBox.sendKeys(Keys.ENTER); // ✅ correct way
	}

	// Method 3: Right Click (aka Context Click)
	public void RightClickOnProduct() {
		WebElement iPhone = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//span[contains(text(),'Apple iPhone 15, 128GB, Black - Unlocked (Renewed)')]")));
		actions.moveToElement(iPhone).contextClick().build().perform();
	}

	public void tearDown() {
		driver.quit();
	}

	public static void main(String[] args) {
		Actions_Demo_Mouse_Interaction obj = new Actions_Demo_Mouse_Interaction();

		obj.setUp(); // open browser once
		obj.hoverOnAccount(); // method 1
		obj.SearchForProduct(); // method 2
		obj.RightClickOnProduct(); // method 3
		// obj.tearDown(); // close browser
	}
}