package com.bankappv2.dto.accountdto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class AccountDtoResponse {
	private String accountNumber;
	private String holderName;
	private BigDecimal balance;
	private LocalDateTime createdAt;

}
