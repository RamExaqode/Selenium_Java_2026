package ecart_Project;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.opencsv.CSVWriter;

import eCart.pageobjects.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest2 {
	static String productName= "ZARA COAT 3";
	
	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		LandingPage landingPage= new LandingPage(driver);
		landingPage.goTo();
		landingPage.loginApplication("ramp@gmail.com", "Track@0021");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement prod=products.stream().filter(product->product.findElement(By.cssSelector("b")).getText().equals("ZARA COAT 3")).findFirst().orElse(null);
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		Thread.sleep(4000);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		//wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.className(".ng-animating"))));
		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		List<WebElement> cartProducts= driver.findElements(By.xpath("//div[@class='cartSection']"));
		
		Boolean match=cartProducts.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(productName));
		Assert.assertTrue(true);
		
		driver.findElement(By.xpath("//button[contains(text(),'Checkout')]")).click();
		
		Actions action = new Actions(driver);
		
		action.sendKeys(driver.findElement(By.xpath("//input[@placeholder='Select Country']")), "india").build().perform();
	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@class='ta-results list-group ng-star-inserted']")));
		driver.findElement(By.xpath("(//button[@class='ta-item list-group-item ng-star-inserted'])[2]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Place Order ')]")).click();
		
		WebElement orderId= driver.findElement(By.xpath("//tr[@class='ng-star-inserted']"));
		String orderIDText = orderId.getText();
		WebElement confirmationMsg= driver.findElement(By.xpath("//h1[contains(text(),' Thankyou for the order. ')]"));
		String confirmationText = confirmationMsg.getText();
		System.out.println(confirmationText +" Your order has been placed and the order ID is: "+ orderIDText);
		
		String filePath = "orderDetails.csv";
		File file = new File(filePath);

		// Check if file already exists
		boolean fileExists = file.exists();

		// Append mode
		CSVWriter writer = new CSVWriter(new FileWriter(filePath, true));

		// ✅ Write header only if file is new
		if (!fileExists) {
		    String[] header = {"Message", "OrderID"};
		    writer.writeNext(header);
		}

		// Write data
		String[] data = {confirmationText, orderIDText};
		writer.writeNext(data);

		writer.close();
		driver.quit();
	}
}
