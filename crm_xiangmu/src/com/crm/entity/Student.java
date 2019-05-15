package com.crm.entity;

import org.springframework.stereotype.Component;

@Component
public class Student {
	private Integer xs_id;
	private String xs_chuangjiantime;
	private String xs_name;
	private String xs_dianhua;
	private Integer xs_xingbie;
	private Integer xs_nianling;
	private String xs_xueli;
	private String xs_zhuangtai;
	private String xs_laiyuanqudao;
	private String xs_laiyuanwangzhi;
	private String xs_guanzhu;
	private String xs_liyuanguanjianzi;
	private String xs_namezixun;
	private String xs_suozaiquyu;
	private String xs_weixin;
	private String xs_qq;
	private String xs_laiyuanbumen;
	private String xs_isbaobei;
	private String xs_kecheng;
	private Integer xs_isyouxiao;
	private String xs_dafen;
	private Integer xs_ishuifang;
	private String xs_shuocihuifangtime;
	private Integer xs_isshangmen;
	private String xs_shangmentime;
	private String xs_wuxiaoyuanyin;
	private Integer xs_isjiaofei;
	private String xs_jiaofeitime;
	private Double xs_jine;
	private Integer xs_istuifei;
	private Integer xs_isjinban;
	private String xs_jinbantime;
	private String xs_jinbanbeizhu;
	private String xs_tuifeiyuanyin;
	private Double xs_dingjinjine;
	private String xs_dingjintime;
	private Integer xs_zixunshi;
	private Integer xs_lururen;
	private String xs_zixunshibeizhu;
	private String xs_exe1;
	private String xs_exe2;

	private User us_zixunshi;
	private User us_wangluozixunshi;
	private String minxs_chuangjiantime;
	private String maxxs_chuangjiantime;
	private String minxs_shangmentime;
	private String maxxs_shangmentime;
	private String minxs_shuocihuifangtime;
	private String maxxs_shuocihuifangtime;
	private String minxs_jiaofeitime;
	private String maxxs_jiaofeitime;
	private String minxs_jinbantime;
	private String maxxs_jinbantime;
	private Integer minxs_nianling;
	private Integer maxxs_nianling;
	private Integer us_id;

	
	
