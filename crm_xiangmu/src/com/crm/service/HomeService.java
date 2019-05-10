package com.crm.service;

import javax.servlet.http.HttpServletRequest;

public interface HomeService {
	/**
	 * 显示首页树列表
	 * @return
	 */
	String hometree(String treeUlId,HttpServletRequest requer);

}
