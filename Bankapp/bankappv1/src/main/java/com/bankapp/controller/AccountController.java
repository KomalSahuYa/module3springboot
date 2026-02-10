package com.bankapp.controller;

import org.springframework.web.bind.annotation.*;

import com.bankapp.dto.DepositRequest;
import com.bankapp.entity.Account;
import com.bankapp.service.AccountService;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public Account createAccount(@RequestParam String holderName) {
        return accountService.createAccount(holderName);
    }

  
    @PostMapping("/deposit")
    public Account deposit(@RequestBody DepositRequest request) {
        return accountService.deposit(
                request.getAccountNumber(),
                request.getAmount()
        );
    }

    
    @GetMapping("/{accountNumber}")
    public Account getAccount(@PathVariable String accountNumber) {
        return accountService.getAccount(accountNumber);
    }
}