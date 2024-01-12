package com.moaaz.wuzzufmostaql.Model.Developer;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "developer_online_presence")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class OnlinePresence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @OneToMany(cascade = CascadeType.ALL)
    private List<MyPair>links;


}
