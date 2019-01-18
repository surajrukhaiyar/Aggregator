package com.example.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Jan 18, 2019
 * @author suraj.r
 * 
 */
public class CustomUserDetails extends Users implements UserDetails {
	List<GrantedAuthority> grantedAuthorities_local;
	
    public CustomUserDetails(final Users users, String token, List<GrantedAuthority> grantedAuthorities) {
    	super(users);
    	this.grantedAuthorities_local = grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public String getUsername() {
        return super.getName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }




	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.grantedAuthorities_local;
	}
}
