package com.crm.entity;

import org.springframework.stereotype.Component;

@Component
public class Mokuai {
private Integer mk_id;
private String mk_name;
private Integer mk_fuid;
private Integer mk_checked;
private String mk_lujing;
private String mk_exe1;
private String mk_exe2;
public Integer getMk_id() {
	return mk_id;
}
public void setMk_id(Integer mk_id) {
	this.mk_id = mk_id;
}
public String getMk_name() {
	return mk_name;
}
public void setMk_name(String mk_name) {
	this.mk_name = mk_name;
}
public Integer getMk_fuid() {
	return mk_fuid;
}
public void setMk_fuid(Integer mk_fuid) {
	this.mk_fuid = mk_fuid;
}
public Integer getMk_checked() {
	return mk_checked;
}
public void setMk_checked(Integer mk_checked) {
	this.mk_checked = mk_checked;
}
public String getMk_lujing() {
	return mk_lujing;
}
public void setMk_lujing(String mk_lujing) {
	this.mk_lujing = mk_lujing;
}
public String getMk_exe1() {
	return mk_exe1;
}
public void setMk_exe1(String mk_exe1) {
	this.mk_exe1 = mk_exe1;
}
public String getMk_exe2() {
	return mk_exe2;
}
public void setMk_exe2(String mk_exe2) {
	this.mk_exe2 = mk_exe2;
}
@Override
public String toString() {
	return "Mokuai [mk_id=" + mk_id + ", mk_name=" + mk_name + ", mk_fuid=" + mk_fuid + ", mk_checked=" + mk_checked
			+ ", mk_lujing=" + mk_lujing + ", mk_exe1=" + mk_exe1 + ", mk_exe2=" + mk_exe2 + "]";
}

}
