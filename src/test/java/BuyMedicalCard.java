import StepsObject.BuyMedicalCardSteps;
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
import static DataObject.BuyMedicalCardData.*;
import static DataObject.UniquePhoneNumberGenerator.*;

public class BuyMedicalCard {

    @Attachment(value = "Screenshot", type = "image/png")
    private byte[] takeScreenshot(){
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }
    private WebDriver driver;
    @BeforeMethod
    private void openChrome(){
//        ესაა ვიზუალურად რო არ გვანახხოს ტესტი
//      ChromeOptions options = new ChromeOptions();
//      options.addArguments("--headless");
//      WebDriver driver = new ChromeDriver(options);
//        ესაა ვიზუალურად რო გვანახოს ტესტი
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
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

    @Test(description = "მოწვეული იუზერის რეგისტრაცია - ქულის დარიცხვის მიზნით", priority = 1, dependsOnMethods = {})
    @Severity(SeverityLevel.CRITICAL)
    @Link("https://auth.test-pirveli.com/realms/pirveli/protocol/openid-connect/registrations?client_id=demo-client&response_type=code&scope=email&redirect_uri=https://test-pirveli.com/main/page?inviteCode=91fe1be5eb2e46eb5f3f6e504823a902")
    public void RegisterInvitedUser() throws InterruptedException {
        BuyMedicalCardSteps step = new BuyMedicalCardSteps(driver);
        driver.get("https://auth.test-pirveli.com/realms/pirveli/protocol/openid-connect/registrations?client_id=demo-client&response_type=code&scope=email&redirect_uri=https://test-pirveli.com/main/page?inviteCode=d85b9ea90e8dfe31deaa4b63f22c5c3d");

        step.FirstNameInput(firstName);
        step.LastNameInput(lastName);


        boolean numberIsValid = false;
        while (!numberIsValid) {
            step.PhoneNumberInputClear();
            step.PhoneNumberInput(generateUniquePhoneNumber());
            step.EmailInputClear();
            step.EmailInput(email);
            step.PasswordInput(password);
            step.ConfirmationPasswordInput(passwordConfirmation);
            step.CheckBox();
            step.EnterRe();

            try {
//                თუ ჩასეტილი ნომერი უკვე გამოყენებული იქნება, მიწვდეს ასერშენს და და შედაროს
                String errorMessage = driver.findElement(By.id("input-error-username")).getText();
                Assert.assertEquals("ნომერი რეგისტრირებულია ბაზაში, გაიარეთ ავტორიზაცია", errorMessage);
                // თუ ამ ხაზს მიაღწევს, ეს ნიშნავს, რომ შეცდომის შეტყობინება გამოჩნდება, ასე რომ ციკლი გაგრძელდება
            } catch (AssertionError | NoSuchElementException e) {
                // თუ ასერშენი დაფეილდა ან ერორ მესიჯი არ მოიძებნა ესეგი ნომერი არაა გამოყენებული
                numberIsValid = true;
            }
        }

        step.OtpInput(otp);
        step.EnterOtp();
    }

    @Test(description = "მედიქალ ბარათის ყიდვა - საკმარისი ბალანსით", priority = 2, dependsOnMethods = {"RegisterInvitedUser"})
    @Severity(SeverityLevel.CRITICAL)
    @Link("https://medical.test-pirveli.com/")
    public void BuyMedicalCardWithBalance() throws InterruptedException {
        BuyMedicalCardSteps step = new BuyMedicalCardSteps(driver);
        driver.get("https://medical.test-pirveli.com/");

       step.AuthButton();
       step.SwitchToFrame();
       step.PhoneNumberInput(getLastGeneratedNumber());
       step.PasswordInput1(password);
       step.SubmitButton();
       driver.navigate().refresh();
       step.SwitchOutFromIframe();
       step.BuyMedCardButton();
       driver.navigate().refresh();
       step.PersonalIdInput(generateUniqueIdNumber());
       step.BuyCardWithBalance();
       step.Checkbox1();
       step.OrderButton();
       step.OrderView();
    }

//    @Test(description = "მედიქალ ბარათის ყიდვა - არასაკმარისი ბალანსით", priority = 3)
//    @Severity(SeverityLevel.CRITICAL)
//    @Link("https://medical.test-pirveli.com/")
//    public void BuyMedicalCardWithoutBalance() throws InterruptedException {
//        BuyMedicalCardSteps step = new BuyMedicalCardSteps(driver);
//        driver.get("https://medical.test-pirveli.com/");
//
//        step.AuthButton();
//        step.SwitchToFrame();
//        step.PhoneNumberInput(phoneNumberWithoutBlanace);
//        step.PasswordInput1(password);
//        step.SubmitButton();
//        driver.navigate().refresh();
//        step.SwitchOutFromIframe();
//        step.BuyMedCardButton();
//        driver.navigate().refresh();
//        step.PersonalIdInput(generateUniqueIdNumber());
//        step.BuyCardWithBalance();
//        step.Checkbox1();
//        step.OrderButton();
//
//        Assert.assertEquals("ანგარიშზე არ გაქვთ საკმარისი თანხა", driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[9]/div/div/div[2]/div[1]/div[4]/div[3]/div[1]/span")).getText());
//    }

}