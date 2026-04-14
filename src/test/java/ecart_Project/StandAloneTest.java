package ecart_Project;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest {

	
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/client/#/auth/login");
		driver.findElement(By.id("userEmail")).sendKeys("ramp@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Track@0021");
		driver.findElement(By.id("login")).click();
		Thread.sleep(4000);
		List <WebElement> products= driver.findElements(By.cssSelector("div.col-lg-4.col-md-6"));
		WebElement prod=products.stream().filter(product->product.findElement(By.cssSelector("b")).getText().equals("ZARA COAT 3")).findFirst().orElse(null);
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
	
	
	
	
	
	
	
	
	
	}
}
