package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.pojos.User;

@Repository
public interface IUserdao extends JpaRepository<User, Integer> {

	@Query(value = "SELECT * FROM Users u WHERE u.email = :email and u.password = :password", 
			  nativeQuery = true)
	User findByEmailAndPassword(@Param("email") String email, @Param("password") String password);

	@Query(value = "SELECT * FROM Users u WHERE u.email = :email", 
			  nativeQuery = true)
		User findByEmail(@Param("email")String email);
	
	  @Modifying
	  @Query("UPDATE User SET password = :newpassword WHERE email = :email ")
	  public void updatePassword(@Param("email") String email,@Param("newpassword")
	  String newpassword);
	 
	  @Query(value = "SELECT password from Users u where u.email := email",
				nativeQuery = true)
		public String getPassword(@Param("email")String email);}
