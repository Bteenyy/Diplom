package tests.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
public @Data class AuthorizationResponseModel {
    UserData data;
    int code;
    String message;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class UserData {
        String token;
    }
}
