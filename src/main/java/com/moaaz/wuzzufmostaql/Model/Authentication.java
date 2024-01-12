package com.moaaz.wuzzufmostaql.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "authentication_for_all")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Authentication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(columnDefinition = "VARCHAR(255)")
    private String otp;

    @Column(columnDefinition = "BOOLEAN")
    private boolean isVerify;

}
