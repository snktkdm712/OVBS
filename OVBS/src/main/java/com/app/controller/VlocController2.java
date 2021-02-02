package com.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.dao.IVenueOwner;
import com.app.pojos.Admin;
import com.app.pojos.User;
import com.app.pojos.Venues;
import com.app.service.IAdminService;
import com.app.service.IUserService;
import com.app.service.IVenueService;
import com.app.service.UserServiceImpl;

@CrossOrigin(origins = "http://localhost:4200")
@RestController // => @Controller at class level +
//@ResponseBody annotation added on ret types of all req handling methods
@RequestMapping("/vloc")
public class VlocController2 {
	// dependency
	@Autowired
	private IVenueService ivservice;
	

	public VlocController2() {
		System.out.println("in ctor of " + getClass().getName());
	}

	// RESTful end point or API end point or API provider
	@GetMapping("/{id}")
	public ResponseEntity<?> getlocation(@PathVariable int id) {
		System.out.println("in getloc");
		List<Venues> venues;
switch (id) {
case 1:
	venues =ivservice.getv1();		
	if (venues.isEmpty())
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	
	return new ResponseEntity<>(venues, HttpStatus.OK);
	
case 2:
	venues =ivservice.getv2();		
	if (venues.isEmpty())
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	
	return new ResponseEntity<>(venues, HttpStatus.OK);

case 3:
	venues =ivservice.getv3();		
	if (venues.isEmpty())
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	
	return new ResponseEntity<>(venues, HttpStatus.OK);
case 4:
	
	venues =ivservice.getv4();		
	if (venues.isEmpty())
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	
	return new ResponseEntity<>(venues, HttpStatus.OK);

default:
	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
}	
	}
	

	
////	// get prduct details by its name : supplied by clnt using path var
//@GetMapping("/a/{email}")
//	public ResponseEntity<?> getAdminDetails(@PathVariable String email) {
//		//System.out.println("in get admin details " + a.getEmail());
////		// invoke service method
//		Optional<Admin> adminDetails = service.getAdminByEmail(email);
////		// valid name : HTTP 200 , marshalled product details
//		if (adminDetails.isPresent())
//			return new ResponseEntity<>(adminDetails.get(), HttpStatus.OK);
////		// in case of invalid name : HTTP 404
//		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//	}
//
//@GetMapping("/{id}")
//public ResponseEntity<?> getAdmin(@PathVariable int id) {
//	System.out.println("in add admin " + id);
//	try {
//		Optional<Admin> getadmin = service.getAdminById(id);
//		return new ResponseEntity<>(getadmin, HttpStatus.OK);
//	} catch (RuntimeException e) {
//		e.printStackTrace();
//		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//	}
//}
//


}
