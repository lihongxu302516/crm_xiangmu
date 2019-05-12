package com.crm.dao;

import java.util.List;

import com.crm.entity.Juese_mokuai;
import com.crm.entity.Mokuai;

public interface MokuaiMapper {
	/**
	 * 查看所有模块
	 * @return
	 */
	List<Mokuai> selectMokuaiAll();
	/**
	 * 添加模块
	 * @param mokuai
	 * @return
	 */
	Integer insertMokuai(Mokuai mokuai);
	/**
	 * 修改模块
	 * @param mokuai
	 * @return
	 */
	Integer updateMokuai(Mokuai mokuai);
	/**
	 * 删除模块
	 * @param mk_id
	 * @return
	 */
	Integer deleteMokuai(Integer mk_id);
	/**
	 * 根据模块id查看模块信息
	 * @return
	 */
	Mokuai selectMokuai_mk_id(Integer mk_id);
	/**
	 * 查看角色的模块是否存在
	 * @param jm
	 * @return
	 */
	Integer selectMokuai_js_id(Juese_mokuai jm);
	/**
	 * 查看角色的所有模块
	 * @param js_id
	 * @return
	 */
	List<Mokuai> selectMokuai_js_idAll(Integer js_id);

}
