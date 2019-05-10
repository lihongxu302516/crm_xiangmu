package com.crm.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crm.entity.User;

public interface LoginService {
	/**
	 * 登陆
	 * @param user
	 * @param yanzhengma
	 * @param request
	 * @return
	 */
	Integer Login_service(User user,String yanzhengma,HttpServletRequest request,HttpServletResponse response);
	/**
	 * 获取验证码图片
	 * @param request
	 * @param response
	 */
	void tupianyanzhengma_service(HttpServletRequest request, HttpServletResponse response);

}
