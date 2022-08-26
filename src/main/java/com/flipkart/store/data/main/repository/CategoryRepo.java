package com.flipkart.store.data.main.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.flipkart.store.data.main.json.ProductJson;
import com.flipkart.store.data.main.model.CategoryOfCapCorner;

@Repository
public interface CategoryRepo extends JpaRepository<CategoryOfCapCorner, Integer> {
	@Query(value = "select * from category where  category_id=:categoryId", nativeQuery = true)
	Optional<CategoryOfCapCorner> addproduct(int categoryId);
	


	

}
