package com.demoqa;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Actions_demo_DragDrop {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.globalsqa.com/demo-site/draganddrop/");
		Actions action= new Actions (driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.demo-frame")));
		WebElement HT=driver.findElement(By.xpath("(//h5[@class='ui-widget-header'])[1]"));
		WebElement HT1=driver.findElement(By.xpath("(//h5[contains(text(),'High Tatras')])[2]"));
		WebElement HT2=driver.findElement(By.xpath("(//h5[contains(text(),'High Tatras')])[3]"));
		WebElement HT3=driver.findElement(By.xpath("(//h5[contains(text(),'High Tatras')])[4]"));
		
		WebElement trash= driver.findElement(By.id("trash"));
		
		action.dragAndDrop(HT, trash).perform();
		action.dragAndDrop(HT1, trash).perform();
		action.dragAndDrop(HT2, trash).perform();
		action.dragAndDrop(HT3, trash).perform();
		
		Thread.sleep(5000);
		driver.quit();
	}

}
