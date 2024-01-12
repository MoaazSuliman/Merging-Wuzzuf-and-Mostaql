package com.moaaz.wuzzufmostaql.Model.Developer;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.tool.schema.spi.SchemaTruncator;

@Entity
@Table(name="developer_birth_date")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class BirthDate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String day;
    private String month;
    private String year;

}
