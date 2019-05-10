package com.crm.dao;

import com.crm.entity.Fenye;
import com.crm.entity.Student;

public interface StudentMapper {
	/**
	 * ��ѯѧ��
	 * @param fenye
	 * @return
	 */
	Fenye<Student> selesctStudent(Fenye<Student> fenye);
	/**
	 * ��ѯ������
	 * @param fenye
	 * @return
	 */
	Integer selescCount(Fenye<Student> fenye);
	/**
	 * �޸�һ��ѧ��
	 * @param student
	 * @return
	 */
	Integer updateStudent(Student student);
	/**
	 * ���һ��ѧ��
	 * @param student
	 * @return
	 */
	Integer insertStudent(Student student);
	/**
	 * ɾ��һ��ѧ��
	 * @param student
	 * @return
	 */
	Integer deleteStudent(Integer xs_id);
}
