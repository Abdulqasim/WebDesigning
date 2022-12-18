package com.Jforce.service;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.Jforce.model.User;
import com.Jforce.repository.UserRepository;

@Service
public class UserSecurityService implements UserDetailsService {

	@Autowired
	private UserRepository ur;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		return this.ur.findByEmail(username).map(user -> {
			return new User(user.getEmail(), user.getPassword(), user.getRoles().stream()
					.map(role -> new SimpleGrantedAuthority(role)).collect(Collectors.toList()));

		}).orElseThrow(() -> {
			throw new UsernameNotFoundException("User with email does not exists");
		})

		;
	}

}
