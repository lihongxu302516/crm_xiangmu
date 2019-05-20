package com.crm.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.crm.entity.Dongtai;
import com.crm.entity.Fenye;
import com.crm.entity.Genzongrizhi;
import com.crm.entity.Student;
import com.crm.entity.User;
import com.crm.service.StudentService;

@Controller
public class StudentController {
	@Autowired
	private StudentService studentService;
	@Autowired
	private Fenye<Student> fenye;
	@Autowired
	private Fenye<Dongtai> fenye_dong;
	@Autowired
	private Fenye<Genzongrizhi> fenye_gen;
	
	@RequestMapping(value = "student_guanli")
	public String student(HttpServletRequest request) {
		return "student_guanli";
	}
	@RequestMapping(value = "student_shanchu")
	public String student_shanchu() {
		return "student_shanchu";
	}
	@RequestMapping(value = "student_xianshi",method = RequestMethod.POST)
	@ResponseBody
	public Fenye<Student> student_xianshi(HttpServletRequest request,Integer page,Integer rows,Student student){
		fenye.setPage(page);
		fenye.setLimit(rows);
		fenye.setT(student);
		fenye = studentService.selesctStudent(request,fenye);
		return fenye;
	}
	@RequestMapping(value = "updateisyouxiao",method = RequestMethod.POST)
	@ResponseBody
	public Integer updateisyouxiao(Student student) {
		Integer updateisyouxiao = studentService.updateisyouxiao(student);
		return updateisyouxiao;
		
	}
	@RequestMapping(value = "updateStudnet",method = RequestMethod.POST)
	@ResponseBody
	public Integer updateStudnet(Student student) {
		System.out.println(student);
		Integer updateStudent = studentService.updateStudent(student);
		return updateStudent;
	}
	@RequestMapping(value = "insertStudnet",method = RequestMethod.POST)
	@ResponseBody
	public Integer insertStudnet(HttpServletRequest request,Student student) {
		Integer insertStudent = studentService.insertStudent(request,student);
		return insertStudent;
	}
	@RequestMapping(value = "Gongneng_zdfp",method = RequestMethod.POST)
	@ResponseBody
	public Integer Gongneng_zdfp() {
		return studentService.selectGongneng_zdfp();
	}
	@RequestMapping(value = "updateGongneng_zdfp",method = RequestMethod.POST)
	@ResponseBody
	public Integer updateGongneng_zdfp(Integer gn_iskaiqi) {
		return studentService.updateGongneng_zdfp(gn_iskaiqi);
	}
	@RequestMapping(value = "updateStudent_zixunshi",method = RequestMethod.POST)
	@ResponseBody
	public Integer updateStudent_zixunshi(Student student) {
		return studentService.updateStudent_zixunshi(student);
	}
	@RequestMapping(value = "insertGenZong",method = RequestMethod.POST)
	@ResponseBody
	public Integer insertGenZong(Genzongrizhi genzongrizhi,HttpServletRequest request) {
		return studentService.insertGenZong(genzongrizhi,request);
	}
	@RequestMapping(value = "daochuexcel")
	@ResponseBody
	public void daochuexcel(HttpServletRequest request,HttpServletResponse response,String xs_ids) throws IOException {
		studentService.daochuexcel(request, response, xs_ids);
	}
	@RequestMapping(value = "delectstudent_dan",method = RequestMethod.POST)
	@ResponseBody
	public Integer delectstudent_dan(Integer xs_id) {
		return studentService.deleteStudent(xs_id);
	}
	@RequestMapping(value = "deleteStudent_duo",method = RequestMethod.POST)
	@ResponseBody
	public Integer deleteStudent_duo(String xs_ids) {
		return studentService.deleteStudent_duo(xs_ids);
	}
	@RequestMapping(value = "tianjia_dongtairizhi",method = RequestMethod.POST)
	@ResponseBody
	public Integer tianjia_dongtairizhi(HttpServletRequest request,Dongtai dt) {
		return studentService.tianjia_dongtairizhi(request, dt);
	}
	@RequestMapping(value = "student_dtrz_xs",method = RequestMethod.POST)
	@ResponseBody
	public Fenye<Dongtai> student_dtrz_xs(Integer page,Integer rows,Dongtai dongtai) {
		fenye_dong.setPage(page);
		fenye_dong.setLimit(rows);
		fenye_dong.setT(dongtai);
		return studentService.selectDongtai_stu_id(fenye_dong);
	}
	@RequestMapping(value = "selectGengzongrizhi_xs_id",method = RequestMethod.POST)
	@ResponseBody
	public Fenye<Genzongrizhi> selectGengzongrizhi_xs_id(Integer page,Integer rows,User user,Student stu,Genzongrizhi gz){
		gz.setUs(user);
		gz.setStu(stu);
		fenye_gen.setPage(page);
		fenye_gen.setLimit(rows);
		fenye_gen.setT(gz);
		return studentService.selectGengzongrizhi_xs_id(fenye_gen);
	}
	
}
