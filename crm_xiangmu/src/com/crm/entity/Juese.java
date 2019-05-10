package com.crm.entity;

import java.util.List;

public class Juese {
private Integer js_id;
private String js_name;
private String js_exe1;
private String js_exe2;

private List<Mokuai> mokuai;

public Integer getJs_id() {
	return js_id;
}

public void setJs_id(Integer js_id) {
	this.js_id = js_id;
}

public String getJs_name() {
	return js_name;
}

public void setJs_name(String js_name) {
	this.js_name = js_name;
}

public String getJs_exe1() {
	return js_exe1;
}

public void setJs_exe1(String js_exe1) {
	this.js_exe1 = js_exe1;
}

public String getJs_exe2() {
	return js_exe2;
}

public void setJs_exe2(String js_exe2) {
	this.js_exe2 = js_exe2;
}

public List<Mokuai> getMokuai() {
	return mokuai;
}

public void setMokuai(List<Mokuai> mokuai) {
	this.mokuai = mokuai;
}

@Override
public String toString() {
	return "Juese [js_id=" + js_id + ", js_name=" + js_name + ", js_exe1=" + js_exe1 + ", js_exe2=" + js_exe2
			+ ", mokuai=" + mokuai + "]";
}


}
