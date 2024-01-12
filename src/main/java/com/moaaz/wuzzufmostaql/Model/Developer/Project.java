package com.moaaz.wuzzufmostaql.Model.Developer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "developer_project")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String address;

    private String imagePath;

    @Column(columnDefinition = "Text")
    private String details;

    private String videoPath;

    private String link;
    private String date;
    private List<String> skills;

    @ManyToOne(cascade =CascadeType.ALL)
    @JsonIgnore
    private Developer developer;


}
