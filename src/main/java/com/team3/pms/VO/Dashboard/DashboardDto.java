package com.team3.pms.VO.Dashboard;



public class DashboardDto {
	
	//dash1
	private String project_pk; 
	private String project_nm;
	private String project_state_nm;
	private String emp_dept_pk;
	private String dept_name;  
	private String project_start_dt;
	private String project_comp_dt;
	private float task_progress;
	
	//dash2
	private int num_of_emp;

	//dash3
	private int project_state_pk;
	private int num_of_project;
	
	//dash4
	private String parent_task_nm;
	private String parent_task_approver_name;
	private int sum_of_task_progress;
	
	
	
	//Getter, Setter
	public String getProject_pk() {
		return project_pk;
	}
	public String getProject_nm() {
		return project_nm;
	}
	public String getProject_state_nm() {
		return project_state_nm;
	}
	public String getEmp_dept_pk() {
		return emp_dept_pk;
	}
	public String getDept_name() {
		return dept_name;
	}
	public String getProject_start_dt() {
		return project_start_dt;
	}
	public String getProject_comp_dt() {
		return project_comp_dt;
	}
	public float getTask_progress() {
		return task_progress;
	}
	public int getProject_state_pk() {
		return project_state_pk;
	}
	public int getNum_of_project() {
		return num_of_project;
	}
	public String getParent_task_nm() {
		return parent_task_nm;
	}
	public String getParent_task_approver_name() {
		return parent_task_approver_name;
	}
	public int getSum_of_task_progress() {
		return sum_of_task_progress;
	}
	public void setProject_pk(String project_pk) {
		this.project_pk = project_pk;
	}
	public void setProject_nm(String project_nm) {
		this.project_nm = project_nm;
	}
	public void setProject_state_nm(String project_state_nm) {
		this.project_state_nm = project_state_nm;
	}
	public void setEmp_dept_pk(String emp_dept_pk) {
		this.emp_dept_pk = emp_dept_pk;
	}
	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}
	public void setProject_start_dt(String project_start_dt) {
		this.project_start_dt = project_start_dt;
	}
	public void setProject_comp_dt(String project_comp_dt) {
		this.project_comp_dt = project_comp_dt;
	}
	public void setTask_progress(float task_progress) {
		this.task_progress = task_progress;
	}
	public void setProject_state_pk(int project_state_pk) {
		this.project_state_pk = project_state_pk;
	}
	public void setNum_of_project(int num_of_project) {
		this.num_of_project = num_of_project;
	}
	public void setParent_task_nm(String parent_task_nm) {
		this.parent_task_nm = parent_task_nm;
	}
	public void setParent_task_approver_name(String parent_task_approver_name) {
		this.parent_task_approver_name = parent_task_approver_name;
	}
	public void setSum_of_task_progress(int sum_of_task_progress) {
		this.sum_of_task_progress = sum_of_task_progress;
	}
	public int getNum_of_emp() {
		return num_of_emp;
	}
	public void setNum_of_emp(int num_of_emp) {
		this.num_of_emp = num_of_emp;
	}
	
	
	

	
	
}
