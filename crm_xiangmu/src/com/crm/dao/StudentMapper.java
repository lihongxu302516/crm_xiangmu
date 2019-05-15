package com.crm.dao;

import java.util.List;

import com.crm.entity.Fenye;
import com.crm.entity.Student;
import com.crm.entity.User;

public interface StudentMapper {
	/**
	 * ��ѯѧ��
	 * @param fenye
	 * @return
	 */
	List<Student> selesctStudent(Fenye<Student> fenye);
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
	/**
	 * ����id��ѯ�û�
	 */
	User selectUser_student_us_id(Integer us_id);
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
