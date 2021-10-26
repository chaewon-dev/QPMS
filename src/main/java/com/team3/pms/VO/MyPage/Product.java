package com.team3.pms.VO.MyPage;

import java.util.Date;

public class Product {
	private String prod_cd_pk;
	private String task_pk;	
	private String task_nm;	
	private String project_pk; 
	private String project_nm; 
	private String uploaded_from;
	private Date prod_reg_dt;
	private String attach_nm;
	private int prod_category_cd;
	private int prod_classify_cd;
	private String prod_detail;
	private String prod_classify_status;
	
	public String getProd_cd_pk() {
		return prod_cd_pk;
	}
	public void setProd_cd_pk(String prod_cd_pk) {
		this.prod_cd_pk = prod_cd_pk;
	}
	public String getTask_pk() {
		return task_pk;
	}
	public void setTask_pk(String task_pk) {
		this.task_pk = task_pk;
	}
	public String getTask_nm() {
		return task_nm;
	}
	public void setTask_nm(String task_nm) {
		this.task_nm = task_nm;
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
	public String getUploaded_from() {
		return uploaded_from;
	}
	public void setUploaded_from(String uploaded_from) {
		this.uploaded_from = uploaded_from;
	}
	public Date getProd_reg_dt() {
		return prod_reg_dt;
	}
	public void setProd_reg_dt(Date prod_reg_dt) {
		this.prod_reg_dt = prod_reg_dt;
	}
	public String getAttach_nm() {
		return attach_nm;
	}
	public void setAttach_nm(String attach_nm) {
		this.attach_nm = attach_nm;
	}
	public int getProd_category_cd() {
		return prod_category_cd;
	}
	public void setProd_category_cd(int prod_category_cd) {
		this.prod_category_cd = prod_category_cd;
	}
	public int getProd_classify_cd() {
		return prod_classify_cd;
	}
	public void setProd_classify_cd(int prod_classify_cd) {
		this.prod_classify_cd = prod_classify_cd;
	}
	public String getProd_detail() {
		return prod_detail;
	}
	public void setProd_detail(String prod_detail) {
		this.prod_detail = prod_detail;
	}
	public String getProd_classify_status() {
		return prod_classify_status;
	}
	public void setProd_classify_status(String prod_classify_status) {
		this.prod_classify_status = prod_classify_status;
	} 
	
	
	

	
}
