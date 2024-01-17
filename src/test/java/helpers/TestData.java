package helpers;

import com.github.javafaker.Faker;

public class TestData {
    final Faker faker = new Faker();
    public final String randomEmail = faker.internet().emailAddress();
    public final String randomPassword = faker.random().hex(6);
}
