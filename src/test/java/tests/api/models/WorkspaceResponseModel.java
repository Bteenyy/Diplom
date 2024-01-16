package tests.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class WorkspaceResponseModel {
    WorkspaceData data;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class WorkspaceData {
        List<ItemData> items;

        @Data
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class ItemData {
            String id;
        }
    }
}
