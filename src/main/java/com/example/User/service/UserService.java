package com.example.User.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.User.Repository.UserRepository;
import com.example.User.entity.User;
import com.example.User.model.UserModel;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	
	public Optional<User> fetchUserByEmail(String email) {
		
		Optional<User> user= userRepository.findUserByEmail(email);
		
		return user;
	}


	public User updateUserdetails(String email, User updateUser) {
		Optional<User> findUser = userRepository.findUserByEmail(email);
		if(findUser.isPresent() ) {
			User existingUser = findUser.get();
			existingUser.setFirstName(updateUser.getFirstName());
			existingUser.setLastName(updateUser.getLastName());
			existingUser.setEmail(updateUser.getEmail());
			return userRepository.save(existingUser);
			
		}else {
			return null;
		}
	}
	
	
	
}
