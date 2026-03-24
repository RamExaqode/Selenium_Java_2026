import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AddMultipleProductsToCart {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

		// ✅ Explicit wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// ✅ Wait until products are visible
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".product")));

		// ✅ Products to add
		List<String> itemsNeeded = Arrays.asList("Cucumber", "Walnuts", "Cashews");

		
		List<WebElement> products = driver.findElements(By.cssSelector(".product"));

		JavascriptExecutor js = (JavascriptExecutor) driver;

		int itemsAdded = 0;

		for (WebElement product : products) {

			String productName = product.findElement(By.cssSelector("h4.product-name")).getText().split("-")[0].trim();

			if (itemsNeeded.contains(productName)) {

				// ✅ Scroll to product
				//js.executeScript("arguments[0].scrollIntoView({block: 'center'});", product);

				Actions actions = new Actions(driver);
				actions.moveToElement(product).perform(); //javascript is the  most reliable method to use instead of Actions class
				
				// ✅ Wait until button clickable
				WebElement addToCartBtn = product.findElement(By.xpath(".//button"));
				//wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn));

				// ✅ Click
				addToCartBtn.click();

				itemsAdded++;

				// ✅ Stop when all items added
				if (itemsAdded == itemsNeeded.size()) {
					break;
					  // ✅ Add to list
				}
			}
		}

		System.out.println("Number of Items successfully added to cart : " +itemsAdded );
		Thread.sleep(3000);
		driver.quit();
	}
}