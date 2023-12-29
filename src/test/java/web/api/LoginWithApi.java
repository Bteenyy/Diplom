package web.api;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import web.models.User;

import static io.restassured.RestAssured.given;
import static web.specs.Spec.requestSpec;
import static web.specs.Spec.responseSpec;

public class LoginWithApi {
    @Step("Authorization")
    public Response getAuth() {
        User user = new User();
        user.setLogin("rasitsahbutdinov915455@gmail.com");
        user.setPassword("mdf9MsZs2bbM7kq_");
        return given(requestSpec)
                .body(user)
                .when()
                .post("https://api.deeray.com/v1/account/login")
                .then()
                .spec(responseSpec)
                .statusCode(200)
                .extract().response();
    }
}
