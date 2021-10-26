package com.team3.pms.Controller.Member.form;

public class RegisterTokenForm {
	private String id;
	private String pass;
	
	
	public RegisterTokenForm(String id, String pass) {
		super();
		this.id = id;
		this.pass = pass;
	}
	public String getId() {
		return id;
	}
	public String getPass() {
		return pass;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	
}
