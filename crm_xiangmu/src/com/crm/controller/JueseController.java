package com.crm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.crm.entity.Fenye;
import com.crm.entity.Juese;
import com.crm.entity.MokuaiTree;
import com.crm.service.JueseService;

@Controller
public class JueseController {
	@Autowired
	JueseService jueseServiceimp;
	@Autowired
	Fenye<Juese> fenye;
	
	@RequestMapping(value = "juese_guanli")
	public String juese_guanli(HttpServletRequest request) {
		return "juese_guanli";
	}
	@RequestMapping(value = "juese_xianshi",method = RequestMethod.POST)
	@ResponseBody
	public Fenye<Juese> juese_chakan(Integer page,Integer rows,Juese juese){
		fenye.setPage(page);
		fenye.setLimit(rows);
		fenye.setT(juese);
		return jueseServiceimp.selectJueseAll(fenye);
	}
	@RequestMapping(value = "juese_tianjia",method = RequestMethod.POST)
	@ResponseBody
	public Integer juese_tianjia(Juese juese) {
		return jueseServiceimp.insertJuese(juese);
	}
	@RequestMapping(value = "juese_xiugai",method = RequestMethod.POST)
	@ResponseBody
	public Integer juese_xiugai(Juese juese) {
		return jueseServiceimp.updateJuese(juese);
	}
	@RequestMapping(value = "juese_shanchu",method = RequestMethod.POST)
	@ResponseBody
	public Integer juese_shanchu(Integer js_id) {
		return jueseServiceimp.deleteJuese(js_id);
	}
	@RequestMapping(value = "juese_chakan_mokuaitree",method = RequestMethod.POST)
	@ResponseBody
	public List<MokuaiTree> juese_chakan_mokuaitree(Integer js_id) {
		return jueseServiceimp.selectJuese_mktree(js_id);
	}
	@RequestMapping(value = "juese_mokuai_tianjia",method = RequestMethod.POST)
	@ResponseBody
	public Integer juese_mokuai_tianjia(String mkids,Integer js_id) {
		return jueseServiceimp.xiugaiJuese_mokuai(mkids, js_id);
	}

}
