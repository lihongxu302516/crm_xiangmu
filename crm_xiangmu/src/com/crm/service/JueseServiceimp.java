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
		// 查询所有的角色信息分页显示
		Integer selectJueseCount = jueseMapper.selectJueseCount(fenye);// 查看所有符合条件的的角色数据数量
		List<Juese> selectJueseAll = jueseMapper.selectJueseAll(fenye);// 查看当前页的所有数据
		fenye.setTotal(selectJueseCount);// 将条数放入total中，easyui的总数据量是total
		fenye.setRows(selectJueseAll);// 将数据放入rows，easyui的数据是rows
		return fenye;
	}

	@Override
	public Integer insertJuese(Juese juese) {
		// TODO Auto-generated method stub
		// 添加一个角色
		Integer select_juese_name_chongfu = jueseMapper.select_juese_name_chongfu(juese);// 查看新添加的角色是否重名
		if (select_juese_name_chongfu == 0) {// 判断是否重名，不重名为0
			Integer insertJuese = jueseMapper.insertJuese(juese);// 添加一个角色
			return insertJuese;// 返回成功1
		} else {
			return -1;// 返回重名-1
		}
	}

	@Override
	public Integer updateJuese(Juese juese) {
		// TODO Auto-generated method stub
		// 修改一个角色
		Integer select_juese_name_chongfu = jueseMapper.select_juese_name_chongfu(juese);// 查看修改的角色是否重名，并查看的是非自己的数据，防止未修改名称出现的重名
		if (select_juese_name_chongfu == 0) {// 判断是否重名，不重名为0
			return jueseMapper.updateJuese(juese);// 修改一个角色，返回成功1
		} else {
			return -1;// 返回重名-1
		}
	}

	@Override
	public Integer deleteJuese(Integer js_id) {
		// TODO Auto-generated method stub
		// 删除一个角色
		Integer select_Juese_is_User = jueseMapper.select_Juese_is_User(js_id);// 查询该角色下是否存在员工
		if (select_Juese_is_User == 0) {// 判断是否存在员工，如果不存在为0
			Integer select_Juese_is_Mokuai = jueseMapper.select_Juese_is_Mokuai(js_id);
			if (select_Juese_is_Mokuai == 0) {
				return jueseMapper.deleteJuese(js_id);// 不存员工的话删除该角色，成功返回1
			} else {
				return -2;
			}
		} else {
			return -1;// 存在员工返回-1，提醒用户先清除员工
		}
	}

	@Override
	public List<Juese> selectJuese(Integer us_id) {
		// TODO Auto-generated method stub
		// 查看所有角色，不分页
		return jueseMapper.selectJuese(us_id);
	}

	@Override
	public List<Juese> selectJuese_us_id(Integer us_id) {
		// TODO Auto-generated method stub
		// 根据用户的id查看这个用户的所有角色
		return jueseMapper.selectJuese_us_id(us_id);
	}

	@Override
	public List<MokuaiTree> selectJuese_mktree(Integer js_id) {
		// TODO Auto-generated method stub
		// 查看角色的模块树
		List<MokuaiTree> mokuaiTreelist = new ArrayList<MokuaiTree>();// 声明模块树的list集合
		List<Mokuai> mokuailist = mokuaiMapper.selectMokuaiAll();// 查看所有的模块
		for (int i = 0; i < mokuailist.size(); i++) {// 循环所有的模块
			if (mokuailist.get(i).getMk_fuid() == 0) {// 判断该模块是否是最顶级节点
				addtree(mokuaiTreelist, mokuailist, i, js_id);// 调用添加模块树的方法
			}
		}
		return mokuaiTreelist;// 返回模块树的list集合
	}

	private void addtree(List<MokuaiTree> mokuaiTreelist, List<Mokuai> mokuailist, int i, Integer js_id) {
		MokuaiTree mk = new MokuaiTree();// 声明一个模块树的对象
		mk.setId(mokuailist.get(i).getMk_id());// 将本次循环的模块id写入到模块树对象中
		mk.setText(mokuailist.get(i).getMk_name());// 将本次循环的模块名称写入到模块树对象中

		juese_mokuai.setJm_jueseid(js_id);// 将角色id写入到角色模块对象中
		juese_mokuai.setJm_mokuaiid(mokuailist.get(i).getMk_id());// 将模块id写入到角色模块对象中
		Integer selectMokuai_js_id = mokuaiMapper.selectMokuai_js_id(juese_mokuai);// 传入角色模块对象，根据角色id和模块id查看该角色是否拥有此模块

		Integer selectMokuai_isyouzi = mokuaiMapper.selectMokuai_isyouzi(mokuailist.get(i).getMk_id());// 查看该模块下是否有子模块
		if (selectMokuai_isyouzi > 0) {// 判断是否有子模块
			mk.setChecked(false);// 如果有子模块就让它不被选择，而是通过子模块进行选择，防止选中父模块后子模块全部被选中
		} else {
			mk.setChecked(selectMokuai_js_id == 1);// 如果没有子模块就判断是1（选中），如果为1就是选中，否则不选中
		}

		MokuaiTree fortree = fortree(mokuailist, i, mk, js_id);// 调用添加此模块下子模块的方法
		if (fortree != null) {// 判断是否添加了子模块
			mokuaiTreelist.add(fortree);// 如果添加了，就将此模块添加给模块树的list集合
		}
	}

	private MokuaiTree fortree(List<Mokuai> mokuailist, int i, MokuaiTree mk, Integer js_id) {
		List<MokuaiTree> treelist = new ArrayList<MokuaiTree>();// 声明模块树的list集合
		for (int j = 0; j < mokuailist.size(); j++) {// 循环所有模块
			if (mokuailist.get(j).getMk_fuid() == mokuailist.get(i).getMk_id()) {// 判断此次循环的模块父id是否和上次循环的模块id相同
				addtree(treelist, mokuailist, j, js_id);// 如果相同就是上个模块的子模块，调用模块添加方法
			}
		}
		mk.setChildren(treelist);// 将该模块树list集合写入到模块树中
		return mk;
	}

	@Override
	public Integer xiugaiJuese_mokuai(String mkids, Integer js_id) {
		// TODO Auto-generated method stub
		// 修改当前角色的模块
		if (mkids != null && mkids != "") {// 判断前台传入的模块id字符串是否为空，因为可能为空为了安全防止报错
			String[] split = mkids.split(",");// 通过，分割出所有的模块id
			List<Juese_mokuai> list = new ArrayList<Juese_mokuai>();// 声明一个角色模块的list集合
			for (int i = 0; i < split.length; i++) {// 循环模块id的数组
				Juese_mokuai jm = new Juese_mokuai();// 声明一个角色模块对象
				jm.setJm_mokuaiid(Integer.parseInt(split[i]));// 将此次循环的模块id写入到角色模块
				jm.setJm_jueseid(js_id);// 将角色id写入到角色模块中
				list.add(jm);// 将角色模块放入list集合中
			}
			mokuaiMapper.deleteJuese_mokuai_js_id(js_id);// 先删除该角色的所有模块
			mokuaiMapper.insertJuese_mokuai_js_id(list);// 在把所有的该角色的模块全部添加上去
		} else {// 如果为空就是让这个角色没有模块，所有要把该角色的所有模块全部删除
			mokuaiMapper.deleteJuese_mokuai_js_id(js_id);
		}
		return 1;// 返回成功1
	}
}
