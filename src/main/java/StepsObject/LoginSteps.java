package StepsObject;

import PageObject.LoginPage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginSteps extends LoginPage {
    WebDriver driver;
    public LoginSteps(WebDriver driver1) {
        driver = driver1;
    }

    @Step("შესვლა ღილაკზე დაჭერა")
    public void AuthButton(){
        driver.findElement(authButton).click();
    }
    @Step("აიფრეიმში შესვლა და დაყოვნება")
    public void SwitchToFrame() {
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("loginIframe")));
    }
    @Step("ტელეფონის ნომრის შეყვანა")
    public void PhoneNumberInput(String s){driver.findElement(phoneNumberField).sendKeys(s);}
    @Step("პაროლის შეყვანა")
    public void PasswordInput(String s){driver.findElement(passwordField).sendKeys(s);}
    @Step("ავტორიზაციის ენთერზე დაჭერა")
    public void Enter(){driver.findElement(submitButton).sendKeys(Keys.ENTER);}
    @Step("დროპდაუნის ჩამოშლა")
    public void Dropdown(){driver.findElement(dropDownButton).click();}
}
