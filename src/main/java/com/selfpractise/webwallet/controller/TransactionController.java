package com.selfpractise.webwallet.controller;

import com.selfpractise.webwallet.controller.dto.ExpenseRequestDTO;
import com.selfpractise.webwallet.controller.dto.IncomeRequestDTO;
import com.selfpractise.webwallet.controller.dto.WalletResponseDTO;
import com.selfpractise.webwallet.entity.Wallet;
import com.selfpractise.webwallet.exceptions.NotEnoughBalance;
import com.selfpractise.webwallet.service.TransactionService;
import com.selfpractise.webwallet.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("web_wallet/transactions")
public class TransactionController {

    private final TransactionService transactionService;
    private final WalletService walletService;

    @Autowired
    public TransactionController(TransactionService transactionService, WalletService walletService) {
        this.transactionService = transactionService;
        this.walletService = walletService;
    }

    @PostMapping("top_up_balance/account/{id}")
    public WalletResponseDTO topUpBalance (@PathVariable Long id,
                              @RequestBody IncomeRequestDTO incomeRequestDTO){
    return new WalletResponseDTO(transactionService.topUpBalance(id,incomeRequestDTO.getAmount()));
    }

    @PostMapping("transfer/account_from/{id}/account_to/{id2}")
    public ResponseEntity<WalletResponseDTO> transfer(@PathVariable Long id,
                                                     @PathVariable Long id2,
                                                     @RequestBody ExpenseRequestDTO expenseRequestDTO){
        Wallet wallet;
        try {
            wallet = transactionService.transfer(id,id2,expenseRequestDTO.getAmount());
        } catch (NotEnoughBalance e){
            return new ResponseEntity<>(new WalletResponseDTO(walletService.getWallet(id)), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(new WalletResponseDTO(wallet),HttpStatus.CREATED);
    }
}
