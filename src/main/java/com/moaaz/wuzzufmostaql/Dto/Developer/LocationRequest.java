package com.moaaz.wuzzufmostaql.Dto.Developer;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LocationRequest {
    @NotEmpty(message = "Country Must Not Be Empty...")
    @NotNull(message = "Country Must Not Be Null...")
    private String country;
    @NotEmpty(message = "City Must Not Be Empty...")
    @NotNull(message = "City Must Not Be Null...")
    private String city;
    @NotEmpty(message = "Area Must Not Be Empty...")
    @NotNull(message = "Area Must Not Be Null...")
    private String area;
    @NotEmpty(message = "Postal Code Must Not Be Empty...")
    @NotNull(message = "Postal Code Must Not Be Null...")
    private String postalCode;
}
