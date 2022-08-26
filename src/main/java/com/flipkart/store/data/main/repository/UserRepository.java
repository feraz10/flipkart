package com.flipkart.store.data.main.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.flipkart.store.data.main.model.User;
import com.flipkart.store.data.main.model.UserAddress;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	@Query(value = "select * from user where user_mobile=:mobile ", nativeQuery = true)
	Optional<User> findByMobileNo(int mobile);
	
	
	
	
	
	@Query(value = "select * from user where user_mobile=:mobileNo or user_email=:email", nativeQuery = true)
	Optional<User> newuser(int mobileNo, String email);
	
	@Query(value = "select * from user where user_mobile=:mobileNo or user_email=:email", nativeQuery = true)
	Optional<User> verifing(int mobileNo, String email);
//	
//	@Query(value = "select * from customer where cus_mobile=:mobile or cus_email=:email", nativeQuery = true)
//	Optional<User> addbuyer(int mobile, String email);
//
//	@Query(value = "select * from customer where order_id=:id ", nativeQuery = true)
//	Optional<User> getting(int id);
	
	public User getByEmail(String email);







	
	
	
	
	
//	@Query(value = "select * from user_address where user_id=:id ", nativeQuery = true)
//	Optional<UserAddress> newAddress(int id);


	


	
	
}
