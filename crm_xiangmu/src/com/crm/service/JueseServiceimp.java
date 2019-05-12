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
		Integer selectJueseCount = jueseMapper.selectJueseCount(fenye);
		List<Juese> selectJueseAll = jueseMapper.selectJueseAll(fenye);
		fenye.setTotal(selectJueseCount);
		fenye.setRows(selectJueseAll);
		return fenye;
	}

	@Override
	public Integer insertJuese(Juese juese) {
		// TODO Auto-generated method stub
		return jueseMapper.insertJuese(juese);
	}

	@Override
	public Integer updateJuese(Juese juese) {
		// TODO Auto-generated method stub
		return jueseMapper.updateJuese(juese);
	}

	@Override
	public Integer deleteJuese(Integer js_id) {
		// TODO Auto-generated method stub
		return jueseMapper.deleteJuese(js_id);
	}

	@Override
	public List<Juese> selectJuese() {
		// TODO Auto-generated method stub
		return jueseMapper.selectJuese();
	}

	@Override
	public List<Juese> selectJuese_us_id(Integer us_id) {
		// TODO Auto-generated method stub
		return jueseMapper.selectJuese_us_id(us_id);
	}

	@Override
	public List<MokuaiTree> selectJuese_mktree(Integer js_id) {
		// TODO Auto-generated method stub
		List<MokuaiTree> mokuaiTreelist=new ArrayList<MokuaiTree>();
		List<Mokuai> mokuailist = mokuaiMapper.selectMokuaiAll();
		for (int i = 0; i < mokuailist.size(); i++) {
			if (mokuailist.get(i).getMk_fuid() == 0) {
				addtree(mokuaiTreelist, mokuailist, i,js_id);
			}
		}
		return mokuaiTreelist;
	}

	private void addtree(List<MokuaiTree> mokuaiTreelist, List<Mokuai> mokuailist, int i,Integer js_id) {
		MokuaiTree mk = new MokuaiTree();
		mk.setId(mokuailist.get(i).getMk_id());
		mk.setText(mokuailist.get(i).getMk_name());
		
		juese_mokuai.setJm_jueseid(js_id);
		juese_mokuai.setJm_mokuaiid(mokuailist.get(i).getMk_id());
		Integer selectMokuai_js_id = mokuaiMapper.selectMokuai_js_id(juese_mokuai);
		
		mk.setChecked(selectMokuai_js_id == 1);
		MokuaiTree fortree = fortree(mokuailist, i,mk,js_id);
		if(fortree!=null) {
			mokuaiTreelist.add(fortree);
		}
	}

	private MokuaiTree fortree(List<Mokuai> mokuailist, int i,MokuaiTree mk,Integer js_id) {
		List<MokuaiTree> treelist = new ArrayList<MokuaiTree>();
		for (int j = 0; j < mokuailist.size(); j++) {
			if (mokuailist.get(j).getMk_fuid() == mokuailist.get(i).getMk_id()) {
				addtree(treelist, mokuailist, j,js_id);
			}
		}
		mk.setChildren(treelist);
		return mk;
	}

	@Override
	public Integer xiugaiJuese_mokuai(String mkids, Integer js_id) {
		// TODO Auto-generated method stub
		String[] split = mkids.split(",");
		List<Mokuai> mkall = mokuaiMapper.selectMokuai_js_idAll(js_id);
		List<Integer> you_li=new ArrayList<Integer>();
		List<Integer> wu_li=new ArrayList<Integer>();
		for(int i=0;i<mkall.size();i++) {
			for(int j=0;j<split.length;i++) {
				if(mkall.get(i).getMk_id()==Integer.parseInt(split[j])) {
					you_li.add(Integer.parseInt(split[j]));
				}else {
					wu_li.add(Integer.parseInt(split[j]));
				}
			}
		}
		System.out.println(you_li);
		System.out.println(wu_li);
		
		
		
		return null;
	}


}
