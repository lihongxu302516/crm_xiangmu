package com.crm.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crm.entity.User;

public interface LoginService {
	/**
	 * ��½
	 * @param user
	 * @param yanzhengma
	 * @param request
	 * @return
	 */
	Integer Login_service(User user,String yanzhengma,HttpServletRequest request,HttpServletResponse response);
	/**
	 * ��ȡ��֤��ͼƬ
	 * @param request
	 * @param response
	 */
	void tupianyanzhengma_service(HttpServletRequest request, HttpServletResponse response);

}
