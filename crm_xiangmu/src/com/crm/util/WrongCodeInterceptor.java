package com.crm.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.crm.dao.LoginMapper;
import com.crm.entity.Juese;
import com.crm.entity.Mokuai;
import com.crm.entity.User;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class WrongCodeInterceptor implements HandlerInterceptor {
	@Autowired
	LoginMapper loginMapper;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if (request.getSession().getAttribute("user") == null) {
			request.getRequestDispatcher("login").forward(request, response);
		} else {
			User user = new User();
			user = loginMapper.selectUser_Login_password((User)request.getSession().getAttribute("user"));
			System.out.println("++++"+user);
			System.out.println(user.getUs_id());
			List<Juese> selectJuese = loginMapper.selectJuese(user.getUs_id());
			for (int i = 0; i < selectJuese.size(); i++) {
				List<Mokuai> selectMokuai = loginMapper.selectMokuai(selectJuese.get(i).getJs_id());
				selectJuese.get(i).setMokuai(selectMokuai);
			}
			user.setJuese(selectJuese);
			request.getSession().setAttribute("user", user);
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

	}

}
