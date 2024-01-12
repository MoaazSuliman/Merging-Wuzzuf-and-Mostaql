package com.moaaz.wuzzufmostaql.Dto.Developer;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.moaaz.wuzzufmostaql.Model.Developer.Enum.CareerLevel;
import com.moaaz.wuzzufmostaql.Model.Developer.Enum.JobType;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CareerInterestRequest {

    @NotNull(message = "Career Level Must Not Be Null")
    @JsonProperty("career_level")
    private CareerLevel careerLevel;

    @NotNull(message = "Career Level Must Not Be Null")
    @JsonProperty("job_types")
    private List<JobType> jobTypes;

    @NotNull(message = "Career Titles  Must Not Be Null")
    @JsonProperty("career_titles")
    private List<String> careerTitles;

    @NotNull(message = "Expected Salary  Must Not Be Null")
    @Min(value = 8000, message = "Your Minimum Salary Shouldn't Be Less Than 8000 Because You Are In Egypt My Friend...")
    @JsonProperty("expected_salary")
    private double expectedSalary;

    @NotNull(message = "Career Titles  Must Not Be Null")
    @JsonProperty("job_positions")
    private List<String> jobPositions;
}
