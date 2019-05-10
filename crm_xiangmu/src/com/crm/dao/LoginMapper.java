package com.crm.dao;

import java.util.List;

import com.crm.entity.*;

public interface LoginMapper {
	/**
	 * 查看登陆用户用户名是否存在
	 * 
	 * @param username
	 * @return
	 */
	Integer selectUser_Login_username(String username);

	/**
	 * 查看该用户的密码是否正确
	 * 
	 * @param user
	 * @return
	 */
	User selectUser_Login_password(User user);
	/**
	 * 查询该用户的角色
	 * @param us_id
	 * @return
	 */
	List<Juese> selectJuese(Integer us_id);
	/**
	 * 查询该角色的功能模块
	 * @param js_id
	 * @return
	 */
	List<Mokuai> selectMokuai(Integer js_id);
	/**
	 * 使该用户密码错误次数加一
	 * @param us_name
	 * @return
	 */
	Integer updatemimacuowucishujiayi(String us_name);
	/**
	 * 通过用户名锁定该用户
	 * @param us_name
	 * @return
	 */
	Integer updatesuodinguser_us_name(User user);
	/**
	 * 查询该用户的密码错误次数
	 * @param us_name
	 * @return
	 */
	Integer selectmimacuowucishu(String us_name);
	/**
	 * 修改最后登陆时间
	 * @param user
	 * @return
	 */
	Integer updatezuihoudenglutime(User user);

}
