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
		User user = (User)requer.getSession().getAttribute("user");//���session�б����user��Ϣ
		List<Juese> juese = user.getJuese();//��ȡ�û������н�ɫ
		String jg="<ul id=\"treeUlId\" class=\"easyui-tree\">";//����һ������html����Ŀ�ͷ
		List<Mokuai> mokuai = juesemapper.select_juese_mokuai_js_ids(juese);//ͨ����ɫ��ȡ�û�������ģ��
			for(int j=0;j<mokuai.size();j++) {//ѭ������ģ�������html�����һһƴ��
				Mokuai mokuai2 = mokuai.get(j);//��ñ���ѭ����ģ��
				if(mokuai2.getMk_fuid()==0) {//�ж��Ƿ������ģ��ڵ�
					//ƴ��һ����ģ��
					jg=jg+"<li>";
					jg=jg+"<span><a title=\""+mokuai2.getMk_id()+"\" onclick=\"navTab('"+mokuai2.getMk_name()+"','"+mokuai2.getMk_lujing()+"')\">"+mokuai2.getMk_name()+"</a></span>";
					jg = tree(jg, mokuai, mokuai2);//����ƴ�Ӵ�ģ�����ģ�鷽��
					jg=jg+"</li>";
				}
			}
		//}
		jg=jg+"</ul>";
		return jg;
	}
	private String tree(String jg, List<Mokuai> mokuai, Mokuai mokuai2) {
		jg=jg+"<ul>";
		for(int j2=0;j2<mokuai.size();j2++) {//�ٴ�ѭ���û�������ģ��
			mokuai3 = mokuai.get(j2);//��ȡ�˴�ѭ����ģ��
			if(mokuai3.getMk_fuid()==mokuai2.getMk_id()) {//�жϴ˴�ѭ����ģ�鸸id�Ƿ���ϸ�ѭ����ģ��id�Ƿ�һ��
				//һ��ƴ��һ����ģ��
				jg=jg+"<li>";
				jg=jg+"<span><a title=\""+mokuai3.getMk_id()+"\" onclick=\"navTab('"+mokuai3.getMk_name()+"','"+mokuai3.getMk_lujing()+"')\">"+mokuai3.getMk_name()+"</a></span>";
				jg = tree(jg, mokuai, mokuai3);//�ݹ飬�ظ����ô˷���ֱ��ƴ�������е���ģ��
				jg=jg+"</li>";
			}
		}
		jg=jg+"</ul>";
		return jg;
	}
	@Override
	public String dongtaixueshengrizhi(HttpServletRequest request) {
		// TODO Auto-generated method stub
		User user=(User)request.getSession().getAttribute("user");//��ȡ��ǰ�û���������Ϣ
		List<Juese> juese = user.getJuese();//��ȡ��ǰ�û������н�ɫ
		String jg="";//�������صĽ�����ַ���
		int is = 0;//����һ������is������ѯʦ�ж�
		for (int i = 0; i < juese.size(); i++) {
			if (juese.get(i).getJs_name().equals("��ѯʦ")) {
				//ѭ���ж��û��Ƿ�����ѯʦ�����ɫ������еĻ�������is++
				is++;
			} 
		}
		if(is>0) {//����ý�ɫ������ѯʦisһ������0
			List<Student> s = studentmapper.selectUser_Student_exe1_isbeixiugai(user.getUs_id());//ͨ���û���idȥ�鿴����ѯʦ�µ����б��޸Ķ�̬��Ϣ��ѧ��
			studentmapper.updateStudent_exe1_isbeixiugai_user(user.getUs_id());//ͨ���û�id������ѧ����Ϊδ�޸�״̬
			if(s!=null) {//�ж��Ƿ��б��޸Ķ�̬��Ϣ��ѧ��
				for(int i=0;i<s.size();i++) {
					//ѭ�������е�ѧ��id������ƴ�ӳ��ַ���
					if(i==0) {
						jg=jg+s.get(i).getXs_name()+"(ѧ�ţ�"+s.get(i).getXs_id()+")";
					}else {
						jg=jg+","+s.get(i).getXs_name()+"(ѧ�ţ�"+s.get(i).getXs_id()+")";
					}
				}
			}else {
				jg="2";//û�б��޸Ķ�̬��Ϣ��ѧ��
			}	
		}else {
			jg="1";//���û�������ѯʦ
		}
		return jg;
	}

}
