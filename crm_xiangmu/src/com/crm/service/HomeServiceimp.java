package com.crm.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.dao.JueseMapper;
import com.crm.dao.StudentMapper;
import com.crm.entity.Juese;
import com.crm.entity.Mokuai;
import com.crm.entity.Student;
import com.crm.entity.User;
@Service
public class HomeServiceimp implements HomeService {
	@Autowired
	private StudentMapper studentmapper;
	@Autowired
	private JueseMapper juesemapper;

	private Mokuai mokuai3;

	@Override
	public String hometree(String treeUlId,HttpServletRequest requer) {
		// TODO Auto-generated method stub
		User user = (User)requer.getSession().getAttribute("user");//获得session中保存的user信息
		List<Juese> juese = user.getJuese();//获取用户的所有角色
		String jg="<ul id=\"treeUlId\" class=\"easyui-tree\">";//定义一个树形html代码的开头
		List<Mokuai> mokuai = juesemapper.select_juese_mokuai_js_ids(juese);//通过角色获取用户的所有模块
			for(int j=0;j<mokuai.size();j++) {//循环所有模块进行树html代码的一一拼接
				Mokuai mokuai2 = mokuai.get(j);//获得本次循环的模块
				if(mokuai2.getMk_fuid()==0) {//判断是否是最顶级模块节点
					//拼接一个子模块
					jg=jg+"<li>";
					jg=jg+"<span><a title=\""+mokuai2.getMk_id()+"\" onclick=\"navTab('"+mokuai2.getMk_name()+"','"+mokuai2.getMk_lujing()+"')\">"+mokuai2.getMk_name()+"</a></span>";
					jg = tree(jg, mokuai, mokuai2);//调用拼接此模块的子模块方法
					jg=jg+"</li>";
				}
			}
		//}
		jg=jg+"</ul>";
		return jg;
	}
	private String tree(String jg, List<Mokuai> mokuai, Mokuai mokuai2) {
		jg=jg+"<ul>";
		for(int j2=0;j2<mokuai.size();j2++) {//再次循环用户的所有模块
			mokuai3 = mokuai.get(j2);//获取此次循环的模块
			if(mokuai3.getMk_fuid()==mokuai2.getMk_id()) {//判断此次循环的模块父id是否和上个循环的模块id是否一样
				//一样拼接一个子模块
				jg=jg+"<li>";
				jg=jg+"<span><a title=\""+mokuai3.getMk_id()+"\" onclick=\"navTab('"+mokuai3.getMk_name()+"','"+mokuai3.getMk_lujing()+"')\">"+mokuai3.getMk_name()+"</a></span>";
				jg = tree(jg, mokuai, mokuai3);//递归，重复调用此方法直至拼接完所有的子模块
				jg=jg+"</li>";
			}
		}
		jg=jg+"</ul>";
		return jg;
	}
	@Override
	public String dongtaixueshengrizhi(HttpServletRequest request) {
		// TODO Auto-generated method stub
		User user=(User)request.getSession().getAttribute("user");//获取当前用户的所有信息
		List<Juese> juese = user.getJuese();//获取当前用户的所有角色
		String jg="";//声明返回的结果的字符串
		int is = 0;//声明一个变量is用于咨询师判断
		for (int i = 0; i < juese.size(); i++) {
			if (juese.get(i).getJs_name().equals("咨询师")) {
				//循环判断用户是否有咨询师这个角色，如果有的话将变量is++
				is++;
			} 
		}
		if(is>0) {//如果该角色下有咨询师is一定大于0
			List<Student> s = studentmapper.selectUser_Student_exe1_isbeixiugai(user.getUs_id());//通过用户的id去查看该咨询师下的所有被修改动态信息的学生
			studentmapper.updateStudent_exe1_isbeixiugai_user(user.getUs_id());//通过用户id把所有学生变为未修改状态
			if(s!=null) {//判断是否有被修改动态信息的学生
				for(int i=0;i<s.size();i++) {
					//循环将所有的学生id和姓名拼接成字符串
					if(i==0) {
						jg=jg+s.get(i).getXs_name()+"(学号："+s.get(i).getXs_id()+")";
					}else {
						jg=jg+","+s.get(i).getXs_name()+"(学号："+s.get(i).getXs_id()+")";
					}
				}
			}else {
				jg="2";//没有被修改动态信息的学生
			}	
		}else {
			jg="1";//该用户不是咨询师
		}
		return jg;
	}

}
