package com.demoqa;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddMultipleProductsToCart extends BaseTest {

    public void addProductsTest() throws InterruptedException {

        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Items to add
        List<String> itemsNeeded = Arrays.asList("Cucumber", "Walnuts", "Cashews");

        // Get all products
        List<WebElement> products = driver.findElements(By.cssSelector(".product"));

        Actions actions = new Actions(driver);

        int itemsAdded = 0;

        for (WebElement product : products) {

            String productName = product.findElement(By.cssSelector("h4.product-name"))
                    .getText().split("-")[0].trim();

            if (itemsNeeded.contains(productName)) {

                // Hover (optional)
                actions.moveToElement(product).perform();

                WebElement addToCartBtn = product.findElement(By.xpath(".//button"));

                wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn));

                addToCartBtn.click();

                itemsAdded++;

                if (itemsAdded == itemsNeeded.size()) {
                    break;
                }
            }
        }

        System.out.println("Number of Items successfully added to cart: " + itemsAdded);

        Thread.sleep(3000);
    }

    public static void main(String[] args) throws InterruptedException {

        AddMultipleProductsToCart obj = new AddMultipleProductsToCart();

        obj.setUp();            // ✅ initialize driver
        obj.addProductsTest(); // ✅ run test
        obj.tearDown();        // ✅ close browser
    }
}