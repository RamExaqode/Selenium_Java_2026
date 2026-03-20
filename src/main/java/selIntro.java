import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class selIntro {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver chrdriver= new ChromeDriver();
		//FirefoxDriver ffdriver = new FirefoxDriver();
		chrdriver.get("https://rahulshettyacademy.com/");
		String Title=chrdriver.getTitle();
		System.out.println(Title);
		WebDriverManager.chromedriver();
		
		
		Thread.sleep(5000);
	   chrdriver.close();
	}
}
