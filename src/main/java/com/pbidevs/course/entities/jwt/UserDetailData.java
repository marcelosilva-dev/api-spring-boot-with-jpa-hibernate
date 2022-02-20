package com.pbidevs.course.entities.jwt;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import org.springframework.security.core.GrantedAuthority;
import com.pbidevs.course.entities.User;
import org.springframework.security.core.userdetails.UserDetails;

public class UserDetailData implements UserDetails {
	
	private final Optional<User> user;

	public UserDetailData(Optional<User> user) {
		super();
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return new ArrayList<>();
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return user.orElse(new User()).getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.orElse(new User()).getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
