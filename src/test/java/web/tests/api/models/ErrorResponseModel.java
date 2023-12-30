package web.tests.api.models;

import lombok.Data;

public @Data class ErrorResponseModel {
    String message;
    int code;
}
