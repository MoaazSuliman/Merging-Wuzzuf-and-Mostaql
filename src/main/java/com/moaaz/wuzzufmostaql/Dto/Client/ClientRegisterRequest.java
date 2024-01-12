package com.moaaz.wuzzufmostaql.Dto.Client;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ClientRegisterRequest {

    @NotNull(message = "client_name Must Not Be Null")
    @NotEmpty(message = "client_name Must Not Be Empty")
    @JsonProperty("client_name")
    @Size(min = 5, max = 30, message = "client_name Must Be Between 5 and 30 char.")
    private String name;

    @NotNull(message = "client_email Must Not Be Null")
    @NotEmpty(message = "client_email Must Not Be Empty")
    @JsonProperty("client_email")
    private String email;
    @NotNull(message = "client_password Must Not Be Null")
    @NotEmpty(message = "client_password Must Not Be Empty")
    @JsonProperty("client_password")
    @Size(min = 8, max = 20, message = "Password Must Be greater than and less than 20")
    @Pattern(regexp = "(?=.*[a-z])(?=.*[A-Z]).+",
            message = "Password must contain both uppercase and lowercase characters")
    private String password;

    @NotNull(message = "client_phone Must Not Be Null")
    @NotEmpty(message = "client_phone Must Not Be Empty")
    @JsonProperty("client_phone")
    private String phone;



}
