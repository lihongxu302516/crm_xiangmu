package com.crm.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.crm.entity.Fenye;
import com.crm.entity.Juese;
import com.crm.entity.User;
import com.crm.entity.User_juese;
import com.crm.service.JueseService;
import com.crm.service.UserService;

@Controller
public class UserController {
	@Autowired
	UserService userServiceimp; 
	@Autowired
	Fenye<User> fenye;
	@Autowired
	JueseService jueseServiceimp;
	
	@RequestMapping(value = "yonghu_guanli")
	public String user() {
		return "yonghu_guanli";
	}
	@RequestMapping(value = "yonghuxianshi",method = RequestMethod.POST)
	@ResponseBody
	public Fenye<User> yonghuxianshi(User user,Integer page,Integer rows) {
		fenye.setPage(page);
		fenye.setLimit(rows);
		fenye.setT(user);
		return userServiceimp.selectUserAll(fenye);
	}
	@RequestMapping(value = "suodingyonghu",method = RequestMethod.POST)
	@ResponseBody
	public Integer suodingyonghu(User user) {
		return userServiceimp.updatesuodingyonghu(user);
	}
	@RequestMapping(value = "chongzhimima",method = RequestMethod.POST)
	@ResponseBody
	public Integer chongzhimima(Integer us_id) {
		return userServiceimp.updatechongzhimima(us_id);
	}
	@RequestMapping(value = "user_tianjia",method = RequestMethod.POST)
	@ResponseBody
	public Integer user_tianjia(User user) {
		return userServiceimp.insertUser(user);
	}
	@RequestMapping(value = "user_xiugai",method = RequestMethod.POST)
	@ResponseBody
	public Integer user_xiugai(User user) {
		return userServiceimp.updateUser(user);
	}
	@RequestMapping(value = "user_shanchu",method = RequestMethod.POST)
	@ResponseBody
	public Integer user_shanchu(Integer us_id) {
		return userServiceimp.deleteUser(us_id);
	}
	@RequestMapping(value = "chakan_user_jueseall",method = RequestMethod.POST)
	@ResponseBody
	public List<Juese> chakan_user_jueseall() {
		return jueseServiceimp.selectJuese();
	}
	@RequestMapping(value = "chakan_user_juese_us_id",method = RequestMethod.POST)
	@ResponseBody
	public List<Juese> chakan_user_juese_us_id(Integer us_id) {
		return jueseServiceimp.selectJuese_us_id(us_id);
	}
	@RequestMapping(value = "user_juese_tianjia",method = RequestMethod.POST)
	@ResponseBody
	public Integer user_juese_tianjia(User_juese uj) {
		return userServiceimp.insertuser_juese(uj);
	}
	@RequestMapping(value = "user_juese_shanchu",method = RequestMethod.POST)
	@ResponseBody
	public Integer user_juese_shanchu(User_juese uj) {
		return userServiceimp.deleteuser_juese(uj);
	}
	@RequestMapping(value = "user_daka",method = RequestMethod.POST)
	@ResponseBody
	public Integer user_daka(HttpServletRequest request) {
		return userServiceimp.updateUser_daka(request);
	}
	@RequestMapping(value = "updateUser_qiantui_dan",method = RequestMethod.POST)
	@ResponseBody
	public Integer updateUser_qiantui_dan(Integer us_id) {
		return userServiceimp.updateUser_qiantui_dan(us_id);
	}
	@RequestMapping(value = "updateUser_qiantui_duo",method = RequestMethod.POST)
	@ResponseBody
	public Integer updateUser_qiantui_duo(String us_ids) {
		return userServiceimp.updateUser_qiantui_duo(us_ids);
	}
	@RequestMapping(value = "updateUser_qiantui_quan",method = RequestMethod.POST)
	@ResponseBody
	public Integer updateUser_qiantui_quan() {
		return userServiceimp.updateUser_qiantui_quan();
	}
	@RequestMapping(value = "updateUser_ygxx",method = RequestMethod.POST)
	@ResponseBody
	public Integer updateUser_ygxx(User user) {
		return userServiceimp.updateUser_ygxx(user);
	}
	@RequestMapping(value = "shoujihaoyanzheng",method = RequestMethod.POST)
	@ResponseBody
	public Integer shoujihaoyanzheng(HttpServletRequest request) {
		return userServiceimp.shoujihaoyanzheng(request);
	}
	@RequestMapping(value = "updateUser_password",method = RequestMethod.POST)
	@ResponseBody
	public Integer updateUser_password(HttpServletRequest request,String us_yan_pas,String us_xin_pas2,String yanzhengma) {
		return userServiceimp.updateUser_password(request,us_yan_pas,us_xin_pas2, yanzhengma);
	}
	@RequestMapping(value = "cz_shoujihaoyanzheng",method = RequestMethod.POST)
	@ResponseBody
	public Integer cz_shoujihaoyanzheng(HttpServletResponse response,HttpServletRequest request,String us_name) {
		return userServiceimp.cz_shoujihaoyanzheng(request, us_name);
	}
	@RequestMapping(value = "user_cz_mima",method = RequestMethod.POST)
	@ResponseBody
	public Integer user_cz_mima(HttpServletResponse response,HttpServletRequest request,String us_sj_yzm) {
		return userServiceimp.user_cz_mima(request, us_sj_yzm);
	}

}
