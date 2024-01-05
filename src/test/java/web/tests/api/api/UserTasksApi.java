package web.tests.api.api;

import web.tests.api.models.AuthorizationResponseModel;
import web.tests.api.models.LoginBodyModel;

public class UserTasksApi {
    LoginBodyModel loginBodyModel = new LoginBodyModel("rasitsahbutdinov915455@gmail.com","mdf9MsZs2bbM7kq_");
    AuthorizationApi authorizationApi = new AuthorizationApi();
    AuthorizationResponseModel authorizationResponseModel = authorizationApi.login(loginBodyModel);

}
