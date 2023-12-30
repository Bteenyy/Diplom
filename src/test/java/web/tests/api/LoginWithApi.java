package web.tests.api;

import io.qameta.allure.Step;
import web.tests.api.models.User;

import static io.restassured.RestAssured.given;
import static web.tests.api.specs.Spec.requestSpec;
import static web.tests.api.specs.Spec.responseSpec;

public class LoginWithApi {
    @Step("Authorization")
    void getAuth() {
        User user = new User();
        user.setEmail("rasitsahbutdinov915455@gmail.com");
        user.setPassword("mdf9MsZs2bbM7kq_");
        User responseUser = given(requestSpec)
                .body(user)
                .when()
                .post("https://api.deeray.com/v1/account/login")
                .then()
                .spec(responseSpec)
                .statusCode(200)
                .extract().as(User.class);
    }
}
