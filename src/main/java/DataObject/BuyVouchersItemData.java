package DataObject;

import com.github.javafaker.Faker;

public interface BuyVouchersItemData {

    Faker faker = new Faker();

    String
            phoneNumberWithBlanace = faker.bothify("539094732"),
            phoneNumberWithoutBlanace = faker.bothify("539829277"),
            password = faker.bothify("1234");
}
