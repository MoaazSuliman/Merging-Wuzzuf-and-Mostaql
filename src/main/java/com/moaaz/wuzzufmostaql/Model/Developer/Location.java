package com.moaaz.wuzzufmostaql.Model.Developer;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "developer_location")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String country;
    private String city;
    private String area;
    private String postalCode;
}
