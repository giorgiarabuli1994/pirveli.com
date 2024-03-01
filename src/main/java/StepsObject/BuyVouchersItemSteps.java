package StepsObject;

import PageObject.BuyVouchersItemPage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BuyVouchersItemSteps extends BuyVouchersItemPage {

    WebDriver driver;
    public BuyVouchersItemSteps(WebDriver driver1) {
        driver = driver1;
    }

    @Step("დამატების ღილაკზე დაჭერა")
    public void AddButton(){
        driver.findElement(addButton).click();
    }
    @Step("შესვლა ღილაკზე დაჭერა")
    public void LoginButton(){
        driver.findElement(loginButton).click();
    }
    @Step("აიფრეიმში შესვლა და დაყოვნება")
    public void SwitchToFrame() {
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("/html/body/div[3]/div/div[2]/div/div[2]/div[1]/div[2]/iframe")));
    }
    @Step("ტელეფონის ნომრის შეყვანა")
    public void PhoneNumberInput(String s){driver.findElement(phoneNumberField).sendKeys(s);}
    @Step("პაროლის შეყვანა")
    public void PasswordInput(String s){driver.findElement(passwordField).sendKeys(s);}
    @Step("ავტორიზაციის ენთერზე დაჭერა")
    public void Enter(){driver.findElement(submitButton).sendKeys(Keys.ENTER);}
    @Step("ქულებით გადახდის არჩევა")
    public void BuyWithCoins(){
        driver.findElement(buyWithCoins).click();
    }
    @Step("ბალანსით გადახდის არჩევა")
    public void BuyWithBalance(){
        driver.findElement(buyWithBalance).sendKeys(Keys.ENTER);
    }
    @Step("ბალანსის შევსების ღილაკზე დაჭერა")
    public void AddBalance(){
        driver.findElement(addBalance).click();
    }
    @Step("ყიდვა ღილაკზე დაჭერა")
    public void BuyButton(){
        driver.findElement(buyButton).click();
    }
    @Step("შეკვეთის გაფორმება")
    public void OrderButton(){
        driver.findElement(orderButton).sendKeys(Keys.ENTER);
    }
    @Step("შეკვეთის ნახვის ღილაკზე დაჭერა")
    public void ViewOrder(){
        driver.findElement(viewOrder).click();
    }
}
