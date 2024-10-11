package com.selfpractise.webwallet.controller.dto;

import com.selfpractise.webwallet.entity.Income;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public class IncomeResponseDTO {
    Long id;

    BigDecimal amount;

    OffsetDateTime transactionTime;

    public IncomeResponseDTO (Income income){
        id= income.getId();
        amount=income.getAmount();
        transactionTime=income.getTransactionTime();
    }
}
