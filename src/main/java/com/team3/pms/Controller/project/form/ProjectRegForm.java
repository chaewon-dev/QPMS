package com.team3.pms.Controller.project.form;

import java.util.Date;

public class ProjectRegForm {
	String projectName;
	String projectType;
	String rndType;
	int projectDept;
	String projectPM;
	Date projectStartDT;
	Date projectCompDT;
	String projectDescription;
	
	
	
	public String getProjectPM() {
		return projectPM;
	}



	public void setProjectPM(String projectPM) {
		this.projectPM = projectPM;
	}



	public ProjectRegForm() {
		super();
	}



	public ProjectRegForm(String projectName, String projectType, String rndType, int projectDept, String projectPM,
			Date projectStartDT, Date projectCompDT, String projectDescription) {
		super();
		this.projectName = projectName;
		this.projectType = projectType;
		this.rndType = rndType;
		this.projectDept = projectDept;
		this.projectPM = projectPM;
		this.projectStartDT = projectStartDT;
		this.projectCompDT = projectCompDT;
		this.projectDescription = projectDescription;
	}



	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectType() {
		return projectType;
	}

	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}

	public String getRndType() {
		return rndType;
	}

	public void setRndType(String rndType) {
		this.rndType = rndType;
	}

	public int getProjectDept() {
		return projectDept;
	}

	public void setProjectDept(int projectDept) {
		this.projectDept = projectDept;
	}

	public Date getProjectStartDT() {
		return projectStartDT;
	}

	public void setProjectStartDT(Date projectStartDT) {
		this.projectStartDT = projectStartDT;
	}

	public Date getProjectCompDT() {
		return projectCompDT;
	}

	public void setProjectCompDT(Date projectCompDT) {
		this.projectCompDT = projectCompDT;
	}

	public String getProjectDescription() {
		return projectDescription;
	}

	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}
	
	
	
	

}
