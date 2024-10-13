package com.selfpractise.webwallet.controller.dto;

import com.selfpractise.webwallet.entity.Expense;
import com.selfpractise.webwallet.utils.DateTimeFormatting;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ExpenseResponseDTO {
    Long id;

    BigDecimal amount;

    String transactionTime;

    public ExpenseResponseDTO(Expense expense) {
        this.id = expense.getId();
        this.amount = expense.getAmount();
        this.transactionTime = DateTimeFormatting.formatDate(expense.getTransactionTime());
    }
}
