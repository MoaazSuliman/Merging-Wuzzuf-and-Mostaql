package com.moaaz.wuzzufmostaql.Model.Company;

import com.moaaz.wuzzufmostaql.Model.Authentication;
import com.moaaz.wuzzufmostaql.Model.Application.Job;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "company")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String details;
    private String email;
    private String password;
    private String basePicture;


    private String logo;
    @OneToOne(cascade = CascadeType.ALL)
    private Authentication authentication;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Benefit> benefits;

    @ElementCollection
    private List<String> pictures;

    private String facebook;
    private String instagram;
    private String linkedin;

    @OneToMany( cascade = CascadeType.ALL)
//    @JsonIgnore
    private List<Job>jobs;


}
