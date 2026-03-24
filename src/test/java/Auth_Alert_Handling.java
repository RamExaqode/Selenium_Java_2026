import static org.testng.Assert.assertEquals;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Auth_Alert_Handling {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		

		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
		Set<Cookie> allCookies = driver.manage().getCookies();

	    // Print total count
	    System.out.println("Total Cookies: " + allCookies.size());

	    // Print each cookie
	    for (Cookie cookie : allCookies) {
	        System.out.println("-----------------------------");
	        System.out.println("Name     : " + cookie.getName());
	        System.out.println("Value    : " + cookie.getValue());
	        System.out.println("Domain   : " + cookie.getDomain());
	        System.out.println("Path     : " + cookie.getPath());
	        System.out.println("Expiry   : " + cookie.getExpiry());
	        System.out.println("isSecure : " + cookie.isSecure());
	        System.out.println("isHttpOnly: " + cookie.isHttpOnly());
	    }
		driver.manage().deleteAllCookies();

		WebElement actualElement = driver.findElement(
				By.xpath("//p[contains(text(),'Congratulations! You must have the proper credentials.')]"));

		String actualText = actualElement.getText();
		String expectedText = "Congratulations! You must have the proper credentials.";

		System.out.println(actualText);

		assertEquals(actualText, expectedText, "Text does not  match");

		Thread.sleep(10000);
		driver.quit();
	}
}