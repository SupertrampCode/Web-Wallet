package com.selfpractise.webwallet.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Entity
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    Long id;

    BigDecimal amount;

    OffsetDateTime transactionTime;

    @ManyToOne
            @JoinColumn(name = "wallet_id")
    Wallet wallet;
    public Expense(BigDecimal amount) {
        this.amount = amount;
        transactionTime=OffsetDateTime.now();
    }
}
