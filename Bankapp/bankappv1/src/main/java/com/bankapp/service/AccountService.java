package com.bankapp.service;

import com.bankapp.entity.Account;

public interface AccountService {
	Account createAccount(String holdername);
	Account deposit(String accountNumber,double amount);
	Account getAccount(String accountNumber);

}
