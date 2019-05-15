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
	 * �鿴���н�ɫ��ҳ
	 * @return
	 */
	List<Juese> selectJueseAll(Fenye<Juese> fenye);
	/**
	 * �鿴���н�ɫ����ҳ
	 * @return
	 */
	List<Juese> selectJuese();
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
	 * �鿴��ѯʦid
	 * @return
	 */
	Integer selectJuese_zixunshi();

}
