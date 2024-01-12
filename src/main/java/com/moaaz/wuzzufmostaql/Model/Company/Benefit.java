package com.moaaz.wuzzufmostaql.Model.Company;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "company_benefit")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

public class Benefit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;
    private String logo;
    private String details;


}
