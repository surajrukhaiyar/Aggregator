package com.example.entity;

import javax.persistence.Embeddable;

/**
 * Jan 18, 2019
 * @author suraj.r
 * 
 */
@Embeddable
public class WfInputData {

	private int inputId;
	private String varName;
	private String varValue;
	
	public int getInputId() {
		return inputId;
	}
	public void setInputId(int inputId) {
		this.inputId = inputId;
	}
	public String getVarName() {
		return varName;
	}
	public void setVarName(String varName) {
		this.varName = varName;
	}
	public String getVarValue() {
		return varValue;
	}
	public void setVarValue(String varValue) {
		this.varValue = varValue;
	}
}
