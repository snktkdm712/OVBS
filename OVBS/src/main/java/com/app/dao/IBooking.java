package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.pojos.Booking;


@Repository
public interface IBooking extends JpaRepository<Booking, Integer>{

	Booking findByVenue(String vname);
	
	@Query(value="SELECT * from Bookings where cust_id = :custid ",nativeQuery = true)
	Booking findByci(@Param("custid") int id);
}
