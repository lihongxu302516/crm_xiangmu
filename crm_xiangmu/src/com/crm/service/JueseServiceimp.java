package com.crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.dao.JueseMapper;
import com.crm.entity.Fenye;
import com.crm.entity.Juese;
@Service
public class JueseServiceimp implements JueseService {
	@Autowired
	JueseMapper jueseMapper;

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

}
