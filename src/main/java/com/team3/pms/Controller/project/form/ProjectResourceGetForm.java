package com.team3.pms.Controller.project.form;

public class ProjectResourceGetForm {
	String label;
	String key;
	public ProjectResourceGetForm(String key, String label) {
		super();
		this.label = label;
		this.key = key;
	}
	public ProjectResourceGetForm() {
		super();
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	
	
}
