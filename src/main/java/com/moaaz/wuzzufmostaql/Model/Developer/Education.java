package com.moaaz.wuzzufmostaql.Model.Developer;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "developer_education")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String universityName;
    private String facultyName;
    private String achievement;
    private String fromYear;
    private String toYear;

//    @ManyToOne
//    private Developer developer;


}
