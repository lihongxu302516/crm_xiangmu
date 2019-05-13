package com.crm.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.crm.entity.Fenye;
import com.crm.entity.Student;
import com.crm.service.StudentService;

@Controller
public class StudentController {
	@Autowired
	private StudentService studentService;
	@Autowired
	private Fenye<Student> fenye;
	
	@RequestMapping(value = "student_guanli")
	public String student(HttpServletRequest request) {
		return "student_guanli";
	}
	@RequestMapping(value = "student_xianshi",method = RequestMethod.POST)
	@ResponseBody
	public Fenye<Student> student_xianshi(Integer page,Integer rows,Student student){
		fenye.setPage(page);
		fenye.setLimit(rows);
		fenye.setT(student);
		fenye = studentService.selesctStudent(fenye);
		return fenye;
	}
}
