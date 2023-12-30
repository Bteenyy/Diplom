package web.tests.api;

import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import web.tests.api.models.ErrorResponseModel;
import web.tests.api.models.LoginBodyModel;

import static org.assertj.core.api.Assertions.assertThat;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static web.tests.api.specs.Spec.*;

@Tag("api")
public class LoginTests extends TestBase {
    @Test
    @DisplayName("Check response status of login")
    @Story("Testing of successful login using method POST")
    void checkLoginStatus() {
        LoginBodyModel user = new LoginBodyModel();
        user.setEmail("rasitsahbutdinov915455@gmail.com");
        user.setPassword("mdf9MsZs2bbM7kq_");
        step("Check that response status is 200", () -> {
            given(LoginTestRequestSpec)
                    .body(user)
                    .when()
                    .post("/v1/account/login")
                    .then()
                    .spec(LoginTestResponseSpec)
                    .statusCode(200);
        });
    }

    @Test
    @DisplayName("Check response status of login without cookie and body")
    @Story("Testing of unsuccessful login using method POST")
    @Tag("negative")
    void checkLoginStatusNegative() {
        LoginBodyModel user = new LoginBodyModel();
        user.setEmail("ras");
        user.setPassword("mdf9MsZs2bbM7kq_");
        ErrorResponseModel response =
                step("Try to login and check code", () ->
                        given(LoginTestRequestSpec)
                                .body(user)
                                .when()
                                .post("/v1/account/login")
                                .then()
                                .spec(LoginTestResponseSpec)
                                .statusCode(200)
                                .extract().as(ErrorResponseModel.class));
        step("Verify error message", () -> {
            assertThat(response.getCode()).isEqualTo(101);
        });
    }
}