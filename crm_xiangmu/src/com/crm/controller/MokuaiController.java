package com.crm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.crm.entity.Mokuai;
import com.crm.entity.MokuaiTree;
import com.crm.service.MokuaiService;

@Controller
public class MokuaiController {
	@Autowired
	MokuaiService mokuaiServiceimp;
	
	@RequestMapping(value = "mokuai_guanli")
	public String mokuai_guanli(HttpServletRequest request) {
			return "mokuai_guanli";
	}
	@RequestMapping(value = "mokuai_xianshi",method = RequestMethod.POST)
	@ResponseBody
	public List<MokuaiTree> mokuai_xianshi(){
		return mokuaiServiceimp.selectMokuaiAll();
	}
	@RequestMapping(value = "mokuai_tianjia",method = RequestMethod.POST)
	@ResponseBody
	public Integer mokuai_tianjia(Mokuai mokuai){
		return mokuaiServiceimp.insertMokuai(mokuai);
	}
	@RequestMapping(value = "mokuai_xiugai",method = RequestMethod.POST)
	@ResponseBody
	public Integer mokuai_xiugai(Mokuai mokuai){
		return mokuaiServiceimp.updateMokuai(mokuai);
	}
	@RequestMapping(value = "mokuai_shanchu",method = RequestMethod.POST)
	@ResponseBody
	public Integer mokuai_shanchu(Integer mk_id){
		return mokuaiServiceimp.deleteMokuai(mk_id);
	}
	@RequestMapping(value = "mokuai_xianshi_xiugai",method = RequestMethod.POST)
	@ResponseBody
	public Mokuai mokuai_xianshi_xiugai(Integer mk_id){
		return mokuaiServiceimp.selectMokuai_mk_id(mk_id);
	}
}
