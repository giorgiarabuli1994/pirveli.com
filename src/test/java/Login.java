import StepsObject.LoginSteps;
import Utilis.ChromeRunner;
import Utilis.EdgeRunner;
import Utilis.FirefoxRunner;
import Utilis.SafariRunner;
import io.qameta.allure.Link;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;

import static DataObject.LoginData.*;

public class Login extends ChromeRunner {

    @Test(description = "ავტორიზაცია - სწორი მონაცემებით", priority = 1, groups = "positive", invocationCount = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Link("https://test-pirveli.com/")
    public void LoginWithCorrectData() throws InterruptedException {
        LoginSteps step = new LoginSteps(driver);

        step.AuthButton();
        step.SwitchToFrame();
        step.PhoneNumberInput(registeredPhoneNumber);
        step.PasswordInput(password);
        step.Enter();
        step.Dropdown();
    }

    @Test(description = "ავტორიზაცია არსწორი პაროლით", priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @Link("https://test-pirveli.com/")
    public void LoginWithIncorrectPassword() throws InterruptedException {
        LoginSteps step = new LoginSteps(driver);

        step.AuthButton();
        step.SwitchToFrame();
        step.PhoneNumberInput(registeredPhoneNumber);
        step.PasswordInput(incorrectPassword);
        step.Enter();

        Assert.assertEquals("არასწორი მობილურის ნომერი ან პაროლი", driver.findElement(By.className("message-text")).getText());
    }

    @Test(description = "ავტორიზაცია ცარიელი ველებით", priority = 3)
    @Severity(SeverityLevel.CRITICAL)
    @Link("https://test-pirveli.com/")
    public void LoginWithEmptyFields() throws InterruptedException {
        LoginSteps step = new LoginSteps(driver);

        step.AuthButton();
        step.SwitchToFrame();
        step.Enter();

        Assert.assertEquals("არასწორი მობილურის ნომერი ან პაროლი", driver.findElement(By.className("message-text")).getText());
    }
}
