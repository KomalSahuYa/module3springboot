package com.bankappv2.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.bankappv2.dto.transactiondto.TransactionRequest;
import com.bankappv2.dto.transactiondto.TransactionResponse;
import com.bankappv2.entity.Account;
import com.bankappv2.entity.Transaction;
import com.bankappv2.exceptions.AccountNotFoundException;
import com.bankappv2.exceptions.InsufficientBalanceException;
import com.bankappv2.mapper.TransactionMapper;
import com.bankappv2.repository.AccountRepository;
import com.bankappv2.repository.TransactionRepository;

import jakarta.transaction.Transactional;
@Service
@Transactional
public class TransactionImpl implements TransactionService {
	private final AccountRepository accountRepository;
	private final TransactionRepository transactionRepository;
	
	public TransactionImpl(AccountRepository accountRepository, TransactionRepository transactionRepository) {
		this.accountRepository = accountRepository;
		this.transactionRepository = transactionRepository;
	}

	@Override
	public TransactionResponse deposit(TransactionRequest request) {
		Account account=accountRepository.findByAccountNumber(request.getAccountNumber()).orElseThrow(()-> new AccountNotFoundException("Account not found"));
		//balance check
		BigDecimal currentBalance=account.getBalance();
		
		account.setBalance(currentBalance.add(request.getAmount()));
		accountRepository.save(account);
		
		//transaction record
		Transaction tx=TransactionMapper.toEntity(request, account.getId());
		Transaction savedTx=transactionRepository.save(tx);
		
		return TransactionMapper.toResponse(savedTx, account.getAccountNumber());
	}

	@Override
	public TransactionResponse withdraw(TransactionRequest request) {
		Account account=accountRepository.findByAccountNumber(request.getAccountNumber()).orElseThrow(()-> new AccountNotFoundException("Account not found"));
		//balance check
		BigDecimal currentBalance=account.getBalance();
		
		if(currentBalance.compareTo(request.getAmount())<0) {
			throw new InsufficientBalanceException("Not enough balance");
		}
		account.setBalance(currentBalance.subtract(request.getAmount().negate()));
		accountRepository.save(account);
		
		//transaction record
		Transaction tx=TransactionMapper.toEntity(request, account.getId());
		Transaction savedTx=transactionRepository.save(tx);
		
		return TransactionMapper.toResponse(savedTx, account.getAccountNumber());
	}

}
