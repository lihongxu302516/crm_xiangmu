package com.crm.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.crm.entity.Fenye;
import com.crm.entity.User;
import com.crm.entity.User_juese;

public interface UserService {
	/**
	 * �鿴�����û�
	 * @param fenye
	 * @return
	 */
	Fenye<User> selectUserAll(Fenye<User> fenye);
	/**
	 * �����û�
	 * @param us_id
	 * @return
	 */
	Integer updatesuodingyonghu(User user);
	/**
	 * ��������
	 * @param us_id
	 * @return
	 */
	Integer updatechongzhimima(Integer us_id);
	/**
	 * ���һ���û�
	 * @param user
	 * @return
	 */
	Integer insertUser(User user);
	/**
	 * �޸�һ���û�
	 * @param user
	 * @return
	 */
	Integer updateUser(User user);
	/**
	 * ɾ��һ���û�
	 * @param user
	 * @return
	 */
	Integer deleteUser(Integer us_id);
	/**
	 * ���û����һ����ɫ
	 * @param uj
	 * @return
	 */
	Integer insertuser_juese(User_juese uj);
	/**
	 * ɾ��һ���û���ɫ
	 * @param uj
	 * @return
	 */
	Integer deleteuser_juese(User_juese uj);
	/**
	 * Ա��ǩ����
	 * @return
	 */
	Integer updateUser_daka(HttpServletRequest request);
	/**
	 * ��Ա��ǩ��
	 * @param us_id
	 * @return
	 */
	Integer updateUser_qiantui_dan(Integer us_id);
	/**
	 * ��Ա��ǩ��
	 * @param us_id
	 * @return
	 */
	Integer updateUser_qiantui_duo(String us_ids);
	/**
	 * ȫ��Ա��ǩ��
	 * @param us_id
	 * @return
	 */
	Integer updateUser_qiantui_quan();
}
