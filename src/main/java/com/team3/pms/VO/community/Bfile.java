package com.team3.pms.VO.community;

public class Bfile {
	private String bfile_cd_pk;
	private String bbs_cd_pk;
	private String org_nm;
	private String bfile_nm;
	private String bfile_path;
	private String bfile_dt;
	
	
	public Bfile() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Bfile(String org_nm, String bfile_nm) {
		super();
		this.org_nm = org_nm;
		this.bfile_nm = bfile_nm;
	}

	public Bfile(String bbs_cd_pk, String org_nm, String bfile_nm) {
		super();
		this.bbs_cd_pk = bbs_cd_pk;
		this.org_nm = org_nm;
		this.bfile_nm = bfile_nm;
	}

	public String getBfile_cd_pk() {
		return bfile_cd_pk;
	}
	public void setBfile_cd_pk(String bfile_cd_pk) {
		this.bfile_cd_pk = bfile_cd_pk;
	}
	public String getBbs_cd_pk() {
		return bbs_cd_pk;
	}
	public void setBbs_cd_pk(String bbs_cd_pk) {
		this.bbs_cd_pk = bbs_cd_pk;
	}
	public String getOrg_nm() {
		return org_nm;
	}
	public void setOrg_nm(String org_nm) {
		this.org_nm = org_nm;
	}
	public String getBfile_nm() {
		return bfile_nm;
	}
	public void setBfile_nm(String bfile_nm) {
		this.bfile_nm = bfile_nm;
	}
	public String getBfile_path() {
		return bfile_path;
	}
	public void setBfile_path(String bfile_path) {
		this.bfile_path = bfile_path;
	}
	public String getBfile_dt() {
		return bfile_dt;
	}
	public void setBfile_dt(String bfile_dt) {
		this.bfile_dt = bfile_dt;
	}

	
}
