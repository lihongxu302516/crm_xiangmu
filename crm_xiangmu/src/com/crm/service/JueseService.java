package com.crm.service;

import com.crm.entity.Fenye;
import com.crm.entity.Juese;

public interface JueseService {
	/**
	 * 查看所有角色
	 * @param fenye
	 * @return
	 */
	Fenye<Juese> selectJueseAll(Fenye<Juese> fenye);
	/**
	 * 添加一个角色
	 * @param juese
	 * @return
	 */
	Integer insertJuese(Juese juese);
	/**
	 * 修改一个角色
	 * @param juese
	 * @return
	 */
	Integer updateJuese(Juese juese);
	/**
	 * 删除一个角色
	 * @param js_id
	 * @return
	 */
	Integer deleteJuese(Integer js_id);

}
