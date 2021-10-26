package com.team3.pms.VO.resource;

public class ResourceState {
	
	private String rsc_pk;
	private String rsc_cat_num;
	private String rsc_cat_nm;
	private String rsc_parent;
	private String rsc_start_dt;
	private String rsc_end_dt;
	private float rsc_prog;
	
	private String project_pk;
	private int emp_dept_pk;
	private String emp_cd_pk;
	private String task_pk;
	private String task_manager;
	

	public ResourceState() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ResourceState(String project_pk, int emp_dept_pk) {
		super();
		this.project_pk = project_pk;
		this.emp_dept_pk = emp_dept_pk;
	}

	public ResourceState(int emp_dept_pk, String emp_cd_pk) {
		super();
		this.emp_dept_pk = emp_dept_pk;
		this.emp_cd_pk = emp_cd_pk;
	}

	public ResourceState(String project_pk, String emp_cd_pk) {
		super();
		this.project_pk = project_pk;
		this.emp_cd_pk = emp_cd_pk;
	}

	public ResourceState(String project_pk, int emp_dept_pk, String emp_cd_pk) {
		super();
		this.project_pk = project_pk;
		this.emp_dept_pk = emp_dept_pk;
		this.emp_cd_pk = emp_cd_pk;
	}

	public ResourceState(String project_pk, String emp_cd_pk, String task_manager) {
		super();
		this.project_pk = project_pk;
		this.emp_cd_pk = emp_cd_pk;
		this.task_manager = task_manager;
	}

	public ResourceState(String rsc_cat_num, String rsc_cat_nm, String rsc_start_dt, String rsc_end_dt) {
		super();
		this.rsc_cat_num = rsc_cat_num;
		this.rsc_cat_nm = rsc_cat_nm;
		this.rsc_start_dt = rsc_start_dt;
		this.rsc_end_dt = rsc_end_dt;
	}

	public ResourceState(String rsc_cat_num, String rsc_cat_nm, String rsc_start_dt, String rsc_end_dt, int emp_dept_pk,
			String emp_cd_pk, String task_pk) {
		super();
		this.rsc_cat_num = rsc_cat_num;
		this.rsc_cat_nm = rsc_cat_nm;
		this.rsc_start_dt = rsc_start_dt;
		this.rsc_end_dt = rsc_end_dt;
		this.emp_dept_pk = emp_dept_pk;
		this.emp_cd_pk = emp_cd_pk;
		this.task_pk = task_pk;
	}

	public String getTask_manager() {
		return task_manager;
	}

	public void setTask_manager(String task_manager) {
		this.task_manager = task_manager;
	}

	public String getTask_pk() {
		return task_pk;
	}

	public void setTask_pk(String task_pk) {
		this.task_pk = task_pk;
	}

	public String getEmp_cd_pk() {
		return emp_cd_pk;
	}

	public void setEmp_cd_pk(String emp_cd_pk) {
		this.emp_cd_pk = emp_cd_pk;
	}

	public String getProject_pk() {
		return project_pk;
	}

	public void setProject_pk(String project_pk) {
		this.project_pk = project_pk;
	}

	public int getEmp_dept_pk() {
		return emp_dept_pk;
	}
	public void setEmp_dept_pk(int emp_dept_pk) {
		this.emp_dept_pk = emp_dept_pk;
	}
	public String getRsc_pk() {
		return rsc_pk;
	}
	public void setRsc_pk(String rsc_pk) {
		this.rsc_pk = rsc_pk;
	}
	public String getRsc_cat_num() {
		return rsc_cat_num;
	}
	public void setRsc_cat_num(String rsc_cat_num) {
		this.rsc_cat_num = rsc_cat_num;
	}
	public String getRsc_cat_nm() {
		return rsc_cat_nm;
	}
	public void setRsc_cat_nm(String rsc_cat_nm) {
		this.rsc_cat_nm = rsc_cat_nm;
	}
	public String getRsc_parent() {
		return rsc_parent;
	}
	public void setRsc_parent(String rsc_parent) {
		this.rsc_parent = rsc_parent;
	}
	public String getRsc_start_dt() {
		return rsc_start_dt;
	}
	public void setRsc_start_dt(String rsc_start_dt) {
		this.rsc_start_dt = rsc_start_dt;
	}
	public String getRsc_end_dt() {
		return rsc_end_dt;
	}
	public void setRsc_end_dt(String rsc_end_dt) {
		this.rsc_end_dt = rsc_end_dt;
	}
	public float getRsc_prog() {
		return rsc_prog;
	}
	public void setRsc_prog(float rsc_prog) {
		this.rsc_prog = rsc_prog;
	}

	
}
