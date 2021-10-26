package com.team3.pms.Controller.project.form;

import java.util.Date;

public class CostSaveForm {
	String project_pk;
	String emp_cd_pk;
	String emp_dept_pk;
	String cost_type;
	int cost;
	String cost_memo ;
	Date cost_dt ;
	public CostSaveForm(String project_pk, String emp_cd_pk, String emp_dept_pk, String cost_type, int cost,
			String cost_memo, Date cost_dt) {
		super();
		this.project_pk = project_pk;
		this.emp_cd_pk = emp_cd_pk;
		this.emp_dept_pk = emp_dept_pk;
		this.cost_type = cost_type;
		this.cost = cost;
		this.cost_memo = cost_memo;
		this.cost_dt = cost_dt;
	}
	public CostSaveForm() {
		super();
	}
	public String getProject_pk() {
		return project_pk;
	}
	public void setProject_pk(String project_pk) {
		this.project_pk = project_pk;
	}
	public String getEmp_cd_pk() {
		return emp_cd_pk;
	}
	public void setEmp_cd_pk(String emp_cd_pk) {
		this.emp_cd_pk = emp_cd_pk;
	}
	public String getEmp_dept_pk() {
		return emp_dept_pk;
	}
	public void setEmp_dept_pk(String emp_dept_pk) {
		this.emp_dept_pk = emp_dept_pk;
	}
	public String getCost_type() {
		return cost_type;
	}
	public void setCost_type(String cost_type) {
		this.cost_type = cost_type;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public String getCost_memo() {
		return cost_memo;
	}
	public void setCost_memo(String cost_memo) {
		this.cost_memo = cost_memo;
	}
	public Date getCost_dt() {
		return cost_dt;
	}
	public void setCost_dt(Date cost_dt) {
		this.cost_dt = cost_dt;
	}
	
	
}
