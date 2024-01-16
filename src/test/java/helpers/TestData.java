package helpers;

import com.github.javafaker.Faker;

public class TestData {
    final Faker faker = new Faker();
    public final String email = "rashitsahbutdinov@yandex.ru";
    public final String password = "mdf9MsZs2bbM7kq_";
    public final String randomEmail = faker.internet().emailAddress();
    public final String randomPassword = faker.random().hex(6);
}
