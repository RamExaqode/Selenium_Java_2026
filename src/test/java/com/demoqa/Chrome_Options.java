package com.demoqa;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Chrome_Options {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		// 1. Disable automation flag
		options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });

		// 2. Disable automation extension
		options.setExperimentalOption("useAutomationExtension", false);

		// 3. Optional (recommended)
		options.addArguments("--disable-blink-features=AutomationControlled");

		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
	}

}
