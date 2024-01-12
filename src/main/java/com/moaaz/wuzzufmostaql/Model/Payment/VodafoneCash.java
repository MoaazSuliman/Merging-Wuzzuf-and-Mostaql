package com.moaaz.wuzzufmostaql.Model.Payment;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "vodafoneCash_information")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VodafoneCash {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private double money;
    private String phoneNumber;


}
