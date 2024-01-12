package com.moaaz.wuzzufmostaql.Dto.Client;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.moaaz.wuzzufmostaql.Model.Authentication;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDto {

    @NotNull(message = "client_name Must Not Be Null")
    @NotEmpty(message = "client_name Must Not Be Empty")
    @JsonProperty("client_name")
    @Size(min = 5, max = 30, message = "client_name Must Be Between 5 and 30 char.")
    private String name;



    @NotNull(message = "client_phone Must Not Be Null")
    @NotEmpty(message = "client_phone Must Not Be Empty")
    @JsonProperty("client_phone")
    private String phone;


    private MultipartFile picture;


}
