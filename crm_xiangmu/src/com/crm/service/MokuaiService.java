package com.crm.service;

import java.util.List;

import com.crm.entity.Mokuai;
import com.crm.entity.MokuaiTree;

public interface MokuaiService {
	/**
	 * 查看所有模块
	 * @return
	 */
	List<MokuaiTree> selectMokuaiAll();
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
	
	
	

}
