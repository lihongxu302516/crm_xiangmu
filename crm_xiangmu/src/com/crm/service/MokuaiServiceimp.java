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
		List<MokuaiTree> mokuaiTreelist = new ArrayList<MokuaiTree>();
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
		MokuaiTree fortree = fortree(mokuailist, i, mk);
		if (fortree != null) {
			mokuaiTreelist.add(fortree);
		}
	}

	private MokuaiTree fortree(List<Mokuai> mokuailist, int i, MokuaiTree mk) {
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
		if (mokuai.getMk_fuid() == null) {
			mokuai.setMk_fuid(0);
		}
		Integer selectMokuai_name_ischongfu = mokuaiMapper.selectMokuai_name_ischongfu(mokuai);
		if (selectMokuai_name_ischongfu == 0) {
			return mokuaiMapper.insertMokuai(mokuai);
		} else {
			return -1;
		}
	}

	@Override
	public Integer updateMokuai(Mokuai mokuai) {
		// TODO Auto-generated method stub
		if (mokuai.getMk_fuid() == null) {
			mokuai.setMk_fuid(0);
		}
		Integer selectMokuai_name_ischongfu = mokuaiMapper.selectMokuai_name_ischongfu(mokuai);
		if (selectMokuai_name_ischongfu == 0) {
			return mokuaiMapper.updateMokuai(mokuai);
		} else {
			return -1;
		}
	}

	@Override
	public Integer deleteMokuai(Integer mk_id) {
		// TODO Auto-generated method stub
		Integer selectMokuai_is_Juese = mokuaiMapper.selectMokuai_is_Juese(mk_id);
		if (selectMokuai_is_Juese == 0) {
			Integer selectMokuai_is_Juese_fu_id = mokuaiMapper.selectMokuai_is_Juese_fu_id(mk_id);
			if (selectMokuai_is_Juese_fu_id == 0) {
				mokuaiMapper.deleteMokuai(mk_id);
				mokuaiMapper.deleteMokuai_fu_id(mk_id);
				return 1;
			} else {
				return -2;
			}
		} else {
			return -1;
		}
	}

	@Override
	public Mokuai selectMokuai_mk_id(Integer mk_id) {
		// TODO Auto-generated method stub
		return mokuaiMapper.selectMokuai_mk_id(mk_id);
	}

}
