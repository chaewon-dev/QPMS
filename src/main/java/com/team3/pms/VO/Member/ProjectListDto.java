package com.team3.pms.VO.Member;

public class ProjectListDto {
	
	private String project_pk;
	private String resource_role;
	private String auth_name;
	private String project_state_pk;
	private String project_state_nm;
	private String project_nm;
	
	
	public String getProject_nm() {
		return project_nm;
	}
	public void setProject_nm(String project_nm) {
		this.project_nm = project_nm;
	}
	public ProjectListDto() {
		
	}
	public String getProject_pk() {
		return project_pk;
	}
	public String getResource_role() {
		return resource_role;
	}
	public String getAuth_name() {
		return auth_name;
	}
	public String getProject_state_pk() {
		return project_state_pk;
	}
	public String getProject_state_nm() {
		return project_state_nm;
	}
	public void setProject_pk(String project_pk) {
		this.project_pk = project_pk;
	}
	public void setResource_role(String resource_role) {
		this.resource_role = resource_role;
	}
	public void setAuth_name(String auth_name) {
		this.auth_name = auth_name;
	}
	public void setProject_state_pk(String project_state_pk) {
		this.project_state_pk = project_state_pk;
	}
	public void setProject_state_nm(String project_state_nm) {
		this.project_state_nm = project_state_nm;
	}
	
	
}
