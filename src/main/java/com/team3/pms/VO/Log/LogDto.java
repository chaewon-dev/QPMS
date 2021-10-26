package com.team3.pms.VO.Log;

public class LogDto {
	
	private String time;
	private String formatted_message;
	private String level_string;
	private String thread_name;
	private int event_id;

	
	public LogDto() {
		
	}
	
	
	public LogDto(String time, String formatted_message, String level_string, String thread_name, int event_id) {
		super();
		this.time = time;
		this.formatted_message = formatted_message;
		this.level_string = level_string;
		this.thread_name = thread_name;
		this.event_id = event_id;
	}


	public String getTime() {
		return time;
	}


	public String getFormatted_message() {
		return formatted_message;
	}


	public String getLevel_string() {
		return level_string;
	}


	public String getThread_name() {
		return thread_name;
	}


	public int getEvent_id() {
		return event_id;
	}

	public void setTime(String time) {
		this.time = time;
	}


	public void setFormatted_message(String formatted_message) {
		this.formatted_message = formatted_message;
	}


	public void setLevel_string(String level_string) {
		this.level_string = level_string;
	}


	public void setThread_name(String thread_name) {
		this.thread_name = thread_name;
	}


	public void setEvent_id(int event_id) {
		this.event_id = event_id;
	}


	
}
