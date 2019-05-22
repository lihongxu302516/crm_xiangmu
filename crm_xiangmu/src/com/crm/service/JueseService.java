package com.crm.service;

import java.util.List;

import com.crm.entity.Fenye;
import com.crm.entity.Juese;
import com.crm.entity.MokuaiTree;

public interface JueseService {
	/**
	 * �鿴���н�ɫ��ҳ
	 * @param fenye
	 * @return
	 */
	Fenye<Juese> selectJueseAll(Fenye<Juese> fenye);
	/**
	 * �鿴���н�ɫ����ҳ
	 * @return
	 */
	List<Juese> selectJuese(Integer us_id);
	/**
	 * �鿴һ���û������н�ɫ
	 * @param us_id
	 * @return
	 */
	List<Juese> selectJuese_us_id(Integer us_id);
	/**
	 * ���һ����ɫ
	 * @param juese
	 * @return
	 */
	Integer insertJuese(Juese juese);
	/**
	 * �޸�һ����ɫ
	 * @param juese
	 * @return
	 */
	Integer updateJuese(Juese juese);
	/**
	 * ɾ��һ����ɫ
	 * @param js_id
	 * @return
	 */
	Integer deleteJuese(Integer js_id);
	/**
	 * �鿴��ǰ��ɫ����
	 * @param js_id
	 * @return
	 */
	List<MokuaiTree> selectJuese_mktree(Integer js_id);
	/**
	 * �޸ĵ�ǰ��ɫ��ģ��
	 * @param mkids
	 * @param js_id
	 * @return
	 */
	Integer xiugaiJuese_mokuai(String mkids,Integer js_id);

}
