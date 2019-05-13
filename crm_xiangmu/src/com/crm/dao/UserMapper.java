package com.crm.dao;

import java.util.List;

import com.crm.entity.Fenye;
import com.crm.entity.User;
import com.crm.entity.User_juese;

public interface UserMapper {
	/**
	 * 查看所有用户的数据
	 * @param fenye
	 * @return
	 */
	List<User> selectUserAll(Fenye<User> fenye);
	/**
	 * 查看用户的数量
	 * @param fenye
	 * @return
	 */
	Integer selectUserCount(Fenye<User> fenye);
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
	 * @param us_id
	 * @return
	 */
	Integer deleteUser(Integer us_id);
	/**
	 * 删除用户角色表中的数据
	 * @param us_id
	 * @return
	 */
	Integer deleteUser_Juese(Integer us_id);
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
	 * @param us
	 * @return
	 */
	Integer updateUser_daka(User us);

}
