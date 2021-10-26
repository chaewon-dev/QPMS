package com.team3.pms.VO.MyPage;

import java.util.Date;

public class Task {
	private String task_pk;	
	private String project_pk; 
	private String task_approver; 
	private String task_nm;	
	private String task_state;	
	private Date task_start_dt;	
	private Date task_comp_dt;		
	private String start_dt;	
	private String comp_dt;		
	private double task_progress; 
	private String task_type; 
	private String task_description; 
	private String task_parent;	
	private int task_sortorder;
	private String emp_name;
	private String start_date;
	private String end_date;
	private String approval_cd_pk;
	private String emp_cd_pk;
	private int approval_status;
	private Date approval_reg_dt;
	private String approval_detail;
	private String project_nm;
	private double appro_progress;
	private String approval_from;
	
	


	public Task() {
		super();
	}



	public Task(String task_pk) {
		super();
		this.task_pk = task_pk;
	}



	public Task(String approval_detail, String task_pk) {
		super();
		this.approval_detail = approval_detail;
		this.task_pk = task_pk;
	}




	public Task(String approval_detail, String task_pk, String emp_cd_pk) {
		super();
		this.approval_detail = approval_detail;
		this.task_pk = task_pk;
		this.emp_cd_pk = emp_cd_pk;
	}



	public String getTask_pk() {
		return task_pk;
	}
	public void setTask_pk(String task_pk) {
		this.task_pk = task_pk;
	}
	public String getProject_pk() {
		return project_pk;
	}
	public void setProject_pk(String project_pk) {
		this.project_pk = project_pk;
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
	public Date getTask_start_dt() {
		return task_start_dt;
	}
	public void setTask_start_dt(Date task_start_dt) {
		this.task_start_dt = task_start_dt;
	}
	public Date getTask_comp_dt() {
		return task_comp_dt;
	}
	public void setTask_comp_dt(Date task_comp_dt) {
		this.task_comp_dt = task_comp_dt;
	}
	public double getTask_progress() {
		return task_progress;
	}
	public void setTask_progress(double task_progress) {
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
	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public String getEnd_date() {
		return end_date;
	}
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
	public int getApproval_status() {
		return approval_status;
	}
	public void setApproval_status(int approval_status) {
		this.approval_status = approval_status;
	}
	public Date getApproval_reg_dt() {
		return approval_reg_dt;
	}
	public void setApproval_reg_dt(Date approval_reg_dt) {
		this.approval_reg_dt = approval_reg_dt;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public String getProject_nm() {
		return project_nm;
	}
	public void setProject_nm(String project_nm) {
		this.project_nm = project_nm;
	}
	public String getApproval_detail() {
		return approval_detail;
	}
	public void setApproval_detail(String approval_detail) {
		this.approval_detail = approval_detail;
	}
	public String getStart_dt() {
		return start_dt;
	}
	public void setStart_dt(String start_dt) {
		this.start_dt = start_dt;
	}
	public String getComp_dt() {
		return comp_dt;
	}
	public void setComp_dt(String comp_dt) {
		this.comp_dt = comp_dt;
	}
	public double getAppro_progress() {
		return appro_progress;
	}
	public void setAppro_progress(double appro_progress) {
		this.appro_progress = appro_progress;
	}
	public String getApproval_cd_pk() {
		return approval_cd_pk;
	}
	public void setApproval_cd_pk(String approval_cd_pk) {
		this.approval_cd_pk = approval_cd_pk;
	}
	public String getEmp_cd_pk() {
		return emp_cd_pk;
	}
	public void setEmp_cd_pk(String emp_cd_pk) {
		this.emp_cd_pk = emp_cd_pk;
	}
	public String getApproval_from() {
		return approval_from;
	}
	public void setApproval_from(String approval_from) {
		this.approval_from = approval_from;
	}
	
}
