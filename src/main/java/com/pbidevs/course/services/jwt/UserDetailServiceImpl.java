package com.pbidevs.course.services.jwt;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.pbidevs.course.entities.User;
import com.pbidevs.course.entities.jwt.UserDetailData;
import com.pbidevs.course.services.UserService;

@Component
public class UserDetailServiceImpl implements UserDetailsService {
	
	@Autowired
	private UserService service;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<User> user = Optional.ofNullable(service.findByEmail(email));
		
		if (user.isEmpty()) {
			throw new UsernameNotFoundException("Usuário [" + email + "] não encontrado");
		}
		
		return new UserDetailData(user);
	}

}
