package com.moaaz.wuzzufmostaql.Model.Developer;

import com.moaaz.wuzzufmostaql.Model.Developer.Enum.Gender;
import com.moaaz.wuzzufmostaql.Model.Developer.Enum.MaritalStatus;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "developer_general_information")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class GeneralInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String email;
    private String password;
    private String title;

    private Gender gender;

    @OneToOne(cascade = CascadeType.ALL)
    private BirthDate birthDate;

    private String nationality;

    private MaritalStatus maritalStatus;

    @Lob
    private byte[] image;

    private String cvPath;

    private String phoneNumber1;

    private String phoneNumber2;

    @OneToOne(cascade = CascadeType.ALL)
    private Location location;
}
