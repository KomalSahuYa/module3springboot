package com.bankappv2.dto.accountdto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateAccountDtoRequest {
	private String holderName;
	private BigDecimal initialDeposit;
}
