package com.moaaz.wuzzufmostaql.Dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DeveloperOfferDto {


    @NotEmpty(message = "description_offer Must Not Be Empty...")
    @NotNull(message = "description_offer Must Not Be Null...")
    @Size(min = 30 , message = "description_offer Must Be In Details To Describe What Will You Do...")
    @JsonProperty("description_offer")
    private String description;

    @NotNull(message = "number_of_days Must Not Be Null...")
    @Min(value = 1 , message = "number_of_days Must Be Greater Than 1 Are You Crazy Or What")
    @JsonProperty("number_of_days")
    private int numberOfDays;


    @NotNull(message = "offer_price Must Not Be Null...")
    @Min(value = 1 , message = "offer_price Must Be Greater Than 1 Are You Crazy Or What")
    @JsonProperty("offer_price")
    private double price;

    @CreationTimestamp
    private LocalDateTime creationTime;

}
