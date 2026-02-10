package com.bankappv2.service;

import org.springframework.stereotype.Service;

import com.bankappv2.dto.accountdto.AccountDtoResponse;
import com.bankappv2.dto.accountdto.CreateAccountDtoRequest;

public interface AccountService {
	AccountDtoResponse createAccount(CreateAccountDtoRequest request);
	AccountDtoResponse getAccount(String accountNumber);

}
