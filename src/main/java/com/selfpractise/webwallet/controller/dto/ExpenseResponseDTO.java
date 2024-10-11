package com.selfpractise.webwallet.controller.dto;

import com.selfpractise.webwallet.entity.Expense;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public class ExpenseResponseDTO {
    Long id;

    BigDecimal amount;

    OffsetDateTime transactionTime;

    public ExpenseResponseDTO(Expense expense){
        id= expense.getId();
        amount=expense.getAmount();
        transactionTime=expense.getTransactionTime();
    }
}
