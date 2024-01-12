package com.moaaz.wuzzufmostaql.Model.Payment;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "all_transferring_data")
public class TransferringData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private double money;
    private String senderEmail;
    private String senderPassword;

    private TransferringWay transferringWay;
    private LocalDateTime localDateTime;
}
