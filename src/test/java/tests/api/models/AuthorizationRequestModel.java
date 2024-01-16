package tests.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AuthorizationRequestModel {
    String email, password;

    public AuthorizationRequestModel(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
