package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.query.Param;

import com.app.pojos.Booking;

public interface IBookingService {

	public Booking addBooking(Booking newBooking);
	//public Optional<Booking> getDetailsById(int id);
	public List<Booking> getBookingDetails();
	Booking getBookingByVName(String vname);
	public Booking getBookingBycust_id(int id);
	void cancelBooking(int id);

}
