package com.crm.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.crm.entity.Fenye;
import com.crm.entity.User;
import com.crm.service.UserService;

@Controller
public class UserController {
	@Autowired
	UserService userServiceimp; 
	@Autowired
	Fenye<User> fenye;
	
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

}
