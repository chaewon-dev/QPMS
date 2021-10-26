package com.team3.pms.Dao.project;

public class ProjectResourceGetDTO {
	String resource_pk;
	String emp_cd_pk;
	String emp_name;
	public ProjectResourceGetDTO(String resource_pk, String emp_cd_pk, String emp_name) {
		super();
		this.resource_pk = resource_pk;
		this.emp_cd_pk = emp_cd_pk;
		this.emp_name = emp_name;
	}
	public ProjectResourceGetDTO() {
		super();
	}
	public String getResource_pk() {
		return resource_pk;
	}
	public void setResource_pk(String resource_pk) {
		this.resource_pk = resource_pk;
	}
	public String getEmp_cd_pk() {
		return emp_cd_pk;
	}
	public void setEmp_cd_pk(String emp_cd_pk) {
		this.emp_cd_pk = emp_cd_pk;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	
	

}
