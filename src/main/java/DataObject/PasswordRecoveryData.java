package DataObject;

import com.github.javafaker.Faker;

public interface PasswordRecoveryData {

    Faker faker = new Faker();

    String
    registeredPhoneNumber = faker.bothify("550001915"),
    incorrectPhoneNumber = faker.bothify("555#####"),
    correctOtp = faker.bothify("1234"),
    incorrectOtp = faker.bothify("4321"),
    newBothePassword = faker.bothify("???###"),
    newPassword = faker.bothify("8765431"),
    incorrectPasswordConfirmation = faker.bothify("???#####");
}
