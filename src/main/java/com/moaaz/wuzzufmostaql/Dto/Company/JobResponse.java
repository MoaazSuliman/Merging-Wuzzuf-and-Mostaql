package com.moaaz.wuzzufmostaql.Dto.Company;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.moaaz.wuzzufmostaql.Dto.ApplicationResponse;
import com.moaaz.wuzzufmostaql.Model.Application.Application;
import com.moaaz.wuzzufmostaql.Model.Company.Company;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Builder
@Data
public class JobResponse {

    private long id;

    private String details;

    private List<String> requirements;


    private List<ApplicationResponse> applications;


    private List<String> questions;

    private boolean open;

    private LocalDateTime localDate;

}
