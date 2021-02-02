package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.User;
import com.app.service.IUserService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/login")
public class LoginController {

	@Autowired
	
	private IUserService userService;
	
	@RequestMapping("/validateUser")
	public ResponseEntity<?> authenticateUser(@RequestBody User loggedUser){
		
		User user = null;
		
		user = userService.validateUser(loggedUser.getEmail(), loggedUser.getPassword());
	
		if(user == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<>(user,HttpStatus.OK);
		
	}
	
	
	
}
