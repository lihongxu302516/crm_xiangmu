package com.crm.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.dao.MokuaiMapper;
import com.crm.entity.Mokuai;
import com.crm.entity.MokuaiTree;

@Service
public class MokuaiServiceimp implements MokuaiService {
	@Autowired
	MokuaiMapper mokuaiMapper;

	@Override
	public List<MokuaiTree> selectMokuaiAll() {
		// TODO Auto-generated method stub
		List<MokuaiTree> mokuaiTreelist=new ArrayList<MokuaiTree>();
		List<Mokuai> mokuailist = mokuaiMapper.selectMokuaiAll();
		for (int i = 0; i < mokuailist.size(); i++) {
			if (mokuailist.get(i).getMk_fuid() == 0) {
				addtree(mokuaiTreelist, mokuailist, i);
			}
		}
		return mokuaiTreelist;
	}

	private void addtree(List<MokuaiTree> mokuaiTreelist, List<Mokuai> mokuailist, int i) {
		MokuaiTree mk = new MokuaiTree();
		mk.setId(mokuailist.get(i).getMk_id());
		mk.setText(mokuailist.get(i).getMk_name());
		mk.setChecked(mokuailist.get(i).getMk_checked() == 1);
		MokuaiTree fortree = fortree(mokuailist, i,mk);
		if(fortree!=null) {
			mokuaiTreelist.add(fortree);
		}
	}

	private MokuaiTree fortree(List<Mokuai> mokuailist, int i,MokuaiTree mk) {
		List<MokuaiTree> treelist = new ArrayList<MokuaiTree>();
		for (int j = 0; j < mokuailist.size(); j++) {
			if (mokuailist.get(j).getMk_fuid() == mokuailist.get(i).getMk_id()) {
				addtree(treelist, mokuailist, j);
			}
		}
		mk.setChildren(treelist);
		return mk;
	}

	@Override
	public Integer insertMokuai(Mokuai mokuai) {
		// TODO Auto-generated method stub
		if(mokuai.getMk_fuid()==null) {
			mokuai.setMk_fuid(0);
		}
		return mokuaiMapper.insertMokuai(mokuai);
	}

	@Override
	public Integer updateMokuai(Mokuai mokuai) {
		// TODO Auto-generated method stub
		return mokuaiMapper.updateMokuai(mokuai);
	}

	@Override
	public Integer deleteMokuai(Integer mk_id) {
		// TODO Auto-generated method stub
		return mokuaiMapper.deleteMokuai(mk_id);
	}

	@Override
	public Mokuai selectMokuai_mk_id(Integer mk_id) {
		// TODO Auto-generated method stub
		return mokuaiMapper.selectMokuai_mk_id(mk_id);
	}

}
