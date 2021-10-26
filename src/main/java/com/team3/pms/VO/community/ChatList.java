package com.team3.pms.VO.community;

public class ChatList {
	private String chtl_cd_pk;
	private String chtr_cd_pk;
	private String emp_cd_pk;
	private String emp_name;
	private String dept_name;
	private String chtl_dt;
	
	public ChatList() {
		super();
	}
	
	public ChatList(String chtr_cd_pk, String emp_cd_pk) {
		super();
		this.chtr_cd_pk = chtr_cd_pk;
		this.emp_cd_pk = emp_cd_pk;
	}

	public String getChtl_cd_pk() {
		return chtl_cd_pk;
	}
	public void setChtl_cd_pk(String chtl_cd_pk) {
		this.chtl_cd_pk = chtl_cd_pk;
	}
	public String getChtr_cd_pk() {
		return chtr_cd_pk;
	}
	public void setChtr_cd_pk(String chtr_cd_pk) {
		this.chtr_cd_pk = chtr_cd_pk;
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

	public String getChtl_dt() {
		return chtl_dt;
	}

	public void setChtl_dt(String chtl_dt) {
		this.chtl_dt = chtl_dt;
	}

	
}
