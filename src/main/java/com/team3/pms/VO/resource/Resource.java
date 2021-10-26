package com.team3.pms.VO.resource;

import java.util.Date;

public class Resource {
	private String emp_cd_pk;
	private String emp_auth_fk;
	private String emp_dept_fk;
	private String emp_pos_fk;
	private String emp_id;
	private String emp_pw;
	private String emp_name;
	private Date emp_birth;
	private String emp_img;
	private String emp_tel;
	private String emp_email;
	private Date income_date;
	private Date edit_date;
	
	private String pos_name;

	
	private String dept_name;
	
	

	public String getEmp_cd_pk() {
		return emp_cd_pk;
	}

	public void setEmp_cd_pk(String emp_cd_pk) {
		this.emp_cd_pk = emp_cd_pk;
	}

	public String getEmp_auth_fk() {
		return emp_auth_fk;
	}

	public void setEmp_auth_fk(String emp_auth_fk) {
		this.emp_auth_fk = emp_auth_fk;
	}

	public String getEmp_dept_fk() {
		return emp_dept_fk;
	}

	public void setEmp_dept_fk(String emp_dept_fk) {
		this.emp_dept_fk = emp_dept_fk;
	}

	public String getEmp_pos_fk() {
		return emp_pos_fk;
	}

	public void setEmp_pos_fk(String emp_pos_fk) {
		this.emp_pos_fk = emp_pos_fk;
	}

	public String getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}

	public String getEmp_pw() {
		return emp_pw;
	}

	public void setEmp_pw(String emp_pw) {
		this.emp_pw = emp_pw;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public Date getEmp_birth() {
		return emp_birth;
	}

	public void setEmp_birth(Date emp_birth) {
		this.emp_birth = emp_birth;
	}

	public String getEmp_img() {
		return emp_img;
	}

	public void setEmp_img(String emp_img) {
		this.emp_img = emp_img;
	}

	public String getEmp_tel() {
		return emp_tel;
	}

	public void setEmp_tel(String emp_tel) {
		this.emp_tel = emp_tel;
	}

	public String getEmp_email() {
		return emp_email;
	}

	public void setEmp_email(String emp_email) {
		this.emp_email = emp_email;
	}

	public Date getIncome_date() {
		return income_date;
	}

	public void setIncome_date(Date income_date) {
		this.income_date = income_date;
	}

	public Date getEdit_date() {
		return edit_date;
	}

	public void setEdit_date(Date edit_date) {
		this.edit_date = edit_date;
	}

	public String getPos_name() {
		return pos_name;
	}

	public void setPos_name(String pos_name) {
		this.pos_name = pos_name;
	}

	public String getDept_name() {
		return dept_name;
	}

	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}
	
}