	private String gz_genzongtime;
	private String gz_genzongneirong;
	private String gz_genzongfangshi;
	private String gz_beizhu;
	private String gz_xiacigenzongtime;


	
	
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
	public User getUs_zixunshi() {
		return us_zixunshi;
	}
	public void setUs_zixunshi(User us_zixunshi) {
		this.us_zixunshi = us_zixunshi;
	}
	public User getUs_wangluozixunshi() {
		return us_wangluozixunshi;
	}
	public void setUs_wangluozixunshi(User us_wangluozixunshi) {
		this.us_wangluozixunshi = us_wangluozixunshi;
	}
	public String getMinxs_chuangjiantime() {
		return minxs_chuangjiantime;
	}
	public void setMinxs_chuangjiantime(String minxs_chuangjiantime) {
		this.minxs_chuangjiantime = minxs_chuangjiantime;
	}
	public String getMaxxs_chuangjiantime() {
		return maxxs_chuangjiantime;
	}
	public void setMaxxs_chuangjiantime(String maxxs_chuangjiantime) {
		this.maxxs_chuangjiantime = maxxs_chuangjiantime;
	}
	public String getMinxs_shangmentime() {
		return minxs_shangmentime;
	}
	public void setMinxs_shangmentime(String minxs_shangmentime) {
		this.minxs_shangmentime = minxs_shangmentime;
	}
	public String getMaxxs_shangmentime() {
		return maxxs_shangmentime;
	}
	public void setMaxxs_shangmentime(String maxxs_shangmentime) {
		this.maxxs_shangmentime = maxxs_shangmentime;
	}
	public String getMinxs_shuocihuifangtime() {
		return minxs_shuocihuifangtime;
	}
	public void setMinxs_shuocihuifangtime(String minxs_shuocihuifangtime) {
		this.minxs_shuocihuifangtime = minxs_shuocihuifangtime;
	}
	public String getMaxxs_shuocihuifangtime() {
		return maxxs_shuocihuifangtime;
	}
	public void setMaxxs_shuocihuifangtime(String maxxs_shuocihuifangtime) {
		this.maxxs_shuocihuifangtime = maxxs_shuocihuifangtime;
	}
	public String getMinxs_jiaofeitime() {
		return minxs_jiaofeitime;
	}
	public void setMinxs_jiaofeitime(String minxs_jiaofeitime) {
		this.minxs_jiaofeitime = minxs_jiaofeitime;
	}
	public String getMaxxs_jiaofeitime() {
		return maxxs_jiaofeitime;
	}
	public void setMaxxs_jiaofeitime(String maxxs_jiaofeitime) {
		this.maxxs_jiaofeitime = maxxs_jiaofeitime;
	}
	public String getMinxs_jinbantime() {
		return minxs_jinbantime;
	}
	public void setMinxs_jinbantime(String minxs_jinbantime) {
		this.minxs_jinbantime = minxs_jinbantime;
	}
	public String getMaxxs_jinbantime() {
		return maxxs_jinbantime;
	}
	public void setMaxxs_jinbantime(String maxxs_jinbantime) {
		this.maxxs_jinbantime = maxxs_jinbantime;
	}
	public Integer getMinxs_nianling() {
		return minxs_nianling;
	}
	public void setMinxs_nianling(Integer minxs_nianling) {
		this.minxs_nianling = minxs_nianling;
	}
	public Integer getMaxxs_nianling() {
		return maxxs_nianling;
	}
	public void setMaxxs_nianling(Integer maxxs_nianling) {
		this.maxxs_nianling = maxxs_nianling;
	}
	public Integer getXs_id() {
		return xs_id;
	}
	public void setXs_id(Integer xs_id) {
		this.xs_id = xs_id;
	}
	public String getXs_chuangjiantime() {
		return xs_chuangjiantime;
	}
	public void setXs_chuangjiantime(String xs_chuangjiantime) {
		this.xs_chuangjiantime = xs_chuangjiantime;
	}
	public String getXs_name() {
		return xs_name;
	}
	public void setXs_name(String xs_name) {
		this.xs_name = xs_name;
	}
	public String getXs_dianhua() {
		return xs_dianhua;
	}
	public void setXs_dianhua(String xs_dianhua) {
		this.xs_dianhua = xs_dianhua;
	}
	public Integer getXs_xingbie() {
		return xs_xingbie;
	}
	public void setXs_xingbie(Integer xs_xingbie) {
		this.xs_xingbie = xs_xingbie;
	}
	public Integer getXs_nianling() {
		return xs_nianling;
	}
	public void setXs_nianling(Integer xs_nianling) {
		this.xs_nianling = xs_nianling;
	}
	public String getXs_xueli() {
		return xs_xueli;
	}
	public void setXs_xueli(String xs_xueli) {
		this.xs_xueli = xs_xueli;
	}
	public String getXs_zhuangtai() {
		return xs_zhuangtai;
	}
	public void setXs_zhuangtai(String xs_zhuangtai) {
		this.xs_zhuangtai = xs_zhuangtai;
	}
	public String getXs_laiyuanqudao() {
		return xs_laiyuanqudao;
	}
	public void setXs_laiyuanqudao(String xs_laiyuanqudao) {
		this.xs_laiyuanqudao = xs_laiyuanqudao;
	}
	public String getXs_laiyuanwangzhi() {
		return xs_laiyuanwangzhi;
	}
	public void setXs_laiyuanwangzhi(String xs_laiyuanwangzhi) {
		this.xs_laiyuanwangzhi = xs_laiyuanwangzhi;
	}
	public String getXs_guanzhu() {
		return xs_guanzhu;
	}
	public void setXs_guanzhu(String xs_guanzhu) {
		this.xs_guanzhu = xs_guanzhu;
	}
	public String getXs_liyuanguanjianzi() {
		return xs_liyuanguanjianzi;
	}
	public void setXs_liyuanguanjianzi(String xs_liyuanguanjianzi) {
		this.xs_liyuanguanjianzi = xs_liyuanguanjianzi;
	}
	public String getXs_namezixun() {
		return xs_namezixun;
	}
	public void setXs_namezixun(String xs_namezixun) {
		this.xs_namezixun = xs_namezixun;
	}
	public String getXs_suozaiquyu() {
		return xs_suozaiquyu;
	}
	public void setXs_suozaiquyu(String xs_suozaiquyu) {
		this.xs_suozaiquyu = xs_suozaiquyu;
	}
	public String getXs_weixin() {
		return xs_weixin;
	}
	public void setXs_weixin(String xs_weixin) {
		this.xs_weixin = xs_weixin;
	}
	public String getXs_qq() {
		return xs_qq;
	}
	public void setXs_qq(String xs_qq) {
		this.xs_qq = xs_qq;
	}
	public String getXs_laiyuanbumen() {
		return xs_laiyuanbumen;
	}
	public void setXs_laiyuanbumen(String xs_laiyuanbumen) {
		this.xs_laiyuanbumen = xs_laiyuanbumen;
	}
	public String getXs_isbaobei() {
		return xs_isbaobei;
	}
	public void setXs_isbaobei(String xs_isbaobei) {
		this.xs_isbaobei = xs_isbaobei;
	}
	public String getXs_kecheng() {
		return xs_kecheng;
	}
	public void setXs_kecheng(String xs_kecheng) {
		this.xs_kecheng = xs_kecheng;
	}
	public Integer getXs_isyouxiao() {
		return xs_isyouxiao;
	}
	public void setXs_isyouxiao(Integer xs_isyouxiao) {
		this.xs_isyouxiao = xs_isyouxiao;
	}
	public String getXs_dafen() {
		return xs_dafen;
	}
	public void setXs_dafen(String xs_dafen) {
		this.xs_dafen = xs_dafen;
	}
	public Integer getXs_ishuifang() {
		return xs_ishuifang;
	}
	public void setXs_ishuifang(Integer xs_ishuifang) {
		this.xs_ishuifang = xs_ishuifang;
	}
	public String getXs_shuocihuifangtime() {
		return xs_shuocihuifangtime;
	}
	public void setXs_shuocihuifangtime(String xs_shuocihuifangtime) {
		this.xs_shuocihuifangtime = xs_shuocihuifangtime;
	}
	public Integer getXs_isshangmen() {
		return xs_isshangmen;
	}
	public void setXs_isshangmen(Integer xs_isshangmen) {
		this.xs_isshangmen = xs_isshangmen;
	}
	public String getXs_shangmentime() {
		return xs_shangmentime;
	}
	public void setXs_shangmentime(String xs_shangmentime) {
		this.xs_shangmentime = xs_shangmentime;
	}
	public String getXs_wuxiaoyuanyin() {
		return xs_wuxiaoyuanyin;
	}
	public void setXs_wuxiaoyuanyin(String xs_wuxiaoyuanyin) {
		this.xs_wuxiaoyuanyin = xs_wuxiaoyuanyin;
	}
	public Integer getXs_isjiaofei() {
		return xs_isjiaofei;
	}
	public void setXs_isjiaofei(Integer xs_isjiaofei) {
		this.xs_isjiaofei = xs_isjiaofei;
	}
	public String getXs_jiaofeitime() {
		return xs_jiaofeitime;
	}
	public void setXs_jiaofeitime(String xs_jiaofeitime) {
		this.xs_jiaofeitime = xs_jiaofeitime;
	}
	public Double getXs_jine() {
		return xs_jine;
	}
	public void setXs_jine(Double xs_jine) {
		this.xs_jine = xs_jine;
	}
	public Integer getXs_istuifei() {
		return xs_istuifei;
	}
	public void setXs_istuifei(Integer xs_istuifei) {
		this.xs_istuifei = xs_istuifei;
	}
	public Integer getXs_isjinban() {
		return xs_isjinban;
	}
	public void setXs_isjinban(Integer xs_isjinban) {
		this.xs_isjinban = xs_isjinban;
	}
	public String getXs_jinbantime() {
		return xs_jinbantime;
	}
	public void setXs_jinbantime(String xs_jinbantime) {
		this.xs_jinbantime = xs_jinbantime;
	}
	public String getXs_jinbanbeizhu() {
		return xs_jinbanbeizhu;
	}
	public void setXs_jinbanbeizhu(String xs_jinbanbeizhu) {
		this.xs_jinbanbeizhu = xs_jinbanbeizhu;
	}
	public String getXs_tuifeiyuanyin() {
		return xs_tuifeiyuanyin;
	}
	public void setXs_tuifeiyuanyin(String xs_tuifeiyuanyin) {
		this.xs_tuifeiyuanyin = xs_tuifeiyuanyin;
	}
	public Double getXs_dingjinjine() {
		return xs_dingjinjine;
	}
	public void setXs_dingjinjine(Double xs_dingjinjine) {
		this.xs_dingjinjine = xs_dingjinjine;
	}
	public String getXs_dingjintime() {
		return xs_dingjintime;
	}
	public void setXs_dingjintime(String xs_dingjintime) {
		this.xs_dingjintime = xs_dingjintime;
	}
	public Integer getXs_zixunshi() {
		return xs_zixunshi;
	}
	public void setXs_zixunshi(Integer xs_zixunshi) {
		this.xs_zixunshi = xs_zixunshi;
	}
	public Integer getXs_lururen() {
		return xs_lururen;
	}
	public void setXs_lururen(Integer xs_lururen) {
		this.xs_lururen = xs_lururen;
	}
	public String getXs_zixunshibeizhu() {
		return xs_zixunshibeizhu;
	}
	public void setXs_zixunshibeizhu(String xs_zixunshibeizhu) {
		this.xs_zixunshibeizhu = xs_zixunshibeizhu;
	}
	public String getXs_exe1() {
		return xs_exe1;
	}
	public void setXs_exe1(String xs_exe1) {
		this.xs_exe1 = xs_exe1;
	}
	public String getXs_exe2() {
		return xs_exe2;
	}
	public void setXs_exe2(String xs_exe2) {
		this.xs_exe2 = xs_exe2;
	}
	public Integer getUs_id() {
		return us_id;
	}
	public void setUs_id(Integer us_id) {
		this.us_id = us_id;
	}
	@Override
	public String toString() {
		return "Student [xs_id=" + xs_id + ", xs_chuangjiantime=" + xs_chuangjiantime + ", xs_name=" + xs_name
				+ ", xs_dianhua=" + xs_dianhua + ", xs_xingbie=" + xs_xingbie + ", xs_nianling=" + xs_nianling
				+ ", xs_xueli=" + xs_xueli + ", xs_zhuangtai=" + xs_zhuangtai + ", xs_laiyuanqudao=" + xs_laiyuanqudao
				+ ", xs_laiyuanwangzhi=" + xs_laiyuanwangzhi + ", xs_guanzhu=" + xs_guanzhu + ", xs_liyuanguanjianzi="
				+ xs_liyuanguanjianzi + ", xs_namezixun=" + xs_namezixun + ", xs_suozaiquyu=" + xs_suozaiquyu
				+ ", xs_weixin=" + xs_weixin + ", xs_qq=" + xs_qq + ", xs_laiyuanbumen=" + xs_laiyuanbumen
				+ ", xs_isbaobei=" + xs_isbaobei + ", xs_kecheng=" + xs_kecheng + ", xs_isyouxiao=" + xs_isyouxiao
				+ ", xs_dafen=" + xs_dafen + ", xs_ishuifang=" + xs_ishuifang + ", xs_shuocihuifangtime="
				+ xs_shuocihuifangtime + ", xs_isshangmen=" + xs_isshangmen + ", xs_shangmentime=" + xs_shangmentime
				+ ", xs_wuxiaoyuanyin=" + xs_wuxiaoyuanyin + ", xs_isjiaofei=" + xs_isjiaofei + ", xs_jiaofeitime="
				+ xs_jiaofeitime + ", xs_jine=" + xs_jine + ", xs_istuifei=" + xs_istuifei + ", xs_isjinban="
				+ xs_isjinban + ", xs_jinbantime=" + xs_jinbantime + ", xs_jinbanbeizhu=" + xs_jinbanbeizhu
				+ ", xs_tuifeiyuanyin=" + xs_tuifeiyuanyin + ", xs_dingjinjine=" + xs_dingjinjine + ", xs_dingjintime="
				+ xs_dingjintime + ", xs_zixunshi=" + xs_zixunshi + ", xs_lururen=" + xs_lururen
				+ ", xs_zixunshibeizhu=" + xs_zixunshibeizhu + ", xs_exe1=" + xs_exe1 + ", xs_exe2=" + xs_exe2
				+ ", us_zixunshi=" + us_zixunshi + ", us_wangluozixunshi=" + us_wangluozixunshi
				+ ", minxs_chuangjiantime=" + minxs_chuangjiantime + ", maxxs_chuangjiantime=" + maxxs_chuangjiantime
				+ ", minxs_shangmentime=" + minxs_shangmentime + ", maxxs_shangmentime=" + maxxs_shangmentime
				+ ", minxs_shuocihuifangtime=" + minxs_shuocihuifangtime + ", maxxs_shuocihuifangtime="
				+ maxxs_shuocihuifangtime + ", minxs_jiaofeitime=" + minxs_jiaofeitime + ", maxxs_jiaofeitime="
				+ maxxs_jiaofeitime + ", minxs_jinbantime=" + minxs_jinbantime + ", maxxs_jinbantime="
				+ maxxs_jinbantime + ", minxs_nianling=" + minxs_nianling + ", maxxs_nianling=" + maxxs_nianling
				+ ", us_id=" + us_id + ", gz_genzongtime=" + gz_genzongtime + ", gz_genzongneirong=" + gz_genzongneirong
				+ ", gz_genzongfangshi=" + gz_genzongfangshi + ", gz_beizhu=" + gz_beizhu + ", gz_xiacigenzongtime="
				+ gz_xiacigenzongtime + "]";
	}
	
}
