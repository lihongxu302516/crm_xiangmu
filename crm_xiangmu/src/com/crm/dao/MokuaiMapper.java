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
	/**
	 * 删除角色的所有模块
	 * @param js_id
	 * @return
	 */
	Integer deleteJuese_mokuai_js_id(Integer js_id);
	/**
	 * 给角色添加多个模块
	 * @param jm
	 * @return
	 */
	Integer insertJuese_mokuai_js_id(List<Juese_mokuai> list_jm);
	/**
	 * 查看该模块是否有子模块
	 * @param mk_fuid
	 * @return
	 */
	Integer selectMokuai_isyouzi(Integer mk_fuid);
	/**
	 * 查看模块名称是否重复
	 * @param mk_name
	 * @return
	 */
	Integer selectMokuai_name_ischongfu(Mokuai mokuai);
	/**
	 * 模块是否被角色使用
	 * @param mk_id
	 * @return
	 */
	Integer selectMokuai_is_Juese(Integer mk_id);
	/**
	 * 查看子模块是否被角色使用
	 * @param mk_id
	 * @return
	 */
	Integer selectMokuai_is_Juese_fu_id(Integer mk_id);
	/**
	 * 删除父id下的所有子模块
	 * @param mk_id
	 * @return
	 */
	Integer deleteMokuai_fu_id(Integer mk_id);

}
