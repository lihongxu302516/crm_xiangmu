package com.crm.dao;

import java.util.List;

import com.crm.entity.*;

public interface LoginMapper {
	/**
	 * �鿴��½�û��û����Ƿ����
	 * 
	 * @param username
	 * @return
	 */
	Integer selectUser_Login_username(String username);

	/**
	 * �鿴���û��������Ƿ���ȷ
	 * 
	 * @param user
	 * @return
	 */
	User selectUser_Login_password(User user);
	/**
	 * ��ѯ���û��Ľ�ɫ
	 * @param us_id
	 * @return
	 */
	List<Juese> selectJuese(Integer us_id);
	/**
	 * ��ѯ�ý�ɫ�Ĺ���ģ��
	 * @param js_id
	 * @return
	 */
	List<Mokuai> selectMokuai(Integer js_id);
	/**
	 * ʹ���û�������������һ
	 * @param us_name
	 * @return
	 */
	Integer updatemimacuowucishujiayi(String us_name);
	/**
	 * ͨ���û����������û�
	 * @param us_name
	 * @return
	 */
	Integer updatesuodinguser_us_name(User user);
	/**
	 * ��ѯ���û�������������
	 * @param us_name
	 * @return
	 */
	Integer selectmimacuowucishu(String us_name);
	/**
	 * �޸�����½ʱ��
	 * @param user
	 * @return
	 */
	Integer updatezuihoudenglutime(User user);

}
