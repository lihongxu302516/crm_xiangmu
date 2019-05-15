package com.crm.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.dao.JueseMapper;
import com.crm.dao.StudentMapper;
import com.crm.dao.UserMapper;
import com.crm.entity.Fenye;
import com.crm.entity.Juese;
import com.crm.entity.Student;
import com.crm.entity.User;
import com.crm.util.QuanZhongFenPei;

@Service
public class StudentServiceimp implements StudentService {
	@Autowired
	private StudentMapper studentMapper;
	@Autowired
	QuanZhongFenPei quanZhongFenPei;
	@Autowired
	JueseMapper juesemapper;
	@Autowired
	UserMapper usermapper;

	@Override
	public Fenye<Student> selesctStudent(HttpServletRequest request,Fenye<Student> fenye) {
		// TODO Auto-generated method stub
		User user = (User)request.getSession().getAttribute("user");
		List<Juese> juese = user.getJuese();
		int is=0;
		for(int i=0;i<juese.size();i++) {
			if(juese.get(i).getJs_name().equals("×ÉÑ¯Ê¦")||juese.get(i).getJs_name().equals("ÍøÂç×ÉÑ¯Ê¦")) {
				is++;
			}
		}
		if(is>0) {
			fenye.getT().setUs_id(user.getUs_id());
		}
		Integer selescCount = studentMapper.selescCount(fenye);
		fenye.setTotal(selescCount);
		List<Student> selesctStudent = studentMapper.selesctStudent(fenye);
		for (int i = 0; i < selesctStudent.size(); i++) {
			User zixunshi = studentMapper.selectUser_student_us_id(selesctStudent.get(i).getXs_zixunshi());
			User lururen = studentMapper.selectUser_student_us_id(selesctStudent.get(i).getXs_lururen());
			selesctStudent.get(i).setUs_zixunshi(zixunshi);
			selesctStudent.get(i).setUs_wangluozixunshi(lururen);
		}
		fenye.setRows(selesctStudent);
		return fenye;
	}

	@Override
	public Integer updateStudent(Student student) {
		// TODO Auto-generated method stub
		Integer updateStudent = studentMapper.updateStudent(student);
		return updateStudent;
	}

	@Override
	public Integer insertStudent(HttpServletRequest request,Student student) {
		// TODO Auto-generated method stub
		User user = (User)request.getSession().getAttribute("user");
		student.setXs_lururen(user.getUs_id());
		Integer selectJuese_zixunshi = juesemapper.selectJuese_zixunshi();
		List<User> selectUser_zixunshi = usermapper.selectUser_zixunshi(selectJuese_zixunshi);
		User fenpei = quanZhongFenPei.fenpei(selectUser_zixunshi);
		student.setXs_zixunshi(fenpei.getUs_id());
		Integer insertStudent = studentMapper.insertStudent(student);
		return insertStudent;
	}

	@Override
	public Integer deleteStudent(Integer xs_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer updateisyouxiao(Student student) {
		// TODO Auto-generated method stub
		Integer updateisyouxiao = studentMapper.updateisyouxiao(student);
		return updateisyouxiao;
	}

	@Override
	public Integer insertGenZong(Student student) {
		// TODO Auto-generated method stub
		return null;
	}

}
