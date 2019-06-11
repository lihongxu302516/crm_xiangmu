package com.crm.dao;

import java.util.List;

import com.crm.entity.Fenye;
import com.crm.entity.Qiandao;
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
	Integer updateUser_qiantui_duo(List<Integer> list);
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
	 * 员工修改自己的密码
	 * @param user
	 * @return
	 */
	Integer updateUser_password(User user);
	/**
	 * 通过用户名查看用户手机号
	 * @param us_name
	 * @return
	 */
	User selectUser_us_name_shoujihao(String us_name);
	/**
	 * 查询所有的咨询师
	 * @return
	 */
	List<User> selectUser_zixunshi(Integer uj_userid);
	/**
	 * 查询所有的lururen
	 * @return
	 */
	List<User> selectUser_wl_zixunshi();
	/**
	 * 添加签到日志
	 * @param user
	 * @return
	 */
	Integer insertqiandaorizhi(User user);
	/**
	 * 查询咨询师有的学生数
	 * @param us_id
	 * @return
	 */
	Integer selectUser_zixuanshi_stu_all(Integer us_id);
	/**
	 * 查询当月所有员工的签到记录，柱状图表用
	 * @return
	 */
	List<Qiandao> selectQiandao_user_tubiao(Integer qd_zhuangtai);
	/**
	 * 查询所有的员工签到状态数量，饼状图表用
	 * @return
	 */
	List<Qiandao> selectQiandao_all_zhuangtai();
	/**
	 * 查询本月的员工签到状态数量，饼状图表用
	 * @return
	 */
	List<Qiandao> selectQiandao_benyue_zhuangtai();
	/**
	 * 查询今日的员工签到状态数量，饼状图表用
	 * @return
	 */
	List<Qiandao> selectQiandao_jingri_zhuangtai();
	/**
	 * 查询本月员工对客户的跟踪次数，柱状图表用
	 * @return
	 */
	List<User> selectUser_genzongcishi();
	/**
	 * 查询每一天的录入学生数量，折线图表用
	 * @return
	 */
	List<User> selectStudent_tianjia_shuliang();
	/**
	 * 添加一条请假记录
	 * @param us_id
	 * @return
	 */
	Integer insertqiandao_qingjia(Integer us_id);
	/**
	 * 查看当前用户是否拥有角色
	 * @param us_id
	 * @return
	 */
	Integer selectUser_juese_us_id(Integer us_id);
	/**
	 * 查看签退时时间是否大于10分钟——单签退
	 * @return
	 */
	Integer select_qiantui_shijianqu_dan(Integer us_id);
	/**
	 * 查看签退时时间是否大于10分钟——多签退
	 * @return
	 */
	List<Integer> select_qiantui_shijianqu_duo(List<Integer> list);
	

}
