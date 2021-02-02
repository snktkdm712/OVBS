package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.app.pojos.User;
import com.app.pojos.VenueOwner;
import com.app.service.IUserService;
import com.app.service.IVenueOwnerService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/vowner")

public class VenueOwnerController {

	@Autowired
	private IVenueOwnerService ownerService;
	@Autowired
	private IUserService userService;

	@PostMapping
	public ResponseEntity<?> registerVenueOwner(@RequestBody VenueOwner owner) {
		System.out.println("in add Customer " + owner);
		try {
			VenueOwner newOwner = ownerService.registerVenueOwner(owner);

			User newUser = new User(newOwner.getEmail(), newOwner.getPassword(), newOwner.getRole());
			userService.addCredintials(newUser);
			return new ResponseEntity<>(newOwner, HttpStatus.OK);

		} catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
@GetMapping
public ResponseEntity<?> getVOwners() {
	List<VenueOwner> owner = ownerService.getAllVenueOwnerDetails();
	if (!owner.isEmpty()) {
		return new ResponseEntity<>(owner, HttpStatus.OK);
	}
	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
}
	@GetMapping("/{id}")
	public ResponseEntity<?> getVOwnerDetails(@PathVariable int id) {
		VenueOwner owner = ownerService.getVenueOwnerById(id);
		if (owner != null) {
			return new ResponseEntity<>(owner, HttpStatus.OK);
		}

		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@GetMapping("/a/{email}")
	public ResponseEntity<?> getVenueOwnerDetails(@PathVariable String email) {
		System.out.println("in get customer by email.." + email);
		VenueOwner existingVOwner = ownerService.getVOwnerDetailsByEmail(email);
		if (existingVOwner != null) {
			return new ResponseEntity<>(existingVOwner, HttpStatus.OK);
		}

		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PutMapping("/changePassword/{vownerId}")
	public String updateVenueOwnerPassword(@PathVariable int vownerId, @RequestBody VenueOwner owner) {

		System.out.println("In Venue_owner Controller=" + owner.getPassword());
		String message = "password not changed";

		VenueOwner existingVOwner = null;

		existingVOwner = ownerService.getVenueOwnerById(vownerId);
		System.out.println(existingVOwner.getEmail());

		if (existingVOwner != null) {
			// customer.setPassword(c.getPassword());
			ownerService.changePassword(existingVOwner.getEmail(), owner.getPassword());
			userService.updatePassword(existingVOwner.getEmail(), owner.getPassword());
			message = "password changed";
		}
		return message;
	}

	@DeleteMapping("/remove/{id}")
	public ResponseEntity<?> deleteVOwner(@PathVariable int id) {

		try {
			ownerService.deleteVenueOwnerDetails(id);
			userService.deleteUser(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}

