package com.crm.entity;

import java.util.List;

import org.springframework.stereotype.Component;
@Component
public class User {
private Integer us_id;
private String us_name;
private String us_password;
private String us_shojihao;
private String us_youxiang;
private Integer us_issuoding;
private String us_suodingtime;
private Integer us_passcuowucishu;
private String us_chuangjiantime;
private String us_zuihoutime;
private Integer us_quanzhong;
private Integer us_pingfen;
private Integer us_pingfenrenshu;
private Integer us_isdaka;
private String us_dakatime;
private String us_biezhu;
private String us_exe1;
private String us_exe2;

private String us_chuangjiantimeMIN;
private String us_chuangjiantimeMAX;
private String us_zuihoutimeMIN;
private String us_zuihoutimeMAX;
private Integer us_quanzhongMIN;
private Integer us_quanzhongMAX;
private String us_dakatimeMIN;
private String us_dakatimeMAX;
private String paixuguize;
private String paixuziduan;

private List<Juese> juese;
private List<Student> student;
private List<Genzongrizhi> genzongrizhi;

private Integer gz_cs;
private Integer stu_sl;
private String stu_sj;
public Integer getUs_id() {
	return us_id;
}
public void setUs_id(Integer us_id) {
	this.us_id = us_id;
}
public String getUs_name() {
	return us_name;
}
public void setUs_name(String us_name) {
	this.us_name = us_name;
}
public String getUs_password() {
	return us_password;
}
public void setUs_password(String us_password) {
	this.us_password = us_password;
}
public String getUs_shojihao() {
	return us_shojihao;
}
public void setUs_shojihao(String us_shojihao) {
	this.us_shojihao = us_shojihao;
}
public String getUs_youxiang() {
	return us_youxiang;
}
public void setUs_youxiang(String us_youxiang) {
	this.us_youxiang = us_youxiang;
}
public Integer getUs_issuoding() {
	return us_issuoding;
}
public void setUs_issuoding(Integer us_issuoding) {
	this.us_issuoding = us_issuoding;
}
public String getUs_suodingtime() {
	return us_suodingtime;
}
public void setUs_suodingtime(String us_suodingtime) {
	this.us_suodingtime = us_suodingtime;
}
public Integer getUs_passcuowucishu() {
	return us_passcuowucishu;
}
public void setUs_passcuowucishu(Integer us_passcuowucishu) {
	this.us_passcuowucishu = us_passcuowucishu;
}
public String getUs_chuangjiantime() {
	return us_chuangjiantime;
}
public void setUs_chuangjiantime(String us_chuangjiantime) {
	this.us_chuangjiantime = us_chuangjiantime;
}
public String getUs_zuihoutime() {
	return us_zuihoutime;
}
public void setUs_zuihoutime(String us_zuihoutime) {
	this.us_zuihoutime = us_zuihoutime;
}
public Integer getUs_quanzhong() {
	return us_quanzhong;
}
public void setUs_quanzhong(Integer us_quanzhong) {
	this.us_quanzhong = us_quanzhong;
}
public Integer getUs_pingfen() {
	return us_pingfen;
}
public void setUs_pingfen(Integer us_pingfen) {
	this.us_pingfen = us_pingfen;
}
public Integer getUs_pingfenrenshu() {
	return us_pingfenrenshu;
}
public void setUs_pingfenrenshu(Integer us_pingfenrenshu) {
	this.us_pingfenrenshu = us_pingfenrenshu;
}
public Integer getUs_isdaka() {
	return us_isdaka;
}
public void setUs_isdaka(Integer us_isdaka) {
	this.us_isdaka = us_isdaka;
}
public String getUs_dakatime() {
	return us_dakatime;
}
public void setUs_dakatime(String us_dakatime) {
	this.us_dakatime = us_dakatime;
}
public String getUs_biezhu() {
	return us_biezhu;
}
public void setUs_biezhu(String us_biezhu) {
	this.us_biezhu = us_biezhu;
}
public String getUs_exe1() {
	return us_exe1;
}
public void setUs_exe1(String us_exe1) {
	this.us_exe1 = us_exe1;
}
public String getUs_exe2() {
	return us_exe2;
}
public void setUs_exe2(String us_exe2) {
	this.us_exe2 = us_exe2;
}
public String getUs_chuangjiantimeMIN() {
	return us_chuangjiantimeMIN;
}
public void setUs_chuangjiantimeMIN(String us_chuangjiantimeMIN) {
	this.us_chuangjiantimeMIN = us_chuangjiantimeMIN;
}
public String getUs_chuangjiantimeMAX() {
	return us_chuangjiantimeMAX;
}
public void setUs_chuangjiantimeMAX(String us_chuangjiantimeMAX) {
	this.us_chuangjiantimeMAX = us_chuangjiantimeMAX;
}
public String getUs_zuihoutimeMIN() {
	return us_zuihoutimeMIN;
}
public void setUs_zuihoutimeMIN(String us_zuihoutimeMIN) {
	this.us_zuihoutimeMIN = us_zuihoutimeMIN;
}
public String getUs_zuihoutimeMAX() {
	return us_zuihoutimeMAX;
}
public void setUs_zuihoutimeMAX(String us_zuihoutimeMAX) {
	this.us_zuihoutimeMAX = us_zuihoutimeMAX;
}
public Integer getUs_quanzhongMIN() {
	return us_quanzhongMIN;
}
public void setUs_quanzhongMIN(Integer us_quanzhongMIN) {
	this.us_quanzhongMIN = us_quanzhongMIN;
}
public Integer getUs_quanzhongMAX() {
	return us_quanzhongMAX;
}
public void setUs_quanzhongMAX(Integer us_quanzhongMAX) {
	this.us_quanzhongMAX = us_quanzhongMAX;
}
public String getUs_dakatimeMIN() {
	return us_dakatimeMIN;
}
public void setUs_dakatimeMIN(String us_dakatimeMIN) {
	this.us_dakatimeMIN = us_dakatimeMIN;
}
public String getUs_dakatimeMAX() {
	return us_dakatimeMAX;
}
public void setUs_dakatimeMAX(String us_dakatimeMAX) {
	this.us_dakatimeMAX = us_dakatimeMAX;
}
public String getPaixuguize() {
	return paixuguize;
}
public void setPaixuguize(String paixuguize) {
	this.paixuguize = paixuguize;
}
public String getPaixuziduan() {
	return paixuziduan;
}
public void setPaixuziduan(String paixuziduan) {
	this.paixuziduan = paixuziduan;
}
public List<Juese> getJuese() {
	return juese;
}
public void setJuese(List<Juese> juese) {
	this.juese = juese;
}
public List<Student> getStudent() {
	return student;
}
public void setStudent(List<Student> student) {
	this.student = student;
}
public List<Genzongrizhi> getGenzongrizhi() {
	return genzongrizhi;
}
public void setGenzongrizhi(List<Genzongrizhi> genzongrizhi) {
	this.genzongrizhi = genzongrizhi;
}
public Integer getGz_cs() {
	return gz_cs;
}
public void setGz_cs(Integer gz_cs) {
	this.gz_cs = gz_cs;
}
public Integer getStu_sl() {
	return stu_sl;
}
public void setStu_sl(Integer stu_sl) {
	this.stu_sl = stu_sl;
}
public String getStu_sj() {
	return stu_sj;
}
public void setStu_sj(String stu_sj) {
	this.stu_sj = stu_sj;
}
@Override
public String toString() {
	return "User [us_id=" + us_id + ", us_name=" + us_name + ", us_password=" + us_password + ", us_shojihao="
			+ us_shojihao + ", us_youxiang=" + us_youxiang + ", us_issuoding=" + us_issuoding + ", us_suodingtime="
			+ us_suodingtime + ", us_passcuowucishu=" + us_passcuowucishu + ", us_chuangjiantime=" + us_chuangjiantime
			+ ", us_zuihoutime=" + us_zuihoutime + ", us_quanzhong=" + us_quanzhong + ", us_pingfen=" + us_pingfen
			+ ", us_pingfenrenshu=" + us_pingfenrenshu + ", us_isdaka=" + us_isdaka + ", us_dakatime=" + us_dakatime
			+ ", us_biezhu=" + us_biezhu + ", us_exe1=" + us_exe1 + ", us_exe2=" + us_exe2 + ", us_chuangjiantimeMIN="
			+ us_chuangjiantimeMIN + ", us_chuangjiantimeMAX=" + us_chuangjiantimeMAX + ", us_zuihoutimeMIN="
			+ us_zuihoutimeMIN + ", us_zuihoutimeMAX=" + us_zuihoutimeMAX + ", us_quanzhongMIN=" + us_quanzhongMIN
			+ ", us_quanzhongMAX=" + us_quanzhongMAX + ", us_dakatimeMIN=" + us_dakatimeMIN + ", us_dakatimeMAX="
			+ us_dakatimeMAX + ", paixuguize=" + paixuguize + ", paixuziduan=" + paixuziduan + ", juese=" + juese
			+ ", student=" + student + ", genzongrizhi=" + genzongrizhi + ", gz_cs=" + gz_cs + ", stu_sl=" + stu_sl
			+ ", stu_sj=" + stu_sj + "]";
}


}
