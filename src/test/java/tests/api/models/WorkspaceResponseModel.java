package tests.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public @Data class WorkspaceResponseModel {
    WorkspaceData data;

    @JsonIgnoreProperties(ignoreUnknown = true)
    public @Data
    static class WorkspaceData {
        List<ItemData> items;

        @JsonIgnoreProperties(ignoreUnknown = true)
        public @Data
        static class ItemData {
            String id;
        }
    }
}
