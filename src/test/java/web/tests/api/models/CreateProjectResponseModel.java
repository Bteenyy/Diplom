package web.tests.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
public @Data class CreateProjectResponseModel {
    CreateData data;
    String message;

    @JsonIgnoreProperties(ignoreUnknown = true)
    public @Data
    static class CreateData {
        ItemData item;

        @JsonIgnoreProperties(ignoreUnknown = true)
        public @Data
        static class ItemData {
            int id;
            String name;

        }
    }
}
