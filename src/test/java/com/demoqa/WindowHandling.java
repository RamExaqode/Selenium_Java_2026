package com.demoqa;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;

public class WindowHandling extends BaseTest {

	public void windowHandlingTest() {

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

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
		String ParentId = it.next();

		String ChildId = it.next();
		driver.switchTo().window(ChildId);
	}

	public static void main(String[] args) {

		WindowHandling obj = new WindowHandling();

		obj.setUp();
		obj.windowHandlingTest();
		obj.tearDown();
	}
}