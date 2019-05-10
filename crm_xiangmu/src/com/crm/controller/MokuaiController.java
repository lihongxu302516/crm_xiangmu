package com.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.crm.entity.MokuaiTree;
import com.crm.service.MokuaiService;

@Controller
public class MokuaiController {
	@Autowired
	MokuaiService mokuaiServiceimp;
	
	@RequestMapping(value = "mokuai_xianshi",method = RequestMethod.POST)
	@ResponseBody
	public List<MokuaiTree> mokuai_xianshi(){
		return mokuaiServiceimp.selectMokuaiAll();
	}

}
