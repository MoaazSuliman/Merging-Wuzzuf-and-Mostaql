package com.moaaz.wuzzufmostaql.Dto.Developer;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class SkillRequest {
    @NotEmpty(message = "Name Must Not Be Empty")
    @NotNull(message = "Name Must Not Be Null")
    @JsonProperty("skill_name")
    private String name;
//    @NotEmpty(message = "Details Must Not Be Empty")
//    @NotNull(message = "Details Must Not Be Null")
    @JsonProperty("skill_details")
    private String details;
    @Min(value = 1, message = "Stars Should Be Between 1 and 5")
    @Max(value = 5, message = "Stars Should Be Between 1 and 5")
    private int stars;



}
