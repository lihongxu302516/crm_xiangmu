package com.crm.service;

import javax.servlet.http.HttpServletRequest;

public interface HomeService {
	/**
	 * ��ʾ��ҳ���б�
	 * @return
	 */
	String hometree(String treeUlId,HttpServletRequest requer);
	/**
	 * �Ƿ�����ѯʦ�����Ƿ���ѧԱ��Ϣ���޸�
	 * @param request
	 * @return
	 */
	String dongtaixueshengrizhi(HttpServletRequest request);

}
