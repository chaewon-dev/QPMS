package com.team3.pms.Controller.project.form;

public class MemberListGetForm {
	int deptData;
	String projectId;
	
	
	public MemberListGetForm() {
		super();
	}


	public MemberListGetForm(int deptData, String projectId) {
		super();
		this.deptData = deptData;
		this.projectId = projectId;
	}


	public int getDeptData() {
		return deptData;
	}


	public void setDeptData(int deptData) {
		this.deptData = deptData;
	}


	public String getProjectId() {
		return projectId;
	}


	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	
	

}
