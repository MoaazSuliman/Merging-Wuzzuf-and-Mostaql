package com.moaaz.wuzzufmostaql.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.moaaz.wuzzufmostaql.Model.Client.Client;
import com.moaaz.wuzzufmostaql.Model.Client.ClientProject;
import com.moaaz.wuzzufmostaql.Model.Developer.Developer;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "developer_offer_for_client_projects")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DeveloperOffer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JsonIgnore
    private Developer developer;

    @ManyToOne
    @JsonIgnore
    private ClientProject clientProject;

    private String description;
    private int numberOfDays;
    private double price;

    private boolean accepted;

    private LocalDateTime creationTime;
}
