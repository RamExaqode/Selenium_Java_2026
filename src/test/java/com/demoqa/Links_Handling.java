package com.demoqa;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Links_Handling {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.flipkart.com/");

		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

			// Wait and click close button
			System.out.println(
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.Kxl7wj.Tpa2jm")))
							.getText());
			driver.findElement(By.xpath("//span[@role='button']")).click();

		} catch (Exception e) {
			System.out.println("Popup not present");
		}

		// Get footer links
		WebElement footer = driver.findElement(By.cssSelector("div.x3q9HG"));
		List<WebElement> links = footer.findElements(By.tagName("a"));

		System.out.println("Total footer links: " + links.size());

		for (WebElement link : links) {
			String clickOnLinkText = Keys.chord(Keys.CONTROL, Keys.ENTER);

			System.out.println(link.getText());
					
			link.sendKeys(clickOnLinkText);
			
//			Set<String> windows = driver.getWindowHandles();
//
//			for (String window : windows) {
//	
//				driver.switchTo().window(window).getTitle();
			}
			
		}

		// Close browser
		//driver.quit();
	}
