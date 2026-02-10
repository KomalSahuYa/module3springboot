package com.bankappv2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankappv2.dto.transactiondto.TransactionRequest;
import com.bankappv2.dto.transactiondto.TransactionResponse;
import com.bankappv2.service.AccountService;
import com.bankappv2.service.TransactionService;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
	
	
	private final TransactionService transactionService;
	public TransactionController(AccountService accountService, TransactionService transactionService) {
		this.transactionService = transactionService;
	}
	
	@PostMapping("/deposit")
	public TransactionResponse deposit(@RequestBody TransactionRequest transactionRequest) {
		return transactionService.deposit(transactionRequest);
		
	}
	
	@PostMapping("/withdraw")
	public TransactionResponse withdraw(@RequestBody TransactionRequest transactionRequest) {
		return transactionService.deposit(transactionRequest);
	}
	
	
	
	

}
