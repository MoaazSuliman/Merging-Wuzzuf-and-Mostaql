package com.moaaz.wuzzufmostaql.Dto.Developer;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class EducationRequest {

    @NotEmpty(message = "University Name Must Not Be Empty")
    @NotNull(message = "University Name Must Not Be Null")
    @JsonProperty("university_name")
    private String universityName;

    @NotEmpty(message = "Faculty Name Must Not Be Empty")
    @NotNull(message = "Faculty Name Must Not Be Null")
    @JsonProperty("faculty_name")
    private String facultyName;

    @NotEmpty(message = "Achievement Name Must Not Be Empty")
    @NotNull(message = "Achievement Name Must Not Be Null")
    @JsonProperty("achievement")
    private String achievement;

    @NotEmpty(message = "From Year Must Not Be Empty")
    @NotNull(message = "From Year Name Must Not Be Null")
    @JsonProperty("from_year")
    private String fromYear;

    @NotEmpty(message = "To Year Name Must Not Be Empty")
    @NotNull(message = "To Year Name Must Not Be Null")
    @JsonProperty("to_year")
    private String toYear;
}
