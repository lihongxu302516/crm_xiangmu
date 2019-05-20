package com.crm.entity;

import org.springframework.stereotype.Component;

@Component
public class Genzongrizhi {
private Integer gz_id;
private Integer gz_xuesheng;
private Integer gz_user;
private String gz_genzongtime;
private String gz_genzongneirong;
private String gz_genzongfangshi;
private String gz_beizhu;
private String gz_xiacigenzongtime;
private String gz_exe1;
private String gz_exe2;

private Student stu;
private User us;

private String min_gz_genzongtime;
private String max_gz_genzongtime;
public Integer getGz_id() {
	return gz_id;
}
public void setGz_id(Integer gz_id) {
	this.gz_id = gz_id;
}
public Integer getGz_xuesheng() {
	return gz_xuesheng;
}
public void setGz_xuesheng(Integer gz_xuesheng) {
	this.gz_xuesheng = gz_xuesheng;
}
public Integer getGz_user() {
	return gz_user;
}
public void setGz_user(Integer gz_user) {
	this.gz_user = gz_user;
}
public String getGz_genzongtime() {
	return gz_genzongtime;
}
public void setGz_genzongtime(String gz_genzongtime) {
	this.gz_genzongtime = gz_genzongtime;
}
public String getGz_genzongneirong() {
	return gz_genzongneirong;
}
public void setGz_genzongneirong(String gz_genzongneirong) {
	this.gz_genzongneirong = gz_genzongneirong;
}
public String getGz_genzongfangshi() {
	return gz_genzongfangshi;
}
public void setGz_genzongfangshi(String gz_genzongfangshi) {
	this.gz_genzongfangshi = gz_genzongfangshi;
}
public String getGz_beizhu() {
	return gz_beizhu;
}
public void setGz_beizhu(String gz_beizhu) {
	this.gz_beizhu = gz_beizhu;
}
public String getGz_xiacigenzongtime() {
	return gz_xiacigenzongtime;
}
public void setGz_xiacigenzongtime(String gz_xiacigenzongtime) {
	this.gz_xiacigenzongtime = gz_xiacigenzongtime;
}
public String getGz_exe1() {
	return gz_exe1;
}
public void setGz_exe1(String gz_exe1) {
	this.gz_exe1 = gz_exe1;
}
public String getGz_exe2() {
	return gz_exe2;
}
public void setGz_exe2(String gz_exe2) {
	this.gz_exe2 = gz_exe2;
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
public String getMin_gz_genzongtime() {
	return min_gz_genzongtime;
}
public void setMin_gz_genzongtime(String min_gz_genzongtime) {
	this.min_gz_genzongtime = min_gz_genzongtime;
}
public String getMax_gz_genzongtime() {
	return max_gz_genzongtime;
}
public void setMax_gz_genzongtime(String max_gz_genzongtime) {
	this.max_gz_genzongtime = max_gz_genzongtime;
}
@Override
public String toString() {
	return "Genzongrizhi [gz_id=" + gz_id + ", gz_xuesheng=" + gz_xuesheng + ", gz_user=" + gz_user
			+ ", gz_genzongtime=" + gz_genzongtime + ", gz_genzongneirong=" + gz_genzongneirong + ", gz_genzongfangshi="
			+ gz_genzongfangshi + ", gz_beizhu=" + gz_beizhu + ", gz_xiacigenzongtime=" + gz_xiacigenzongtime
			+ ", gz_exe1=" + gz_exe1 + ", gz_exe2=" + gz_exe2 + ", stu=" + stu + ", us=" + us + ", min_gz_genzongtime="
			+ min_gz_genzongtime + ", max_gz_genzongtime=" + max_gz_genzongtime + "]";
}

}
