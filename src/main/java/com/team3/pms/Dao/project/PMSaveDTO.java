package com.team3.pms.Dao.project;

public class PMSaveDTO {
	String project_pk;
	String emp_cd_pk;
	public PMSaveDTO() {
		super();
	}
	public PMSaveDTO(String project_pk, String emp_cd_pk) {
		super();
		this.project_pk = project_pk;
		this.emp_cd_pk = emp_cd_pk;
	}
	public String getProject_pk() {
		return project_pk;
	}
	public void setProject_pk(String project_pk) {
		this.project_pk = project_pk;
	}
	public String getEmp_cd_pk() {
		return emp_cd_pk;
	}
	public void setEmp_cd_pk(String emp_cd_pk) {
		this.emp_cd_pk = emp_cd_pk;
	}
	
	
}
