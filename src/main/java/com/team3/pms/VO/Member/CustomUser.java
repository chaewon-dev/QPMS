package com.team3.pms.VO.Member;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUser extends User{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String emp_cd_pk;
	private String emp_name;
	private String emp_pos;
	private String emp_dept;
	
	public CustomUser(String username, String password, boolean enabled, boolean accountNonExpired,
			boolean credentialsNonExpired, boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
		// TODO Auto-generated constructor stub
	}

	public CustomUser(String username, String password, Collection<? extends GrantedAuthority> authorities,
			String emp_cd_pk, String emp_name, String emp_pos, String emp_dept) {
		super(username, password, authorities);
		this.emp_cd_pk = emp_cd_pk;
		this.emp_name = emp_name;
		this.emp_pos = emp_pos;
		this.emp_dept = emp_dept;
	}

	public String getEmp_cd_pk() {
		return emp_cd_pk;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public String getEmp_pos() {
		return emp_pos;
	}

	public String getEmp_dept() {
		return emp_dept;
	}

	public void setEmp_cd_pk(String emp_cd_pk) {
		this.emp_cd_pk = emp_cd_pk;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public void setEmp_pos(String emp_pos) {
		this.emp_pos = emp_pos;
	}

	public void setEmp_dept(String emp_dept) {
		this.emp_dept = emp_dept;
	}
	
	
}
