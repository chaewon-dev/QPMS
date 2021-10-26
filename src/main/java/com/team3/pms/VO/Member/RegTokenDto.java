package com.team3.pms.VO.Member;

public class RegTokenDto {
	private int id;
	private String expiration_dt;
	private int expired; //1:true, 0:false
	private String emp_email;
	private String emp_name;
	private int emp_auth_fk;
	private String auth_name;
	private int emp_dept_fk;
	private String dept_name;
	private int emp_pos_fk;
	private String pos_name;
	private String create_dt;
	private String last_modified_dt;
	private String sha;
	
	
	
	public RegTokenDto() {
		
	}
	
	public String getSha() {
		return sha;
	}

	public void setSha(String sha) {
		this.sha = sha;
	}

	public int getId() {
		return id;
	}
	public String getExpiration_dt() {
		return expiration_dt;
	}
	public int getExpired() {
		return expired;
	}
	public String getEmp_email() {
		return emp_email;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public int getEmp_auth_fk() {
		return emp_auth_fk;
	}
	public String getAuth_name() {
		return auth_name;
	}
	public int getEmp_dept_fk() {
		return emp_dept_fk;
	}
	public String getDept_name() {
		return dept_name;
	}
	public int getEmp_pos_fk() {
		return emp_pos_fk;
	}
	public String getPos_name() {
		return pos_name;
	}
	public String getCreate_dt() {
		return create_dt;
	}
	public String getLast_modified_dt() {
		return last_modified_dt;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setExpiration_dt(String expiration_dt) {
		this.expiration_dt = expiration_dt;
	}
	public void setExpired(int expired) {
		this.expired = expired;
	}
	public void setEmp_email(String emp_email) {
		this.emp_email = emp_email;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public void setEmp_auth_fk(int emp_auth_fk) {
		this.emp_auth_fk = emp_auth_fk;
	}
	public void setAuth_name(String auth_name) {
		this.auth_name = auth_name;
	}
	public void setEmp_dept_fk(int emp_dept_fk) {
		this.emp_dept_fk = emp_dept_fk;
	}
	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}
	public void setEmp_pos_fk(int emp_pos_fk) {
		this.emp_pos_fk = emp_pos_fk;
	}
	public void setPos_name(String pos_name) {
		this.pos_name = pos_name;
	}
	public void setCreate_dt(String create_dt) {
		this.create_dt = create_dt;
	}
	public void setLast_modified_dt(String last_modified_dt) {
		this.last_modified_dt = last_modified_dt;
	}
	
}
