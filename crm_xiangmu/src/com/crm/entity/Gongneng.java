package com.crm.entity;

public class Gongneng {
	private Integer gn_id;
	private String gn_name;
	private String gn_iskaiqi;
	public Integer getGn_id() {
		return gn_id;
	}
	public void setGn_id(Integer gn_id) {
		this.gn_id = gn_id;
	}
	public String getGn_name() {
		return gn_name;
	}
	public void setGn_name(String gn_name) {
		this.gn_name = gn_name;
	}
	public String getGn_iskaiqi() {
		return gn_iskaiqi;
	}
	public void setGn_iskaiqi(String gn_iskaiqi) {
		this.gn_iskaiqi = gn_iskaiqi;
	}
	@Override
	public String toString() {
		return "Gongneng [gn_id=" + gn_id + ", gn_name=" + gn_name + ", gn_iskaiqi=" + gn_iskaiqi + "]";
	}

}
