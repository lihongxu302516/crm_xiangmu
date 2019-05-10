package com.crm.dao;

import java.util.List;

import com.crm.entity.Fenye;
import com.crm.entity.Juese;

public interface JueseMapper {
	/**
	 * �鿴��ɫ������
	 * @return
	 */
	Integer selectJueseCount(Fenye<Juese> fenye);
	/**
	 * �鿴���н�ɫ
	 * @return
	 */
	List<Juese> selectJueseAll(Fenye<Juese> fenye);
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

}
