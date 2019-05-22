package com.crm.service;

import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.dao.JueseMapper;
import com.crm.dao.StudentMapper;
import com.crm.dao.UserMapper;
import com.crm.entity.Dongtai;
import com.crm.entity.Fenye;
import com.crm.entity.Genzongrizhi;
import com.crm.entity.Juese;
import com.crm.entity.Student;
import com.crm.entity.User;
import com.crm.util.QuanZhongFenPei;

@Service
public class StudentServiceimp implements StudentService {
	@Autowired
	private StudentMapper studentMapper;
	@Autowired
	QuanZhongFenPei quanZhongFenPei;
	@Autowired
	JueseMapper juesemapper;
	@Autowired
	UserMapper usermapper;

	@Override
	public Fenye<Student> selesctStudent(HttpServletRequest request, Fenye<Student> fenye) {
		// TODO Auto-generated method stub
		User user = (User) request.getSession().getAttribute("user");
		List<Juese> juese = user.getJuese();
		int is = 0;
		for (int i = 0; i < juese.size(); i++) {
			if (juese.get(i).getJs_name().equals("咨询师") || juese.get(i).getJs_name().equals("网络咨询师")) {
				is++;
			} else if (juese.get(i).getJs_name().equals("咨询经理") || juese.get(i).getJs_name().equals("管理员")) {
				is = -100;
			}
		}
		if (is > 0) {
			fenye.getT().setUs_id(user.getUs_id());
		}
		Integer selescCount = studentMapper.selescCount(fenye);
		fenye.setTotal(selescCount);
		List<Student> selesctStudent = studentMapper.selesctStudent(fenye);
		for (int i = 0; i < selesctStudent.size(); i++) {
			User zixunshi = studentMapper.selectUser_student_us_id(selesctStudent.get(i).getXs_zixunshi());
			User lururen = studentMapper.selectUser_student_us_id(selesctStudent.get(i).getXs_lururen());
			selesctStudent.get(i).setUs_zixunshi(zixunshi);
			selesctStudent.get(i).setUs_wangluozixunshi(lururen);
		}
		request.getSession().setAttribute("selesctStudent", selesctStudent);
		fenye.setRows(selesctStudent);
		return fenye;
	}

	@Override
	public Integer updateStudent(Student student) {
		// TODO Auto-generated method stub
		Integer updateStudent = studentMapper.updateStudent(student);
		return updateStudent;
	}

	@Override
	public Integer insertStudent(HttpServletRequest request, Student student) {
		// TODO Auto-generated method stub
		User user = (User) request.getSession().getAttribute("user");
		student.setXs_lururen(user.getUs_id());
		Integer selectGongneng_zdfp = studentMapper.selectGongneng_zdfp();
		if (selectGongneng_zdfp == 1) {
			Integer selectJuese_zixunshi = juesemapper.selectJuese_zixunshi();
			List<User> selectUser_zixunshi = usermapper.selectUser_zixunshi(selectJuese_zixunshi);
			if(selectUser_zixunshi!=null) {
				User fenpei = quanZhongFenPei.fenpei(selectUser_zixunshi);
				student.setXs_zixunshi(fenpei.getUs_id());
			}
		}
		String sj = huoqu_sj();
		student.setXs_chuangjiantime(sj);
		Integer insertStudent = studentMapper.insertStudent(student);
		return insertStudent;
	}

