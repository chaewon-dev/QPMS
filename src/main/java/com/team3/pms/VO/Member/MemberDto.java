package com.team3.pms.VO.Member;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;


public class MemberDto implements UserDetails {
	
	//General info
	private String emp_cd_pk;
	private int emp_auth_fk;
	private String emp_auth;
	private int emp_pos_fk;
	private String emp_pos;
	private int emp_dept_fk;
	private String emp_dept;
	private String emp_id;
	private String emp_pw;
	private String emp_name;
	private String emp_birth;
	private String emp_img;
	private String emp_tel;
	private String emp_email;
	
	
	//멤버리스트 조회
	private String auth_name;
	private String dept_name;
	private String pos_name; 
	private int num_of_project;
	
	//상세조회
	private String income_date;

	public MemberDto() {
		super();
	}

	public MemberDto(String emp_cd_pk, int emp_auth_fk, String emp_auth, int emp_pos_fk, String emp_pos,
			int emp_dept_fk, String emp_dept, String emp_id, String emp_pw, String emp_name, String emp_birth,
			String emp_img, String emp_tel, String emp_email) {
		super();
		this.emp_cd_pk = emp_cd_pk;
		this.emp_auth_fk = emp_auth_fk;
		this.emp_auth = emp_auth;
		this.emp_pos_fk = emp_pos_fk;
		this.emp_pos = emp_pos;
		this.emp_dept_fk = emp_dept_fk;
		this.emp_dept = emp_dept;
		this.emp_id = emp_id;
		this.emp_pw = emp_pw;
		this.emp_name = emp_name;
		this.emp_birth = emp_birth;
		this.emp_img = emp_img;
		this.emp_tel = emp_tel;
		this.emp_email = emp_email;
	}




	public String getAuth_name() {
		return auth_name;
	}

	public String getDept_name() {
		return dept_name;
	}

	public String getPos_name() {
		return pos_name;
	}

	public int getNum_of_project() {
		return num_of_project;
	}

	public String getIncome_date() {
		return income_date;
	}

	public void setAuth_name(String auth_name) {
		this.auth_name = auth_name;
	}

	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}

	public void setPos_name(String pos_name) {
		this.pos_name = pos_name;
	}

	public void setNum_of_project(int num_of_project) {
		this.num_of_project = num_of_project;
	}

	public void setIncome_date(String income_date) {
		this.income_date = income_date;
	}

	public String getEmp_pw() {
		return emp_pw;
	}


	public void setEmp_pw(String emp_pw) {
		this.emp_pw = emp_pw;
	}


	public String getEmp_cd_pk() {
		return emp_cd_pk;
	}

	public int getEmp_auth_fk() {
		return emp_auth_fk;
	}

	public String getEmp_auth() {
		return emp_auth;
	}

	public int getEmp_pos_fk() {
		return emp_pos_fk;
	}

	public String getEmp_pos() {
		return emp_pos;
	}

	public int getEmp_dept_fk() {
		return emp_dept_fk;
	}

	public String getEmp_dept() {
		return emp_dept;
	}

	public String getEmp_id() {
		return emp_id;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public String getEmp_birth() {
		return emp_birth;
	}

	public String getEmp_img() {
		return emp_img;
	}

	public String getEmp_tel() {
		return emp_tel;
	}

	public String getEmp_email() {
		return emp_email;
	}

	public void setEmp_cd_pk(String emp_cd_pk) {
		this.emp_cd_pk = emp_cd_pk;
	}

	public void setEmp_auth_fk(int emp_auth_fk) {
		this.emp_auth_fk = emp_auth_fk;
	}

	public void setEmp_auth(String emp_auth) {
		this.emp_auth = emp_auth;
	}

	public void setEmp_pos_fk(int emp_pos_fk) {
		this.emp_pos_fk = emp_pos_fk;
	}

	public void setEmp_pos(String emp_pos) {
		this.emp_pos = emp_pos;
	}

	public void setEmp_dept_fk(int emp_dept_fk) {
		this.emp_dept_fk = emp_dept_fk;
	}

	public void setEmp_dept(String emp_dept) {
		this.emp_dept = emp_dept;
	}

	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public void setEmp_birth(String emp_birth) {
		this.emp_birth = emp_birth;
	}

	public void setEmp_img(String emp_img) {
		this.emp_img = emp_img;
	}

	public void setEmp_tel(String emp_tel) {
		this.emp_tel = emp_tel;
	}

	public void setEmp_email(String emp_email) {
		this.emp_email = emp_email;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

}

