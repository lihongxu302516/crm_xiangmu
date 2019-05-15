package com.crm.service;


import javax.servlet.http.HttpServletRequest;

import com.crm.entity.Fenye;
import com.crm.entity.User;
import com.crm.entity.User_juese;

public interface UserService {
	/**
	 * 查看所有用户
	 * @param fenye
	 * @return
	 */
	Fenye<User> selectUserAll(Fenye<User> fenye);
	/**
	 * 锁定用户
	 * @param us_id
	 * @return
	 */
	Integer updatesuodingyonghu(User user);
	/**
	 * 重置密码
	 * @param us_id
	 * @return
	 */
	Integer updatechongzhimima(Integer us_id);
	/**
	 * 添加一个用户
	 * @param user
	 * @return
	 */
	Integer insertUser(User user);
	/**
	 * 修改一个用户
	 * @param user
	 * @return
	 */
	Integer updateUser(User user);
	/**
	 * 删除一个用户
	 * @param user
	 * @return
	 */
	Integer deleteUser(Integer us_id);
	/**
	 * 给用户添加一个角色
	 * @param uj
	 * @return
	 */
	Integer insertuser_juese(User_juese uj);
	/**
	 * 删除一个用户角色
	 * @param uj
	 * @return
	 */
	Integer deleteuser_juese(User_juese uj);
	/**
	 * 员工签到打卡
	 * @return
	 */
	Integer updateUser_daka(HttpServletRequest request);
	/**
	 * 单员工签退
	 * @param us_id
	 * @return
	 */
	Integer updateUser_qiantui_dan(Integer us_id);
	/**
	 * 多员工签退
	 * @param us_id
	 * @return
	 */
	Integer updateUser_qiantui_duo(String us_ids);
	/**
	 * 全部员工签退
	 * @param us_id
	 * @return
	 */
	Integer updateUser_qiantui_quan();
	/**
	 * 员工修改自己信息
	 * @param user
	 * @return
	 */
	Integer updateUser_ygxx(User user);
	/**
	 * 获取手机号验证码
	 * @param request
	 * @return
	 */
	Integer shoujihaoyanzheng(HttpServletRequest request);
	/**
	 * 员工修改自己的密码
	 * @param user
	 * @return
	 */
	Integer updateUser_password(HttpServletRequest request,String us_yan_pas,String us_xin_pas2,String yanzhengma);
	/**
	 * 重置密码获取获取手机号验证码
	 * @param request
	 * @return
	 */
	Integer cz_shoujihaoyanzheng(HttpServletRequest request,String us_name);
	/**
	 * 员工自己重置密码
	 * @param request
	 * @param us_sj_yzm
	 * @return
	 */
	Integer user_cz_mima(HttpServletRequest request,String us_sj_yzm);
}
