package PageObject;

import org.openqa.selenium.By;

public class PasswordRecoveryPage {

    protected By
            authButton = By.xpath("//*[@id=\"__next\"]/div[2]/div[1]/header/div/div/div[2]/p/span"),
            passwordRecoveryLinkText = By.linkText("პაროლის აღდგენა"),
            phoneNumerField = By.id("username"),
            smsCodeButton = By.className("submit"),
            otpField = By.id("otp"),
            newPasswordField = By.id("password"),
            confirmationPasswordField = By.id("password-change"),
            dropDownButton = By.id("dropdownPosition");
}
