package com.crm.service;

import javax.servlet.http.HttpServletRequest;

import com.crm.entity.Fenye;
import com.crm.entity.Student;

public interface StudentService {
	/**
	 * 查询学生
	 * @param fenye
	 * @return
	 */
	Fenye<Student> selesctStudent(HttpServletRequest request,Fenye<Student> fenye);
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
	Integer insertStudent(HttpServletRequest request,Student student);
	/**
	 * 删除一个学生
	 * @param student
	 * @return
	 */
	Integer deleteStudent(Integer xs_id);
	/**
	 * 修改是否有效
	 * @param student
	 * @return
	 */
	Integer updateisyouxiao(Student student);
	/**
	 * 添加跟踪信息
	 */
	Integer insertGenZong(Student student);
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
}
