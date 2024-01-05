package web.tests.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;


@JsonIgnoreProperties(ignoreUnknown = true)
public @Data class LoginBodyModel {
    String email, password;
    public LoginBodyModel(String email, String password){
        this.email = email;
        this.password = password;
    }
}
