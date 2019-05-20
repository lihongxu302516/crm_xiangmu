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
	 * ɾ�����ѧ��
	 * @param list
	 * @return
	 */
	Integer deleteStudent_duo(String xs_ids);
	/**
	 * �޸��Ƿ���Ч
	 * @param student
	 * @return
	 */
	Integer updateisyouxiao(Student student);
	/**
	 * ��Ӹ�����Ϣ
	 */
	Integer insertGenZong(Genzongrizhi genzongrizhi,HttpServletRequest request);
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
	 * ����excel
	 * @param request
	 * @return
	 * @throws IOException 
	 */
	void daochuexcel(HttpServletRequest request,HttpServletResponse response,String xs_ids) throws IOException;
	/**
	 * ��Ӷ�̬��־
	 * @param request
	 * @param dt
	 * @return
	 */
	Integer tianjia_dongtairizhi(HttpServletRequest request,Dongtai dt);
	/**
	 * �鿴��ѧ���Ķ�̬��־
	 * @param dt_student
	 * @return
	 */
	Fenye<Dongtai> selectDongtai_stu_id(Fenye<Dongtai> fenye);
	/**
	 * ����ѧ��id�鿴������־
	 * @param fenye
	 * @return
	 */
	Fenye<Genzongrizhi> selectGengzongrizhi_xs_id(Fenye<Genzongrizhi> fenye);
}
