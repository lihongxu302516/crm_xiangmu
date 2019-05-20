package com.crm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.crm.service.HomeService;
import com.crm.util.CookiesUtil;

@Controller
public class HomeController {
	@Autowired
	HomeService homeServiceimp;
	@Autowired
	CookiesUtil cookiesUtil;

	@RequestMapping(value = "home")
	public String home(HttpServletRequest request) {
			return "home";
	}
	@RequestMapping(value = "hometree", method = RequestMethod.POST)
	@ResponseBody
	public String hometree(String treeUlId, HttpServletRequest requer) {
		String hometree = homeServiceimp.hometree(treeUlId, requer);
		return hometree;
	}
	@RequestMapping(value = "tuichu")
	public String tuichu(HttpServletRequest request,HttpServletResponse response) {
		request.getSession().setAttribute("user", null);
		cookiesUtil.setCookie(response, "us_name", "", 0);
		cookiesUtil.setCookie(response, "us_password", "", 0);
		return "login";
	}
	@RequestMapping(value = "dongtaixueshengrizhi",method = RequestMethod.POST)
	@ResponseBody
	public String dongtaixueshengrizhi(HttpServletRequest request) {
		return homeServiceimp.dongtaixueshengrizhi(request);
	}

}
