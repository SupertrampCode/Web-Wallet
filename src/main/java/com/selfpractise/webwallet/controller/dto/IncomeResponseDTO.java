package com.selfpractise.webwallet.controller.dto;

import com.selfpractise.webwallet.entity.Income;
import com.selfpractise.webwallet.utils.DateTimeFormatting;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class IncomeResponseDTO {
    Long id;

    BigDecimal amount;

    String transactionTime;

    public IncomeResponseDTO(Income income) {
        this.id = income.getId();
        this.amount = income.getAmount();
        this.transactionTime = DateTimeFormatting.formatDate(income.getTransactionTime());
    }

}
