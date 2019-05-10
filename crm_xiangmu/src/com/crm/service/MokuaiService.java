package com.crm.service;

import java.util.List;

import com.crm.entity.MokuaiTree;

public interface MokuaiService {
	/**
	 * 查看所有模块
	 * @return
	 */
	List<MokuaiTree> selectMokuaiAll();
	
	

}
