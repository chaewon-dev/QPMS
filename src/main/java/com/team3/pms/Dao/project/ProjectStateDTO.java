package com.team3.pms.Dao.project;

public class ProjectStateDTO {
	int project_state_pk;
	String project_state_nm;
	public ProjectStateDTO(int project_state_pk, String project_state_nm) {
		super();
		this.project_state_pk = project_state_pk;
		this.project_state_nm = project_state_nm;
	}
	public ProjectStateDTO() {
		super();
	}
	public int getProject_state_pk() {
		return project_state_pk;
	}
	public void setProject_state_pk(int project_state_pk) {
		this.project_state_pk = project_state_pk;
	}
	public String getProject_state_nm() {
		return project_state_nm;
	}
	public void setProject_state_nm(String project_state_nm) {
		this.project_state_nm = project_state_nm;
	}
	
	

}
