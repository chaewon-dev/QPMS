package com.team3.pms.VO.risk;

public class RiskResource {
	private String resource_pk;
	private String project_pk;
	private String emp_cd_pk;
	private int resource_role;
	
	private String emp_name;
	
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
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	
	
	
}
