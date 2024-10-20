package com.selfpractise.webwallet.service;

import com.selfpractise.webwallet.entity.Expense;
import com.selfpractise.webwallet.entity.Income;
import com.selfpractise.webwallet.entity.Wallet;
import com.selfpractise.webwallet.exceptions.NotEnoughBalance;
import com.selfpractise.webwallet.repository.ExpenseRepository;
import com.selfpractise.webwallet.repository.IncomeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
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
        BigDecimal balance = wallet.getBalance();
        if (balance.compareTo(amount)<0){
            throw new NotEnoughBalance("On your wallet not enough money for this transaction!"+balance);
        } else {
        Expense expense = new Expense(amount);
        expense.setWallet(wallet);
        wallet.getExpensesList().add(expenseRepository.save(expense));
        wallet.setBalance(balance.subtract(amount));
        return walletService.saveWallet(wallet);}
    }

    @Transactional(rollbackForClassName = "NotEnoughBalance")
    public Wallet transfer(Long accountFromId, Long accountToId, BigDecimal amount) {
        Wallet walletFrom = createExpense(accountFromId, amount);
        topUpBalance(accountToId, amount);
        return walletFrom;
    }
}
