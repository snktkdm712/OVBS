package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.pojos.VenueOwner;

@Repository
public interface IVenueOwner extends JpaRepository<VenueOwner, Integer>{

	@Modifying
	@Query("UPDATE VenueOwner SET password = :newpassword WHERE email = :email ")
	public void updatePassword(@Param("email") String email,@Param("newpassword") String newPassword);

	public VenueOwner findByEmail(String email);
	
}
