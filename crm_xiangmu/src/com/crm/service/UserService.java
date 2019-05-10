package com.crm.service;

import com.crm.entity.Fenye;
import com.crm.entity.User;

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
}
