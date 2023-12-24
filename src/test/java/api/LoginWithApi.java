package api;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import models.SuccessfulRegisterBodyModel;

import static io.restassured.RestAssured.given;
import static spec.RegAndResSpec.*;

public class LoginWithApi {
    @Step("Authorization")
    public Response getAuth() {
        SuccessfulRegisterBodyModel successfulRegisterBodyModel = new SuccessfulRegisterBodyModel();
        successfulRegisterBodyModel.setUserName("Bteeny");
        successfulRegisterBodyModel.setPassword("Test(111)^");
        return given(requestSpec)
                .body(successfulRegisterBodyModel)
                .when()
                .post("/Account/v1/Login")
                .then()
                .spec(responseSpec)
                .statusCode(200)
                .extract().response();
    }

}