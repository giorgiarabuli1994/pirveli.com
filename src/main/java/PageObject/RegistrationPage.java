package PageObject;

import org.openqa.selenium.By;

public class RegistrationPage {

protected By
authButton = By.xpath("//*[@id=\"__next\"]/div[2]/div[1]/header/div/div/div[2]/p/span"),
regTextLink = By.linkText("რეგისტრაცია"),
firstNameField = By.id("firstName"),
lastNameField = By.id("lastName"),
phoneNumberField = By.id("username"),
emailField = By.id("user.attributes.mail"),
passwordField = By.id("password"),
confirmationPasswordField = By.id("password-confirm"),
checkBox = By.id("rememberMe"),
otpField = By.id("otp"),
otpButton = By.cssSelector("#kc-form-buttons > input"),
dropDownButton = By.id("dropdownPosition");
}
