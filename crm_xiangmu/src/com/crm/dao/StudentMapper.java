package com.crm.dao;

import java.util.List;


import com.crm.entity.Dongtai;
import com.crm.entity.Fenye;
import com.crm.entity.Genzongrizhi;
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
	 * ɾ�����ѧ��
	 * @param list
	 * @return
	 */
	Integer deleteStudent_duo(List<Integer> list);
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
	Integer insertGenZong(Genzongrizhi genzongrizhi);
	/**
	 * �鿴�Ƿ��Զ�����
	 * @return
	 */
	Integer selectGongneng_zdfp();
	/**
	 * �޸��Զ�����
	 * @param gn_iskaiqi
	 * @return
	 */
	Integer updateGongneng_zdfp(Integer gn_iskaiqi);
	/**
	 * ��ѧ��������ѯʦ
	 * @param student
	 * @return
	 */
	Integer updateStudent_zixunshi(Student student);
	/**
	 * ������ѧ��������ѯʦ
	 * @param student
	 * @return
	 */
	Integer pl_updateStudent_zixunshi(Student student);
	/**
	 * ��ѯ����ѡ���ѧ��
	 * @param list
	 * @return
	 */
	List<Student> selectStudent_xuanzhong(List<Integer> list);
	/**
	 * ��Ӷ�̬��־
	 * @param request
	 * @param dt
	 * @return
	 */
	Integer tianjia_dongtairizhi(Dongtai dt);
	/**
	 * �鿴��ѧ���Ķ�̬��־
	 * @param dt_student
	 * @return
	 */
	List<Dongtai> selectDongtai_stu_id(Fenye<Dongtai> fenye);
	/**
	 * ͨ��ѧ��id����ѧ���Ƿ��޸�
	 * @param student
	 * @return
	 */
	Integer updateStudent_exe1_isbeixiugai(Student student);
	/**
	 * ͨ���û�id����ѧ���Ƿ��޸�
	 * @param student
	 * @return
	 */
	Integer updateStudent_exe1_isbeixiugai_user(Integer us_id);
	/**
	 * �鿴����ѯʦ�µ�ѧ���Ƿ��б��޸�
	 * @param us_id
	 * @return
	 */
	List<Student> selectUser_Student_exe1_isbeixiugai(Integer us_id);
	/**
	 * ����ѧ��id�鿴������־
	 * @param fenye
	 * @return
	 */
	List<Genzongrizhi> selectGengzongrizhi_xs_id(Fenye<Genzongrizhi> fenye);
}
