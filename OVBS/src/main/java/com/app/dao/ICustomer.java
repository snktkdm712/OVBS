package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.pojos.Customer;

@Repository
public interface ICustomer extends JpaRepository<Customer, Integer>{

public Customer getCustomerByEmail(String email);
	
	@Modifying
	@Query("UPDATE Customer SET password = :newpassword WHERE id = :id ")
	public void updatePassword(@Param("newpassword") String newPassword,@Param("id") int custId);
	
}
