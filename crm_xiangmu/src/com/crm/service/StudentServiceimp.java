package com.crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.dao.StudentMapper;
import com.crm.entity.Fenye;
import com.crm.entity.Student;

@Service
public class StudentServiceimp implements StudentService {
	@Autowired
	private StudentMapper studentMapper;

	@Override
	public Fenye<Student> selesctStudent(Fenye<Student> fenye) {
		// TODO Auto-generated method stub
		List selesctStudent = studentMapper.selesctStudent(fenye);
		fenye.setRows(selesctStudent);
		Integer selescCount = studentMapper.selescCount(fenye);
		fenye.setTotal(selescCount);
		return fenye;
	}

	@Override
	public Integer selescCount(Fenye<Student> fenye) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer updateStudent(Student student) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer insertStudent(Student student) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer deleteStudent(Integer xs_id) {
		// TODO Auto-generated method stub
		return null;
	}

}
