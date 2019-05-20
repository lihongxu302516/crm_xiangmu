package com.crm.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crm.entity.Dongtai;
import com.crm.entity.Fenye;
import com.crm.entity.Genzongrizhi;
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
	 * 删除多个学生
	 * @param list
	 * @return
	 */
	Integer deleteStudent_duo(String xs_ids);
	/**
	 * 修改是否有效
	 * @param student
	 * @return
	 */
	Integer updateisyouxiao(Student student);
	/**
	 * 添加跟踪信息
	 */
	Integer insertGenZong(Genzongrizhi genzongrizhi,HttpServletRequest request);
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
	 * 导出excel
	 * @param request
	 * @return
	 * @throws IOException 
	 */
	void daochuexcel(HttpServletRequest request,HttpServletResponse response,String xs_ids) throws IOException;
	/**
	 * 添加动态日志
	 * @param request
	 * @param dt
	 * @return
	 */
	Integer tianjia_dongtairizhi(HttpServletRequest request,Dongtai dt);
	/**
	 * 查看该学生的动态日志
	 * @param dt_student
	 * @return
	 */
	Fenye<Dongtai> selectDongtai_stu_id(Fenye<Dongtai> fenye);
	/**
	 * 根据学生id查看跟踪日志
	 * @param fenye
	 * @return
	 */
	Fenye<Genzongrizhi> selectGengzongrizhi_xs_id(Fenye<Genzongrizhi> fenye);
}
