package com.crm.entity;

public class Juese_mokuai {
private Integer jm_id;
private Integer jm_jueseid;
private Integer jm_mokuaiid;
private String jm_exe1;
private String jm_exe2;
public Integer getJm_id() {
	return jm_id;
}
public void setJm_id(Integer jm_id) {
	this.jm_id = jm_id;
}
public Integer getJm_jueseid() {
	return jm_jueseid;
}
public void setJm_jueseid(Integer jm_jueseid) {
	this.jm_jueseid = jm_jueseid;
}
public Integer getJm_mokuaiid() {
	return jm_mokuaiid;
}
public void setJm_mokuaiid(Integer jm_mokuaiid) {
	this.jm_mokuaiid = jm_mokuaiid;
}
public String getJm_exe1() {
	return jm_exe1;
}
public void setJm_exe1(String jm_exe1) {
	this.jm_exe1 = jm_exe1;
}
public String getJm_exe2() {
	return jm_exe2;
}
public void setJm_exe2(String jm_exe2) {
	this.jm_exe2 = jm_exe2;
}
@Override
public String toString() {
	return "Juese_mokuai [jm_id=" + jm_id + ", jm_jueseid=" + jm_jueseid + ", jm_mokuaiid=" + jm_mokuaiid + ", jm_exe1="
			+ jm_exe1 + ", jm_exe2=" + jm_exe2 + "]";
}

}
