package com.crm.service;

import javax.servlet.http.HttpServletRequest;

public interface HomeService {
	/**
	 * 显示首页树列表
	 * @return
	 */
	String hometree(String treeUlId,HttpServletRequest requer);
	/**
	 * 是否是咨询师，及是否有学员信息被修改
	 * @param request
	 * @return
	 */
	String dongtaixueshengrizhi(HttpServletRequest request);

}
