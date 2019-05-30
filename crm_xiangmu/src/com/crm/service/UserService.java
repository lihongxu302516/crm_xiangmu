package com.crm.service;


import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.crm.entity.Fenye;
import com.crm.entity.Qd_Cd_Wq_tu;
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
	Integer updateUser(User user,HttpServletRequest request);
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
	 * Ա�����
	 * @param us_id
	 * @return
	 */
	Integer updateUser_qingjia(Integer us_id);
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
	/**
	 * Ա���޸��Լ���Ϣ
	 * @param user
	 * @return
	 */
	Integer updateUser_ygxx(User user);
	/**
	 * ��ȡ�ֻ�����֤��
	 * @param request
	 * @return
	 */
	Integer shoujihaoyanzheng(HttpServletRequest request);
	/**
	 * Ա���޸��Լ�������
	 * @param user
	 * @return
	 */
	Integer updateUser_password(HttpServletRequest request,String us_yan_pas,String us_xin_pas2,String yanzhengma);
	/**
	 * ���������ȡ��ȡ�ֻ�����֤��
	 * @param request
	 * @return
	 */
	Integer cz_shoujihaoyanzheng(HttpServletRequest request,String us_name);
	/**
	 * Ա���Լ���������
	 * @param request
	 * @param us_sj_yzm
	 * @return
	 */
	Integer user_cz_mima(HttpServletRequest request,String us_sj_yzm);
	/**
	 * ����-��ѯ���е���ѯʦ
	 * @return
	 */
	List<User> zixunshi_all();
	/**
	 * ѧ��-�鿴���е���ѯʦ
	 * @return
	 */
	List<User> chakan_all_zixunshu();
	/**
	 * ѧ��-�鿴���е�������ѯʦ
	 * @return
	 */
	List<User> chakan_all_wl_zixunshu();
	/**
	 * ǩ��ͼ��
	 * @return
	 */
	Qd_Cd_Wq_tu user_qiandao_tubiao();
	/**
	 * ����ͼƬ��״ͼ
	 * @return
	 */
	List<Map<String, Object>> yuangong_kq_tubiao_bingtu();
	/**
	 * ��ѯ����Ա���ĸ��ٴ���
	 * @return
	 */
	Map<String,Object> yuangong_genzongcishu();
	/**
	 * ��ѯÿ��¼���ѧ������
	 * @return
	 */
	Map<String,Object> selectStudent_tianjia_shuliang();
}
