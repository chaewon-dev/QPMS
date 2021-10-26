package com.team3.pms.Dao.project;

public class ResourceEngagementAddDTO {
	String emp_cd_pk;
	String project_pk;
	public ResourceEngagementAddDTO() {
		super();
	}
	
	
	public ResourceEngagementAddDTO(String emp_cd_pk, String project_pk) {
		super();
		this.emp_cd_pk = emp_cd_pk;
		this.project_pk = project_pk;
	}


	public String getEmp_cd_pk() {
		return emp_cd_pk;
	}
	public void setEmp_cd_pk(String emp_cd_pk) {
		this.emp_cd_pk = emp_cd_pk;
	}
	public String getProject_pk() {
		return project_pk;
	}
	public void setProject_pk(String project_pk) {
		this.project_pk = project_pk;
	}
	
	
}
