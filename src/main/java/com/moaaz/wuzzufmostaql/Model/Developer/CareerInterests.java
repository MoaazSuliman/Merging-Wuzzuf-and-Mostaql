package com.moaaz.wuzzufmostaql.Model.Developer;

import com.moaaz.wuzzufmostaql.Model.Developer.Enum.CareerLevel;
import com.moaaz.wuzzufmostaql.Model.Developer.Enum.JobType;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Table(name = "developer_career")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CareerInterests {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private CareerLevel careerLevel;

    @ElementCollection
    private List<JobType> jobTypes;

    @ElementCollection
    private List<String> careerTitles;

    private double expectedSalary;
    @ElementCollection
    private List<String> jobPositions;



}
