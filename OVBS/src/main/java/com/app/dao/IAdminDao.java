package com.app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.pojos.Admin;

@Repository
public interface IAdminDao extends JpaRepository<Admin, Integer>{

	Optional<Admin> findByEmail(String email);
	
 //search by product name
//	Optional<Product> findByName(String pName);
	
//	@Query(value="select v_id, bkdate , cust_id  from bookings u where u.user_id =:userId", nativeQuery=true)
//	List<Object[]> getRequests();
	
	@Modifying
	@Query("UPDATE Admin SET password = :newpassword WHERE email = :email ")
	public void updatePassword(@Param("newpassword") String newPassword,@Param("email") String email);
	

}
