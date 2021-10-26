package com.team3.pms.Controller.project.form;

public class ResourceEngagementDeleteForm {
	String resourceId;
	String projectId;
	public ResourceEngagementDeleteForm(String resourceId, String projectId) {
		super();
		this.resourceId = resourceId;
		this.projectId = projectId;
	}
	public ResourceEngagementDeleteForm() {
		super();
	}
	public String getResourceId() {
		return resourceId;
	}
	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	
	
}
