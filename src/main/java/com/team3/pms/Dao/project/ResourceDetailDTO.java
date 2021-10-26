package com.team3.pms.Dao.project;

public class ResourceDetailDTO {
	String resource_pk;
	String project_pk;
	String emp_cd_pk;
	int resource_role;
	String emp_name;
	
	public ResourceDetailDTO(String resource_pk, String project_pk, String emp_cd_pk, int resource_role,
			String emp_name) {
		super();
		this.resource_pk = resource_pk;
		this.project_pk = project_pk;
		this.emp_cd_pk = emp_cd_pk;
		this.resource_role = resource_role;
		this.emp_name = emp_name;
	}
	
	
	public String getEmp_name() {
		return emp_name;
	}


	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}


	public ResourceDetailDTO() {
		super();
	}
	public String getResource_pk() {
		return resource_pk;
	}
	public void setResource_pk(String resource_pk) {
		this.resource_pk = resource_pk;
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
	public int getResource_role() {
		return resource_role;
	}
	public void setResource_role(int resource_role) {
		this.resource_role = resource_role;
	}
	
	

}
