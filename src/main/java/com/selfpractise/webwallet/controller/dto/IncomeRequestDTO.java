package com.selfpractise.webwallet.controller.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class IncomeRequestDTO {

    BigDecimal amount;

    public IncomeRequestDTO(BigDecimal amount) {
        this.amount = amount;
    }

    public IncomeRequestDTO() {
    }
}
