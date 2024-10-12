package com.selfpractise.webwallet.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Income {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    Long id;

    BigDecimal amount;

    OffsetDateTime transactionTime;

    @ManyToOne
    @JoinColumn(name = "wallet_id")
    private Wallet wallet;

    public Income(BigDecimal amount) {
        this.amount = amount;
        transactionTime = OffsetDateTime.now();
    }
}
