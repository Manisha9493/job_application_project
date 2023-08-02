package com.coforge.job.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.coforge.job.model.ChangePassword;
import com.coforge.job.model.UserRegistration;
import com.coforge.job.service.UserService;

import jakarta.validation.ValidationException;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class UserController {
	
	@Autowired
	UserService userService;
	

	@RequestMapping(path="/registration", method=RequestMethod.POST, consumes="application/json", produces="application/json")
	public ResponseEntity<Integer> registerUser(@RequestBody UserRegistration userRegistration) throws ValidationException {
		
		//return new ResponseEntity<>(userService.registerUser(userRegistration), HttpStatus.OK);
		UserRegistration registration=userService.registerUser(userRegistration);
		int userId=registration.getUserId();
		if(registration==null)
		{
			throw new ValidationException("user cannot be created");
		}
		else
		{
			return new ResponseEntity<>(userId, HttpStatus.OK);
		}
		
	}
	
	
	
	@RequestMapping(path="/authenticate/{userName}/{password}", method=RequestMethod.GET)
	public ResponseEntity<String> authenticate(@PathVariable("userName") String userName,@PathVariable("password") String password) {
		
		UserRegistration registration=userService.authenticate(userName, password);
	    if (registration != null) {
	        return ResponseEntity.ok("authenticated successfully");
	    } else {
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("username and password is incorrect");
	    }
	}
		
		@ExceptionHandler(ValidationException.class)
		ResponseEntity<String> exceptionHandler1(ValidationException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
		
		@PutMapping("/change-password")
		public ResponseEntity<String> changePassword(@RequestBody ChangePassword changePassword)
		{ String message=null;
			try {
			
		   message= userService.changePassword(changePassword);
		   return new ResponseEntity<>(message, HttpStatus.OK);
			
		}catch(Exception e)
		{
			e.printStackTrace();
			
		}
		return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
			
			
			
		}
		
		@PostMapping("forgot-password")
		public ResponseEntity<String> forgotPassword(String mail)
		{
			return null;
			
		}

}

