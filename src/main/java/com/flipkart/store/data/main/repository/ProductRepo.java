package com.flipkart.store.data.main.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.flipkart.store.data.main.model.CategoryOfCapCorner;
import com.flipkart.store.data.main.model.ProductOfCapCorner;

@Repository
public interface ProductRepo extends JpaRepository<ProductOfCapCorner, Integer>{
	
	@Query(value = "select * from product where product_name=:productName ", nativeQuery = true)
	Optional<ProductOfCapCorner> findByProductName(String productName);
	
	@Query(value = "select * from product where product_id=:id ", nativeQuery = true)
	Optional<ProductOfCapCorner> findById1(int id);


}
