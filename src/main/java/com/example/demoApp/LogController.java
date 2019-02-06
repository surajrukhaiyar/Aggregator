package com.example.demoApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.constant.SecurityConstants;
import com.example.entity.AppProcess;
import com.example.entity.Users;
import com.example.jpaRepo.AppProcessRepository;
import com.example.jpaRepo.UsersRepository;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

/**
 * Jan 18, 2019
 * @author suraj.r
 * 
 */
@Controller
@RequestMapping(path="/demo")
public class LogController {
	
	@Autowired
	private UsersRepository usersRepo;
    @Autowired
    private AppProcessRepository processLogRepo;
	@GetMapping(path="/all")
	public @ResponseBody Iterable<AppProcess> getAllLogs(@RequestHeader(value=SecurityConstants.HEADER_STRING) String authToken) {     
        Claims claims = Jwts.parser()
		                .setSigningKey(SecurityConstants.SECRET)
		                .parseClaimsJws(authToken.substring(6))
		                .getBody();
        Users user = usersRepo.findByName(claims.getSubject());
        if(user.getRole().getRole().equals(SecurityConstants.ADMIN_ROLE)) {
        	return processLogRepo.findAll();
        }else {
        	return processLogRepo.findByUser(claims.getSubject());	
        }
	}
	
	@GetMapping(path="/app/{id}")
	public @ResponseBody AppProcess getAppById(@RequestHeader(value=SecurityConstants.HEADER_STRING) String authToken,
			@PathVariable("id") String id) {     
			return processLogRepo.findByProcessId(id);
	}
}

