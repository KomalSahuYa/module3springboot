package com.bankapp.service;

import java.util.Random;

import org.springframework.stereotype.Service;

import com.bankapp.entity.Account;
import com.bankapp.exception.AccountNotFoundException;
import com.bankapp.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Account createAccount(String holderName) {

        Account account = new Account();
        account.setHolderName(holderName);
        account.setAccountNumber(generateAccountNumber());
        account.setBalance(0.0);

        return accountRepository.save(account);
    }

    @Override
    public Account deposit(String accountNumber, double amount) {

//        if (amount <= 0) {
//            throw new IllegalArgumentException("Deposit amount must be positive");
//        }

        Account account = accountRepository
                .findByAccountNumber(accountNumber)
                .orElseThrow(() ->
                        new AccountNotFoundException("Account not found"));

        account.setBalance(account.getBalance() + amount);

        return accountRepository.save(account);
    }

    @Override
    public Account getAccount(String accountNumber) {

        return accountRepository
                .findByAccountNumber(accountNumber)
                .orElseThrow(() ->
                        new AccountNotFoundException("Account not found"));
    }

    private String generateAccountNumber() {
        Random random = new Random();
        return "ACC" + (100000 + random.nextInt(900000));
    }
}