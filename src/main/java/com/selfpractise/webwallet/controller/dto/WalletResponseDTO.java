package com.selfpractise.webwallet.controller.dto;

import com.selfpractise.webwallet.entity.Wallet;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class WalletResponseDTO {

    Long id;

    BigDecimal balance;

    List<IncomeResponseDTO> incomesList;

    List<ExpenseResponseDTO> expensesList;

    public WalletResponseDTO(Wallet wallet) {
        id = wallet.getId();
        balance = wallet.getBalance();
        this.incomesList = new ArrayList<>();
        this.expensesList = new ArrayList<>();
        if (wallet.getIncomesList().size() > 0) {
            wallet.getIncomesList().forEach(income -> incomesList.add(new IncomeResponseDTO(income)));
        }
        if (wallet.getExpensesList().size() > 0) {
            wallet.getExpensesList().forEach(expense -> expensesList.add(new ExpenseResponseDTO(expense)));
        }
    }

}
