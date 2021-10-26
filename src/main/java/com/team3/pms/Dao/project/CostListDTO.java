package com.team3.pms.Dao.project;

import java.util.Date;

public class CostListDTO {
	String cost_pk;
	String cost_type;
	int cost;
	String dept_name;
	Date cost_dt;
	String emp_name;
	Date cost_reg_dt;
	
	
	
	public CostListDTO() {
		super();
	}
	public CostListDTO(String cost_pk, String cost_type, int cost, String dept_name, Date cost_dt, String emp_name,
			Date cost_reg_dt) {
		super();
		this.cost_pk = cost_pk;
		this.cost_type = cost_type;
		this.cost = cost;
		this.dept_name = dept_name;
		this.cost_dt = cost_dt;
		this.emp_name = emp_name;
		this.cost_reg_dt = cost_reg_dt;
	}
	public String getCost_pk() {
		return cost_pk;
	}
	public void setCost_pk(String cost_pk) {
		this.cost_pk = cost_pk;
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
	public String getDept_name() {
		return dept_name;
	}
	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}
	public Date getCost_dt() {
		return cost_dt;
	}
	public void setCost_dt(Date cost_dt) {
		this.cost_dt = cost_dt;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public Date getCost_reg_dt() {
		return cost_reg_dt;
	}
	public void setCost_reg_dt(Date cost_reg_dt) {
		this.cost_reg_dt = cost_reg_dt;
	}
	
	
}
