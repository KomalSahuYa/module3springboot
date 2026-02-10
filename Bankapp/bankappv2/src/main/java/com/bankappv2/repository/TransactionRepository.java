package com.bankappv2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bankappv2.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

}
