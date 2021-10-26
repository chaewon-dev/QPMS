package com.team3.pms.VO.community;

public class ChatTitle {
	private String titl_cd_pk;
	private String chtr_cd_pk;
	private String titl_nm;
	private String emp_cd_pk;
	
	
	public ChatTitle(String chtr_cd_pk, String titl_nm, String emp_cd_pk) {
		super();
		this.chtr_cd_pk = chtr_cd_pk;
		this.titl_nm = titl_nm;
		this.emp_cd_pk = emp_cd_pk;
	}
	public String getTitl_cd_pk() {
		return titl_cd_pk;
	}
	public void setTitl_cd_pk(String titl_cd_pk) {
		this.titl_cd_pk = titl_cd_pk;
	}
	public String getChtr_cd_pk() {
		return chtr_cd_pk;
	}
	public void setChtr_cd_pk(String chtr_cd_pk) {
		this.chtr_cd_pk = chtr_cd_pk;
	}
	public String getTitl_nm() {
		return titl_nm;
	}
	public void setTitl_nm(String titl_nm) {
		this.titl_nm = titl_nm;
	}
	public String getEmp_cd_pk() {
		return emp_cd_pk;
	}
	public void setEmp_cd_pk(String emp_cd_pk) {
		this.emp_cd_pk = emp_cd_pk;
	}
	
	
}
