package com.moaaz.wuzzufmostaql.Dto.Developer;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ToString
public class DeveloperRegisterRequest {

    @NotEmpty(message = "First Name Must Not Be Empty")
    @NotNull(message = "First Name Must Not Be Null")
    @JsonProperty("developer_first_name")
    private String firstName;

    @NotEmpty(message = "Last Name Must Not Be Empty")
    @NotNull(message = "Last Name Must Not Be Null")
    @JsonProperty("developer_last_name")
    private String lastName;


    @Email(message = "Email Must Be an Email Format ...")
    @NotEmpty(message = "Email Must Not Be Empty")
    @NotNull(message = "Email Must Not Be Null")
    @JsonProperty("developer_email")
    private String email;
    @NotEmpty(message = "Password Must Not Be Empty")
    @NotNull(message = "Password Must Not Be Null")
    @Pattern(regexp = "(?=.*[a-z])(?=.*[A-Z]).+",
            message = "Password must contain both uppercase and lowercase characters")
    @JsonProperty("developer_password")
    @Size(min = 8 , max = 20 , message = "Password Must Be greater than and less than 20")
    private String password;


    @NotEmpty(message = "Title Must Not Be Empty")
    @NotNull(message = "Title Must Not Be Null")
    @JsonProperty("developer_title")
    private String title;




}
