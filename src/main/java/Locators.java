import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Locators {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--log-level=3");

		WebDriver driver = new ChromeDriver(options); // ✅ pass options
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		WebElement Username = driver.findElement(By.id("inputUsername"));
		Username.clear();
		Username.click();
		Username.sendKeys("Ram Marshivane");
		WebElement Password = driver.findElement(By.xpath("//input[@name='inputPassword']"));
		Password.clear();
		Password.click();
		Password.sendKeys("rahulshettyacademy");
		
		WebElement Checkbox = driver.findElement(By.id("chkboxTwo"));
		Checkbox.click();
		
		WebElement SignInButton= driver.findElement(By.xpath("//button[@class='submit signInBtn']"));
		SignInButton.click();
		 
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        try {
            // ✅ Try to detect SUCCESS (change locator based on actual page)
            WebElement successMsg = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                		By.xpath("//p[contains(text(),'successfully logged in')]")                  
                    
                    
                )
            );

            System.out.println("Login Successful ✅");
            System.out.println(successMsg.getText());

        } catch (TimeoutException e) {

            // ❌ If success not found → check error
            WebElement errorMsg = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//p[contains(text(),'Incorrect username or password')]")
                )
            );

            System.out.println("Login Failed ❌");
            System.out.println(errorMsg.getText());
        }

		
		driver.quit();
	}

}
