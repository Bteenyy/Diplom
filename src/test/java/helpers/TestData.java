package helpers;

import com.github.javafaker.Faker;

public class TestData {
    Faker faker = new Faker();
    public String email = "rashitsahbutdinov@yandex.ru";
    public String password = "mdf9MsZs2bbM7kq_";
    public String randomEmail = faker.internet().emailAddress();
    public String randomPassword = faker.random().hex(6);
}
