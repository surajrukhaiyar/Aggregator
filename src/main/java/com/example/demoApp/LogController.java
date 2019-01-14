package com.example.demoApp;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.constant.SecurityConstants;
import com.example.entity.Log;
import com.example.entity.Users;
import com.example.jpaRepo.LogRepository;
import com.example.jpaRepo.UsersRepository;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Controller
@RequestMapping(path="/demo")
public class LogController {
	
	@Autowired
	private LogRepository logRepo;
	@Autowired
	private UsersRepository usersRepo;

	@GetMapping(path="/add")
	public @ResponseBody String addNewUser (@RequestParam String Status, @RequestParam String User, @RequestParam String system) {
		Log log = new Log();
		log.setStatus(Status);
		log.setUser(User);
		
		String pattern = "DD-MM-yyyy HH:mm:ss";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String date = simpleDateFormat.format(new Date());
		
		log.setDate(date);
		log.setUserSystem(system);
		logRepo.save(log);
		return "Saved";
	}

	@GetMapping(path="/all")
	public @ResponseBody Iterable<Log> getAllLogs(@RequestHeader(value=SecurityConstants.HEADER_STRING) String authToken) {     
        Claims claims = Jwts.parser()
		                .setSigningKey(SecurityConstants.SECRET)
		                .parseClaimsJws(authToken.substring(6))
		                .getBody();
        Users user = usersRepo.findByName(claims.getSubject());
        if(user.getRole().getRole().equals(SecurityConstants.ADMIN_ROLE)) {
        	return logRepo.findAll();
        }else {
        	return logRepo.findByUser(claims.getSubject());	
        }
        
		
	}
}

