package com.crm.service;

import java.util.List;

import com.crm.entity.Fenye;
import com.crm.entity.Juese;
import com.crm.entity.MokuaiTree;

public interface JueseService {
	/**
	 * 查看所有角色分页
	 * @param fenye
	 * @return
	 */
	Fenye<Juese> selectJueseAll(Fenye<Juese> fenye);
	/**
	 * 查看所有角色不分页
	 * @return
	 */
	List<Juese> selectJuese(Integer us_id);
	/**
	 * 查看一个用户的所有角色
	 * @param us_id
	 * @return
	 */
	List<Juese> selectJuese_us_id(Integer us_id);
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
	/**
	 * 查看当前角色的树
	 * @param js_id
	 * @return
	 */
	List<MokuaiTree> selectJuese_mktree(Integer js_id);
	/**
	 * 修改当前角色的模块
	 * @param mkids
	 * @param js_id
	 * @return
	 */
	Integer xiugaiJuese_mokuai(String mkids,Integer js_id);

}
