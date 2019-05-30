package com.crm.entity;

import java.util.List;

public class Qd_Cd_Wq_tu {
	private List<String> us_name;
	private List<Integer> qd_cs;
	private List<Integer> cd_cs;
	private List<Integer> wq_cs;
	private List<Integer> qj_cs;
	public List<String> getUs_name() {
		return us_name;
	}
	public void setUs_name(List<String> us_name) {
		this.us_name = us_name;
	}
	public List<Integer> getQd_cs() {
		return qd_cs;
	}
	public void setQd_cs(List<Integer> qd_cs) {
		this.qd_cs = qd_cs;
	}
	public List<Integer> getCd_cs() {
		return cd_cs;
	}
	public void setCd_cs(List<Integer> cd_cs) {
		this.cd_cs = cd_cs;
	}
	public List<Integer> getWq_cs() {
		return wq_cs;
	}
	public void setWq_cs(List<Integer> wq_cs) {
		this.wq_cs = wq_cs;
	}
	public List<Integer> getQj_cs() {
		return qj_cs;
	}
	public void setQj_cs(List<Integer> qj_cs) {
		this.qj_cs = qj_cs;
	}
	@Override
	public String toString() {
		return "Qd_Cd_Wq_tu [us_name=" + us_name + ", qd_cs=" + qd_cs + ", cd_cs=" + cd_cs + ", wq_cs=" + wq_cs
				+ ", qj_cs=" + qj_cs + "]";
	}
	
}
