package tests.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateProjectRequestModel {
    String description, name;

    public CreateProjectRequestModel(String description, String name) {
        this.description = description;
        this.name = name;
    }
}
