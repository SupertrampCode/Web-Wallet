package com.selfpractise.webwallet.controller.dto;

import com.selfpractise.webwallet.entity.Income;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class IncomeResponseDTO {
    Long id;

    BigDecimal amount;

    OffsetDateTime transactionTime;

    public IncomeResponseDTO (Income income){
        this.id= income.getId();
        this.amount=income.getAmount();
        this.transactionTime=income.getTransactionTime();
    }
}
