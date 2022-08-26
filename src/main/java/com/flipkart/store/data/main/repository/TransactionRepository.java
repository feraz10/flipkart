package com.flipkart.store.data.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flipkart.store.data.main.model.Transaction;
@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer>{

}
