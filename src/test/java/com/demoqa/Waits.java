package com.demoqa;

import java.util.Arrays;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Waits {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        String[] itemsNeeded = { "Cucumber", "Brocolli", "Beetroot" };

        driver.get("https://rahulshettyacademy.com/seleniumPractise/");

        // Wait for products to load
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h4.product-name")));

        addItems(driver, itemsNeeded);

        driver.findElement(By.cssSelector("img[alt='Cart']")).click();
        driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));

        driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
        driver.findElement(By.cssSelector("button.promoBtn")).click();

        // Wait for promo result
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));

        System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());

        driver.quit();
    }

    public static void addItems(WebDriver driver, String[] itemsNeeded) {

        int j = 0;

        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
        List<WebElement> buttons = driver.findElements(By.xpath("//div[@class='product-action']/button"));

        List<String> itemsNeededList = Arrays.asList(itemsNeeded);

        for (int i = 0; i < products.size(); i++) {

            String[] name = products.get(i).getText().split("-");
            String formattedName = name[0].trim();

            if (itemsNeededList.contains(formattedName)) {

                buttons.get(i).click();
                j++;

                if (j == itemsNeeded.length) {
                    break;
                }
            }
        }
    }
}