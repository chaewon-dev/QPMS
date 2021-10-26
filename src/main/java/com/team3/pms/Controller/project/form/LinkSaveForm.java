package com.team3.pms.Controller.project.form;

public class LinkSaveForm {
	String id;
	String projectId;
	String source;
	String target;
	String type;
	public LinkSaveForm(String id, String projectId, String source, String target, String type) {
		super();
		this.id = id;
		this.projectId = projectId;
		this.source = source;
		this.target = target;
		this.type = type;
	}
	public LinkSaveForm() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
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
