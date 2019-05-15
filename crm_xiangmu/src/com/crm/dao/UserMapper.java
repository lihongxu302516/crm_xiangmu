package com.crm.dao;

import java.util.List;

import com.crm.entity.Fenye;
import com.crm.entity.User;
import com.crm.entity.User_juese;

public interface UserMapper {
	/**
	 * �鿴�����û�������
	 * @param fenye
	 * @return
	 */
	List<User> selectUserAll(Fenye<User> fenye);
	/**
	 * �鿴�û�������
	 * @param fenye
	 * @return
	 */
	Integer selectUserCount(Fenye<User> fenye);
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
	 * @param us_id
	 * @return
	 */
	Integer deleteUser(Integer us_id);
	/**
	 * ɾ���û���ɫ���е�����
	 * @param us_id
	 * @return
	 */
	Integer deleteUser_Juese(Integer us_id);
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
	 * @param us
	 * @return
	 */
	Integer updateUser_daka(User us);
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
	Integer updateUser_qiantui_duo(List<Integer> list);
	/**
	 * ȫ��Ա��ǩ��
	 * @param us_id
	 * @return
	 */
	Integer updateUser_qiantui_quan();
	/**
	 * Ա���޸��Լ���Ϣ
	 * @param user
	 * @return
	 */
	Integer updateUser_ygxx(User user);
	/**
	 * Ա���޸��Լ�������
	 * @param user
	 * @return
	 */
	Integer updateUser_password(User user);
	/**
	 * ͨ���û����鿴�û��ֻ���
	 * @param us_name
	 * @return
	 */
	User selectUser_us_name_shoujihao(String us_name);
	/**
	 * ��ѯ���е���ѯʦ
	 * @return
	 */
	List<User> selectUser_zixunshi(Integer uj_userid);

}
