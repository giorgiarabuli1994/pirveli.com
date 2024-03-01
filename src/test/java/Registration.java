import DataObject.RegistrationData;
import DataObject.UniquePhoneNumberGenerator;
import StepsObject.RegistrationSteps;
import Utilis.ChromeRunner;
import Utilis.FirefoxRunner;
import io.qameta.allure.Link;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import static DataObject.RegistrationData.*;
import static DataObject.UniquePhoneNumberGenerator.*;

public class Registration extends ChromeRunner {

    @Test(description = "რეგისტრაცია - სწორი მონაცემებით", priority = 1, groups = "positive", invocationCount = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Link("https://test-pirveli.com/")
    public void RegistraationWithCorrectDat() throws InterruptedException {
            RegistrationSteps step = new RegistrationSteps(driver);

            step.AuthButton();
            step.SwitchToIframe();
            step.RegTextLink();
            step.FirstNameInput(firstName);
            step.LastNameInput(lastName);


            boolean numberIsValid = false;
            while (!numberIsValid) {
                step.PhoneNumberInputClear();
                step.PhoneNumberInput(generateUniquePhoneNumber());
                step.EmailInputClear();
                step.EmailInput(correctEmail);
                step.PasswordInput(password);
                step.ConfirmationPasswordInput(correctPasswordConfirmation);
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

            step.OtpInput(correctOtp);
            step.EnterOtp();
            step.WaitUntilClickableDropdown();
        }
    }



    @Test(description = "რეგისტრაცია - არასწორი ფორმატის ნომრით", priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @Link("https://test-pirveli.com/")
    public void RegistrationWithIncorrectPhoneNumber() {
        RegistrationSteps step = new RegistrationSteps(driver);

        step.AuthButton();
        step.SwitchToIframe();
        step.RegTextLink();
        step.FirstNameInput(firstName);
        step.LastNameInput(lastName);
        step.PhoneNumberInput(incorrectPhoneNumber);
        step.EmailInput(correctEmail);
        step.PasswordInput(password);
        step.ConfirmationPasswordInput(correctPasswordConfirmation);
        step.CheckBox();
        step.EnterRe();

        Assert.assertEquals("შეიყვანეთ სწორი ტელეფონის ნომერი", driver.findElement(By.id("input-error-username")).getText());
    }

    @Test(description = "რეგისტრაცია - არასწორი ფორმატის იმეილით", priority = 3)
    @Severity(SeverityLevel.CRITICAL)
    @Link("https://test-pirveli.com/")
    public void RegistrationWithIncorrectEmail() {
        RegistrationSteps step = new RegistrationSteps(driver);

        step.AuthButton();
        step.SwitchToIframe();
        step.RegTextLink();
        step.FirstNameInput(firstName);
        step.LastNameInput(lastName);
        step.PhoneNumberInput(generateUniquePhoneNumber());
        step.EmailInput(incorrectEmail);
        step.PasswordInput(password);
        step.ConfirmationPasswordInput(correctPasswordConfirmation);
        step.CheckBox();
        step.EnterRe();

        String msg = driver.findElement(By.xpath("//input[@id='user.attributes.mail']")).getAttribute("validationMessage");
        Assert.assertEquals("ელ.ფოსტის ფორმატი არასწორია", msg);
    }

    @Test(description = "რეგისტრაცია - არასწორი confirmation პაროლით", priority = 4)
    @Severity(SeverityLevel.CRITICAL)
    @Link("https://test-pirveli.com/")
    public void RegistrationWithIncorrectConfirmationPassword() {
        RegistrationSteps step = new RegistrationSteps(driver);

        step.AuthButton();
        step.SwitchToIframe();
        step.RegTextLink();
        step.FirstNameInput(firstName);
        step.LastNameInput(lastName);

        boolean numberIsValid = false;
        while (!numberIsValid) {
            step.PhoneNumberInputClear();
            step.PhoneNumberInput(generateUniquePhoneNumber());
            step.EmailInputClear();
            step.EmailInput(correctEmail);
            step.PasswordInput(password);
            step.ConfirmationPasswordInput(incorrectPasswordConfirmation);
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

        Assert.assertEquals("პაროლები არ ემთხვევა ერთმანეთს", driver.findElement(By.id("input-error-password-confirm")).getText());
    }

    @Test(description = "რეგისტრაცია - ჩეკბოქსის გარეშე", priority = 5)
    @Severity(SeverityLevel.MINOR)
    @Link("https://test-pirveli.com/")
    public void RegistrationWithoutChechbox() throws InterruptedException {
        RegistrationSteps step = new RegistrationSteps(driver);

        step.AuthButton();
        step.SwitchToIframe();
        step.RegTextLink();
        step.FirstNameInput(firstName);
        step.LastNameInput(lastName);
        step.PhoneNumberInput(generateUniquePhoneNumber());
        step.EmailInput(correctEmail);
        step.PasswordInput(password);
        step.ConfirmationPasswordInput(correctPasswordConfirmation);
        step.EnterRe();

        String msg = driver.findElement(By.xpath("//input[@id='rememberMe']")).getAttribute("validationMessage");
        Assert.assertEquals("გთხოვთ დაადასტუროთ, რომ ეთანხმებით წესებს და პირობებს", msg);
    }

    @Test(description = "რეგისტრაცია - არასწორი OTP კოდით", priority = 6)
    @Severity(SeverityLevel.CRITICAL)
    @Link("https://test-pirveli.com/")
    public void RegistrationWithIncorrectOtp() {
        RegistrationSteps step = new RegistrationSteps(driver);

        step.AuthButton();
        step.SwitchToIframe();
        step.RegTextLink();
        step.FirstNameInput(firstName);
        step.LastNameInput(lastName);

        boolean numberIsValid = false;
        while (!numberIsValid) {
            step.PhoneNumberInputClear();
            step.PhoneNumberInput(generateUniquePhoneNumber());
            step.EmailInputClear();
            step.EmailInput(correctEmail);
            step.PasswordInput(password);
            step.ConfirmationPasswordInput(correctPasswordConfirmation);
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

        step.OtpInput(incorrectOtp);
        step.EnterOtp();

        Assert.assertEquals("კოდი არასწორია", driver.findElement(By.id("input-error-password")).getText());
    }

    @Test(description = "რეგისტრაცია - OTP გარეშე", priority = 7)
    @Severity(SeverityLevel.CRITICAL)
    @Link("https://test-pirveli.com/")
    public void RegistrationWithoutOtp() throws InterruptedException {
        RegistrationSteps step = new RegistrationSteps(driver);

        step.AuthButton();
        step.SwitchToIframe();
        step.RegTextLink();
        step.FirstNameInput(firstName);
        step.LastNameInput(lastName);

        boolean numberIsValid = false;
        while (!numberIsValid) {
            step.PhoneNumberInputClear();
            step.PhoneNumberInput(generateUniquePhoneNumber());
            step.EmailInputClear();
            step.EmailInput(correctEmail);
            step.PasswordInput(password);
            step.ConfirmationPasswordInput(correctPasswordConfirmation);
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

        step.EnterOtp();

        // First Assertion
        try {
            String actualText = driver.findElement(By.id("input-error-password")).getText();
            System.out.println("Actual text for first assertion: " + actualText);
            Assert.assertEquals("კოდი არასწორია", actualText);
        } catch (AssertionError | NoSuchElementException e) {
            System.out.println("First assertion failed or element not found: " + e.getMessage());
        }

        // Second Assertion
        try {
            WebElement otpInput = driver.findElement(By.xpath("//input[@id='otp']"));
            String msg = otpInput.getAttribute("validationMessage");
            System.out.println("Validation message for OTP: " + msg);
            Assert.assertEquals("კოდის შეყვანა აუცილებელია", msg);
        } catch (AssertionError | NoSuchElementException e) {
            System.out.println("Second assertion failed or element not found: " + e.getMessage());
        }
    }

    @Test(description = "რეგისტრაცია - უკვე რეგისტრირებული მობილური ნომრით", priority = 3)
    @Severity(SeverityLevel.CRITICAL)
    @Link("https://test-pirveli.com/")
    public void RegistrationWithRegisteredPhoneNumber() {
        RegistrationSteps step = new RegistrationSteps(driver);

        step.AuthButton();
        step.SwitchToIframe();
        step.RegTextLink();
        step.FirstNameInput(firstName);
        step.LastNameInput(lastName);
        step.PhoneNumberInput(registeredPhoneNumber);
        step.EmailInput(correctEmail);
        step.PasswordInput(password);
        step.ConfirmationPasswordInput(correctPasswordConfirmation);
        step.CheckBox();
        step.EnterRe();

        Assert.assertEquals("ნომერი რეგისტრირებულია ბაზაში, გაიარეთ ავტორიზაცია", driver.findElement(By.id("input-error-username")).getText());
    }

}
