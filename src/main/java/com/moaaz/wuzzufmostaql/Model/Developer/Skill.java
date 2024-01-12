package com.moaaz.wuzzufmostaql.Model.Developer;


import jakarta.persistence.*;
import lombok.*;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@Entity
@Table(name = "developer_skill")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;
    private String name;
    private String details;
    private int stars;


}
