package StepsObject;

import PageObject.PasswordRecoveryPage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PasswordRecoverySteps extends PasswordRecoveryPage {

    WebDriver driver;
    public PasswordRecoverySteps(WebDriver driver1) {
        driver = driver1;
    }

    @Step("შესვლა ღილაკზე დაკლიკვა")
    public void AuthButton(){
        driver.findElement(authButton).click();
    }
    @Step("აიფრეიმში შესვლა და დაყოვნება")
    public void SwitchToFrame() {
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("loginIframe")));
    }
    @Step("პაროლის აღდგენაზე დაკლიკვა")
    public void PasswordRecoveryLinkText(){
        driver.findElement(passwordRecoveryLinkText).click();
    }
    @Step("მობილური ნომრის შეყვანა")
    public void PhoneNumberInput(String s){
        driver.findElement(phoneNumerField).sendKeys(s);
    }
    @Step("სმს კოდის მიღება ღილაკზე დაკლიკვა")
    public void SmsCodeButton(){
        driver.findElement(smsCodeButton).click();
    }
    @Step("Otp კოდის შეყვანა")
    public void OtpInput(String s){
        driver.findElement(otpField).sendKeys(s);
    }
    @Step("პაროლის აღდგენაზე ენთერის დაჭერა")
    public void Enter(){
        driver.findElement(otpField).sendKeys(Keys.ENTER);
    }
    @Step("ახალი პაროლის შეყვანა ორივეგან")
    public void NewPasswordsInputs(String s){
        driver.findElement(newPasswordField).sendKeys(s);
        driver.findElement(confirmationPasswordField).sendKeys(s);
    }
    @Step("ახალი პაროლის შეყვანა")
    public void NewPasswordInput(String s){
        driver.findElement(newPasswordField).sendKeys(s);
    }
    @Step("აროლის დადასტურება")
    public void ConfirmationNewPassword(String s){
        driver.findElement(confirmationPasswordField).sendKeys(s);
    }
    @Step("ენთერზე დაჭერა ახალი პაროლისთვის")
    public void Enter1(){
        driver.findElement(confirmationPasswordField).sendKeys(Keys.ENTER);
    }
    @Step("პროფილის დროპდაუნის ჩამოშლა")
    public void Dropdown(){
        driver.findElement(dropDownButton).click();
    }
}