	private String huoqu_sj() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		String sj = df.format(new Date());
		return sj;
	}

	@Override
	public Integer deleteStudent(Integer xs_id) {
		// TODO Auto-generated method stub
		return studentMapper.deleteStudent(xs_id);
	}

	@Override
	public Integer updateisyouxiao(Student student) {
		// TODO Auto-generated method stub
		Integer updateisyouxiao = studentMapper.updateisyouxiao(student);
		return updateisyouxiao;
	}

	@Override
	public Integer selectGongneng_zdfp() {
		// TODO Auto-generated method stub
		return studentMapper.selectGongneng_zdfp();
	}

	@Override
	public Integer updateGongneng_zdfp(Integer gn_iskaiqi) {
		// TODO Auto-generated method stub
		return studentMapper.updateGongneng_zdfp(gn_iskaiqi);
	}

	@Override
	public Integer updateStudent_zixunshi(Student student) {
		// TODO Auto-generated method stub
		return studentMapper.updateStudent_zixunshi(student);
	}

	@Override
	public Integer insertGenZong(Genzongrizhi genzongrizhi, HttpServletRequest request) {
		// TODO Auto-generated method stub
		Integer us_id = ((User) request.getSession().getAttribute("user")).getUs_id();
		genzongrizhi.setGz_user(us_id);
		Integer insertGenZong = studentMapper.insertGenZong(genzongrizhi);
		return insertGenZong;
	}

	@Override
	public void daochuexcel(HttpServletRequest request, HttpServletResponse response, String xs_ids)
			throws IOException {
		// TODO Auto-generated method stub
		String[] split = xs_ids.split(",");
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < split.length; i++) {
			list.add(Integer.parseInt(split[i]));
		}
		List<Student> studentlist = studentMapper.selectStudent_xuanzhong(list);
		for (int i = 0; i < studentlist.size(); i++) {
			User zixunshi = studentMapper.selectUser_student_us_id(studentlist.get(i).getXs_zixunshi());
			User lururen = studentMapper.selectUser_student_us_id(studentlist.get(i).getXs_lururen());
			studentlist.get(i).setUs_zixunshi(zixunshi);
			studentlist.get(i).setUs_wangluozixunshi(lururen);
		}

		// 创建HSSFWorkbook对象(excel的文档对象)
		HSSFWorkbook wkb = new HSSFWorkbook();
		// 建立新的sheet对象（excel的表单）
		HSSFSheet sheet = wkb.createSheet("学生信息");
		// 在sheet里创建第一行，参数为行索引(excel的行)，可以是0～65535之间的任何一个
		HSSFRow row1 = sheet.createRow(0);
		// 创建单元格（excel的单元格，参数为列索引，可以是0～255之间的任何一个
		HSSFCell cell = row1.createCell(0);
		// 设置单元格内容
		cell.setCellValue("学生信息");
		// 合并单元格CellRangeAddress构造参数依次表示起始行，截至行，起始列， 截至列
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 3));
		// 在sheet里创建第二行

		HSSFRow row2 = sheet.createRow(1);
		// 创建单元格并设置单元格内容
		/*
		 * row2.createCell(0).setCellValue("sj_id");
		 * row2.createCell(1).setCellValue("sj_name");
		 * row2.createCell(2).setCellValue("sj_jage");
		 * row2.createCell(3).setCellValue("sj_zuozhe");
		 */

		String columnStr = "姓名，性别，年龄，电话，创建时间，学历，个人状态，来源渠道，来源网站，学生关注，"
				+ "来源关键字，姓名(咨询)，所在区域，微信，qq，来源部门，是否报备，课程方向，是否有效，打分，" + "是否回访，首次回访时间，是否上门，上门时间，无效原因，是否缴费，缴费时间，金额，是否退费，"
				+ "是否进班，进班时间，进班备注，退费原因，定金金额，定金时间，咨询师，录入人，咨询师备注";
		String[] heads = columnStr.split("，");
		for (int i = 0; i < heads.length; i++) {
			row2.createCell(i).setCellValue("" + heads[i] + "");
		}
		for (int i = 0; i < studentlist.size(); i++) {
			HSSFRow row3 = sheet.createRow(i + 2);
			Student stu = studentlist.get(i);
			row3.createCell(0).setCellValue(stu.getXs_name() == null ? "" : stu.getXs_name());
			row3.createCell(1).setCellValue(stu.getXs_xingbie() == null ? "" : (stu.getXs_xingbie() == 1 ? "男" : "女"));
			row3.createCell(2).setCellValue(stu.getXs_nianling() == null ? "" : "" + stu.getXs_nianling());
			row3.createCell(3).setCellValue(stu.getXs_dianhua() == null ? "" : stu.getXs_dianhua());
			row3.createCell(4).setCellValue(stu.getXs_chuangjiantime() == null ? "" : stu.getXs_chuangjiantime());
			row3.createCell(5).setCellValue(stu.getXs_xueli() == null ? "" : stu.getXs_xueli());
			row3.createCell(6).setCellValue(stu.getXs_zhuangtai() == null ? "" : stu.getXs_zhuangtai());
			row3.createCell(7).setCellValue(stu.getXs_laiyuanqudao() == null ? "" : stu.getXs_laiyuanqudao());
			row3.createCell(8).setCellValue(stu.getXs_laiyuanwangzhi() == null ? "" : stu.getXs_laiyuanwangzhi());
			row3.createCell(9).setCellValue(stu.getXs_guanzhu() == null ? "" : stu.getXs_guanzhu());
			row3.createCell(10).setCellValue(stu.getXs_liyuanguanjianzi() == null ? "" : stu.getXs_liyuanguanjianzi());
			row3.createCell(11).setCellValue(stu.getXs_namezixun() == null ? "" : stu.getXs_namezixun());
			row3.createCell(12).setCellValue(stu.getXs_suozaiquyu() == null ? "" : stu.getXs_suozaiquyu());
			row3.createCell(13).setCellValue(stu.getXs_weixin() == null ? "" : stu.getXs_weixin());
			row3.createCell(14).setCellValue(stu.getXs_qq() == null ? "" : stu.getXs_qq());
			row3.createCell(15).setCellValue(stu.getXs_laiyuanbumen() == null ? "" : stu.getXs_laiyuanbumen());
			row3.createCell(16).setCellValue(
					stu.getXs_isbaobei() == null ? "" : (stu.getXs_isbaobei().equals("1") ? "已报备" : "未报备"));
			row3.createCell(17).setCellValue(stu.getXs_kecheng() == null ? "" : stu.getXs_kecheng());
			row3.createCell(18)
					.setCellValue(stu.getXs_isyouxiao() == null ? "" : (stu.getXs_isyouxiao() == 1 ? "有效" : "无效"));
			row3.createCell(19).setCellValue(stu.getXs_dafen() == null ? "" : stu.getXs_dafen());
			row3.createCell(20)
					.setCellValue(stu.getXs_ishuifang() == null ? "" : (stu.getXs_ishuifang() == 1 ? "已回访" : "未回访"));
			row3.createCell(21)
					.setCellValue(stu.getXs_shuocihuifangtime() == null ? "" : stu.getXs_shuocihuifangtime());
			row3.createCell(22)
					.setCellValue(stu.getXs_isshangmen() == null ? "" : (stu.getXs_isshangmen() == 1 ? "是" : "否"));
			row3.createCell(23).setCellValue(stu.getXs_shangmentime() == null ? "" : stu.getXs_shangmentime());
			row3.createCell(24).setCellValue(stu.getXs_wuxiaoyuanyin() == null ? "" : stu.getXs_wuxiaoyuanyin());
			row3.createCell(25)
					.setCellValue(stu.getXs_isjiaofei() == null ? "" : (stu.getXs_isjiaofei() == 1 ? "是" : "否"));
			row3.createCell(26).setCellValue(stu.getXs_jiaofeitime() == null ? "" : stu.getXs_jiaofeitime());
			row3.createCell(27).setCellValue(stu.getXs_jine() == null ? 0 : stu.getXs_jine());
			row3.createCell(28)
					.setCellValue(stu.getXs_istuifei() == null ? "" : (stu.getXs_istuifei() == 1 ? "是" : "否"));
			row3.createCell(29)
					.setCellValue(stu.getXs_isjinban() == null ? "" : (stu.getXs_isjinban() == 1 ? "是" : "否"));
			row3.createCell(30).setCellValue(stu.getXs_jinbantime() == null ? "" : stu.getXs_jinbantime());
			row3.createCell(31).setCellValue(stu.getXs_jinbanbeizhu() == null ? "" : stu.getXs_jinbanbeizhu());
			row3.createCell(32).setCellValue(stu.getXs_tuifeiyuanyin() == null ? "" : stu.getXs_tuifeiyuanyin());
			row3.createCell(33).setCellValue(stu.getXs_dingjinjine() == null ? 0 : stu.getXs_dingjinjine());
			row3.createCell(34).setCellValue(stu.getXs_dingjintime() == null ? "" : stu.getXs_dingjintime());
			row3.createCell(35).setCellValue(stu.getUs_zixunshi() == null ? "暂无咨询师"
					: (stu.getUs_zixunshi().getUs_name() == null ? "" : stu.getUs_zixunshi().getUs_name()));
			row3.createCell(36)
					.setCellValue(stu.getUs_wangluozixunshi() == null ? "暂无录入人"
							: (stu.getUs_wangluozixunshi().getUs_name() == null ? ""
									: stu.getUs_wangluozixunshi().getUs_name()));
			row3.createCell(37).setCellValue(stu.getXs_zixunshibeizhu() == null ? "" : stu.getXs_zixunshibeizhu());
		}
		// 输出Excel文件
		OutputStream output = response.getOutputStream();
		response.reset();
		response.setHeader("Content-disposition", "attachment; filename="+new String("学生信息.xls".getBytes("GB2312"),"ISO8859-1"));
		response.setContentType("application/msexcel");
		wkb.write(output);
		output.close();
	}

	@Override
	public Integer deleteStudent_duo(String xs_ids) {
		// TODO Auto-generated method stub
		String[] split = xs_ids.split(",");
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < split.length; i++) {
			list.add(Integer.parseInt(split[i]));
		}
		Integer deleteStudent_duo = studentMapper.deleteStudent_duo(list);
		return deleteStudent_duo;
	}

	@Override
	public Integer tianjia_dongtairizhi(HttpServletRequest request, Dongtai dt) {
		// TODO Auto-generated method stub
		String sj = huoqu_sj();
		User user=(User)request.getSession().getAttribute("user");
		dt.setDt_time(sj);
		dt.setDt_tianjiaren(user.getUs_id());
		Student stu=new Student();
		stu.setXs_id(dt.getDt_student());
		stu.setXs_exe1("2");
		studentMapper.updateStudent_exe1_isbeixiugai(stu);
		return studentMapper.tianjia_dongtairizhi(dt);
	}

	@Override
	public Fenye<Dongtai> selectDongtai_stu_id(Fenye<Dongtai> fenye) {
		// TODO Auto-generated method stub
		List<Dongtai> selectDongtai_stu_id = studentMapper.selectDongtai_stu_id(fenye);
		fenye.setRows(selectDongtai_stu_id);
		return fenye;
	}

	@Override
	public Fenye<Genzongrizhi> selectGengzongrizhi_xs_id(Fenye<Genzongrizhi> fenye) {
		// TODO Auto-generated method stub
		List<Genzongrizhi> selectGengzongrizhi_xs_id = studentMapper.selectGengzongrizhi_xs_id(fenye);
		fenye.setRows(selectGengzongrizhi_xs_id);
		return fenye;
	}

	@Override
	public Integer pl_updateStudent_zixunshi(Student student, String xs_ids) {
		// TODO Auto-generated method stub
		String[] split = xs_ids.split(",");
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < split.length; i++) {
			list.add(Integer.parseInt(split[i]));
		}
		student.setPl_fp_zxs(list);
		return studentMapper.pl_updateStudent_zixunshi(student);
	}

}
