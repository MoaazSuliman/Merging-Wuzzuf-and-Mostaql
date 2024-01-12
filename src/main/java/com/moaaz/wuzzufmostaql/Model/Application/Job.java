package com.moaaz.wuzzufmostaql.Model.Application;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.moaaz.wuzzufmostaql.Model.Company.Company;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.util.Lazy;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="company_job")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String details;
    @ElementCollection
    private List<String>requirements;
    @ManyToOne(cascade = {
            CascadeType.MERGE,
            CascadeType.DETACH,
            CascadeType.PERSIST,
            CascadeType.REFRESH
    }
    , fetch = FetchType.LAZY
    )
    @JsonIgnore
    private Company company;

    @OneToMany(mappedBy = "job" , fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Application> applications;

    @ElementCollection
    private List<String> questions;

    private boolean open;

    private LocalDateTime localDate;

}
