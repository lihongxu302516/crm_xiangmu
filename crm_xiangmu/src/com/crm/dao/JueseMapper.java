package com.crm.dao;

import java.util.List;

import com.crm.entity.Fenye;
import com.crm.entity.Juese;
import com.crm.entity.Mokuai;

public interface JueseMapper {
	/**
	 * 查看角色的条数
	 * @return
	 */
	Integer selectJueseCount(Fenye<Juese> fenye);
	/**
	 * 查看所有角色分页
	 * @return
	 */
	List<Juese> selectJueseAll(Fenye<Juese> fenye);
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
	 * 查看咨询师id
	 * @return
	 */
	Integer selectJuese_zixunshi();
	/**
	 * 用所有角色获取所有的功能模块
	 * @param list
	 * @return
	 */
	List<Mokuai> select_juese_mokuai_js_ids(List<Juese> list);
	/**
	 * 查询角色名是否重复
	 * @param js_name
	 * @return
	 */
	Integer select_juese_name_chongfu(String js_name);
	/**
	 * 查看该角色下是否有员工
	 * @param js_id
	 * @return
	 */
	Integer select_Juese_is_User(Integer js_id);

}
