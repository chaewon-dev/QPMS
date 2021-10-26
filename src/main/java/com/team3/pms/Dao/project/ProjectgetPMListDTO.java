package com.team3.pms.Dao.project;

public class ProjectgetPMListDTO {
	String emp_cd_pk;
	String emp_name;
	public ProjectgetPMListDTO() {
		super();
	}
	public ProjectgetPMListDTO(String emp_cd_pk, String emp_name) {
		super();
		this.emp_cd_pk = emp_cd_pk;
		this.emp_name = emp_name;
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
