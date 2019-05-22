package com.crm.dao;

import java.util.List;

import com.crm.entity.Juese_mokuai;
import com.crm.entity.Mokuai;

public interface MokuaiMapper {
	/**
	 * �鿴����ģ��
	 * @return
	 */
	List<Mokuai> selectMokuaiAll();
	/**
	 * ���ģ��
	 * @param mokuai
	 * @return
	 */
	Integer insertMokuai(Mokuai mokuai);
	/**
	 * �޸�ģ��
	 * @param mokuai
	 * @return
	 */
	Integer updateMokuai(Mokuai mokuai);
	/**
	 * ɾ��ģ��
	 * @param mk_id
	 * @return
	 */
	Integer deleteMokuai(Integer mk_id);
	/**
	 * ����ģ��id�鿴ģ����Ϣ
	 * @return
	 */
	Mokuai selectMokuai_mk_id(Integer mk_id);
	/**
	 * �鿴��ɫ��ģ���Ƿ����
	 * @param jm
	 * @return
	 */
	Integer selectMokuai_js_id(Juese_mokuai jm);
	/**
	 * �鿴��ɫ������ģ��
	 * @param js_id
	 * @return
	 */
	List<Mokuai> selectMokuai_js_idAll(Integer js_id);
	/**
	 * ɾ����ɫ������ģ��
	 * @param js_id
	 * @return
	 */
	Integer deleteJuese_mokuai_js_id(Integer js_id);
	/**
	 * ����ɫ��Ӷ��ģ��
	 * @param jm
	 * @return
	 */
	Integer insertJuese_mokuai_js_id(List<Juese_mokuai> list_jm);
	/**
	 * �鿴��ģ���Ƿ�����ģ��
	 * @param mk_fuid
	 * @return
	 */
	Integer selectMokuai_isyouzi(Integer mk_fuid);
	/**
	 * �鿴ģ�������Ƿ��ظ�
	 * @param mk_name
	 * @return
	 */
	Integer selectMokuai_name_ischongfu(Mokuai mokuai);
	/**
	 * ģ���Ƿ񱻽�ɫʹ��
	 * @param mk_id
	 * @return
	 */
	Integer selectMokuai_is_Juese(Integer mk_id);
	/**
	 * �鿴��ģ���Ƿ񱻽�ɫʹ��
	 * @param mk_id
	 * @return
	 */
	Integer selectMokuai_is_Juese_fu_id(Integer mk_id);
	/**
	 * ɾ����id�µ�������ģ��
	 * @param mk_id
	 * @return
	 */
	Integer deleteMokuai_fu_id(Integer mk_id);

}
