package com.example.auth;

import static java.util.Collections.emptyList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.entity.Users;
import com.example.jpaRepo.UsersRepository;

/**
 * Jan 18, 2019
 * @author suraj.r
 * 
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
    private UsersRepository applicationUserRepository;

    public UserDetailsServiceImpl(UsersRepository applicationUserRepository) {
        this.applicationUserRepository = applicationUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
    	System.out.println("UserDetailServiceImpl LoadUserByUserName :"+ userName);
    	Users applicationUser = applicationUserRepository.findByName(userName);
    	if(applicationUser == null) {
    		throw new UsernameNotFoundException(userName); 
    	}
        return new User(applicationUser.getName(), applicationUser.getPassword(), emptyList());
    }
}


