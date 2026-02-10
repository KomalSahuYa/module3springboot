package com.bankappv2.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bankappv2.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Integer> {
	public boolean existsByAccountNumber(String accountNumber);
	
	Optional<Account> findByAccountNumber(String accountNumber);

}
