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
import com.app.service.IAdminService;
import com.app.service.IUserService;
import com.app.service.UserServiceImpl;

@CrossOrigin(origins = "http://localhost:4200")
@RestController // => @Controller at class level +
//@ResponseBody annotation added on ret types of all req handling methods
@RequestMapping("/admin")
public class AdminController {
	// dependency
	@Autowired
	private IAdminService service;
	@Autowired
	private IUserService userService;

	public AdminController() {
		System.out.println("in ctor of " + getClass().getName());
	}

	// RESTful end point or API end point or API provider
	@GetMapping
	public ResponseEntity<?> listAllAdmins() {
		System.out.println("in list all products");
		// invoke service layer's method : controller --> service impl (p) --->JPA
		List<Admin> admins =service.getAllAdmins();		
		if (admins.isEmpty())
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
		return new ResponseEntity<>(admins, HttpStatus.OK);
	}
	
	// req handling method to create a new product : post
		@PostMapping
		public ResponseEntity<?> addAdmin(@RequestBody Admin  a) {
			System.out.println("in add admin " + a);
			try {
				Admin addadmin = service.registerAdmin(a);
				User newUser = new User(a.getEmail(),a.getPassword(), a.getRole());
				userService.addCredintials(newUser);
				return new ResponseEntity<>(addadmin, HttpStatus.OK);
			} catch (RuntimeException e) {
				e.printStackTrace();
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

//	// get prduct details by its name : supplied by clnt using path var
@GetMapping("/a/{email}")
	public ResponseEntity<?> getAdminDetails(@PathVariable String email) {
		//System.out.println("in get admin details " + a.getEmail());
//		// invoke service method
		Optional<Admin> adminDetails = service.getAdminByEmail(email);
//		// valid name : HTTP 200 , marshalled product details
		if (adminDetails.isPresent())
			return new ResponseEntity<>(adminDetails.get(), HttpStatus.OK);
//		// in case of invalid name : HTTP 404
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

@GetMapping("/{id}")
public ResponseEntity<?> getAdmin(@PathVariable int id) {
	System.out.println("in add admin " + id);
	try {
		Admin getadmin = service.getAdminById(id);
		return new ResponseEntity<>(getadmin, HttpStatus.OK);
	} catch (RuntimeException e) {
		e.printStackTrace();
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}



}
