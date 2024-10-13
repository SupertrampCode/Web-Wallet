package com.selfpractise.webwallet.service;

import com.selfpractise.webwallet.entity.Wallet;
import com.selfpractise.webwallet.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WalletService {

    AccountService accountService;
    WalletRepository walletRepository;

    @Autowired
    public WalletService(AccountService accountService, WalletRepository walletRepository) {
        this.accountService = accountService;
        this.walletRepository = walletRepository;
    }

    public Wallet getWallet(Long id) {
        return accountService.getById(id).getWallet();
    }

    public Wallet saveWallet(Wallet wallet) {
        return walletRepository.save(wallet);
    }
}
