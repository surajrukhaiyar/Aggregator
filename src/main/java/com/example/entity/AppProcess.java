package com.example.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

/**
 * Jan 18, 2019
 * @author suraj.r
 * 
 */
@Entity
public class AppProcess {
	
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(columnDefinition = "CHAR(32)")
    @Id
	private String processId;
	private String pName;
	private String dateTime;
	private String user;
	private String userSystem;
	private String status;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<WfTransaction> transactions=new ArrayList<WfTransaction>();
	
	public String getProcessId() {
		return processId;
	}
	public void setProcessId(String processId) {
		this.processId = processId;
	}
	
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	
	public String getDateTime() {
		return dateTime;
	}
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	
	public List<WfTransaction> getTransactions() {
		return transactions;
	}
	public void setTransactions(List<WfTransaction> transactions) {
		this.transactions = transactions;
	}
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	
	public String getUserSystem() {
		return userSystem;
	}
	public void setUserSystem(String userSystem) {
		this.userSystem = userSystem;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

}
