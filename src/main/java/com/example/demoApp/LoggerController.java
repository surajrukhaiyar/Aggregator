package com.example.demoApp;

import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.entity.AppProcess;
import com.example.entity.WfTransaction;
import com.example.jpaRepo.AppProcessRepository;
import com.example.jpaRepo.UsersRepository;
@Controller
@RequestMapping(path="/logger")
public class LoggerController {
	
	@Autowired
	private UsersRepository usersRepo;
    @Autowired
    private AppProcessRepository processLogRepo;
    
	@PostMapping(path="/add")
	public @ResponseBody String addNewUser(@RequestBody AppProcess appProcess) {
		AppProcess savedApp = processLogRepo.save(appProcess);
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
	
	@PostMapping(path="/appStatus")
	public @ResponseBody String updateAppStatus(@RequestBody AppProcess appProcess) {
		AppProcess app = processLogRepo.findByProcessId(appProcess.getProcessId());
		app.setStatus(appProcess.getStatus());
		app.setDateTime(appProcess.getDateTime());
		processLogRepo.save(app);
		return "Status saved";
	}
}