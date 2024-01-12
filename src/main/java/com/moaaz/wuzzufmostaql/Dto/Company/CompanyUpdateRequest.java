package com.moaaz.wuzzufmostaql.Dto.Company;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class CompanyUpdateRequest {


    @NotEmpty(message = "Name Must Not Be Empty")
    @NotNull(message = "Name Must Not Be Null")
    @JsonProperty("company_name")
    private String name;
    @NotEmpty(message = "Email Must Not Be Empty")
    @NotNull(message = "Email Must Not Be Null")
    private String email;
    @NotEmpty(message = "company_details Must Not Be Empty")
    @NotNull(message = "company_details Must Not Be Null")
    @JsonProperty("company_details")
    private String details;

    @NotNull(message = "background_picture Must Not Be Null")
    @JsonProperty("background_picture")
    private MultipartFile basePicture;



    @NotNull(message = "logo Must Not Be Null")
    private MultipartFile logo;
    @NotEmpty(message = "facebook_link Must Not Be Empty")
    @NotNull(message = "facebook_link Must Not Be Null")
    @JsonProperty("facebook_link")
    private String facebook;
    @NotEmpty(message = "linkedin_link Must Not Be Empty")
    @NotNull(message = "linkedin_link Must Not Be Null")
    @JsonProperty("linkedin_link")
    private String linkedin;

    @JsonProperty("instagram_link")
    private String instagram;

}
