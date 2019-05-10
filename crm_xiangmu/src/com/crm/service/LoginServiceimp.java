package com.crm.service;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.dao.LoginMapper;
import com.crm.entity.Juese;
import com.crm.entity.Mokuai;
import com.crm.entity.User;
import com.crm.util.CookiesUtil;
import com.crm.util.DigestUtil;
import com.crm.util.SCaptcha;
@Service
public class LoginServiceimp implements LoginService {
	@Autowired
	LoginMapper loginMapper;
	@Autowired
	DigestUtil digestUtil;
	@Autowired
	User user;
	@Autowired
	CookiesUtil cookiesUtil;

	@Override
	public Integer Login_service(User user,String yanzhengma,HttpServletRequest request,HttpServletResponse response) {
		// TODO Auto-generated method stub
		int jg=0;
		String us_name=user.getUs_name();
		if(request.getSession().getAttribute("yanzhengmatext").equals(yanzhengma)) {
			if(loginMapper.selectUser_Login_username(us_name)==1) {
				if(!"0".equals(yanzhengma)) {
					user.setUs_password(digestUtil.string2MD5(user.getUs_password()));
				}
				user = loginMapper.selectUser_Login_password(user);
				if(user!=null) {
					if(user.getUs_issuoding()==2) {
						SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
						String sj = df.format(new Date());
						user.setUs_zuihoutime(sj);
						loginMapper.updatezuihoudenglutime(user);
						user=loginMapper.selectUser_Login_password(user);
						if(!"0".equals(yanzhengma)) {
							cookiesUtil.setCookie(response, "us_name", us_name,7*24*60*60);
							cookiesUtil.setCookie(response, "us_password", user.getUs_password(),7*24*60*60);
						}
						List<Juese> selectJuese = loginMapper.selectJuese(user.getUs_id());
						for(int i=0;i<selectJuese.size();i++) {
							List<Mokuai> selectMokuai = loginMapper.selectMokuai(selectJuese.get(i).getJs_id());
							selectJuese.get(i).setMokuai(selectMokuai);
						}
						user.setJuese(selectJuese);
						request.getSession().setAttribute("user", user);
					}else {
						jg=4;
					}
				}else {
					jg=3;
				}
			}else {
				jg=2;
			}
		}else {
			jg=1;
		}
		if(jg==3) {
			loginMapper.updatemimacuowucishujiayi(us_name);
			Integer selectmimacuowucishu = loginMapper.selectmimacuowucishu(us_name);
			if(selectmimacuowucishu>=3) {
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
				String sj = df.format(new Date());
				this.user.setUs_suodingtime(sj);
				this.user.setUs_name(us_name);
				loginMapper.updatesuodinguser_us_name(this.user);
				jg=5;
			}
		}
		return jg;
	}

	@Override
	public void tupianyanzhengma_service(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		/*
		 * 1.生成验证码 2.把验证码上的文本存在session中 3.把验证码图片发送给客户端
		 */
		SCaptcha ivc = new SCaptcha(); // 用我们的验证码类，生成验证码类对象
		BufferedImage image = ivc.getImage();
		request.getSession().setAttribute("yanzhengmatext", ivc.getText()); // 将验证码的文本存在session中
		// System.out.println(request.getSession().getAttribute("yanzhengmatext"));
		try {
			ivc.output(image, response.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 将验证码图片响应给客户端

	}

}
