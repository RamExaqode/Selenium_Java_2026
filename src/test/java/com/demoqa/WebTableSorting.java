package com.demoqa;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

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
//		  Thread.sleep(4000);
//		  driver.switchTo().window(ParentWindow);
		 
		  driver.findElement(By.xpath("//tr//th[1]")).click();
		  
		  //Elements List
		 List<WebElement> elementsList =driver.findElements(By.xpath("//tr//td[1]"));
		 
		 //Capture list of all original elements
		 List<String> originalList=elementsList.stream().map(s->s.getText()).collect(Collectors.toList());
		 
		 //Sort original List
		 List <String> sortedList=originalList.stream().sorted().collect(Collectors.toList());
		 
		 //Compare original List vs Sorted list
		 
		 Assert.assertTrue(originalList.equals(sortedList));
		 
	}

}
