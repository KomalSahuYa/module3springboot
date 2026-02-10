package com.bankappv2.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.bankappv2.dto.accountdto.AccountDtoResponse;
import com.bankappv2.dto.accountdto.CreateAccountDtoRequest;
import com.bankappv2.entity.Account;
import com.bankappv2.exceptions.AccountNotFoundException;
import com.bankappv2.mapper.AccountMapper;
import com.bankappv2.repository.AccountRepository;
import com.bankappv2.util.AccountNumberGenerator;
@Service
public class AccountServiceImpl implements AccountService {

	private final AccountRepository accountRepository;
	private final AccountNumberGenerator generator;
	
	
	public AccountServiceImpl(AccountRepository accountRepository,AccountNumberGenerator generator) {
		this.accountRepository = accountRepository;
		this.generator=generator;
	}

	@Override
	public AccountDtoResponse createAccount(CreateAccountDtoRequest request) {
		//dto to entity
		Account account=AccountMapper.toEntity(request);
		String generatedAccountNumber=generator.generate();
		
		//bl
		account.setAccountNumber(generatedAccountNumber);
		account.setBalance(request.getInitialDeposit());
		account.setCreatedAt(LocalDateTime.now());
		//save to db
		Account saveAccount=accountRepository.save(account);
		//map to entity to return
		return AccountMapper.toResponse(saveAccount);
		
	}

	@Override
	public AccountDtoResponse getAccount(String accountNumber) {
		Account account=accountRepository.findByAccountNumber(accountNumber).orElseThrow(() -> new AccountNotFoundException("Account not found"));
		return AccountMapper.toResponse(account);
		
	}

}
