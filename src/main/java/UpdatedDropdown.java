import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UpdatedDropdown {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		WebElement Passengers = driver.findElement(By.id("divpaxinfo"));
		Passengers.click();

		System.out.println("Default Selected Passengers number is: " +Passengers.getText());

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// ✅ Wait for Adult button to be visible
		WebElement adult = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("hrefIncAdt")));

		/*
		 * int i=1; while (i<5) { adult.click(); //select 1+4 adults i++;
		 * 
		 * }
		 */

		for (int i = 1; i < 5; i++) {
			adult.click(); // select 1+4 adults

		}

		// Optional: wait for Child also
		WebElement child = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("hrefIncChd")));

		/*
		 * int j=1; while (j<4) { child.click(); //Select 3 Childs j++;
		 * 
		 * }
		 */

		for (int j = 1; j < 4; j++) {
			child.click(); // Select 3 Childs

		}

		driver.findElement(By.id("btnclosepaxoption")).click();

		System.out.println("Total Selected Passengers number is: "+ Passengers.getText());
	}

}
