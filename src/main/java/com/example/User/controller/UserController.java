package com.example.User.controller;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.User.entity.User;
import com.example.User.model.UserModel;
import com.example.User.service.UserService;

@RestController
@RequestMapping("/user/")
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping("/hello/{email}")
	public String hello() {
		return "hello from Jwt Authorization";
	}
	
	
	@GetMapping("/fetchUserByEmail/{email}")
	public Optional<User> fetchUserByEmail(@PathVariable("email") String email) {
		return userService.fetchUserByEmail(email);
	}
	
	@PutMapping("/updateUserdetails/{email}")
	public User updateUserdetails(@PathVariable("email") String email, User user) {
		return userService.updateUserdetails(email,user);
		
	}
	
	@DeleteMapping("/deleteUserdetails/{email}")
	public String deleteUserDetails(@PathVariable("email") String email) {
		userService.deleteUserDetails(email);
		return "User details deleted successfully";
	}
	
}
