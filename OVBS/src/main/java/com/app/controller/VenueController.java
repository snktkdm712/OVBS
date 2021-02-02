package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Admin;
import com.app.pojos.Venues;
import com.app.service.IVenueService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/venue")
public class VenueController {
	
	@Autowired
	private IVenueService venueService;
	
	@GetMapping
	public ResponseEntity<?> listAllVenues() {
		System.out.println("in list all Venues");
		// invoke service layer's method : controller --> service impl (p) --->JPA
		List<Venues> venues =venueService.getAllVenues();
		if (venues.isEmpty())
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
		return new ResponseEntity<>(venues, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> registerv(@RequestBody Venues venue) {
		System.out.println("in add Customer " + venue);
		try {
			
			Venues newVenue = venueService.addVenue(venue);
			
			return new ResponseEntity<>(newVenue, HttpStatus.OK);

		} catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/{vname}")
	public ResponseEntity<?> getlocation(@PathVariable String vname ) {
		System.out.println("in getloc");
		Venues venue =venueService.getvdetails(vname);		
	if (venue.getClass()==null)
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	
	return new ResponseEntity<>(venue, HttpStatus.OK);
}
	
}