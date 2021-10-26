package com.team3.pms.VO.MyPage;

import java.util.Date;

public class Log {
	private String task_log_cd_pk;
	private String task_pk;
	private String approval_cd_pk;
	private int task_log_category;
	private Date task_log_dt;
	private String task_log_writer;
	
	
	public String getTask_log_cd_pk() {
		return task_log_cd_pk;
	}
	public void setTask_log_cd_pk(String task_log_cd_pk) {
		this.task_log_cd_pk = task_log_cd_pk;
	}
	public String getTask_pk() {
		return task_pk;
	}
	public void setTask_pk(String task_pk) {
		this.task_pk = task_pk;
	}
	public String getApproval_cd_pk() {
		return approval_cd_pk;
	}
	public void setApproval_cd_pk(String approval_cd_pk) {
		this.approval_cd_pk = approval_cd_pk;
	}
	public int getTask_log_category() {
		return task_log_category;
	}
	public void setTask_log_category(int task_log_category) {
		this.task_log_category = task_log_category;
	}
	public Date getTask_log_dt() {
		return task_log_dt;
	}
	public void setTask_log_dt(Date task_log_dt) {
		this.task_log_dt = task_log_dt;
	}
	public String getTask_log_writer() {
		return task_log_writer;
	}
	public void setTask_log_writer(String task_log_writer) {
		this.task_log_writer = task_log_writer;
	}
	
	
}
