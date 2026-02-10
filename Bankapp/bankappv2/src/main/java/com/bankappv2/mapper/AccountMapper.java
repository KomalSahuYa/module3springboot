package com.bankappv2.mapper;

import com.bankappv2.dto.accountdto.AccountDtoResponse;
import com.bankappv2.dto.accountdto.CreateAccountDtoRequest;
import com.bankappv2.entity.Account;

public class AccountMapper {
	public static Account toEntity(CreateAccountDtoRequest dto) {

        Account account = new Account();

        account.setHolderName(dto.getHolderName());
        return account;
    }


    // Entity → Response DTO
    public static AccountDtoResponse toResponse(Account account) {

        AccountDtoResponse response = new AccountDtoResponse();

        response.setAccountNumber(account.getAccountNumber());
        response.setHolderName(account.getHolderName());
        response.setBalance(account.getBalance());

        return response;
    }


}
