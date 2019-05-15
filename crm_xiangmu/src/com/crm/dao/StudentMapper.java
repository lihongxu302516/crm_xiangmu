package com.crm.dao;

import java.util.List;

import com.crm.entity.Fenye;
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
	Integer insertGenZong(Student student);
}
