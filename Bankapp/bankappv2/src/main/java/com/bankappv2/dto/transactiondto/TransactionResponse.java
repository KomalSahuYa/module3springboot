package com.bankappv2.dto.transactiondto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class TransactionResponse {
	private Integer transactionId;
	private String accountNumber;
	private BigDecimal amount;
	private LocalDateTime timestamp;

}
