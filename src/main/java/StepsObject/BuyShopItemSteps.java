package StepsObject;

import PageObject.BuyShopItemPage;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BuyShopItemSteps extends BuyShopItemPage {

    WebDriver driver;
    public BuyShopItemSteps(WebDriver driver1) {
        driver = driver1;
    }

    @Step("შესვლა ღილაკზე დაჭერა")
    public void AddButton(){
        driver.findElement(addButton).click();
    }
    @Step("ტელეფონის ნომრის შეყვანა")
    public void PhoneNumberInput(String s){driver.findElement(phoneNumberField).sendKeys(s);}
    @Step("პაროლის შეყვანა")
    public void PasswordInput(String s){driver.findElement(passwordField).sendKeys(s);}
    @Step("ავტორიზაციის ენთერზე დაჭერა")
    public void Enter(){driver.findElement(submitButton).sendKeys(Keys.ENTER);}
    @Step("ბალანსის არჩევა")
    public void BuyWithBalance(){
        driver.findElement(balance).click();
    }

    @Step("შეკვეთის გაფორმებაზე დაჭერა")
    public void OrderButton(){
//        driver.findElement(orderButton).sendKeys(Keys.PAGE_UP);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(orderButton)).click();
//        FluentWait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(500)).ignoring(NoSuchElementException.class);
//        wait.until(ExpectedConditions.elementToBeClickable(orderButton)).click();
    }
    @Step("შეკვეთის ნახვა")
    public void OrderView(){
        driver.findElement(orderView).click();
    }


}
