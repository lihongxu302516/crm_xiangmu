package com.crm.entity;

public class Qiandao {
	private Integer qd_id;
	private Integer qd_user;
	private String qd_time;
	private Integer qd_zhuangtai;
	private String qd_exe1;
	private String qd_exe2;
	
	private Integer shuliang;
	private User user;
	public Integer getQd_id() {
		return qd_id;
	}
	public void setQd_id(Integer qd_id) {
		this.qd_id = qd_id;
	}
	public Integer getQd_user() {
		return qd_user;
	}
	public void setQd_user(Integer qd_user) {
		this.qd_user = qd_user;
	}
	public String getQd_time() {
		return qd_time;
	}
	public void setQd_time(String qd_time) {
		this.qd_time = qd_time;
	}
	public Integer getQd_zhuangtai() {
		return qd_zhuangtai;
	}
	public void setQd_zhuangtai(Integer qd_zhuangtai) {
		this.qd_zhuangtai = qd_zhuangtai;
	}
	public String getQd_exe1() {
		return qd_exe1;
	}
	public void setQd_exe1(String qd_exe1) {
		this.qd_exe1 = qd_exe1;
	}
	public String getQd_exe2() {
		return qd_exe2;
	}
	public void setQd_exe2(String qd_exe2) {
		this.qd_exe2 = qd_exe2;
	}
	public Integer getShuliang() {
		return shuliang;
	}
	public void setShuliang(Integer shuliang) {
		this.shuliang = shuliang;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Qiandao [qd_id=" + qd_id + ", qd_user=" + qd_user + ", qd_time=" + qd_time + ", qd_zhuangtai="
				+ qd_zhuangtai + ", qd_exe1=" + qd_exe1 + ", qd_exe2=" + qd_exe2 + ", shuliang=" + shuliang + ", user="
				+ user + "]";
	}

	
}
