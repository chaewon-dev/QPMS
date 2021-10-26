package com.team3.pms.VO.risk;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class Risk {
	/*
	risk_cd varchar(8) PRIMARY KEY,
	risk_nm varchar(30),
	project_cd varchar(8),
	riskpgs_cd char(1),
	risk_finder varchar(9),
	risk_handler varchar(9),
	risk_regdate_dt date,
	risk_upddate_dt date,
	risk_actionbf text(3000),
	risk_actionaf text(3000),
	risk_lesson text(3000),
	risk_file text(3000)
	 */
	
	private String risk_cd;
	private String risk_nm;
	private String project_cd;
	
	private int riskpgs_cd;
	
	private String risk_finder;
	private String risk_handler;
	private Date risk_regdate_dt;
	private Date risk_upddate_dt;
	
	private int risktype_pk;
	private String risktype_nm;
	
	private int riskact_pk;
	private String riskact_st;
	
	private String risk_actionbf;
	private String risk_actionaf;
	private String risk_lesson;
	private String risk_file;
	
	

	private String project_nm;
	
	private String riskpgs_st;
	
	
	
	/* 파일 다운로드 */
	private MultipartFile report;



	public MultipartFile getReport() {
		return report;
	}

	public void setReport(MultipartFile report) {
		this.report = report;
	}








	public Risk() {
		super();
	}
	
	






	public String getRisk_cd() {
		return risk_cd;
	}

	public void setRisk_cd(String risk_cd) {
		this.risk_cd = risk_cd;
	}

	public String getRisk_nm() {
		return risk_nm;
	}

	public void setRisk_nm(String risk_nm) {
		this.risk_nm = risk_nm;
	}

	public String getProject_cd() {
		return project_cd;
	}

	public void setProject_cd(String project_cd) {
		this.project_cd = project_cd;
	}

	public int getRiskpgs_cd() {
		return riskpgs_cd;
	}

	public void setRiskpgs_cd(int riskpgs_cd) {
		this.riskpgs_cd = riskpgs_cd;
	}

	public String getRisk_finder() {
		return risk_finder;
	}

	public void setRisk_finder(String risk_finder) {
		this.risk_finder = risk_finder;
	}

	public String getRisk_handler() {
		return risk_handler;
	}

	public void setRisk_handler(String risk_handler) {
		this.risk_handler = risk_handler;
	}

	public Date getRisk_regdate_dt() {
		return risk_regdate_dt;
	}

	public void setRisk_regdate_dt(Date risk_regdate_dt) {
		this.risk_regdate_dt = risk_regdate_dt;
	}

	public Date getRisk_upddate_dt() {
		return risk_upddate_dt;
	}

	public void setRisk_upddate_dt(Date risk_upddate_dt) {
		this.risk_upddate_dt = risk_upddate_dt;
	}

	public String getRisk_actionbf() {
		return risk_actionbf;
	}

	public void setRisk_actionbf(String risk_actionbf) {
		this.risk_actionbf = risk_actionbf;
	}

	public String getRisk_actionaf() {
		return risk_actionaf;
	}

	public void setRisk_actionaf(String risk_actionaf) {
		this.risk_actionaf = risk_actionaf;
	}

	public String getRisk_lesson() {
		return risk_lesson;
	}

	public void setRisk_lesson(String risk_lesson) {
		this.risk_lesson = risk_lesson;
	}


	public String getProject_nm() {
		return project_nm;
	}

	public void setProject_nm(String project_nm) {
		this.project_nm = project_nm;
	}
	
	public String getRiskpgs_st() {
		return riskpgs_st;
	}

	public void setRiskpgs_st(String riskpgs_st) {
		this.riskpgs_st = riskpgs_st;
	}
	
	

	public String getRisk_file() {
		return risk_file;
	}

	public void setRisk_file(String risk_file) {
		this.risk_file = risk_file;
	}




	public int getRisktype_pk() {
		return risktype_pk;
	}




	public void setRisktype_pk(int risktype_pk) {
		this.risktype_pk = risktype_pk;
	}




	public String getRisktype_nm() {
		return risktype_nm;
	}




	public void setRisktype_nm(String risktype_nm) {
		this.risktype_nm = risktype_nm;
	}

	public int getRiskact_pk() {
		return riskact_pk;
	}


	public void setRiskact_pk(int riskact_pk) {
		this.riskact_pk = riskact_pk;
	}


	public String getRiskact_st() {
		return riskact_st;
	}


	public void setRiskact_st(String riskact_st) {
		this.riskact_st = riskact_st;
	}
	
	

	
}
