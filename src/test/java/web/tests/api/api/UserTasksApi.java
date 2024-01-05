package web.tests.api.api;

import web.tests.api.models.AuthorizationResponseModel;
import web.tests.api.models.AuthorizationRequestModel;

public class UserTasksApi {
    AuthorizationRequestModel loginBodyModel = new AuthorizationRequestModel("rasitsahbutdinov915455@gmail.com","mdf9MsZs2bbM7kq_");
    AuthorizationApi authorizationApi = new AuthorizationApi();
    AuthorizationResponseModel authorizationResponseModel = authorizationApi.login(loginBodyModel);

}
