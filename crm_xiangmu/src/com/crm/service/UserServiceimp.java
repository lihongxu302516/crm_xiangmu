package com.crm.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.dao.JueseMapper;
import com.crm.dao.LoginMapper;
import com.crm.dao.UserMapper;
import com.crm.entity.Fenye;
import com.crm.entity.IndustrySMS;
import com.crm.entity.User;
import com.crm.entity.User_juese;
import com.crm.util.DigestUtil;
import com.crm.util.ShijianQujian;

@Service
public class UserServiceimp implements UserService {
	@Autowired
	UserMapper usermapper;
	@Autowired
	LoginMapper loginMapper;
	@Autowired
	JueseMapper jueseMapper;
	@Autowired
	ShijianQujian shijianQujian;
	@Autowired
	DigestUtil digestUtil;

	@Override
	public Fenye<User> selectUserAll(Fenye<User> fenye) {
		// TODO Auto-generated method stub
		//111
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

	@Override
	public Integer updateUser_daka(HttpServletRequest request) {
		// TODO Auto-generated method stub
		User user = (User)request.getSession().getAttribute("user");
		String sj = getdangqianshijian();
		user.setUs_dakatime(sj);
		boolean is_shijianq = shijianQujian.is_shijianq("8:00", "9:00");
		if(is_shijianq) {
			user.setUs_isdaka(1);
		}else {
			user.setUs_isdaka(3);
		}
		Integer updateUser_daka = usermapper.updateUser_daka(user);
		if(updateUser_daka>0) {
			usermapper.insertqiandaorizhi(user);
		}
		return updateUser_daka;
	}

	@Override
	public Integer updateUser_qiantui_dan(Integer us_id) {
		// TODO Auto-generated method stub
		return usermapper.updateUser_qiantui_dan(us_id);
	}

	@Override
	public Integer updateUser_qiantui_duo(String us_ids) {
		// TODO Auto-generated method stub
		List<Integer> list=new ArrayList<Integer>();
		String[] split = us_ids.split(",");
		for(int i=0;i<split.length;i++) {
			list.add(Integer.parseInt(split[i]));
		}
		return usermapper.updateUser_qiantui_duo(list);
	}

	@Override
	public Integer updateUser_qiantui_quan() {
		// TODO Auto-generated method stub
		return usermapper.updateUser_qiantui_quan();
	}

	@Override
	public Integer updateUser_ygxx(User user) {
		// TODO Auto-generated method stub
		return usermapper.updateUser_ygxx(user);
	}
	public Integer shoujihaoyanzheng(HttpServletRequest request) {
		User user = (User)request.getSession().getAttribute("user");
			if (user.getUs_shojihao()!=null && user.getUs_shojihao()!="" ) {
				if(user.getUs_shojihao().length()==11) {
					int yanzhengma = (int) (Math.random() * (999999 - 100000 + 1) + 100000);
					IndustrySMS.execute(user.getUs_shojihao(), yanzhengma);
					request.getSession().setAttribute("yanzhengma", yanzhengma);
					return 0;
				}else {
					return 2;
				}
			} else {
				return 1;
			}
	}

	@Override
	public Integer updateUser_password(HttpServletRequest request,String us_yan_pas,String us_xin_pas2,String yanzhengma) {
		// TODO Auto-generated method stub
		User user = (User)request.getSession().getAttribute("user");
		if(yanzhengma!=null && yanzhengma!="") {
			if(request.getSession().getAttribute("yanzhengma").toString().equals(yanzhengma.trim())) {
				if(user.getUs_password().equals(digestUtil.string2MD5(us_yan_pas))) {
					String string2md5 = digestUtil.string2MD5(us_xin_pas2);
					user.setUs_password(string2md5);
					request.getSession().setAttribute("user", user);
					Integer updateUser_password = usermapper.updateUser_password(user);
					return updateUser_password;
				}else {
					return 4;
				}
			}else {
				return 3;
			}
		}else {
			return 2;
		}
	}

	@Override
	public Integer cz_shoujihaoyanzheng(HttpServletRequest request,String us_name) {
		// TODO Auto-generated method stub
		Integer jg=0;
		us_name=us_name.trim();
		if(us_name!=null && us_name!="") {
			User user = usermapper.selectUser_us_name_shoujihao(us_name);
			String us_shoujihao=user.getUs_shojihao();
			if(us_shoujihao!=null && us_shoujihao!="") {
				if(us_shoujihao.length()==11) {
					int yanzhengma = (int) (Math.random() * (999999 - 100000 + 1) + 100000);
					IndustrySMS.execute(us_shoujihao, yanzhengma);
					request.getSession().setAttribute("cz_yanzhengma", yanzhengma);
					request.getSession().setAttribute("cz_mima_us_id", user.getUs_id());
					jg=4;
				}else {
					//该用户绑定的手机号不符合格式
					jg=3;
				}
			}else {
				//没有该用户或该用户没有绑定手机号
				jg=2;
			}
		}else {
			//用户名为空
			jg=1;
		}
		return jg;
	}

	@Override
	public Integer user_cz_mima(HttpServletRequest request, String us_sj_yzm) {
		// TODO Auto-generated method stub
		Integer jg=0;
		us_sj_yzm=us_sj_yzm.trim();
		if(us_sj_yzm!=null && us_sj_yzm!="") {
			String cz_yanzhengma = request.getSession().getAttribute("cz_yanzhengma").toString();
			String cz_mima_us_id = request.getSession().getAttribute("cz_mima_us_id").toString();
			if(cz_yanzhengma.equals(us_sj_yzm)) {
				jg = usermapper.updatechongzhimima(Integer.parseInt(cz_mima_us_id));
			}else {
				//验证码错误
				jg=3;
			}
		}else {
			//验证码为空
			jg=2;
		}
		return jg;
	}

	@Override
	public List<User> zixunshi_all() {
		// TODO Auto-generated method stub
		Integer uj_userid = jueseMapper.selectJuese_zixunshi();
		List<User> selectUser_zixunshi = usermapper.selectUser_zixunshi(uj_userid);
		for(int i=0;i<selectUser_zixunshi.size();i++) {
			if(selectUser_zixunshi.get(i).getUs_isdaka()==2) {
				selectUser_zixunshi.get(i).setUs_name(selectUser_zixunshi.get(i).getUs_name()+"(未签到)");
			}
		}
		return selectUser_zixunshi;
	}
}
