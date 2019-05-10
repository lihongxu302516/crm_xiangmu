package com.crm.dao;

import java.util.List;

import com.crm.entity.Fenye;
import com.crm.entity.Juese;

public interface JueseMapper {
	/**
	 * 查看角色的条数
	 * @return
	 */
	Integer selectJueseCount(Fenye<Juese> fenye);
	/**
	 * 查看所有角色
	 * @return
	 */
	List<Juese> selectJueseAll(Fenye<Juese> fenye);
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
