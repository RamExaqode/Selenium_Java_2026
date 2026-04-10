package com.demoqa;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class HandlingBrokenLinks extends BaseTest {

	public static void main(String[] args) throws IOException, InterruptedException, URISyntaxException {

		HandlingBrokenLinks obj = new HandlingBrokenLinks();

		obj.setUp();

		obj.driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		Thread.sleep(3000);

//		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
//		takeScreenshot(methodName);

		String className = obj.getClass().getSimpleName();
		takeScreenshot(className);
		List<WebElement> links = driver.findElements(By.xpath("//li[@class='gf-li']/a"));
		SoftAssert a = new SoftAssert();
		for (WebElement link: links) {
		
		String url = link.getAttribute("href");
		HttpURLConnection conn= (HttpURLConnection) new URI(url).toURL().openConnection(); 
		conn.setRequestMethod("HEAD");
		conn.connect();
		int respCode=conn.getResponseCode();
		System.out.println(respCode);
		a.assertTrue(respCode>400, "The link with text " +link.getText()+ " is broken with code " + respCode);
		
		}
		
		a.assertAll();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//obj.tearDown();
	}
}