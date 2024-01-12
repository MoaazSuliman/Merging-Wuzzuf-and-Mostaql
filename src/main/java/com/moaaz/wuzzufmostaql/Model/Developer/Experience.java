package com.moaaz.wuzzufmostaql.Model.Developer;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "developer_experience")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class Experience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int yearOfExperience;

    private String companyName;
}
