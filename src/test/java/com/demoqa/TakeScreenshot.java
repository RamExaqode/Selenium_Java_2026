package com.demoqa;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TakeScreenshot {

    public static void main(String[] args) throws IOException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com");

        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

        String projectPath = System.getProperty("user.dir");

        File folder = new File(projectPath + "/screenshots");
        if (!folder.exists()) {
            folder.mkdir();
        }

        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File dest = new File(projectPath + "/screenshots/screenshot_" + timestamp + ".png");

        FileUtils.copyFile(src, dest);

        System.out.println("Screenshot saved at: " + dest.getAbsolutePath());

        driver.quit();
        
        //Directly calling from Base Class
        /*public class GoogleTest extends BaseTest {

    public void testGoogle() throws IOException {
        setUp();

        driver.get("https://www.google.com");

        // Take screenshot
        takeScreenshot("Google_Homepage");

        tearDown();
    }
}*/
    }
}