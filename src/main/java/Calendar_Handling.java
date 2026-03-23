
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class Calendar_Handling {

	public static void main(String[] args) {
	WebDriverManager.chromedriver().setup();

	WebDriver driver = new ChromeDriver();
	driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

	driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();

	driver.findElement(By.xpath("//a[contains(text(),'Pune (PNQ)')]")).click();

	driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).click();

	driver.findElement(By.xpath("(//a[contains(text(),'Tirupati (TIR)')])[2]")).click(); //Indexing in xpath
	
	driver.findElement(By.cssSelector("a[class='ui-state-default ui-state-active']")).click();
}

}
