package com.flipkart.store.data.main.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.flipkart.store.data.main.model.User;
import com.flipkart.store.data.main.model.UserAddress;

@Repository
public interface UserAddreRepository extends JpaRepository<UserAddress, Integer> {
	@Query(value = "select * from user where user_mobile=:mobileNo ", nativeQuery = true)
	Optional<User> newAddress(int mobileNo);
//	@Query(value = "select * from order1 where order_id=:id ", nativeQuery = true)
//	Optional<UserAddress> delete(int id);

	

	

}
