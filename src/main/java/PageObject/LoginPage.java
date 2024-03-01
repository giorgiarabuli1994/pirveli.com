package PageObject;

import org.openqa.selenium.By;

public class LoginPage {

    protected By
            authButton = By.xpath("//*[@id=\"__next\"]/div[2]/div[1]/header/div/div/div[2]/p"),
            phoneNumberField = By.id("username"),
            passwordField = By.id("txtPassword"),
            submitButton = By.className("submit"),
            dropDownButton = By.id("dropdownPosition");
}
