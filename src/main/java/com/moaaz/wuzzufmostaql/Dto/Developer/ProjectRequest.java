package com.moaaz.wuzzufmostaql.Dto.Developer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
public class ProjectRequest {

    @NotEmpty(message = "Address Must Not Be Null")
    @NotNull(message = "Address Must Not Be Empty")
    @Size(max = 100, min = 30, message = "Address Is So Small ==> To Be A Good Address , " +
            "Characters Must Be Between 30 and 100 Characters...")
    @JsonProperty("project_address")
    private String address;


    @NotEmpty(message = "Details Must Not Be Null")
    @NotNull(message = "Details Must Not Be Empty")
//    @Size(max = 500, min = 30
//            , message = "Description Is So Small ==> To Be A Good Description , " +
//            "Characters Must Be Between 50 and 500 Characters...")
    @JsonProperty("project_details")
    private String details;


    @NotEmpty(message = "Link Must Not Be Null")
    @NotNull(message = "Link Must Not Be Empty")
    @JsonProperty("project_link")
    private String link;

    @NotEmpty(message = "Date Must Not Be Null")
    @NotNull(message = "Date Must Not Be Empty")
    @JsonProperty("project_date")
    private String date;
    @NotEmpty(message = "Details Must Not Be Null")
    @NotNull(message = "Details Must Not Be Empty")
    @JsonProperty("used_skills")
    private List<String> skills;



}
