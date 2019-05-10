package com.crm.service;

import com.crm.entity.Fenye;
import com.crm.entity.Juese;

public interface JueseService {
	/**
	 * �鿴���н�ɫ
	 * @param fenye
	 * @return
	 */
	Fenye<Juese> selectJueseAll(Fenye<Juese> fenye);
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
