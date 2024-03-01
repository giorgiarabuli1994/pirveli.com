import StepsObject.BuyShopItemSteps;
import io.qameta.allure.Attachment;
import io.qameta.allure.Link;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static DataObject.BuyShopItemData.*;

public class BuyShopItem {

    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] takeScreenshot(){
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }
    private WebDriver driver;
    @BeforeMethod
    private void openChrome(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        driver.get("https://shop.test-pirveli.com/technics/%E1%83%9B%E1%83%9D%E1%83%91%E1%83%98%E1%83%9A%E1%83%A3%E1%83%A0%E1%83%94%E1%83%91%E1%83%98-%E1%83%93%E1%83%90-%E1%83%90%E1%83%A5%E1%83%A1%E1%83%94%E1%83%A1%E1%83%A3%E1%83%90%E1%83%A0%E1%83%94%E1%83%91%E1%83%98/%E1%83%99%E1%83%90%E1%83%91%E1%83%94%E1%83%9A%E1%83%94%E1%83%91%E1%83%98-%E1%83%93%E1%83%90-%E1%83%90%E1%83%93%E1%83%90%E1%83%9E%E1%83%A2%E1%83%94%E1%83%A0%E1%83%94%E1%83%91%E1%83%98/gembird-cc-satam-data-0.3m-serial-ata-iii-30-cm-data-cable/");
    }

    @AfterMethod
    private void closeChrome(){
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

    @Test(description = "შოპზე ნივთის ყიდვა - საკმარისი ბალანსით", priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Link("https://shop.test-pirveli.com/")
    public void BuyShopItemWithBalance() throws InterruptedException {
        BuyShopItemSteps step = new BuyShopItemSteps(driver);

        step.AddButton();
        step.PhoneNumberInput(userWithBalance);
        step.PasswordInput(password);
        step.Enter();
        step.BuyWithBalance();
        step.OrderButton();
        step.OrderView();
    }

    @Test(description = "შოპზე ნივთის ყიდვა - არასაკმარისი ბალანსით", priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @Link("https://shop.test-pirveli.com/")
    public void BuyShopItemWithoutBalance() throws InterruptedException {
        BuyShopItemSteps step = new BuyShopItemSteps(driver);

        step.AddButton();
        step.PhoneNumberInput(userWithoutBalance);
        step.PasswordInput(password);
        step.Enter();
        step.BuyWithBalance();
        step.OrderButton();

        Assert.assertEquals("არასაკმარისი ბალანსი", driver.findElement(By.className("notification-message")).getText());

    }

    }