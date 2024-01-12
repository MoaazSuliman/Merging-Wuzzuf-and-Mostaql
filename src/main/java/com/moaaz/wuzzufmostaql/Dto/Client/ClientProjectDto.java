package com.moaaz.wuzzufmostaql.Dto.Client;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientProjectDto {


    @NotEmpty(message = "project_title Must Not Be Empty...")
    @NotNull(message = "project_title Must Not Be Null...")
    @JsonProperty("project_title")
    private String title;

    @NotEmpty(message = "project_description Must Not Be Empty...")
    @NotNull(message = "project_description Must Not Be Null...")
    @Size(min = 50 , message = "project_description should be greater than 50 character to can desc project with all details.")
    @JsonProperty("project_description")
    private String description;


    @NotNull(message = "min_money_for_project Must Not Be Null...")
    @Min(value = 5, message = "min_money_for_project must be at least 30")
    @JsonProperty("min_money_for_project")
    private double minMoney;


    @NotNull(message = "max_money_for_project Must Not Be Null...")
    @Min(value = 0, message = "max_money_for_project must be at least 0")
    @JsonProperty("max_money_for_project")
    private double maxMoney;


    @NotNull(message = "min_number_of_days_for_project Must Not Be Null...")
    @JsonProperty("min_number_of_days_for_project")
    @Min(value = 1, message = "min_number_of_days_for_project must be at least 1")
    private int minNumberOfDays;


    @NotNull(message = "max_number_of_days_for_project Must Not Be Null...")
    @JsonProperty("max_number_of_days_for_project")
    @Min(value = 1, message = "max_number_of_days_for_project must be at least 1")
    private int maxNumberOfDays;

    @JsonProperty("link_for_another_website")
    private String linkForAnotherDescription;

}
