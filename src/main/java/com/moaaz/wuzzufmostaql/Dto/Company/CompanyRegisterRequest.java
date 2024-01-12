package com.moaaz.wuzzufmostaql.Dto.Company;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CompanyRegisterRequest {

    @NotEmpty(message = "email Must Not Be Empty")
    @NotNull(message = "email Must Not Be Null")
    private String email;
    @NotEmpty(message = "password Must Not Be Empty")
    @NotNull(message = "password Must Not Be Null")
    private String password;
    @NotEmpty(message = "Name Must Not Be Empty")
    @NotNull(message = "Name Must Not Be Null")
    @JsonProperty("company_name")
    private String name;
    @NotEmpty(message = "company_details Must Not Be Empty")
    @NotNull(message = "company_details Must Not Be Null")
    @JsonProperty("company_details")
    private String details;

}
