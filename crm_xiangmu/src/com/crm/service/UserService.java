package com.crm.service;

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
}
