package com.selfpractise.webwallet.service;

import com.selfpractise.webwallet.entity.Account;
import com.selfpractise.webwallet.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class AccountService {


    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Long createAccount (String name,int age, String email){
        return accountRepository.save(new Account(name,age,email)).getId();
    }

    public Account getById(Long id){
        return accountRepository
                .findById(id)
                .orElseThrow(()->new NoSuchElementException("Account with id: "+id+" doesn't exist!"));
    }

    public List<Account> getAccounts (){
        return accountRepository.findAll();
    }
}
