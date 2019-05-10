package com.crm.controller;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.crm.entity.User;
import com.crm.service.LoginService;
import com.crm.util.CookiesUtil;
import com.crm.util.SCaptcha;

@Controller
public class LoginController {
	@Autowired
	SCaptcha instance;
	@Autowired
	LoginService loginServiceimp;
	@Autowired
	CookiesUtil cookiesUtil;
	@Autowired
	User user;
	
	@RequestMapping(value="login")
	public String login(HttpServletRequest request,HttpServletResponse response) {
		Cookie us_name = cookiesUtil.getCookieByName(request, "us_name");
		Cookie us_password = cookiesUtil.getCookieByName(request, "us_password");
		if(us_name!=null && us_password!=null && us_name.getValue()!="" && us_password.getValue()!="") {
			user.setUs_name(us_name.getValue());
			user.setUs_password(us_password.getValue());
			request.getSession().setAttribute("yanzhengmatext", "0");;
			denglu(user, "0", request, response);
			return "home";
		}else {
			return "login";
		}
	}
	@RequestMapping(value = "yanzhengma")
	@ResponseBody
	public void tupianyanzhengma(HttpServletRequest request, HttpServletResponse response) {
		loginServiceimp.tupianyanzhengma_service(request, response);
	}
	@RequestMapping(value = "denglu",method = RequestMethod.POST)
	@ResponseBody
	public int denglu(User user,String yanzhengma,HttpServletRequest request,HttpServletResponse response) {
		Integer login_service = loginServiceimp.Login_service(user,yanzhengma,request,response);
		return login_service;
	}

}
