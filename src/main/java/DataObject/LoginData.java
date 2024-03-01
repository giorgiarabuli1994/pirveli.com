package DataObject;

import com.github.javafaker.Faker;

public interface LoginData {

    Faker faker = new Faker();

    String
        registeredPhoneNumber = faker.bothify("509510511"),
        password = faker.bothify("123456"),
        incorrectPassword = faker.bothify("1234");

}
