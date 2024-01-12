package com.moaaz.wuzzufmostaql.Model.Client;

import com.moaaz.wuzzufmostaql.Model.Authentication;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "client")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String email;
    @OneToOne(cascade = CascadeType.ALL)
    private Authentication authentication;
    private String password;

    private String picturePath;
    private String phone;

    @OneToMany(cascade = CascadeType.ALL)
    private List<ClientProject>clientProjects;

}
