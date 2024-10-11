package com.selfpractise.webwallet.controller.dto;

import com.selfpractise.webwallet.entity.Account;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class AccountResponseDTO {

    Long id;

    String name;

    int age;

    String email;

    WalletResponseDTO wallet;

    public AccountResponseDTO (Account account){
        id= account.getId();
        name=account.getName();
        age=account.getAge();
        email = account.getEmail();
        wallet=new WalletResponseDTO(account.getWallet());

    }
}