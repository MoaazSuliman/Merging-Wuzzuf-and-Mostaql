package com.moaaz.wuzzufmostaql.Model.Developer;

import com.fasterxml.jackson.annotation.JsonRootName;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "links_pair")
@Getter
@Setter
@JsonRootName("Link")
public class MyPair {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String link;
}
