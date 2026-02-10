package com.bankappv2.util;

import java.util.Random;

import org.springframework.stereotype.Component;

import com.bankappv2.repository.AccountRepository;
@Component
public class AccountNumberGenerator {
	private final AccountRepository accountRepository;
	private final Random random=new Random();
	public AccountNumberGenerator(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}
	
	public String generate() {
		while(true) {
			int number=100000000+random.nextInt(90000000);
			
			String accountNumber="ACC"+number;
			if(!accountRepository.existsByAccountNumber(accountNumber)) {
				return accountNumber;
			}
		}
	}
	
	

}
