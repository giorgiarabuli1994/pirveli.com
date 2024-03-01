package PageObject;

import org.openqa.selenium.By;

public class BuyShopItemPage {

    protected By
            addButton = By.id("add_to_cart_button_2679"),
            phoneNumberField = By.id("username"),
            passwordField = By.id("txtPassword"),
            submitButton = By.className("submit"),
            balance = By.xpath("//*[@id=\"litecheckout_step_payment\"]/div/div[1]/div[1]/div[3]"),
            orderButton = By.xpath("/html/body/div/div[4]/div[3]/div/div[2]/div/div[2]/div[2]/div/form/div[2]/button"),
            orderView = By.className("view-order");
    ;
}
