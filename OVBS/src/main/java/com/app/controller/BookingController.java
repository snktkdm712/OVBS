package com.app.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Abc;
import com.app.pojos.Booking;
import com.app.pojos.Customer;
import com.app.pojos.Venues;
import com.app.service.IBookingService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/booking")
public class BookingController {
	
	@Autowired
	private IBookingService bookingService;
	
	@PostMapping()
	public ResponseEntity<?> addBooking( @RequestBody Abc a ){
		
		System.out.println("in add booking");
		Booking newBooking =new Booking();
		try {
			Customer c=new Customer();
			Venues v=new Venues();
			
			newBooking.setBkdate(a.getBkdate());
			newBooking.setBooking_days(a.getB_days());
			v.setVname(a.getVname());
			v.setV_id(a.getVenue_id());
			newBooking.setVname(v);
			newBooking.setVenues(v);
			c.setCust_id(a.getCust_id());
			newBooking.setCustomer(c);
			System.out.println(newBooking);
			Booking booking = bookingService.addBooking(newBooking);
			return new ResponseEntity<>(booking, HttpStatus.OK);
		}catch(RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping()
	public ResponseEntity<?> getBookingDetails(){

		
		List<Booking> bookings = bookingService.getBookingDetails();
		if(bookings.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<>(bookings,HttpStatus.OK);	
		}
	}

	@GetMapping("/{vname}")
	public ResponseEntity<?> getBookingByVName(@PathVariable String vname){
		
		Booking b = bookingService.getBookingByVName(vname);
		
		if(b != null) {
			return new ResponseEntity<>(b, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/a/{id}")
	public ResponseEntity<?> getBookingBycust_id(@PathVariable int id){
		
		Booking b = bookingService.getBookingBycust_id(id);
		
		System.out.println("in add booking");
		
		
		if(b != null) {
			return new ResponseEntity<>(b, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	///////////////
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> cancelBooking(@PathVariable int id){
		
		System.out.println("in cancle booking"+id);
		try {
			bookingService.cancelBooking(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}catch (RuntimeException e) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
 }
