package com.crm.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.dao.JueseMapper;
import com.crm.dao.MokuaiMapper;
import com.crm.entity.Fenye;
import com.crm.entity.Juese;
import com.crm.entity.Juese_mokuai;
import com.crm.entity.Mokuai;
import com.crm.entity.MokuaiTree;

@Service
public class JueseServiceimp implements JueseService {
	@Autowired
	JueseMapper jueseMapper;
	@Autowired
	MokuaiMapper mokuaiMapper;
	@Autowired
	Juese_mokuai juese_mokuai;

	@Override
	public Fenye<Juese> selectJueseAll(Fenye<Juese> fenye) {
		// TODO Auto-generated method stub
		// ��ѯ���еĽ�ɫ��Ϣ��ҳ��ʾ
		Integer selectJueseCount = jueseMapper.selectJueseCount(fenye);// �鿴���з��������ĵĽ�ɫ��������
		List<Juese> selectJueseAll = jueseMapper.selectJueseAll(fenye);// �鿴��ǰҳ����������
		fenye.setTotal(selectJueseCount);// ����������total�У�easyui������������total
		fenye.setRows(selectJueseAll);// �����ݷ���rows��easyui��������rows
		return fenye;
	}

	@Override
	public Integer insertJuese(Juese juese) {
		// TODO Auto-generated method stub
		// ���һ����ɫ
		Integer select_juese_name_chongfu = jueseMapper.select_juese_name_chongfu(juese);// �鿴����ӵĽ�ɫ�Ƿ�����
		if (select_juese_name_chongfu == 0) {// �ж��Ƿ�������������Ϊ0
			Integer insertJuese = jueseMapper.insertJuese(juese);// ���һ����ɫ
			return insertJuese;// ���سɹ�1
		} else {
			return -1;// ��������-1
		}
	}

	@Override
	public Integer updateJuese(Juese juese) {
		// TODO Auto-generated method stub
		// �޸�һ����ɫ
		Integer select_juese_name_chongfu = jueseMapper.select_juese_name_chongfu(juese);// �鿴�޸ĵĽ�ɫ�Ƿ����������鿴���Ƿ��Լ������ݣ���ֹδ�޸����Ƴ��ֵ�����
		if (select_juese_name_chongfu == 0) {// �ж��Ƿ�������������Ϊ0
			return jueseMapper.updateJuese(juese);// �޸�һ����ɫ�����سɹ�1
		} else {
			return -1;// ��������-1
		}
	}

	@Override
	public Integer deleteJuese(Integer js_id) {
		// TODO Auto-generated method stub
		// ɾ��һ����ɫ
		Integer select_Juese_is_User = jueseMapper.select_Juese_is_User(js_id);// ��ѯ�ý�ɫ���Ƿ����Ա��
		if (select_Juese_is_User == 0) {// �ж��Ƿ����Ա�������������Ϊ0
			Integer select_Juese_is_Mokuai = jueseMapper.select_Juese_is_Mokuai(js_id);
			if (select_Juese_is_Mokuai == 0) {
				return jueseMapper.deleteJuese(js_id);// ����Ա���Ļ�ɾ���ý�ɫ���ɹ�����1
			} else {
				return -2;
			}
		} else {
			return -1;// ����Ա������-1�������û������Ա��
		}
	}

	@Override
	public List<Juese> selectJuese(Integer us_id) {
		// TODO Auto-generated method stub
		// �鿴���н�ɫ������ҳ
		return jueseMapper.selectJuese(us_id);
	}

	@Override
	public List<Juese> selectJuese_us_id(Integer us_id) {
		// TODO Auto-generated method stub
		// �����û���id�鿴����û������н�ɫ
		return jueseMapper.selectJuese_us_id(us_id);
	}

	@Override
	public List<MokuaiTree> selectJuese_mktree(Integer js_id) {
		// TODO Auto-generated method stub
		// �鿴��ɫ��ģ����
		List<MokuaiTree> mokuaiTreelist = new ArrayList<MokuaiTree>();// ����ģ������list����
		List<Mokuai> mokuailist = mokuaiMapper.selectMokuaiAll();// �鿴���е�ģ��
		for (int i = 0; i < mokuailist.size(); i++) {// ѭ�����е�ģ��
			if (mokuailist.get(i).getMk_fuid() == 0) {// �жϸ�ģ���Ƿ�������ڵ�
				addtree(mokuaiTreelist, mokuailist, i, js_id);// �������ģ�����ķ���
			}
		}
		return mokuaiTreelist;// ����ģ������list����
	}

