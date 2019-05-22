package com.crm.dao;

import java.util.List;


import com.crm.entity.Dongtai;
import com.crm.entity.Fenye;
import com.crm.entity.Genzongrizhi;
import com.crm.entity.Student;
import com.crm.entity.User;

public interface StudentMapper {
	/**
	 * 查询学生
	 * @param fenye
	 * @return
	 */
	List<Student> selesctStudent(Fenye<Student> fenye);
	/**
	 * 查询总条数
	 * @param fenye
	 * @return
	 */
	Integer selescCount(Fenye<Student> fenye);
	/**
	 * 修改一个学生
	 * @param student
	 * @return
	 */
	Integer updateStudent(Student student);
	/**
	 * 添加一个学生
	 * @param student
	 * @return
	 */
	Integer insertStudent(Student student);
	/**
	 * 删除一个学生
	 * @param student
	 * @return
	 */
	Integer deleteStudent(Integer xs_id);
	/**
	 * 删除多个学生
	 * @param list
	 * @return
	 */
	Integer deleteStudent_duo(List<Integer> list);
	/**
	 * 根据id查询用户
	 */
	User selectUser_student_us_id(Integer us_id);
	/**
	 * 修改是否有效
	 * @param student
	 * @return
	 */
	Integer updateisyouxiao(Student student);
	/**
	 * 添加跟踪信息
	 */
	Integer insertGenZong(Genzongrizhi genzongrizhi);
	/**
	 * 查看是否自动分配
	 * @return
	 */
	Integer selectGongneng_zdfp();
	/**
	 * 修改自动分配
	 * @param gn_iskaiqi
	 * @return
	 */
	Integer updateGongneng_zdfp(Integer gn_iskaiqi);
	/**
	 * 给学生设置咨询师
	 * @param student
	 * @return
	 */
	Integer updateStudent_zixunshi(Student student);
	/**
	 * 批量给学生设置咨询师
	 * @param student
	 * @return
	 */
	Integer pl_updateStudent_zixunshi(Student student);
	/**
	 * 查询所有选择的学生
	 * @param list
	 * @return
	 */
	List<Student> selectStudent_xuanzhong(List<Integer> list);
	/**
	 * 添加动态日志
	 * @param request
	 * @param dt
	 * @return
	 */
	Integer tianjia_dongtairizhi(Dongtai dt);
	/**
	 * 查看该学生的动态日志
	 * @param dt_student
	 * @return
	 */
	List<Dongtai> selectDongtai_stu_id(Fenye<Dongtai> fenye);
	/**
	 * 通过学生id更该学生是否被修改
	 * @param student
	 * @return
	 */
	Integer updateStudent_exe1_isbeixiugai(Student student);
	/**
	 * 通过用户id更该学生是否被修改
	 * @param student
	 * @return
	 */
	Integer updateStudent_exe1_isbeixiugai_user(Integer us_id);
	/**
	 * 查看该咨询师下的学生是否有被修改
	 * @param us_id
	 * @return
	 */
	List<Student> selectUser_Student_exe1_isbeixiugai(Integer us_id);
	/**
	 * 根据学生id查看跟踪日志
	 * @param fenye
	 * @return
	 */
	List<Genzongrizhi> selectGengzongrizhi_xs_id(Fenye<Genzongrizhi> fenye);
}
