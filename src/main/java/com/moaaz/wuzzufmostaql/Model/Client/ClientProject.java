package com.moaaz.wuzzufmostaql.Model.Client;

import com.moaaz.wuzzufmostaql.Model.DeveloperOffer;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "client_project")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ClientProject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String description;

    private double minMoney;

    private double maxMoney;

    private int minNumberOfDays;

    private int maxNumberOfDays;

    private String linkForAnotherDescription;

    private LocalDateTime localDateTime;

    private boolean accepted;

    private boolean available;

    private boolean done;


    @ManyToOne
    private Client client;

    @OneToMany(cascade = CascadeType.ALL , mappedBy = "clientProject")
    private List<DeveloperOffer> developerOffers;

    private boolean associated;
}
