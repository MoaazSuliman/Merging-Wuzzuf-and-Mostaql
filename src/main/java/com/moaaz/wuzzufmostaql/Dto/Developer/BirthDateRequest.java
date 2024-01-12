package com.moaaz.wuzzufmostaql.Dto.Developer;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BirthDateRequest {
    @NotEmpty(message = "Day Must Not Be Empty...")
    @NotNull(message = "Day Must Not Be Null")
    private String day;

    @NotEmpty(message = "Month Must Not Be Empty...")
    @NotNull(message = "Month Must Not Be Null")
    private String month;

    @NotEmpty(message = "Year Must Not Be Empty...")
    @NotNull(message = "Year Must Not Be Null")
    private String year;

}
