package com.crm.dao;

import com.crm.entity.Fenye;
import com.crm.entity.Student;

public interface StudentMapper {
	/**
	 * 查询学生
	 * @param fenye
	 * @return
	 */
	Fenye<Student> selesctStudent(Fenye<Student> fenye);
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
}
