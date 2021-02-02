package com.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Admin;
import com.app.pojos.Customer;
import com.app.pojos.User;
import com.app.service.ICustomerService;
import com.app.service.IUserService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/customer")
public class CustomerController {

	
	@Autowired
	private ICustomerService custService;
	@Autowired
	private IUserService userService;

	@PostMapping
	public ResponseEntity<?> registerCustomer(@RequestBody Customer customer) {
		System.out.println("in add Customer " + customer);
		try {
			Customer newCustomer = custService.registerCustomer(customer);

			User newUser = new User(newCustomer.getEmail(), newCustomer.getPassword(), newCustomer.getRole());
			userService.addCredintials(newUser);
			return new ResponseEntity<>(newCustomer, HttpStatus.OK);

		} catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping
	public ResponseEntity<?> listAllCustomers() {
		System.out.println("in list all products");
		// invoke service layer's method : controller --> service impl (p) --->JPA
		List<Customer> customers = custService.getAllCustomers();
		if (customers.isEmpty())
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);

		return new ResponseEntity<>(customers, HttpStatus.OK);

	}

	@GetMapping("/a/{email}")
	public ResponseEntity<?> getCustomerDetails(@PathVariable String email) {
		System.out.println("in get customer by email.." + email);
		Customer existingCustomer = custService.getCustomerByEmail(email);
		if (existingCustomer != null) {
			return new ResponseEntity<>(existingCustomer, HttpStatus.OK);
		}

		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PutMapping("/changePassword/{custId}")
	public String updateCustomerPassword(@PathVariable int custId, @RequestBody Customer c) {
		System.out.println("In Customer Controller=" + c.getPassword());
		String message = "password not changed";

		Customer customer = null;

		customer = custService.getcustomerById(custId);
		System.out.println(customer.getEmail());

		if (customer != null) {
			// customer.setPassword(c.getPassword());
			custService.changePassword(c.getPassword(), custId);
			userService.updatePassword(customer.getEmail(), c.getPassword());
			message = "password changed";
		}

		return message;
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getCustomerDetails(@PathVariable int id) {
		Customer customer = custService.getcustomerById(id);
		if (customer != null) {
			return new ResponseEntity<>(customer, HttpStatus.OK);
		}

		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PutMapping("/update/{custId}")
	public ResponseEntity<?> updateCustomer(@PathVariable int custId, @RequestBody Customer updatedCustomer) {

		Customer existingCustomer = custService.getcustomerById(custId);

		if (existingCustomer == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

		// existingCustomer = new Customer(updatedCustomer.getFirstName(),
		// updatedCustomer.getLastName(), updatedCustomer.getEmail(),
		// updatedCustomer.getContact_no(),updatedCustomer.getAddress());

		existingCustomer.setFirstName(updatedCustomer.getFirstName());
		existingCustomer.setLastName(updatedCustomer.getLastName());
		existingCustomer.setEmail(updatedCustomer.getEmail());
		existingCustomer.setContact_no(updatedCustomer.getContact_no());
		existingCustomer.setAddress(updatedCustomer.getAddress());

		custService.updateCustomerDetails(existingCustomer);

		return new ResponseEntity<>(existingCustomer, HttpStatus.OK);

	}

	@DeleteMapping("/remove/{id}")
	public ResponseEntity<?> deleteCustomer(@PathVariable int id) {

		try {
			custService.deleteCustomerDetails(id);
			userService.deleteUser(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
}
