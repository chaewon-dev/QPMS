package com.team3.pms.VO.community;

import org.springframework.web.multipart.MultipartFile;

public class Bbs {
	
	private int bbs_no;
	private String bbs_cd_pk;
	private String bbs_title;
	private String bbs_kind;
	private String bbs_cont;
	private String bbs_dt;
	private String emp_cd_pk;
	private int bbs_hit;
	private String emp_name;
	
	private String bfile_nm;
	private String bfile_cd_pk;
	private MultipartFile report;
	
	
	public int getBbs_no() {
		return bbs_no;
	}
	public void setBbs_no(int bbs_no) {
		this.bbs_no = bbs_no;
	}
	public String getBbs_cd_pk() {
		return bbs_cd_pk;
	}
	public void setBbs_cd_pk(String bbs_cd_pk) {
		this.bbs_cd_pk = bbs_cd_pk;
	}
	public String getBbs_title() {
		return bbs_title;
	}
	public void setBbs_title(String bbs_title) {
		this.bbs_title = bbs_title;
	}
	public String getBbs_kind() {
		return bbs_kind;
	}
	public void setBbs_kind(String bbs_kind) {
		this.bbs_kind = bbs_kind;
	}
	public String getBbs_cont() {
		return bbs_cont;
	}
	public void setBbs_cont(String bbs_cont) {
		this.bbs_cont = bbs_cont;
	}
	public String getBbs_dt() {
		return bbs_dt;
	}
	public void setBbs_dt(String bbs_dt) {
		this.bbs_dt = bbs_dt;
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
	public int getBbs_hit() {
		return bbs_hit;
	}
	public void setBbs_hit(int bbs_hit) {
		this.bbs_hit = bbs_hit;
	}
	
	public String getBfile_cd_pk() {
		return bfile_cd_pk;
	}
	public void setBfile_cd_pk(String bfile_cd_pk) {
		this.bfile_cd_pk = bfile_cd_pk;
	}
	public String getBfile_nm() {
		return bfile_nm;
	}
	public void setBfile_nm(String bfile_nm) {
		this.bfile_nm = bfile_nm;
	}
	public MultipartFile getReport() {
		return report;
	}
	public void setReport(MultipartFile report) {
		this.report = report;
	}
	
}
