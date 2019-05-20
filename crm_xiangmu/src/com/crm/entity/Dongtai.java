package com.crm.entity;

import org.springframework.stereotype.Component;

@Component
public class Dongtai {
	private Integer dt_id;
	private Integer dt_student;
	private String dt_time;
	private String dt_neirong;
	private Integer dt_tianjiaren;
	private String dt_exe1;
	private String dt_exe2;
	
	private Student stu;
	private User us;
	public Integer getDt_id() {
		return dt_id;
	}
	public void setDt_id(Integer dt_id) {
		this.dt_id = dt_id;
	}
	public Integer getDt_student() {
		return dt_student;
	}
	public void setDt_student(Integer dt_student) {
		this.dt_student = dt_student;
	}
	public String getDt_time() {
		return dt_time;
	}
	public void setDt_time(String dt_time) {
		this.dt_time = dt_time;
	}
	public String getDt_neirong() {
		return dt_neirong;
	}
	public void setDt_neirong(String dt_neirong) {
		this.dt_neirong = dt_neirong;
	}
	public Integer getDt_tianjiaren() {
		return dt_tianjiaren;
	}
	public void setDt_tianjiaren(Integer dt_tianjiaren) {
		this.dt_tianjiaren = dt_tianjiaren;
	}
	public String getDt_exe1() {
		return dt_exe1;
	}
	public void setDt_exe1(String dt_exe1) {
		this.dt_exe1 = dt_exe1;
	}
	public String getDt_exe2() {
		return dt_exe2;
	}
	public void setDt_exe2(String dt_exe2) {
		this.dt_exe2 = dt_exe2;
	}
	public Student getStu() {
		return stu;
	}
	public void setStu(Student stu) {
		this.stu = stu;
	}
	public User getUs() {
		return us;
	}
	public void setUs(User us) {
		this.us = us;
	}
	@Override
	public String toString() {
		return "Dongtai [dt_id=" + dt_id + ", dt_student=" + dt_student + ", dt_time=" + dt_time + ", dt_neirong="
				+ dt_neirong + ", dt_tianjiaren=" + dt_tianjiaren + ", dt_exe1=" + dt_exe1 + ", dt_exe2=" + dt_exe2
				+ ", stu=" + stu + ", us=" + us + "]";
	}
	
	
	

}
