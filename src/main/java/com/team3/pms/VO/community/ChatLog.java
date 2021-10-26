package com.team3.pms.VO.community;

public class ChatLog {
	private String clog_cd_pk;
	private String chtr_cd_pk;
	private String clog_sender;
	private String clog_cont;
	private String clog_dt;
	//not in DB
	private String emp_name;
	private String dept_name;
	
	
	public ChatLog() {
		super();
	}
	public ChatLog(String chtr_cd_pk, String clog_cont) {
		super();
		this.chtr_cd_pk = chtr_cd_pk;
		this.clog_cont = clog_cont;
	}
	public ChatLog(String chtr_cd_pk, String clog_sender, String clog_cont) {
		super();
		this.chtr_cd_pk = chtr_cd_pk;
		this.clog_sender = clog_sender;
		this.clog_cont = clog_cont;
	}
	public String getClog_cd_pk() {
		return clog_cd_pk;
	}
	public void setClog_cd_pk(String clog_cd_pk) {
		this.clog_cd_pk = clog_cd_pk;
	}
	public String getChtr_cd_pk() {
		return chtr_cd_pk;
	}
	public void setChtr_cd_pk(String chtr_cd_pk) {
		this.chtr_cd_pk = chtr_cd_pk;
	}
	public String getClog_sender() {
		return clog_sender;
	}
	public void setClog_sender(String clog_sender) {
		this.clog_sender = clog_sender;
	}
	public String getClog_cont() {
		return clog_cont;
	}
	public void setClog_cont(String clog_cont) {
		this.clog_cont = clog_cont;
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
	public String getClog_dt() {
		return clog_dt;
	}
	public void setClog_dt(String clog_dt) {
		this.clog_dt = clog_dt;
	}
	
	
}
