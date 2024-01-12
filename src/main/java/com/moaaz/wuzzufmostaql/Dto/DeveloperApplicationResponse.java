package com.moaaz.wuzzufmostaql.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class DeveloperApplicationResponse {

    private String companyName;
    private String companyPicturePath;
    private long numbersOfApplications;
    private List<String> requirements;
    private List<String> questions;
    private List<String> answers;
    @JsonProperty("job_date")
    private LocalDateTime jobDateTime;
    @JsonProperty("application_date")
    private LocalDateTime applicationDateTime;

}
