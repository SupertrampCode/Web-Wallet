package com.selfpractise.webwallet.controller.dto;

import com.selfpractise.webwallet.entity.Account;
import com.selfpractise.webwallet.entity.Wallet;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AccountRequestDTO {

    String name;

    int age;

    String email;

    Wallet wallet;

    public AccountRequestDTO(String name, int age, Wallet wallet, String email) {
        this.name = name;
        this.age = age;
        this.wallet = wallet;
        this.email=email;
    }

    public AccountRequestDTO(Account account){
        name=account.getName();
        age= account.getAge();
        wallet=account.getWallet();
        email=account.getEmail();
    }
}
