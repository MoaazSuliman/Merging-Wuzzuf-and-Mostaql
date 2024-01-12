package com.moaaz.wuzzufmostaql.Model.Payment;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "paypal_information")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Paypal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long money;
    private String cardNumber;
}
