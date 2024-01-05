package web.tests.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;


@JsonIgnoreProperties(ignoreUnknown = true)
public @Data class AuthorizationRequestModel {
    String email, password;
    public AuthorizationRequestModel(String email, String password){
        this.email = email;
        this.password = password;
    }
}
