import java.time.Duration;
import java.util.List;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoSuggestiveDropdown {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		WebElement autoSuggestivedd = driver.findElement(By.id("autosuggest"));
		autoSuggestivedd.sendKeys("In");

		// ✅ Wait until options appear
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		wait.until(ExpectedConditions.visibilityOfElementLocated(
		    By.cssSelector("li[class='ui-menu-item'] a")
		));
		
		
		// Now fetch options
		List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));

		  System.out.println("Available options:");
	        for (WebElement option : options) {
	            System.out.println(option.getText());
	        }
		for (WebElement option : options) {
			
		    if (option.getText().equalsIgnoreCase("India")) {
		        option.click();
		        break;
		    }
		    
		}
	}

}
