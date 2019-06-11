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
		// 请求home.jsp
		return "home";
	}

	@RequestMapping(value = "hometree", method = RequestMethod.POST)
	@ResponseBody
	public String hometree(String treeUlId, HttpServletRequest requer) {
		// 首页树的显示
		String hometree = homeServiceimp.hometree(treeUlId, requer);
		return hometree;
	}

	@RequestMapping(value = "tuichu")
	public String tuichu(HttpServletRequest request, HttpServletResponse response) {
		//退出请求
		request.getSession().setAttribute("user", null);//清空session
		cookiesUtil.setCookie(response, "us_name", "", 0);//清空cookie账户
		cookiesUtil.setCookie(response, "us_password", "", 0);//清空cookie密码
		return "login";//请求login.jsp页面
	}

	@RequestMapping(value = "dongtaixueshengrizhi", method = RequestMethod.POST)
	@ResponseBody
	public String dongtaixueshengrizhi(HttpServletRequest request) {
		//查看学生的动态日志
		return homeServiceimp.dongtaixueshengrizhi(request);
	}

}
