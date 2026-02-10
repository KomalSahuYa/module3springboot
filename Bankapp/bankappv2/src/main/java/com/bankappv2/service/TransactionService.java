package com.bankappv2.service;

import com.bankappv2.dto.transactiondto.TransactionRequest;
import com.bankappv2.dto.transactiondto.TransactionResponse;

public interface TransactionService {
	TransactionResponse deposit(TransactionRequest request);
	TransactionResponse withdraw(TransactionRequest request);

}
