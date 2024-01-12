package com.moaaz.wuzzufmostaql.Dto.Company;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class JobDto {

    @NotEmpty(message = "Title Must Not Be Empty....")
    @NotNull(message = "Title Must Not Be Null....")
    private String title;
    @NotEmpty(message = "Details Must Not Be Empty....")
    @NotNull(message = "Details Must Not Be Null....")
    private String details;
    @NotEmpty(message = "Requirements Must Not Be Empty....")
    @NotNull(message = "Requirements Must Not Be Null....")
    private List<String> requirements;
    @NotEmpty(message = "Questions Must Not Be Empty....")
    @NotNull(message = "Questions Must Not Be Null....")
    private List<String>questions;

}
