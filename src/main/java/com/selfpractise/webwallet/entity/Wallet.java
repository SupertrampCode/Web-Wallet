package com.selfpractise.webwallet.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Wallet {

    @Id
    @Setter(AccessLevel.NONE)
    Long id;

    public Wallet() {
        this.balance = BigDecimal.ZERO;
        this.incomesList = new ArrayList<>();
        this.expensesList = new ArrayList<>();
    }

    @OneToOne
            @MapsId
            @JoinColumn(name="account_id")
    Account account;

    BigDecimal balance;

    @OneToMany(mappedBy = "wallet", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<Income> incomesList;

    @OneToMany(mappedBy = "wallet", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<Expense> expensesList;
}
