package com.training.chatapp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.training.chatapp.model.CustomUserDetails;
import com.training.chatapp.model.User;
import com.training.chatapp.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<User> optionalUser=userRepository.findByEmail(email);
		if(!optionalUser.isPresent())
		throw new UsernameNotFoundException("User Not Found");
			
			return optionalUser.map(CustomUserDetails::new).get();
		
	}

	
}
