package com.bankappv2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankappv2.dto.accountdto.AccountDtoResponse;
import com.bankappv2.dto.accountdto.CreateAccountDtoRequest;
import com.bankappv2.entity.Account;
import com.bankappv2.service.AccountService;

@RestController
@RequestMapping("/accounts")
public class AccountController {
	
	AccountService accountService;

	public AccountController(AccountService accountService) {
		this.accountService = accountService;
	}
	

	@PostMapping
	public AccountDtoResponse createAccount(@RequestBody CreateAccountDtoRequest request) {
		return accountService.createAccount(request);
	}
	
	@GetMapping("/{accountNumber}")
	public AccountDtoResponse getAccount(@PathVariable String accountNumber) {
		return accountService.getAccount(accountNumber);
	}
	

}
