package com.selfpractise.webwallet.controller;

import com.selfpractise.webwallet.controller.dto.WalletResponseDTO;
import com.selfpractise.webwallet.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("web_wallet/wallet")
public class WalletController {

    WalletService walletService;

    @Autowired
    public WalletController(WalletService walletService) {
        this.walletService = walletService;
    }

    @GetMapping("/account/{id}")
    public WalletResponseDTO getWalletInfo (@PathVariable Long id){
    return new WalletResponseDTO(walletService.getWallet(id));
    }
}
