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

}
