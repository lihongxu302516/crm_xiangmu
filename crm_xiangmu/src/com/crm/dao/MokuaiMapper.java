package com.crm.dao;

import java.util.List;

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

}
