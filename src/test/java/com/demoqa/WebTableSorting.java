package com.demoqa;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;

public class WebTableSorting extends BaseTest{

	public static void main(String[] args) throws InterruptedException {

		setUp();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.findElement(By.xpath("//a[contains(text(),'Top Deals')]")).click();
		 Set<String> tabs=driver.getWindowHandles();
		  Iterator<String> it=tabs.iterator();
		  String ParentWindow=it.next();
		  String ChildWindow=it.next();
		  System.out.println(driver.findElement(By.cssSelector(".brand.greenLogo")).getText());
		  Thread.sleep(4000);
		  driver.switchTo().window(ParentWindow);
		 
	}

}
