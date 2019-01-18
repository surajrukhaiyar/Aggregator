package com.example.demoApp;

import javax.security.sasl.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.auth.UserDetailsServiceImpl;
import com.example.entity.AppProcess;
import com.example.entity.JwtAuthenticationToken;
import com.example.entity.Users;
import com.example.jpaRepo.AppProcessRepository;
import com.example.jpaRepo.UsersRepository;
import com.example.jwt.JwtGenerator;


/**
 * Jan 18, 2019
 * @author suraj.r
 * 
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    private JwtGenerator jwtGenerator;
    private UsersRepository usersRepo;
    
    @Autowired
    private AppProcessRepository processLogRepo;


    public UserController(UsersRepository applicationUserRepository, JwtGenerator jwtGen) {
        this.usersRepo = applicationUserRepository;
        this.jwtGenerator = jwtGen;
    }
    
    @PostMapping("/signUp")
    public void signUp(@RequestBody Users user) {
    	System.out.println(" userId: " + user.getId() +" name: " + user.getName() + " role: " + user.getRole());
    	UserDetails userDetails = null;
    	
    	try {
    		userDetails = userDetailsService.loadUserByUsername(user.getName());	
    	}catch (UsernameNotFoundException e) {
    		//User need to be saved if not Found
		}finally {
	    	if(userDetails != null) {
	    		throw new ResponseStatusException(HttpStatus.CONFLICT, "User already exist");    		
	    	}
		}
    	usersRepo.save(user);	
    }


    @PostMapping("/login")
    @ResponseBody
    public JwtAuthenticationToken login(@RequestBody Users user) {
    	try {
    		UserDetails userDetails = userDetailsService.loadUserByUsername(user.getName());
    		if(user.getPassword().equals(userDetails.getPassword())) {
    			return new JwtAuthenticationToken(jwtGenerator.generate(user));    			
    		}else {
    			throw new AuthenticationException();
    		}
		} catch (UsernameNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User doesn't exist please signUp"); 
		} catch (AuthenticationException e) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Unauthorise user try re-entering password"); 
		}
    }
    
    @PostMapping("/applicationLog")
    @ResponseBody
    public AppProcess getApplicationLog(@RequestBody AppProcess process) {
    	processLogRepo.save(process);
    	return process;
    }
}
