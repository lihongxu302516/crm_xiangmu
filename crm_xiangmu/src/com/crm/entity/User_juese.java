package com.crm.entity;

import org.springframework.stereotype.Component;

@Component
public class User_juese {
private Integer uj_id;
private Integer uj_userid;
private Integer uj_jueseid;
private String uj_exe1;
private String uj_exe2;
public Integer getUj_id() {
	return uj_id;
}
public void setUj_id(Integer uj_id) {
	this.uj_id = uj_id;
}
public Integer getUj_userid() {
	return uj_userid;
}
public void setUj_userid(Integer uj_userid) {
	this.uj_userid = uj_userid;
}
public Integer getUj_jueseid() {
	return uj_jueseid;
}
public void setUj_jueseid(Integer uj_jueseid) {
	this.uj_jueseid = uj_jueseid;
}
public String getUj_exe1() {
	return uj_exe1;
}
public void setUj_exe1(String uj_exe1) {
	this.uj_exe1 = uj_exe1;
}
public String getUj_exe2() {
	return uj_exe2;
}
public void setUj_exe2(String uj_exe2) {
	this.uj_exe2 = uj_exe2;
}
@Override
public String toString() {
	return "User_juese [uj_id=" + uj_id + ", uj_userid=" + uj_userid + ", uj_jueseid=" + uj_jueseid + ", uj_exe1="
			+ uj_exe1 + ", uj_exe2=" + uj_exe2 + "]";
}

}
