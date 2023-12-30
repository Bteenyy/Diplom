package web.tests.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;


@JsonIgnoreProperties(ignoreUnknown = true)
public @Data class LoginBodyModel {
    private String email, password;
}
