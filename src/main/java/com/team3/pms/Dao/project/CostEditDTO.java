package com.team3.pms.Dao.project;

import java.util.Date;

public class CostEditDTO {
	String cost_pk;
	String emp_cd_pk;
	String cost_type;
	int cost;
	String emp_dept_pk;
	Date cost_dt;
	String cost_memo;
	public String getCost_pk() {
		return cost_pk;
	}
	public void setCost_pk(String cost_pk) {
		this.cost_pk = cost_pk;
	}
	public String getEmp_cd_pk() {
		return emp_cd_pk;
	}
	public void setEmp_cd_pk(String emp_cd_pk) {
		this.emp_cd_pk = emp_cd_pk;
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
	public String getEmp_dept_pk() {
		return emp_dept_pk;
	}
	public void setEmp_dept_pk(String emp_dept_pk) {
		this.emp_dept_pk = emp_dept_pk;
	}
	public Date getCost_dt() {
		return cost_dt;
	}
	public void setCost_dt(Date cost_dt) {
		this.cost_dt = cost_dt;
	}
	public String getCost_memo() {
		return cost_memo;
	}
	public void setCost_memo(String cost_memo) {
		this.cost_memo = cost_memo;
	}
	
	
	
	
}
