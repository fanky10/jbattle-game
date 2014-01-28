package com.doinfinite.battlegame.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.doinfinite.battlegame.model.User;
import com.doinfinite.battlegame.model.repository.UserRepository;

@Service
public class SimpleUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		UserDetails userDetails = userRepository.findByUsername(username);
		if(userDetails==null){
			return new User();
		}
		return userDetails;
	}

}
