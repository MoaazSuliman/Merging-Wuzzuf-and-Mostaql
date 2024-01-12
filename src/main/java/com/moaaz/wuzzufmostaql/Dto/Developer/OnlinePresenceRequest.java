package com.moaaz.wuzzufmostaql.Dto.Developer;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.moaaz.wuzzufmostaql.Model.Developer.MyPair;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class OnlinePresenceRequest {




    @JsonProperty("links")
    @NotNull(message = "Links Must Not Be Null")
    private List<MyPair> links;









}
