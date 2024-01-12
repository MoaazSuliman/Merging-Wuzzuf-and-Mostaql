package com.moaaz.wuzzufmostaql.Model.Application;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.moaaz.wuzzufmostaql.Model.Developer.Developer;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "developer_application")
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
@ToString
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne/*(cascade = {CascadeType.DETACH ,CascadeType.MERGE , CascadeType.PERSIST , CascadeType.REFRESH})*/
    @JsonIgnore
    private Developer developer;

    @ManyToOne/*(cascade = {CascadeType.DETACH ,CascadeType.MERGE , CascadeType.PERSIST , CascadeType.REFRESH})*/
    @JsonIgnore
    private Job job;

    @ElementCollection
    private List<String> answers;
    private ApplicationStatus selected;
    private LocalDateTime dateTime;
}
