package com.crm.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.crm.entity.Juese;
import com.crm.entity.Mokuai;
import com.crm.entity.User;
@Service
public class HomeServiceimp implements HomeService {

	private Mokuai mokuai3;

	@Override
	public String hometree(String treeUlId,HttpServletRequest requer) {
		// TODO Auto-generated method stub
		User user = (User)requer.getSession().getAttribute("user");
		List<Juese> juese = user.getJuese();
		String jg="<ul id=\"treeUlId\" class=\"easyui-tree\"><li>";
		for(int i=0;i<juese.size();i++) {
			List<Mokuai> mokuai = juese.get(i).getMokuai();
			for(int j=0;j<mokuai.size();j++) {
				Mokuai mokuai2 = mokuai.get(j);
				if(mokuai2.getMk_fuid()==0) {
					jg=jg+"<span><a title=\""+mokuai2.getMk_id()+"\" onclick=\"navTab('"+mokuai2.getMk_name()+"','')\">"+mokuai2.getMk_name()+"</a></span>";
					jg = tree(jg, mokuai, mokuai2);
				}
			}
		}
		jg=jg+"</li></ul>";
		return jg;
	}
	private String tree(String jg, List<Mokuai> mokuai, Mokuai mokuai2) {
		jg=jg+"<ul>";
		for(int j2=0;j2<mokuai.size();j2++) {
			mokuai3 = mokuai.get(j2);
			if(mokuai3.getMk_fuid()==mokuai2.getMk_id()) {
				jg=jg+"<li>";
				jg=jg+"<span><a title=\""+mokuai3.getMk_id()+"\" onclick=\"navTab('"+mokuai3.getMk_name()+"','"+mokuai3.getMk_lujing()+"')\">"+mokuai3.getMk_name()+"</a></span>";
				jg = tree(jg, mokuai, mokuai3);
				jg=jg+"</li>";
			}
		}
		jg=jg+"</ul>";
		return jg;
	}

}
