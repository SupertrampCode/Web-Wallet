package com.selfpractise.webwallet.controller.dto;

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

    public AccountRequestDTO(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }


}
