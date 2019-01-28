package com.example.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

/**
 * Jan 18, 2019
 * @author suraj.r
 * 
 */
@Entity
public class WfTransaction {
	
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(columnDefinition = "CHAR(32)")
    @Id
	private String transactionId;
	private String tName;
	private String tStatus;
	private String dateTime;
	
	@ElementCollection
	private List<WfInputData> inputData=new ArrayList<>();
	
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	
	public String gettName() {
		return tName;
	}
	public void settName(String tName) {
		this.tName = tName;
	}
	
	public String gettStatus() {
		return tStatus;
	}
	public void settStatus(String tStatus) {
		this.tStatus = tStatus;
	}
	
	public List<WfInputData> getInputData() {
		return inputData;
	}
	public void setInputData(List<WfInputData> inputData) {
		this.inputData = inputData;
	}
	
	public String getDateTime() {
		return dateTime;
	}
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
}
