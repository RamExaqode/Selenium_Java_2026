
import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.*;

public class PassFailSameTest {

	public static void main(String[] args) {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--log-level=3");

		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();

		// ✅ Test 2 - INVALID (FAIL)
		loginTest(driver, "Ram Marshivane", "wrongpassword");

		// ✅ Test 1 - VALID (PASS)
		loginTest(driver, "Ram Marshivane", "rahulshettyacademy");

		driver.quit();
	}

	public static void loginTest(WebDriver driver, String username, String password) {

		driver.get("https://rahulshettyacademy.com/locatorspractice/");

		driver.findElement(By.id("inputUsername")).clear();
		driver.findElement(By.id("inputUsername")).sendKeys(username);

		driver.findElement(By.name("inputPassword")).clear();
		driver.findElement(By.name("inputPassword")).sendKeys(password);

		driver.findElement(By.id("chkboxTwo")).click();
		driver.findElement(By.cssSelector("button.submit")).click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		try {
			// ✅ SUCCESS CASE
			WebElement successMsg = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//p[contains(text(),'successfully logged in')]")));

			System.out.println("Login Successful ✅");
			System.out.println(successMsg.getText());

		} catch (TimeoutException e) {

			// ❌ FAILURE CASE
			WebElement errorMsg = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//p[contains(text(),'Incorrect username or password')]")));

			System.out.println("Login Failed ❌");
			System.out.println(errorMsg.getText());
		}
	}
}
