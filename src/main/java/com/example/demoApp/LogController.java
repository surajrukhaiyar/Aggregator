package com.example.demoApp;

import java.util.List;
import java.util.ListIterator;
import java.util.UUID;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.constant.SecurityConstants;
import com.example.entity.AppProcess;
import com.example.entity.Users;
import com.example.entity.WfTransaction;
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
    
	@PostMapping(path="/add")
	public @ResponseBody String addNewUser(@RequestBody AppProcess appProcess) {
		AppProcess savedApp = processLogRepo.save(appProcess);
		AppProcess savedApp1 = processLogRepo.findByProcessId(savedApp.getProcessId());
		return savedApp.getProcessId();
	}
	
	@PostMapping(path="/updateApp")
	public @ResponseBody String updateApp(@RequestBody WfTransaction wfTransaction) {
		
		AppProcess savedApp = processLogRepo.findByProcessId(wfTransaction.getTransactionId());
		List<WfTransaction> transactionList = savedApp.getTransactions();
		
		ListIterator<WfTransaction> iterator = transactionList.listIterator();
		while (iterator.hasNext()) {
			WfTransaction next = iterator.next();
		     if (next.gettName().equals(wfTransaction.gettName())) {
		         iterator.set(wfTransaction);
		     }
		 }
		
		savedApp.setTransactions(transactionList);
		processLogRepo.save(savedApp);
		return "updated";
	}

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
}

