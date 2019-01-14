package com.example.entity;

import java.util.Date;

//@Entity
public class AppProcess {
	
	private String process;
	private WfTransaction transactions[];
	private Date dateTime;
	
	
	public String getProcess() {
		return process;
	}
	public void setProcess(String process) {
		this.process = process;
	}
	public WfTransaction[] getTransactions() {
		return transactions;
	}
	public void setTransactions(WfTransaction[] transactions) {
		this.transactions = transactions;
	}
	public Date getDateTime() {
		return dateTime;
	}
	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}	
}
