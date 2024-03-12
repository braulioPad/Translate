package com.main.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.main.entity.Users;
import com.main.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	 Optional<Users> userOptional = userRepository.findByUsername(username);

         if (userOptional.isPresent()) {
             Users user = userOptional.get();
             return org.springframework.security.core.userdetails.User.builder()
                     .username(user.getUsername())
                     .password(user.getPassword())
                     .roles(user.getRole())
                     .build();
         } else {
             // Handle the case when the user is not found
             throw new UsernameNotFoundException("User not found with username: " + username);
             // Alternatively, you can throw UsernameNotFoundException if you want
             // throw new UsernameNotFoundException("User not found with username: " + username);
         }
    	
        
    }
}