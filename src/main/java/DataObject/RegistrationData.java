package DataObject;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;


public interface RegistrationData {

    Faker faker = new Faker();

    String
         firstName = faker.bothify("Automation"),
         lastName = faker.bothify("გიო"),
         registeredPhoneNumber = faker.bothify("550001915"),
         incorrectPhoneNumber = faker.bothify("550#####"),
         correctEmail = faker.bothify("?????###@gmail.com"),
         incorrectEmail = faker.bothify("?????###gmail.com"),
         password = faker.bothify("123456"),
         correctPasswordConfirmation = faker.bothify("123456"),
         incorrectPasswordConfirmation = faker.bothify("######"),
         correctOtp = faker.bothify("1234"),
         incorrectOtp = faker.bothify("####");
}