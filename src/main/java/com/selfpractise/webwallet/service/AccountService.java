package com.selfpractise.webwallet.service;

import com.selfpractise.webwallet.entity.Account;
import com.selfpractise.webwallet.entity.Wallet;
import com.selfpractise.webwallet.repository.AccountRepository;
import com.selfpractise.webwallet.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class AccountService {


    private final AccountRepository accountRepository;

    private final WalletRepository walletRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository, WalletRepository walletRepository) {
        this.accountRepository = accountRepository;
        this.walletRepository = walletRepository;
    }

    public Long createAccount(String name, int age, String email) {
        Account account = new Account(name, age, email);
        Wallet wallet= account.getWallet();
        wallet.setAccount(account);
        walletRepository.save(wallet);
        return accountRepository.save(account).getId();
    }

    public Account getById(Long id) {
        return accountRepository
                .findById(id)
                .orElseThrow(() -> new NoSuchElementException("Account with id: " + id + " doesn't exist!"));
    }

    public List<Account> getAccounts() {
        return accountRepository.findAll();
    }
}
