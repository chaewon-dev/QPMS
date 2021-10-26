package com.team3.pms.Controller.project.form;

public class LinkForm {
	String id;
	String source;
	String target;
	String type;
	public LinkForm(String id, String source, String target, String type) {
		super();
		this.id = id;
		this.source = source;
		this.target = target;
		this.type = type;
	}
	public LinkForm() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
}
