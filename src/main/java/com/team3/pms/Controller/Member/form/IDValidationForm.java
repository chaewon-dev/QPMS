package com.team3.pms.Controller.Member.form;

public class IDValidationForm {

	String id;
	boolean isID_verified;
	
	
	
	
	
	public IDValidationForm() {
		super();
	}
	public IDValidationForm(String id, boolean isID_verified) {
		super();
		this.id = id;
		this.isID_verified = isID_verified;
	}
	public String getId() {
		return id;
	}
	public boolean isID_verified() {
		return isID_verified;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setID_verified(boolean isID_verified) {
		this.isID_verified = isID_verified;
	}
	
	
}
