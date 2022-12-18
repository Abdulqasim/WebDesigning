package com.Jforce.service;

import java.lang.reflect.Array;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.Jforce.model.User;
import com.Jforce.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository ur;
	
	//registeor
	public User register(User user) {
		if(this.ur.findByEmail(user.getEmail()).isPresent()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"User with email alredy exits");
		}
		else {
			BCryptPasswordEncoder encoder= new BCryptPasswordEncoder();
			User newUser=new User();
			newUser.setName(user.getName());
			newUser.setEmail(user.getEmail());
			newUser.setContact(user.getContact());
			
			newUser.setPassword(encoder.encode(user.getPassword()));
			newUser.setRoles(Arrays.asList("USER"));
			return this.ur.save(newUser);
		}
	}

}
