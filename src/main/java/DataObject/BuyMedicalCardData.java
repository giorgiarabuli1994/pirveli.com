package DataObject;

import com.github.javafaker.Faker;

public interface BuyMedicalCardData {

    Faker faker = new Faker();

    String
            firstName = faker.name().firstName(),
            lastName = faker.bothify("ტესტერ"),
            phoneNumberWithoutBlanace = faker.bothify("539728023"),
            email = faker.bothify("?????###@gmail.com"),
            password = faker.bothify("12345678"),
            passwordConfirmation = faker.bothify("12345678"),
            otp = faker.bothify("1234");

}
