package com.selfpractise.webwallet.controller;

import com.selfpractise.webwallet.controller.dto.AccountRequestDTO;
import com.selfpractise.webwallet.controller.dto.AccountResponseDTO;
import com.selfpractise.webwallet.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("web_wallet/accounts")
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/create_account")
    public Long createAccount(@RequestBody AccountRequestDTO accountRequestDTO) {
        return accountService.createAccount(
                accountRequestDTO.getName(),
                accountRequestDTO.getAge(),
                accountRequestDTO.getEmail());
    }

    @GetMapping("/{id}")
    public AccountResponseDTO getById(@PathVariable Long id) {
        return new AccountResponseDTO(accountService.getById(id));
    }

    @GetMapping
    public List<AccountResponseDTO> getAccounts() {
        return accountService.getAccounts()
                .stream()
                .map(AccountResponseDTO::new)
                .collect(Collectors.toList());
    }

}
