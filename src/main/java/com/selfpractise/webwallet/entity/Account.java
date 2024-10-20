package com.selfpractise.webwallet.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
            @Column(name = "account_id")
    Long id;

    String name;

    int age;

    String email;

    @OneToOne(mappedBy = "account", cascade = CascadeType.ALL)
    Wallet wallet;

    public Account(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

}


