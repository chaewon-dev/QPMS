package com.team3.pms.Dao.project;

public class LinkDTO {
	String link_pk;
	String link_source;
	String link_target;
	String link_type;
	public LinkDTO(String link_pk, String link_source, String link_target, String link_type) {
		super();
		this.link_pk = link_pk;
		this.link_source = link_source;
		this.link_target = link_target;
		this.link_type = link_type;
	}
	public LinkDTO() {
		super();
	}
	public String getLink_pk() {
		return link_pk;
	}
	public void setLink_pk(String link_pk) {
		this.link_pk = link_pk;
	}
	public String getLink_source() {
		return link_source;
	}
	public void setLink_source(String link_source) {
		this.link_source = link_source;
	}
	public String getLink_target() {
		return link_target;
	}
	public void setLink_target(String link_target) {
		this.link_target = link_target;
	}
	public String getLink_type() {
		return link_type;
	}
	public void setLink_type(String link_type) {
		this.link_type = link_type;
	}
	
	

}
