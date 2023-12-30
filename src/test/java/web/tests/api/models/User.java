package web.tests.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    String email, password;
    int code;
    @lombok.Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Data{
        String token, expiration;
    }
}
