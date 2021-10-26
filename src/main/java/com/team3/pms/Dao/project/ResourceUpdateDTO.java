package com.team3.pms.Dao.project;

public class ResourceUpdateDTO {
	String emp_cd_pk;
	String project_pk;
	int resource_role;
	public ResourceUpdateDTO(String emp_cd_pk, String project_pk, int resource_role) {
		super();
		this.emp_cd_pk = emp_cd_pk;
		this.project_pk = project_pk;
		this.resource_role = resource_role;
	}
	public ResourceUpdateDTO() {
		super();
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
	public int getResource_role() {
		return resource_role;
	}
	public void setResource_role(int resource_role) {
		this.resource_role = resource_role;
	}
	
	
	
	

}
