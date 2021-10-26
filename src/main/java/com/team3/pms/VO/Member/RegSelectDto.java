package com.team3.pms.VO.Member;

public class RegSelectDto {
	private int emp_auth_pk;
	private String auth_name;
	private int emp_dept_pk;
	private String dept_name;
	private int emp_pos_pk;
	private String pos_name;
	
	public RegSelectDto() {

	}
	
	public String getPos_name() {
		return pos_name;
	}

	public void setPos_name(String pos_name) {
		this.pos_name = pos_name;
	}

	public int getEmp_auth_pk() {
		return emp_auth_pk;
	}
	public String getAuth_name() {
		return auth_name;
	}
	public int getEmp_dept_pk() {
		return emp_dept_pk;
	}
	public String getDept_name() {
		return dept_name;
	}
	public int getEmp_pos_pk() {
		return emp_pos_pk;
	}
	public void setEmp_auth_pk(int emp_auth_pk) {
		this.emp_auth_pk = emp_auth_pk;
	}
	public void setAuth_name(String auth_name) {
		this.auth_name = auth_name;
	}
	public void setEmp_dept_pk(int emp_dept_pk) {
		this.emp_dept_pk = emp_dept_pk;
	}
	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}
	public void setEmp_pos_pk(int emp_pos_pk) {
		this.emp_pos_pk = emp_pos_pk;
	}
	
	
}
