package com.moaaz.wuzzufmostaql.Model.Payment;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "payment_method")
@Builder
public class PaymentMethod {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private long id;
    @OneToOne
    private VodafoneCash vodafoneCash;

    @OneToOne
    private Paypal paypal;


}
