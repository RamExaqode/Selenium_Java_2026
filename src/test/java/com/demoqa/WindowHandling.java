package com.demoqa;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class WindowHandling extends BaseTest {

	public void windowHandlingTest() throws InterruptedException {

		driver.get("https://rahulshettyacademy.com/loginpagePractise/");

		driver.findElement(By.cssSelector(".blinkingText")).click();
		Set<String> windows = driver.getWindowHandles();
		System.out.println("Total windows: " + windows.size());

		// Loop through all windows

		for (String WindowId : windows) {
			driver.switchTo().window(WindowId);
			System.out.println("Window ID: " + WindowId);
			System.out.println("Title: " + driver.getTitle());
			System.out.println("URL: " + driver.getCurrentUrl());
			System.out.println("-----------------------------");
		}
		Iterator<String> it = windows.iterator();
		String parentId = it.next();

		String ChildId = it.next();
		driver.switchTo().window(ChildId);
		String emailId=driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim( ).split(" ")[0];
		System.out.println(emailId);
		driver.switchTo().window(parentId);

		driver.findElement(By.id("username")).sendKeys(emailId);
		Thread.sleep(4000);

	
	}

	public static void main(String[] args) throws InterruptedException {

		WindowHandling obj = new WindowHandling();

		obj.setUp();
		obj.windowHandlingTest();
		obj.tearDown();
	}
}