package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.IAvailableDates;
import com.app.pojos.AvailableDates;
import com.app.pojos.User;
import com.app.pojos.VenueOwner;
import com.app.pojos.Venues;
import com.app.service.IAvailableDatesService;
import com.app.service.IVenueService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/availableDates")
public class AvailableDatesController {

@Autowired
private IAvailableDatesService availableDatesService;

@GetMapping
public ResponseEntity<?> AllAvailableDates() {
	System.out.println("in  all available dates");
	// invoke service layer's method : controller --> service impl (p) --->JPA
	List<AvailableDates> dates =availableDatesService.getAllAvailableDates();
	if (dates.isEmpty())
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	
	return new ResponseEntity<>(dates, HttpStatus.OK);
}

@PostMapping
public ResponseEntity<?> AddAvailableDates(@RequestBody AvailableDates availableDates) {
	System.out.println("in add dates " + availableDates);
	try {
		AvailableDates newdates=availableDatesService.addDates(availableDates);
		return new ResponseEntity<>(newdates, HttpStatus.OK);

	} catch (RuntimeException e) {
		e.printStackTrace();
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}

}
