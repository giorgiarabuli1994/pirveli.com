package Utilis;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class ChromeRunner {

    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] takeScreenshot(){
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }

    public WebDriver driver = null;

    @BeforeMethod
    public void openChrome() {
//        ესაა ვიზუალურად რო არ გვანახხოს ტესტი
//      ChromeOptions options = new ChromeOptions();   
//      options.addArguments("--headless");
//      WebDriver driver = new ChromeDriver(options);
//        ესაა ვიზუალურად რო გვანახოს ტესტი
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://test-pirveli.com/");
    }

    @AfterMethod
    public void closeChrome() {
        try {
            byte[] screenshot = takeScreenshot();
            if (screenshot == null) {
                System.out.println("Screenshot was not taken.");
            }
        } catch (Exception e) {
            System.err.println("Error occurred while taking screenshot: " + e.getMessage());
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }
}