package com.selfpractise.webwallet.controller.dto;

import com.selfpractise.webwallet.entity.Wallet;

import java.math.BigDecimal;
import java.util.List;

public class WalletResponseDTO {

    Long id;

    BigDecimal balance;

    List<IncomeResponseDTO> incomesList;

    List<ExpenseResponseDTO> expensesList;

    public WalletResponseDTO(Wallet wallet){
        id= wallet.getId();
        balance=wallet.getBalance();
        wallet.getIncomesList().forEach(income -> incomesList.add(new IncomeResponseDTO(income)));
        wallet.getExpensesList().forEach(expense -> expensesList.add(new ExpenseResponseDTO(expense)));
    }

}
