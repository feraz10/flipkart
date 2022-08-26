package com.flipkart.store.data.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.flipkart.store.data.main.model.InvoiceOrder;

@Repository
public interface Orderinvicerepository extends JpaRepository<InvoiceOrder, Integer> {
	@Query(value = "select order_no,per_dayOrder from orderinvice where"
			+ " Order_Date=:requireDate and id="
			+ "(select max(id) from orderinvice where Order_Date=:requireDate)", nativeQuery = true)
	List<Object[]> findByDate(String requireDate);

}
