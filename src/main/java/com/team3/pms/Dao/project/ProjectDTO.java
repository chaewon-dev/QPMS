package com.team3.pms.Dao.project;

import java.util.Date;

public class ProjectDTO {
	String project_nm;
	String project_state_nm;
	String project_pk;
	String project_type;
	Date project_start_dt;
	Date project_comp_dt;
	public ProjectDTO(String project_nm, String project_state_nm, String project_pk, String project_type,
			Date project_start_dt, Date project_comp_dt) {
		super();
		this.project_nm = project_nm;
		this.project_state_nm = project_state_nm;
		this.project_pk = project_pk;
		this.project_type = project_type;
		this.project_start_dt = project_start_dt;
		this.project_comp_dt = project_comp_dt;
	}
	public String getProject_nm() {
		return project_nm;
	}
	public void setProject_nm(String project_nm) {
		this.project_nm = project_nm;
	}
	public String getProject_state_nm() {
		return project_state_nm;
	}
	public void setProject_state_nm(String project_state_nm) {
		this.project_state_nm = project_state_nm;
	}
	public String getProject_pk() {
		return project_pk;
	}
	public void setProject_pk(String project_pk) {
		this.project_pk = project_pk;
	}
	public String getProject_type() {
		return project_type;
	}
	public void setProject_type(String project_type) {
		this.project_type = project_type;
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
	
	

}
