package com.team3.pms.VO.resource;

public class RscStateForm {
	String id;
	String text;
	String start_date;
	String end_date;
	float progress;
	//String type;
	String parent;
	
	
	
	public RscStateForm(String id, String text, String start_date, String end_date, float progress, String parent) {
		super();
		this.id = id;
		this.text = text;
		this.start_date = start_date;
		this.end_date = end_date;
		this.progress = progress;
		this.parent = parent;
	}

	public RscStateForm() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
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

	public String getParent() {
		return parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}

	
	
	


}
