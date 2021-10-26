package com.team3.pms.Controller.project.form;

import java.util.Date;

public class ProjectUpdateForm {
	
	String project_pk;
	String project_nm;
	String project_type;
	String rnd_type;
	String emp_dept_pk;
	Date project_start_dt;
	Date project_comp_dt;
	String project_description;
	int project_state_pk;
	
	String cur_resource_pk;
	String cur_emp_cd_pk;
	String new_emp_cd_pk;
	public ProjectUpdateForm(String project_pk, String project_nm, String project_type, String rnd_type,
			String emp_dept_pk, Date project_start_dt, Date project_comp_dt, String project_description,
			int project_state_pk, String cur_resource_pk, String cur_emp_cd_pk, String new_emp_cd_pk) {
		super();
		this.project_pk = project_pk;
		this.project_nm = project_nm;
		this.project_type = project_type;
		this.rnd_type = rnd_type;
		this.emp_dept_pk = emp_dept_pk;
		this.project_start_dt = project_start_dt;
		this.project_comp_dt = project_comp_dt;
		this.project_description = project_description;
		this.project_state_pk = project_state_pk;
		this.cur_resource_pk = cur_resource_pk;
		this.cur_emp_cd_pk = cur_emp_cd_pk;
		this.new_emp_cd_pk = new_emp_cd_pk;
	}
	public ProjectUpdateForm() {
		super();
	}
	public String getProject_pk() {
		return project_pk;
	}
	public void setProject_pk(String project_pk) {
		this.project_pk = project_pk;
	}
	public String getProject_nm() {
		return project_nm;
	}
	public void setProject_nm(String project_nm) {
		this.project_nm = project_nm;
	}
	public String getProject_type() {
		return project_type;
	}
	public void setProject_type(String project_type) {
		this.project_type = project_type;
	}
	public String getRnd_type() {
		return rnd_type;
	}
	public void setRnd_type(String rnd_type) {
		this.rnd_type = rnd_type;
	}
	public String getEmp_dept_pk() {
		return emp_dept_pk;
	}
	public void setEmp_dept_pk(String emp_dept_pk) {
		this.emp_dept_pk = emp_dept_pk;
	}
	public Date getProject_start_dt() {
		return project_start_dt;
	}
	public void setProject_start_dt(Date project_start_dt) {
		this.project_start_dt = project_start_dt;
	}
	public Date getProject_comp_dt() {
		return project_comp_dt;
	}
	public void setProject_comp_dt(Date project_comp_dt) {
		this.project_comp_dt = project_comp_dt;
	}
	public String getProject_description() {
		return project_description;
	}
	public void setProject_description(String project_description) {
		this.project_description = project_description;
	}
	public int getProject_state_pk() {
		return project_state_pk;
	}
	public void setProject_state_pk(int project_state_pk) {
		this.project_state_pk = project_state_pk;
	}
	public String getCur_resource_pk() {
		return cur_resource_pk;
	}
	public void setCur_resource_pk(String cur_resource_pk) {
		this.cur_resource_pk = cur_resource_pk;
	}
	public String getCur_emp_cd_pk() {
		return cur_emp_cd_pk;
	}
	public void setCur_emp_cd_pk(String cur_emp_cd_pk) {
		this.cur_emp_cd_pk = cur_emp_cd_pk;
	}
	public String getNew_emp_cd_pk() {
		return new_emp_cd_pk;
	}
	public void setNew_emp_cd_pk(String new_emp_cd_pk) {
		this.new_emp_cd_pk = new_emp_cd_pk;
	}
	
	
	
	

}
