package com.crm.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.dao.JueseMapper;
import com.crm.dao.LoginMapper;
import com.crm.dao.UserMapper;
import com.crm.entity.Fenye;
import com.crm.entity.User;
import com.crm.entity.User_juese;

@Service
public class UserServiceimp implements UserService {
	@Autowired
	UserMapper usermapper;
	@Autowired
	LoginMapper loginMapper;
	@Autowired
	JueseMapper jueseMapper;

	@Override
	public Fenye<User> selectUserAll(Fenye<User> fenye) {
		// TODO Auto-generated method stub
		Integer selectUserCount = usermapper.selectUserCount(fenye);
		List<User> selectUserAll = usermapper.selectUserAll(fenye);
		fenye.setTotal(selectUserCount);
		fenye.setRows(selectUserAll);
		return fenye;
	}

	@Override
	public Integer updatesuodingyonghu(User user) {
		// TODO Auto-generated method stub
		if(user.getUs_issuoding()==1) {
			String sj = getdangqianshijian();
			user.setUs_suodingtime(sj);
		}
		return usermapper.updatesuodingyonghu(user);
	}

	private String getdangqianshijian() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String sj = df.format(new Date());
		return sj;
	}

	@Override
	public Integer updatechongzhimima(Integer us_id) {
		// TODO Auto-generated method stub
		return usermapper.updatechongzhimima(us_id);
	}

	@Override
	public Integer insertUser(User user) {
		// TODO Auto-generated method stub
		Integer jg=0;
		Integer selectUser_Login_username = loginMapper.selectUser_Login_username(user.getUs_name());
		if(selectUser_Login_username==0) {
			user.setUs_issuoding(2);
			user.setUs_passcuowucishu(0);
			String sj = getdangqianshijian();
			user.setUs_chuangjiantime(sj);
			user.setUs_pingfen(0);
			user.setUs_pingfenrenshu(0);
			Integer insertUser = usermapper.insertUser(user);
			jg=insertUser;
		}else {
			jg=-1;
		}
		return jg;
	}

	@Override
	public Integer updateUser(User user) {
		// TODO Auto-generated method stub
		return usermapper.updateUser(user);
	}

	@Override
	public Integer deleteUser(Integer us_id) {
		// TODO Auto-generated method stub
		Integer deleteUser = usermapper.deleteUser(us_id);
		if(deleteUser==1) {
			usermapper.deleteUser_Juese(us_id);
		}
		return deleteUser;
	}

	@Override
	public Integer insertuser_juese(User_juese uj) {
		// TODO Auto-generated method stub
		return usermapper.insertuser_juese(uj);
	}

	@Override
	public Integer deleteuser_juese(User_juese uj) {
		// TODO Auto-generated method stub
		return usermapper.deleteuser_juese(uj);
	}

}
