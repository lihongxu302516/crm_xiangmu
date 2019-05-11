package com.crm.dao;

import java.util.List;

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

}
