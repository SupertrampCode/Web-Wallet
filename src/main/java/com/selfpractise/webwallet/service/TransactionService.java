package com.selfpractise.webwallet.service;

import com.selfpractise.webwallet.entity.Expense;
import com.selfpractise.webwallet.entity.Income;
import com.selfpractise.webwallet.entity.Wallet;
import com.selfpractise.webwallet.repository.ExpenseRepository;
import com.selfpractise.webwallet.repository.IncomeRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class TransactionService {

    private final WalletService walletService;
    private final IncomeRepository incomeRepository;
    private final ExpenseRepository expenseRepository;

    public TransactionService(WalletService walletService,
                              IncomeRepository incomeRepository,
                              ExpenseRepository expenseRepository) {
        this.walletService = walletService;
        this.incomeRepository = incomeRepository;
        this.expenseRepository = expenseRepository;
    }

    public Wallet topUpBalance(Long id, BigDecimal amount) {
        Wallet wallet = walletService.getWallet(id);
        Income income = new Income(amount);
        income.setWallet(wallet);
        wallet.getIncomesList().add(incomeRepository.save(income));
        wallet.setBalance(wallet.getBalance().add(amount));
        return walletService.saveWallet(wallet);
    }

    public Wallet createExpense(Long id, BigDecimal amount) {
        Wallet wallet = walletService.getWallet(id);
        Expense expense = new Expense(amount);
        expense.setWallet(wallet);
        wallet.getExpensesList().add(expenseRepository.save(expense));
        wallet.setBalance(wallet.getBalance().subtract(amount));
        return walletService.saveWallet(wallet);
    }

    public Wallet transfer(Long accountFromId, Long accountToId, BigDecimal amount) {
        Wallet walletFrom = createExpense(accountFromId, amount);
        topUpBalance(accountToId, amount);
        return walletFrom;
    }
}
