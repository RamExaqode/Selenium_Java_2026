package com.demoqa;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AddToCart_Ecommerce {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

		// ✅ Correct method
		List<WebElement> productNames = driver.findElements(By.cssSelector("h4.product-name"));

		List<WebElement> addToCartButtons = driver.findElements(By.xpath("//button[text()='ADD TO CART']"));

		for (int i = 0; i < productNames.size(); i++) {

			String name = productNames.get(i).getText();

			System.out.println(name);
			if (name.contains("Walnuts")) {

				addToCartButtons.get(i).click();
				break; // stop after adding
			}
		}

		Thread.sleep(3000);
		driver.quit();
	}
}