package StepsObject;

import PageObject.RegistrationPage;
import com.google.common.annotations.VisibleForTesting;
import io.qameta.allure.Step;
import net.bytebuddy.asm.MemberSubstitution;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.plaf.PanelUI;
import java.time.Duration;

public class RegistrationSteps extends RegistrationPage {
    WebDriver driver;
    public RegistrationSteps(WebDriver driver1){
        driver = driver1;
    }

@Step("შესვლა ღილაკზე დაკლიკვა")
public void AuthButton(){
        driver.findElement(authButton).click();
}
@Step("აიფრეიმში შესვლა და დაყოვნება")
public void SwitchToIframe() {
    new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("loginIframe")));
}
@Step("რეგისტრაციაზე დაკლიკვა")
public void RegTextLink(){
        driver.findElement(regTextLink).click();
}
@Step("სახელის შეყვანა")
public void FirstNameInput(String s){
        driver.findElement(firstNameField).sendKeys(s);
}
@Step("გვარის შეყვანა")
public void LastNameInput(String s){
        driver.findElement(lastNameField).sendKeys(s);
}
@Step("ტელეფონის ნომრის შეყვანა")
public void PhoneNumberInput(String s){
        driver.findElement(phoneNumberField).sendKeys(s);
}
@Step("ტელეფონის ინფუთის გასუფთავება")
public void PhoneNumberInputClear(){ driver.findElement(phoneNumberField).clear(); }
@Step("იმეილის შეყვანა")
public void EmailInput(String s){
        driver.findElement(emailField).sendKeys(s);
}
@Step("იმეილის ინფუთის გასუფთავება")
public void EmailInputClear(){
        driver.findElement(emailField).clear();
}
@Step("პაროლის შეყვანა")
    public void PasswordInput(String s){
        driver.findElement(passwordField).sendKeys(s);
}
@Step("დადასტურებული პაროლის შეყვანა")
    public void ConfirmationPasswordInput(String s){
        driver.findElement(confirmationPasswordField).sendKeys(s);
}
@Step("ჩეკბოქსის მონიშვნა")
    public void CheckBox(){
        driver.findElement(checkBox).click();
}
@Step("რეგისტრაციისას ენთერზე დაჭერა")
    public void EnterRe(){driver.findElement(confirmationPasswordField).sendKeys(Keys.ENTER);}
@Step("OTP შეყვანა")
    public void OtpInput(String s){
        driver.findElement(otpField).sendKeys(s);
}
@Step("OTP - ზე ენთერზე დაჭერა")
    public void EnterOtp(){
        driver.findElement(otpButton).sendKeys(Keys.ENTER);
}
//@Step("აიფრეიმიდან გამოსვლა")
//public void SwitchOutFromIframe(){
//    driver.switchTo().defaultContent();
//}
@Step("დაყოვნება, სანამ დაკლიკვადი არ იქნება")
public void WaitUntilClickableDropdown(){
//    Wait<WebDriver> waitForDropdown = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(500)).ignoring(NoSuchElementException.class);
//    waitForDropdown.until(ExpectedConditions.presenceOfElementLocated(dropDownButton)).click();
    driver.findElement(dropDownButton).click();
}

}

