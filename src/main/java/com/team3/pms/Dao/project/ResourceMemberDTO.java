package com.team3.pms.Dao.project;

public class ResourceMemberDTO {
	//emp_cd_pk, emp_name, dept_name
	String emp_cd_pk;
	String emp_name;
	String dept_name;
	//String project_pk;
	


	public ResourceMemberDTO() {
		super();
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
	public String getDept_name() {
		return dept_name;
	}
	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}
	
	
}
