package com.example.entity;

import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class WfTransaction {
	
	@Id
	private String tName;
	private String status;
	private Map<String, String> inputData;
	
	public String gettName() {
		return tName;
	}
	public void settName(String tName) {
		this.tName = tName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Map<String, String> getInputData() {
		return inputData;
	}
	public void setInputData(Map<String, String> inputData) {
		this.inputData = inputData;
	}

}
