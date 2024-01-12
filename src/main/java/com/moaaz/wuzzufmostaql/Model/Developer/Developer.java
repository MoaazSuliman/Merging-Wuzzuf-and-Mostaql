package com.moaaz.wuzzufmostaql.Model.Developer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.moaaz.wuzzufmostaql.Dto.Developer.DeveloperRegisterRequest;
import com.moaaz.wuzzufmostaql.Model.Application.Application;
import com.moaaz.wuzzufmostaql.Model.Authentication;
import com.moaaz.wuzzufmostaql.Model.DeveloperOffer;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "Developer")
@Table(name = "developer")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class Developer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne(cascade = CascadeType.ALL)
    private GeneralInfo generalInfo;

    @OneToOne(cascade = CascadeType.ALL)
    private CareerInterests careerInterests;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Experience> experiences;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Skill> skills;

    @OneToOne(cascade = CascadeType.ALL)
    private Education education;


    @OneToOne(cascade = CascadeType.ALL)
    private Authentication authentication;

    @OneToOne(cascade = CascadeType.ALL)
    private OnlinePresence onlinePresence;

    private String achievement;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "developer")
    private List<Project> projects;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "developer")
    @JsonIgnore
    private List<Application> applications;


    @OneToMany(mappedBy = "developer", cascade = CascadeType.ALL)
    private List<DeveloperOffer> developerOffers;

    public void Builder(DeveloperRegisterRequest developerRegisterRequest) {
        System.out.println(developerRegisterRequest.toString());
        // convert developer register dto to developer.
        GeneralInfo generalInfo = new GeneralInfo();
        generalInfo.setFirstName(developerRegisterRequest.getFirstName());
        generalInfo.setLastName(developerRegisterRequest.getLastName());
        generalInfo.setEmail(developerRegisterRequest.getEmail());
        generalInfo.setPassword(developerRegisterRequest.getPassword());
        generalInfo.setTitle(developerRegisterRequest.getTitle());

        this.setGeneralInfo(generalInfo);


    }


}
