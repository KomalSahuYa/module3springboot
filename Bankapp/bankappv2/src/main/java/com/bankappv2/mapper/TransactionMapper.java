package com.bankappv2.mapper;

import com.bankappv2.dto.transactiondto.TransactionRequest;
import com.bankappv2.dto.transactiondto.TransactionResponse;
import com.bankappv2.entity.Transaction;

public class TransactionMapper {
	
	public static Transaction toEntity(TransactionRequest dto,Integer accountId) {
		Transaction tx=new Transaction();
		tx.setAccountId(accountId);
        tx.setAmount(dto.getAmount());
        tx.setTimestamp(java.time.LocalDateTime.now());
		return tx;
	}
	public static TransactionResponse toResponse(Transaction tx, String accountNumber) {

        TransactionResponse response = new TransactionResponse();

        response.setTransactionId(tx.getId());
        response.setAccountNumber(accountNumber);
        response.setAmount(tx.getAmount());
        response.setTimestamp(tx.getTimestamp());

        return response;
    }

}
