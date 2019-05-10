package com.crm.service;

import java.util.List;

import com.crm.entity.Mokuai;
import com.crm.entity.MokuaiTree;

public interface MokuaiService {
	/**
	 * �鿴����ģ��
	 * @return
	 */
	List<MokuaiTree> selectMokuaiAll();
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
	
	
	

}
