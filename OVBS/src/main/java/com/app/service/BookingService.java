package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IBooking;
import com.app.pojos.Booking;

@Service
@Transactional
public class BookingService implements IBookingService {
//dependency
	@Autowired
	private IBooking dao;
	
	
	@Override
	public List<Booking> getBookingDetails() {
	
		return dao.findAll();
	}

	@Override
	public Booking addBooking(Booking newBooking) {
	
		return dao.save(newBooking);
	}

	@Override
	public Booking getBookingByVName(String vname) {
		
		return dao.findByVenue(vname);
	}

	@Override
	public Booking getBookingBycust_id(int id) {
		// TODO Auto-generated method stub
		return  dao.findByci(id);
	}

	@Override
	public void cancelBooking(int id) {
		dao.deleteById(id);
		
	}

}
