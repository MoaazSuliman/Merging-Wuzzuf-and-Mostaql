package com.moaaz.wuzzufmostaql.Dto.Developer;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ExperienceRequest {

    @NotNull(message = "Year Of Experience Must Not Be Null")
    @Min(value = 1,
            message = "At Little Year Of Experience Must Not Be Little Than 1 Year... Or May Be You Are Baby In This Company...")
    @JsonProperty("year_of_experience")
    private int yearOfExperience;

    @NotNull(message = "Company Name  Must Not Be Null")
    @NotEmpty(message = "Company Name  Must Not Be Null")
    @JsonProperty("company_name")
    private String companyName;
}
