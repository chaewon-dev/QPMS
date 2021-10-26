package com.team3.pms.Dao.project;

import java.util.Date;

public class ProjectDetailDTO {

	String project_pk;
	int project_state_pk;
	int emp_dept_pk;
	String project_nm;
	String project_type;
	String rnd_type;
	Date project_start_dt;
	Date project_comp_dt;
	String project_description;
	public ProjectDetailDTO(String project_pk, int project_state_pk, int emp_dept_pk, String project_nm,
			String project_type, String rnd_type, Date project_start_dt, Date project_comp_dt,
			String project_description) {
		super();
		this.project_pk = project_pk;
		this.project_state_pk = project_state_pk;
		this.emp_dept_pk = emp_dept_pk;
		this.project_nm = project_nm;
		this.project_type = project_type;
		this.rnd_type = rnd_type;
		this.project_start_dt = project_start_dt;
		this.project_comp_dt = project_comp_dt;
		this.project_description = project_description;
	}
	public ProjectDetailDTO() {
		super();
	}
	public String getProject_pk() {
		return project_pk;
	}
	public void setProject_pk(String project_pk) {
		this.project_pk = project_pk;
	}
	public int getProject_state_pk() {
		return project_state_pk;
	}
	public void setProject_state_pk(int project_state_pk) {
		this.project_state_pk = project_state_pk;
	}
	public int getEmp_dept_pk() {
		return emp_dept_pk;
	}
	public void setEmp_dept_pk(int emp_dept_pk) {
		this.emp_dept_pk = emp_dept_pk;
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
	
	
	
}
