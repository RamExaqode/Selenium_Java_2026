package com.demoqa;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertHandling {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        String name = "Ram Marshivane";

        driver.findElement(By.id("name")).sendKeys(name);

        // SIMPLE ALERT
        driver.findElement(By.id("alertbtn")).click();

        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();

        System.out.println("Alert Message: " + alertText);
        Assert.assertEquals(alertText,
                "Hello Ram Marshivane, share this practice page and share your knowledge");

        alert.accept();

        Thread.sleep(2000);

        // CONFIRM ALERT ACCEPT
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys(name);
        driver.findElement(By.id("confirmbtn")).click();

        Alert confirmAlert = driver.switchTo().alert();
        String confirmText = confirmAlert.getText();

        System.out.println("Confirm Alert Message: " + confirmText);
        Assert.assertEquals(confirmText,
                "Hello Ram Marshivane, Are you sure you want to confirm?");

        confirmAlert.accept();

        Thread.sleep(2000);

        // CONFIRM ALERT DISMISS
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys(name);
        driver.findElement(By.id("confirmbtn")).click();

        Alert dismissAlert = driver.switchTo().alert();
        String dismissText = dismissAlert.getText();

        System.out.println("Dismiss Alert Message: " + dismissText);
        Assert.assertEquals(dismissText,
                "Hello Ram Marshivane, Are you sure you want to confirm?");

        dismissAlert.dismiss();

        Thread.sleep(2000);

        // BASIC AUTH ALERT (correct way)
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");

        driver.quit();
    }
}