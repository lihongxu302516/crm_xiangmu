package com.crm.service;

import javax.servlet.http.HttpServletRequest;

import com.crm.entity.Fenye;
import com.crm.entity.Student;

public interface StudentService {
	/**
	 * ��ѯѧ��
	 * @param fenye
	 * @return
	 */
	Fenye<Student> selesctStudent(HttpServletRequest request,Fenye<Student> fenye);
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
	Integer insertStudent(HttpServletRequest request,Student student);
	/**
	 * ɾ��һ��ѧ��
	 * @param student
	 * @return
	 */
	Integer deleteStudent(Integer xs_id);
	/**
	 * �޸��Ƿ���Ч
	 * @param student
	 * @return
	 */
	Integer updateisyouxiao(Student student);
	/**
	 * ��Ӹ�����Ϣ
	 */
	Integer insertGenZong(Student student);
}
