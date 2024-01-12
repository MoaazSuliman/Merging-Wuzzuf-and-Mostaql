package com.moaaz.wuzzufmostaql.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.util.List;


@Data
public class ApplicationDto {

    @NotNull(message = "Developer Id Must Not Be Null")
            @JsonProperty("developer_id")
    long developerId;

    @NotNull(message = "Job Id Must Not Be Null")
    @JsonProperty("job_id")
    long jobId;

    @NotNull(message = "Answers Must Not Be Null")
    private List<String> answers;
}
