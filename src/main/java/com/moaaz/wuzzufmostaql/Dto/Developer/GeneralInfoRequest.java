package com.moaaz.wuzzufmostaql.Dto.Developer;


import com.moaaz.wuzzufmostaql.Model.Developer.Enum.Gender;
import com.moaaz.wuzzufmostaql.Model.Developer.Enum.MaritalStatus;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GeneralInfoRequest {

    @NotEmpty(message = "firstName Must Not Be Empty...")
    @NotNull(message = "firstName Must Not Be Null...")
    private String firstName;
    @NotEmpty(message = "lastName Must Not Be Empty...")
    @NotNull(message = "lastName Must Not Be Null...")
    private String lastName;

    @NotEmpty(message = "title Must Not Be Empty...")
    @NotNull(message = "title Must Not Be Null...")
    private String title;


    @NotNull(message = "gender Must Not Be Null...")
    private Gender gender;


    @NotNull(message = "BirthDateRequest Must Not Be Null...")
    private BirthDateRequest birthDateRequest;

    @NotEmpty(message = "nationality Must Not Be Empty...")
    @NotNull(message = "nationality Must Not Be Null...")
    private String nationality;


    @NotNull(message = "maritalStatus Must Not Be Null...")
    private MaritalStatus maritalStatus;

    @NotEmpty(message = "phoneNumber1 Must Not Be Empty...")
    @NotNull(message = "phoneNumber1 Must Not Be Null...")
    private String phoneNumber1;

    private String phoneNumber2;

    @NotNull(message = "locationRequest Must Not Be Null...")
    private LocationRequest locationRequest;

}
