package com.team3.pms.Controller.Member.form;


public class MemberRegForm {
	
	private int pk;
	private int emp_auth_pk;
	private int emp_dept_pk;
	private int emp_pos_pk;
	private String id;
	private String pass;
	private String name;
	private String birth;
	private String tel;
	private String email;

	public MemberRegForm() {
		super();
	}
	

	public MemberRegForm(int emp_auth_pk, int emp_dept_pk, int emp_pos_pk, String name, String email) {
		super();
		this.emp_auth_pk = emp_auth_pk;
		this.emp_dept_pk = emp_dept_pk;
		this.emp_pos_pk = emp_pos_pk;
		this.name = name;
		this.email = email;
	}


	public MemberRegForm(int emp_auth_pk, int emp_dept_pk, int emp_pos_pk, String id, String pass, String name,
			String birth, String tel, String email) {
		super();
		this.emp_auth_pk = emp_auth_pk;
		this.emp_dept_pk = emp_dept_pk;
		this.emp_pos_pk = emp_pos_pk;
		this.id = id;
		this.pass = pass;
		this.name = name;
		this.birth = birth;
		this.tel = tel;
		this.email = email;
	}

	
	public int getPk() {
		return pk;
	}


	public void setPk(int pk) {
		this.pk = pk;
	}


	public int getEmp_auth_pk() {
		return emp_auth_pk;
	}

	public int getEmp_dept_pk() {
		return emp_dept_pk;
	}

	public int getEmp_pos_pk() {
		return emp_pos_pk;
	}

	public String getId() {
		return id;
	}

	public String getPass() {
		return pass;
	}

	public String getName() {
		return name;
	}

	public String getBirth() {
		return birth;
	}

	public String getTel() {
		return tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmp_auth_pk(int emp_auth_pk) {
		this.emp_auth_pk = emp_auth_pk;
	}

	public void setEmp_dept_pk(int emp_dept_pk) {
		this.emp_dept_pk = emp_dept_pk;
	}

	public void setEmp_pos_pk(int emp_pos_pk) {
		this.emp_pos_pk = emp_pos_pk;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
