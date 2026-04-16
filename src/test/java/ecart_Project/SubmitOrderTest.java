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
import org.testng.Assert;

import com.opencsv.CSVWriter;

import eCart.pageobjects.LandingPage;
import eCart.pageobjects.ProductCatalouge;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SubmitOrderTest {

    static String productName = "ZARA COAT 3";

    public static void main(String[] args) throws InterruptedException, IOException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        LandingPage landingPage = new LandingPage(driver);
        landingPage.goTo();
        landingPage.loginApplication("ramp@gmail.com", "Track@0021");

        ProductCatalouge productCatalouge = new ProductCatalouge(driver);
        productCatalouge.addProductToCart(productName);

        // Go to Cart
        driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();

        List<WebElement> cartProducts = driver.findElements(By.xpath("//div[@class='cartSection']"));

        Boolean match = cartProducts.stream()
                .anyMatch(cartProduct -> cartProduct.getText().contains(productName));

        Assert.assertTrue(match);

        driver.findElement(By.xpath("//button[contains(text(),'Checkout')]")).click();

        Actions action = new Actions(driver);

        action.sendKeys(driver.findElement(By.xpath("//input[@placeholder='Select Country']")), "india")
                .build().perform();

        // Wait for dropdown
        productCatalouge.waitForElementToAppear(
                By.xpath("//section[@class='ta-results list-group ng-star-inserted']")
        );

        driver.findElement(By.xpath("(//button[@class='ta-item list-group-item ng-star-inserted'])[2]")).click();

        driver.findElement(By.xpath("//a[contains(text(),'Place Order')]")).click();

        WebElement orderId = driver.findElement(By.xpath("//tr[@class='ng-star-inserted']"));
        String orderIDText = orderId.getText();

        WebElement confirmationMsg = driver.findElement(By.xpath("//h1[contains(text(),'Thankyou for the order.')]"));
        String confirmationText = confirmationMsg.getText();

        System.out.println(confirmationText + " | Order ID: " + orderIDText);

        // CSV Writing
        String filePath = "orderDetails.csv";
        File file = new File(filePath);
        boolean fileExists = file.exists();

        CSVWriter writer = new CSVWriter(new FileWriter(filePath, true));

        if (!fileExists) {
            String[] header = {"Message", "OrderID"};
            writer.writeNext(header);
        }

        String[] data = {confirmationText.trim(), orderIDText.trim()};
        writer.writeNext(data);

        writer.close();
        driver.quit();
    }
}