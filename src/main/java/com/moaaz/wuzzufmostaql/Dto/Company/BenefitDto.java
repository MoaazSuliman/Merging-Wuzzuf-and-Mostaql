package com.moaaz.wuzzufmostaql.Dto.Company;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class BenefitDto {


    @NotNull(message = "Logo Must Not Be Null , There Are Not Good Company Without Logo...")
    private MultipartFile logo;
    @NotEmpty(message = "You Should Tell Me What Is The Logo For?!")
    @NotNull(message = "You Should Tell Me What Is The Logo For?!")
    @JsonProperty("logo_details")
    private String details;
}
