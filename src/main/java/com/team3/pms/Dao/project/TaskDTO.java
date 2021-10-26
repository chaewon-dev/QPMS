package com.team3.pms.Dao.project;

import java.time.LocalDateTime;

public class TaskDTO {
	String task_pk;
	String task_approver;
	String task_nm;
	String task_state;
	String task_start_dt;
	String task_comp_dt;
	float task_progress;
	String task_type;
	String task_description;
	String task_parent;
	int task_sortorder;
	String task_manager;
	
	public TaskDTO() {
		super();
	}
	public TaskDTO(String task_pk, String task_approver, String task_nm, String task_state, String task_start_dt,
			String task_comp_dt, float task_progress, String task_type, String task_description, String task_parent,
			int task_sortorder, String task_manager) {
		super();
		this.task_pk = task_pk;
		this.task_approver = task_approver;
		this.task_nm = task_nm;
		this.task_state = task_state;
		this.task_start_dt = task_start_dt;
		this.task_comp_dt = task_comp_dt;
		this.task_progress = task_progress;
		this.task_type = task_type;
		this.task_description = task_description;
		this.task_parent = task_parent;
		this.task_sortorder = task_sortorder;
		this.task_manager = task_manager;
	}
	
	
	
	public String getTask_manager() {
		return task_manager;
	}
	public void setTask_manager(String task_manager) {
		this.task_manager = task_manager;
	}
	public String getTask_pk() {
		return task_pk;
	}
	public void setTask_pk(String task_pk) {
		this.task_pk = task_pk;
	}
	public String getTask_approver() {
		return task_approver;
	}
	public void setTask_approver(String task_approver) {
		this.task_approver = task_approver;
	}
	public String getTask_nm() {
		return task_nm;
	}
	public void setTask_nm(String task_nm) {
		this.task_nm = task_nm;
	}
	public String getTask_state() {
		return task_state;
	}
	public void setTask_state(String task_state) {
		this.task_state = task_state;
	}
	public String getTask_start_dt() {
		return task_start_dt;
	}
	public void setTask_start_dt(String task_start_dt) {
		this.task_start_dt = task_start_dt;
	}
	public String getTask_comp_dt() {
		return task_comp_dt;
	}
	public void setTask_comp_dt(String task_comp_dt) {
		this.task_comp_dt = task_comp_dt;
	}
	public float getTask_progress() {
		return task_progress;
	}
	public void setTask_progress(float task_progress) {
		this.task_progress = task_progress;
	}
	public String getTask_type() {
		return task_type;
	}
	public void setTask_type(String task_type) {
		this.task_type = task_type;
	}
	public String getTask_description() {
		return task_description;
	}
	public void setTask_description(String task_description) {
		this.task_description = task_description;
	}
	public String getTask_parent() {
		return task_parent;
	}
	public void setTask_parent(String task_parent) {
		this.task_parent = task_parent;
	}
	public int getTask_sortorder() {
		return task_sortorder;
	}
	public void setTask_sortorder(int task_sortorder) {
		this.task_sortorder = task_sortorder;
	}
	
	
	
	
}
