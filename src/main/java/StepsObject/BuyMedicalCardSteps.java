package StepsObject;

import PageObject.BuyMedicalCardPage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BuyMedicalCardSteps extends BuyMedicalCardPage {

    WebDriver driver;
    public BuyMedicalCardSteps(WebDriver driver1) {
        driver = driver1;
    }
    @Step("აიფრეიმში შესვლა და დაყოვნება")
    public void SwitchToFrame() {
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//*[@id=\"__next\"]/div/div[4]/div[2]/iframe")));
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
    @Step("იმეილის ინფუთის გასუთავება")
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
        driver.findElement(otpField).sendKeys(Keys.ENTER);
    }
    @Step("აიფრეიმიდან გამოსვლა")
    public void SwitchOutFromIframe(){
        driver.switchTo().defaultContent();
    }
    @Step("შესვლა ღილაკზე დაჭერა")
    public void AuthButton(){
        driver.findElement(authbutton).click();
    }
    @Step("ავტორიზაციის ენთერზე დაჭერა")
    public void SubmitButton(){
        driver.findElement(submitButton).sendKeys(Keys.ENTER);
    }
    @Step("პაროლის შეყვანა")
    public void PasswordInput1(String s){
        driver.findElement(passwordField1).sendKeys(s);
    }
    @Step("ბარათის ყიდვის ღილაკზე დაჭერა")
    public void BuyMedCardButton(){
        FluentWait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(500)).ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.elementToBeClickable(buyMedCardButton)).click();
    }
    @Step("პირადი ნომრის შეყვანა")
    public void PersonalIdInput(String s){
        driver.findElement(personalIdField).sendKeys(s);
    }

    @Step("ბალანსის არჩევა")
    public void BuyCardWithBalance(){
        driver.findElement(buyCardWithBalance).click();
    }
    @Step("შეკვეთის გაფორმება")
    public void OrderButton(){
        driver.findElement(orderButton).click();
    }
    @Step("ჩეკბოქსის მონიშვნა")
    public void Checkbox1(){
        driver.findElement(checkBox1).click();
    }
    @Step("შეკვეთის ნახვა")
    public void OrderView(){
        driver.findElement(orderView).click();
    }


}
