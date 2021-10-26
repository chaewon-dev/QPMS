package com.team3.pms.VO.community;


public class Chat {
	private String chtr_cd_pk;
	private String chtr_nm;
	private String chtr_kind;
	//private String file_nm;
	//private String file_path;
	private String chtr_dt;
	//not in DB
	private String emp_cd_pk;
	private String emp_name;
	private String dept_name;
	private String chtr_cont;
	private String send_dt;
	
	public Chat() {
		super();
	}
	
	public Chat(String chtr_cd_pk, String emp_cd_pk) {
		super();
		this.chtr_cd_pk = chtr_cd_pk;
		this.emp_cd_pk = emp_cd_pk;
	}

	public Chat(String chtr_cd_pk, String chtr_nm, String emp_cd_pk) {
		super();
		this.chtr_cd_pk = chtr_cd_pk;
		this.chtr_nm = chtr_nm;
		this.emp_cd_pk = emp_cd_pk;
	}

	public String getChtr_cd_pk() {
		return chtr_cd_pk;
	}
	public void setChtr_cd_pk(String chtr_cd_pk) {
		this.chtr_cd_pk = chtr_cd_pk;
	}
	public String getChtr_nm() {
		return chtr_nm;
	}
	public void setChtr_nm(String chtr_nm) {
		this.chtr_nm = chtr_nm;
	}
	public String getChtr_dt() {
		return chtr_dt;
	}
	public void setChtr_dt(String chtr_dt) {
		this.chtr_dt = chtr_dt;
	}
	public String getChtr_kind() {
		return chtr_kind;
	}
	public void setChtr_kind(String chtr_kind) {
		this.chtr_kind = chtr_kind;
	}
	public String getChtr_cont() {
		return chtr_cont;
	}
	public void setChtr_cont(String chtr_cont) {
		this.chtr_cont = chtr_cont;
	}
	/*
	public String getFile_nm() {
		return file_nm;
	}
	public void setFile_nm(String file_nm) {
		this.file_nm = file_nm;
	}
	public String getFile_path() {
		return file_path;
	}
	public void setFile_path(String file_path) {
		this.file_path = file_path;
	}*/
	public String getSend_dt() {
		return send_dt;
	}
	public void setSend_dt(String send_dt) {
		this.send_dt = send_dt;
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
	
	
}
