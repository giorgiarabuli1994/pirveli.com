import StepsObject.BuyVouchersItemSteps;
import io.qameta.allure.Attachment;
import io.qameta.allure.Link;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
import static DataObject.BuyVouchersItemData.*;

public class BuyVouchersItem {

    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] takeScreenshot(){
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }
    private WebDriver driver;

    @BeforeMethod
    private void openChrome() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        driver.get("https://vouchers.test-pirveli.com/557752064/486883");
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

    @Test(description = "ვაუჩერის ყიდვა - საკმარისი ქულებით", priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Link("https://vouchers.test-pirveli.com/557752064/486883")
   public void BuyVoucherWithPoints(){
        BuyVouchersItemSteps step = new BuyVouchersItemSteps(driver);

        step.AddButton();
        step.LoginButton();
        step.SwitchToFrame();
        step.PhoneNumberInput(phoneNumberWithBlanace);
        step.PasswordInput(password);
        step.Enter();
        step.BuyWithCoins();
        step.BuyButton();
        step.OrderButton();
        step.ViewOrder();
    }

    @Test(description = "ვაუჩერის ყიდვა - არასაკმარისი მონეტებით", priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @Link("https://vouchers.test-pirveli.com/557752064/486883")
    public void BuyVoucherWithoutPoints(){
        BuyVouchersItemSteps step = new BuyVouchersItemSteps(driver);

        step.AddButton();
        step.LoginButton();
        step.SwitchToFrame();
        step.PhoneNumberInput(phoneNumberWithoutBlanace);
        step.PasswordInput(password);
        step.Enter();
        step.BuyWithCoins();

        Assert.assertEquals("(არასაკმარისი მონეტები)", driver.findElement(By.cssSelector("#__next > main > div > div:nth-child(1) > div.mt-4.md\\:mt-0.flex.bg-\\[white\\].min-h-\\[334px\\].rounded-xl.flex-col.w-full.p-4.md\\:p-\\[30px\\].md\\:pb-\\[20px\\] > div > div.ant-collapse-item.ant-collapse-item-disabled.mb-6.border-none > div > span > div > h5 > p")).getText());
    }

    @Test(description = "ვაუჩერის ყიდვა - საკმარისი ბალანსით", priority = 3)
    @Severity(SeverityLevel.CRITICAL)
    @Link("https://vouchers.test-pirveli.com/557752064/486883")
    public void BuyVoucherWithBalance(){
        BuyVouchersItemSteps step = new BuyVouchersItemSteps(driver);

        step.AddButton();
        step.LoginButton();
        step.SwitchToFrame();
        step.PhoneNumberInput(phoneNumberWithBlanace);
        step.PasswordInput(password);
        step.Enter();
        step.BuyWithBalance();
        step.BuyButton();
        step.OrderButton();
        step.ViewOrder();
    }

    @Test(description = "ვაუჩერის ყიდვა - არასაკმარისი ბალანსით", priority = 4)
    @Severity(SeverityLevel.CRITICAL)
    @Link("https://vouchers.test-pirveli.com/557752064/486883")
    public void BuyVoucherWithoutBalance(){
        BuyVouchersItemSteps step = new BuyVouchersItemSteps(driver);

        step.AddButton();
        step.LoginButton();
        step.SwitchToFrame();
        step.PhoneNumberInput(phoneNumberWithoutBlanace);
        step.PasswordInput(password);
        step.Enter();
        step.BuyWithBalance();
        step.AddBalance();
    }
}
