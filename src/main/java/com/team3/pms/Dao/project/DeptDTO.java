package com.team3.pms.Dao.project;

public class DeptDTO {
	int emp_dept_pk;
	String dept_name;
	public DeptDTO() {
		super();
	}
	public DeptDTO(int emp_dept_pk, String dept_name) {
		super();
		this.emp_dept_pk = emp_dept_pk;
		this.dept_name = dept_name;
	}
	public int getEmp_dept_pk() {
		return emp_dept_pk;
	}
	public void setEmp_dept_pk(int emp_dept_pk) {
		this.emp_dept_pk = emp_dept_pk;
	}
	public String getDept_name() {
		return dept_name;
	}
	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}
	
	

}
