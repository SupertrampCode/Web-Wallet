package com.selfpractise.webwallet.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.util.ArrayList;

@Entity
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    Long id;

    String name;

    int age;

    String email;

    @OneToOne
    Wallet wallet;

    public Account(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email=email;
        this.wallet = new Wallet(new BigDecimal(0),new ArrayList<Income>(),new ArrayList<Expense>());
    }

}


