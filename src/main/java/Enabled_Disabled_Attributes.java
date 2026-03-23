import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Enabled_Disabled_Attributes {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		WebElement btn = driver.findElement(By.id("submit"));

		if (btn.isEnabled()) {
			btn.click();
		} else {
			System.out.println("Button is disabled");
		}
	}

}
