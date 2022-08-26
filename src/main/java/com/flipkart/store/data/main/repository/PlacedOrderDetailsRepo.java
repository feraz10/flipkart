package com.flipkart.store.data.main.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.flipkart.store.data.main.model.PlacedOrderDetails;

@Repository
public interface PlacedOrderDetailsRepo extends JpaRepository<PlacedOrderDetails, Integer> {

	// Optional<PlacedOrderDetails> orderPlced(String productName);
	@Query(value = "select * from placed_order_details where  user_mobile=:mobileNo", nativeQuery = true)
	Optional<PlacedOrderDetails> orderPlced(int mobileNo);

	@Query(value = "select * from placed_order_details where  order_id=:orderId", nativeQuery = true)
	Optional<PlacedOrderDetails> cancel(int orderId);
	
	@Query(value = "select * from placed_order_details where  user_mobile=:mobileNo", nativeQuery = true)
	Optional<PlacedOrderDetails> findByMobileNo(int mobileNo);

}
