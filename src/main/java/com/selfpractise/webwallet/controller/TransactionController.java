package com.selfpractise.webwallet.controller;

import com.selfpractise.webwallet.controller.dto.IncomeRequestDTO;
import com.selfpractise.webwallet.controller.dto.WalletResponseDTO;
import com.selfpractise.webwallet.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("web_wallet/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("top_up_balance/account/{id}")
    public WalletResponseDTO topUpBalance (@PathVariable Long id,
                              @RequestBody IncomeRequestDTO incomeRequestDTO){
    return new WalletResponseDTO(transactionService.topUpBalance(id,incomeRequestDTO.getAmount()));
    }
}
