import StepsObject.PasswordRecoverySteps;
import Utilis.ChromeRunner;
import io.qameta.allure.Link;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
import static DataObject.PasswordRecoveryData.*;

public class PasswordRecovery extends ChromeRunner {

    @Test(description = "პაროლის აღდგენა - სწორი მონაცემებით", priority = 1, groups = "positive")
    @Severity(SeverityLevel.CRITICAL)
    @Link("https://test-pirveli.com/")
    public void RecoveryPassworWithCorrectData() throws InterruptedException {
        PasswordRecoverySteps step = new PasswordRecoverySteps(driver);

        step.AuthButton();
        step.SwitchToFrame();
        step.PasswordRecoveryLinkText();
        step.PhoneNumberInput(registeredPhoneNumber);
        step.SmsCodeButton();
        step.OtpInput(correctOtp);
        step.Enter();
        step.NewPasswordsInputs(newBothePassword);
        step.Enter1();
        step.Dropdown();
    }

    @Test(description = "პაროლის აღდგენა ტელეფონი ნომრის გარეშე", priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @Link("https://test-pirveli.com/")
    public void RecoveryPassworWithoutPhoneNumber() throws InterruptedException {
        PasswordRecoverySteps step = new PasswordRecoverySteps(driver);

        step.AuthButton();
        step.SwitchToFrame();
        step.PasswordRecoveryLinkText();
        step.SmsCodeButton();

        Assert.assertEquals("შეიყვანე ნომერი*", driver.findElement(By.id("input-error-lastname")).getText());
    }

    @Test(description = "პაროლის აღდგენა - არასწორი OTP კოდით", priority = 3)
    @Severity(SeverityLevel.CRITICAL)
    @Link("https://test-pirveli.com/")
    public void RecoveryPassworWithIncorrectOtp() throws InterruptedException {
        PasswordRecoverySteps step = new PasswordRecoverySteps(driver);

        step.AuthButton();
        step.SwitchToFrame();
        step.PasswordRecoveryLinkText();
        step.PhoneNumberInput(registeredPhoneNumber);
        step.SmsCodeButton();
        step.OtpInput(incorrectOtp);
        step.Enter();

        Assert.assertEquals("კოდი არასწორია", driver.findElement(By.id("input-error-password")).getText());
    }

    @Test(description = "პაროლის აღდგენა - OTP კოდის გარეშე", priority = 4)
    @Severity(SeverityLevel.CRITICAL)
    @Link("https://test-pirveli.com/")
    public void RecoveryPassworWithoutOtp() throws InterruptedException {
        PasswordRecoverySteps step = new PasswordRecoverySteps(driver);

        step.AuthButton();
        step.SwitchToFrame();
        step.PasswordRecoveryLinkText();
        step.PhoneNumberInput(registeredPhoneNumber);
        step.SmsCodeButton();
        step.Enter();

        String msg = driver.findElement(By.xpath("//input[@id='otp']")).getAttribute("validationMessage");
        Assert.assertEquals("კოდის შეყვანა აუცილებელია", msg);
    }

    @Test(description = "პაროლის აღდგენა - ახალი პაროლების გარეშე", priority = 5)
    @Severity(SeverityLevel.CRITICAL)
    @Link("https://test-pirveli.com/")
    public void RecoveryPassworWithoutNewPasswords() throws InterruptedException {
        PasswordRecoverySteps step = new PasswordRecoverySteps(driver);

        step.AuthButton();
        step.SwitchToFrame();
        step.PasswordRecoveryLinkText();
        step.PhoneNumberInput(registeredPhoneNumber);
        step.SmsCodeButton();
        step.OtpInput(correctOtp);
        step.Enter();
        step.Enter1();

        Assert.assertEquals("შეიყვანე პაროლი*", driver.findElement(By.className("message-text")).getText());
    }

    @Test(description = "პაროლის აღდგენა - არასწორი დამადასტურებელი პაროლით", priority = 6)
    @Severity(SeverityLevel.CRITICAL)
    @Link("https://test-pirveli.com/")
    public void RecoveryPassworWithIncorrectConfirmationPassword() throws InterruptedException {
        PasswordRecoverySteps step = new PasswordRecoverySteps(driver);

        step.AuthButton();
        step.SwitchToFrame();
        step.PasswordRecoveryLinkText();
        step.PhoneNumberInput(registeredPhoneNumber);
        step.SmsCodeButton();
        step.OtpInput(correctOtp);
        step.Enter();
        step.NewPasswordInput(newPassword);
        step.ConfirmationNewPassword(incorrectPasswordConfirmation);
        step.Enter1();

        Assert.assertEquals("შეყვანილი პაროლები არ ემთხვევა ერთმანეთს", driver.findElement(By.id("input-error-password")).getText());
    }
}