package com.crm.service;


import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.crm.entity.Fenye;
import com.crm.entity.Qd_Cd_Wq_tu;
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
	Integer updateUser(User user,HttpServletRequest request);
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
	 * 员工请假
	 * @param us_id
	 * @return
	 */
	Integer updateUser_qingjia(Integer us_id);
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
	/**
	 * 分配-查询所有的咨询师
	 * @return
	 */
	List<User> zixunshi_all();
	/**
	 * 学生-查看所有的咨询师
	 * @return
	 */
	List<User> chakan_all_zixunshu();
	/**
	 * 学生-查看所有的网络咨询师
	 * @return
	 */
	List<User> chakan_all_wl_zixunshu();
	/**
	 * 签到图表
	 * @return
	 */
	Qd_Cd_Wq_tu user_qiandao_tubiao();
	/**
	 * 考勤图片饼状图
	 * @return
	 */
	List<Map<String, Object>> yuangong_kq_tubiao_bingtu();
	/**
	 * 查询本月员工的跟踪次数
	 * @return
	 */
	Map<String,Object> yuangong_genzongcishu();
	/**
	 * 查询每天录入的学生数量
	 * @return
	 */
	Map<String,Object> selectStudent_tianjia_shuliang();
}
