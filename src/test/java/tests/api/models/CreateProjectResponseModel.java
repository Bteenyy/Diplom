package tests.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateProjectResponseModel {
    CreateData data;
    String message;
    int code;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class CreateData {
        ItemData item;

        @Data
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class ItemData {
            int id;
            String name;

        }
    }
}
