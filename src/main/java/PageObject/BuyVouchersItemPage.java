package PageObject;

import org.openqa.selenium.By;

public class BuyVouchersItemPage {

    protected By
            addButton = By.xpath("//div[@class='hidden lg:block w-[450px] shrink-0']//div[@class='h-[48px] rounded-xl w-min px-10 flex justify-center items-center cursor-pointer bg-[#8338EC] hover:!bg-[#7423e6] !w-full aveSofRegular']"),
            loginButton = By.xpath("/html/body/div[1]/header/div/div[1]/div[2]/div[2]/p/div/div"),
            phoneNumberField = By.id("username"),
            passwordField = By.id("txtPassword"),
            submitButton = By.className("submit"),
            buyWithCoins = By.xpath("//*[@id=\"__next\"]/main/div/div[1]/div[1]/div/div[1]/div"),
            buyWithBalance = By.xpath("//*[@id=\"__next\"]/main/div/div[1]/div[1]/div/div[3]/div"),
            buyButton = By.xpath("//*[@id=\"__next\"]/main/div/div[1]/div[2]/div"),
            orderButton = By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div/div/div[2]/button[2]"),
            addBalance = By.xpath("//*[@id=\"__next\"]/main/div/div[1]/div[1]/div/div[3]/div[2]/div/div/div[2]/p"),
            viewOrder = By.xpath("//*[@id=\"__next\"]/main/div/div[2]/div/div/button[3]/p");
}
