package DataObject;

import com.github.javafaker.Faker;

public interface BuyShopItemData {


    Faker faker = new Faker();

    String
            userWithBalance = faker.bothify("539094732"),
            userWithoutBalance = faker.bothify("539829277"),
            password = faker.bothify("1234");
}
