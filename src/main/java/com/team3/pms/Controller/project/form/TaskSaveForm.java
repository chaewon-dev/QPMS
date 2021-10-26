package com.team3.pms.Controller.project.form;

public class TaskSaveForm {
	String approver;
	String text;
	String state;
	String start_date;
	
	String end_date;
	float progress;
	String type;
	String description;
	String parent;
	int sortorder;
	String manager;
	public TaskSaveForm() {
		super();
	}


	public TaskSaveForm(String approver, String text, String state, String start_date, String end_date, float progress,
			String type, String description, String parent, int sortorder, String manager) {
		super();
		this.approver = approver;
		this.text = text;
		this.state = state;
		this.start_date = start_date;
		this.end_date = end_date;
		this.progress = progress;
		this.type = type;
		this.description = description;
		this.parent = parent;
		this.sortorder = sortorder;
		this.manager = manager;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}
	public String getApprover() {
		return approver;
	}
	public void setApprover(String approver) {
		this.approver = approver;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public String getEnd_date() {
		return end_date;
	}
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
	public float getProgress() {
		return progress;
	}
	public void setProgress(float progress) {
		this.progress = progress;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getParent() {
		return parent;
	}
	public void setParent(String parent) {
		this.parent = parent;
	}
	public int getSortorder() {
		return sortorder;
	}
	public void setSortorder(int sortorder) {
		this.sortorder = sortorder;
	}
	


}
