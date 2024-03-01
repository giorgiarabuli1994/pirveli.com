package PageObject;

import org.openqa.selenium.By;

public class BuyMedicalCardPage {

    protected By

            firstNameField = By.id("firstName"),
            lastNameField = By.id("lastName"),
            phoneNumberField = By.id("username"),
            emailField = By.id("user.attributes.mail"),
            passwordField = By.id("password"),
            passwordField1 = By.id("txtPassword"),
            confirmationPasswordField = By.id("password-confirm"),
            checkBox = By.id("rememberMe"),
            otpField = By.id("otp"),
            authbutton = By.className("headerFooter_signInBtnStyle__f4uu8"),
            submitButton = By.className("submit"),
            buyMedCardButton = By.xpath("/html/body/div[1]/div/div[9]/div[1]/div/div[1]/div/div/div/div[1]/button"),
            personalIdField = By.name("personalid"),
            buyCardWithBalance = By.xpath("//*[@id=\"__next\"]/div/div[9]/div/div/div[2]/div[1]/div[4]/div[2]/div/label[2]"),
            orderButton = By.className("order_orderCreateBtn__om2jc"),
            checkBox1 = By.xpath("//*[@id=\"__next\"]/div/div[9]/div/div/div[2]/div[2]/div/div[2]/div[2]/div[2]/label[2]/span[1]/input"),
            orderView = By.xpath("//*[@id=\"__next\"]/div/div[9]/div[2]/div[2]/button[2]");




}