	private void addtree(List<MokuaiTree> mokuaiTreelist, List<Mokuai> mokuailist, int i, Integer js_id) {
		MokuaiTree mk = new MokuaiTree();// ����һ��ģ�����Ķ���
		mk.setId(mokuailist.get(i).getMk_id());// ������ѭ����ģ��idд�뵽ģ����������
		mk.setText(mokuailist.get(i).getMk_name());// ������ѭ����ģ������д�뵽ģ����������

		juese_mokuai.setJm_jueseid(js_id);// ����ɫidд�뵽��ɫģ�������
		juese_mokuai.setJm_mokuaiid(mokuailist.get(i).getMk_id());// ��ģ��idд�뵽��ɫģ�������
		Integer selectMokuai_js_id = mokuaiMapper.selectMokuai_js_id(juese_mokuai);// �����ɫģ����󣬸��ݽ�ɫid��ģ��id�鿴�ý�ɫ�Ƿ�ӵ�д�ģ��

		Integer selectMokuai_isyouzi = mokuaiMapper.selectMokuai_isyouzi(mokuailist.get(i).getMk_id());// �鿴��ģ�����Ƿ�����ģ��
		if (selectMokuai_isyouzi > 0) {// �ж��Ƿ�����ģ��
			mk.setChecked(false);// �������ģ�����������ѡ�񣬶���ͨ����ģ�����ѡ�񣬷�ֹѡ�и�ģ�����ģ��ȫ����ѡ��
		} else {
			mk.setChecked(selectMokuai_js_id == 1);// ���û����ģ����ж���1��ѡ�У������Ϊ1����ѡ�У�����ѡ��
		}

		MokuaiTree fortree = fortree(mokuailist, i, mk, js_id);// ������Ӵ�ģ������ģ��ķ���
		if (fortree != null) {// �ж��Ƿ��������ģ��
			mokuaiTreelist.add(fortree);// �������ˣ��ͽ���ģ����Ӹ�ģ������list����
		}
	}

	private MokuaiTree fortree(List<Mokuai> mokuailist, int i, MokuaiTree mk, Integer js_id) {
		List<MokuaiTree> treelist = new ArrayList<MokuaiTree>();// ����ģ������list����
		for (int j = 0; j < mokuailist.size(); j++) {// ѭ������ģ��
			if (mokuailist.get(j).getMk_fuid() == mokuailist.get(i).getMk_id()) {// �жϴ˴�ѭ����ģ�鸸id�Ƿ���ϴ�ѭ����ģ��id��ͬ
				addtree(treelist, mokuailist, j, js_id);// �����ͬ�����ϸ�ģ�����ģ�飬����ģ����ӷ���
			}
		}
		mk.setChildren(treelist);// ����ģ����list����д�뵽ģ������
		return mk;
	}

	@Override
	public Integer xiugaiJuese_mokuai(String mkids, Integer js_id) {
		// TODO Auto-generated method stub
		// �޸ĵ�ǰ��ɫ��ģ��
		if (mkids != null && mkids != "") {// �ж�ǰ̨�����ģ��id�ַ����Ƿ�Ϊ�գ���Ϊ����Ϊ��Ϊ�˰�ȫ��ֹ����
			String[] split = mkids.split(",");// ͨ�����ָ�����е�ģ��id
			List<Juese_mokuai> list = new ArrayList<Juese_mokuai>();// ����һ����ɫģ���list����
			for (int i = 0; i < split.length; i++) {// ѭ��ģ��id������
				Juese_mokuai jm = new Juese_mokuai();// ����һ����ɫģ�����
				jm.setJm_mokuaiid(Integer.parseInt(split[i]));// ���˴�ѭ����ģ��idд�뵽��ɫģ��
				jm.setJm_jueseid(js_id);// ����ɫidд�뵽��ɫģ����
				list.add(jm);// ����ɫģ�����list������
			}
			mokuaiMapper.deleteJuese_mokuai_js_id(js_id);// ��ɾ���ý�ɫ������ģ��
			mokuaiMapper.insertJuese_mokuai_js_id(list);// �ڰ����еĸý�ɫ��ģ��ȫ�������ȥ
		} else {// ���Ϊ�վ����������ɫû��ģ�飬����Ҫ�Ѹý�ɫ������ģ��ȫ��ɾ��
			mokuaiMapper.deleteJuese_mokuai_js_id(js_id);
		}
		return 1;// ���سɹ�1
	}
}
