package com.flipkart.store.data.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flipkart.store.data.main.model.Refund;

@Repository
public interface RefundRepo extends JpaRepository<Refund, Integer>{

}
