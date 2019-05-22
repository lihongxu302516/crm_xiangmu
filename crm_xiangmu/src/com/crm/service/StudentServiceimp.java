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
			if (juese.get(i).getJs_name().equals("��ѯʦ") || juese.get(i).getJs_name().equals("������ѯʦ")) {
				is++;
			} else if (juese.get(i).getJs_name().equals("��ѯ����") || juese.get(i).getJs_name().equals("����Ա")) {
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
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// �������ڸ�ʽ
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

		// ����HSSFWorkbook����(excel���ĵ�����)
		HSSFWorkbook wkb = new HSSFWorkbook();
		// �����µ�sheet����excel�ı���
		HSSFSheet sheet = wkb.createSheet("ѧ����Ϣ");
		// ��sheet�ﴴ����һ�У�����Ϊ������(excel����)��������0��65535֮����κ�һ��
		HSSFRow row1 = sheet.createRow(0);
		// ������Ԫ��excel�ĵ�Ԫ�񣬲���Ϊ��������������0��255֮����κ�һ��
		HSSFCell cell = row1.createCell(0);
		// ���õ�Ԫ������
		cell.setCellValue("ѧ����Ϣ");
		// �ϲ���Ԫ��CellRangeAddress����������α�ʾ��ʼ�У������У���ʼ�У� ������
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 3));
		// ��sheet�ﴴ���ڶ���

		HSSFRow row2 = sheet.createRow(1);
		// ������Ԫ�����õ�Ԫ������
		/*
		 * row2.createCell(0).setCellValue("sj_id");
		 * row2.createCell(1).setCellValue("sj_name");
		 * row2.createCell(2).setCellValue("sj_jage");
		 * row2.createCell(3).setCellValue("sj_zuozhe");
		 */

		String columnStr = "�������Ա����䣬�绰������ʱ�䣬ѧ��������״̬����Դ��������Դ��վ��ѧ����ע��"
				+ "��Դ�ؼ��֣�����(��ѯ)����������΢�ţ�qq����Դ���ţ��Ƿ񱨱����γ̷����Ƿ���Ч����֣�" + "�Ƿ�طã��״λط�ʱ�䣬�Ƿ����ţ�����ʱ�䣬��Чԭ���Ƿ�ɷѣ��ɷ�ʱ�䣬���Ƿ��˷ѣ�"
				+ "�Ƿ���࣬����ʱ�䣬���౸ע���˷�ԭ�򣬶��������ʱ�䣬��ѯʦ��¼���ˣ���ѯʦ��ע";
		String[] heads = columnStr.split("��");
		for (int i = 0; i < heads.length; i++) {
			row2.createCell(i).setCellValue("" + heads[i] + "");
		}
		for (int i = 0; i < studentlist.size(); i++) {
			HSSFRow row3 = sheet.createRow(i + 2);
			Student stu = studentlist.get(i);
			row3.createCell(0).setCellValue(stu.getXs_name() == null ? "" : stu.getXs_name());
			row3.createCell(1).setCellValue(stu.getXs_xingbie() == null ? "" : (stu.getXs_xingbie() == 1 ? "��" : "Ů"));
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
					stu.getXs_isbaobei() == null ? "" : (stu.getXs_isbaobei().equals("1") ? "�ѱ���" : "δ����"));
			row3.createCell(17).setCellValue(stu.getXs_kecheng() == null ? "" : stu.getXs_kecheng());
			row3.createCell(18)
					.setCellValue(stu.getXs_isyouxiao() == null ? "" : (stu.getXs_isyouxiao() == 1 ? "��Ч" : "��Ч"));
			row3.createCell(19).setCellValue(stu.getXs_dafen() == null ? "" : stu.getXs_dafen());
			row3.createCell(20)
					.setCellValue(stu.getXs_ishuifang() == null ? "" : (stu.getXs_ishuifang() == 1 ? "�ѻط�" : "δ�ط�"));
			row3.createCell(21)
					.setCellValue(stu.getXs_shuocihuifangtime() == null ? "" : stu.getXs_shuocihuifangtime());
			row3.createCell(22)
					.setCellValue(stu.getXs_isshangmen() == null ? "" : (stu.getXs_isshangmen() == 1 ? "��" : "��"));
			row3.createCell(23).setCellValue(stu.getXs_shangmentime() == null ? "" : stu.getXs_shangmentime());
			row3.createCell(24).setCellValue(stu.getXs_wuxiaoyuanyin() == null ? "" : stu.getXs_wuxiaoyuanyin());
			row3.createCell(25)
					.setCellValue(stu.getXs_isjiaofei() == null ? "" : (stu.getXs_isjiaofei() == 1 ? "��" : "��"));
			row3.createCell(26).setCellValue(stu.getXs_jiaofeitime() == null ? "" : stu.getXs_jiaofeitime());
			row3.createCell(27).setCellValue(stu.getXs_jine() == null ? 0 : stu.getXs_jine());
			row3.createCell(28)
					.setCellValue(stu.getXs_istuifei() == null ? "" : (stu.getXs_istuifei() == 1 ? "��" : "��"));
			row3.createCell(29)
					.setCellValue(stu.getXs_isjinban() == null ? "" : (stu.getXs_isjinban() == 1 ? "��" : "��"));
			row3.createCell(30).setCellValue(stu.getXs_jinbantime() == null ? "" : stu.getXs_jinbantime());
			row3.createCell(31).setCellValue(stu.getXs_jinbanbeizhu() == null ? "" : stu.getXs_jinbanbeizhu());
			row3.createCell(32).setCellValue(stu.getXs_tuifeiyuanyin() == null ? "" : stu.getXs_tuifeiyuanyin());
			row3.createCell(33).setCellValue(stu.getXs_dingjinjine() == null ? 0 : stu.getXs_dingjinjine());
			row3.createCell(34).setCellValue(stu.getXs_dingjintime() == null ? "" : stu.getXs_dingjintime());
			row3.createCell(35).setCellValue(stu.getUs_zixunshi() == null ? "������ѯʦ"
					: (stu.getUs_zixunshi().getUs_name() == null ? "" : stu.getUs_zixunshi().getUs_name()));
			row3.createCell(36)
					.setCellValue(stu.getUs_wangluozixunshi() == null ? "����¼����"
							: (stu.getUs_wangluozixunshi().getUs_name() == null ? ""
									: stu.getUs_wangluozixunshi().getUs_name()));
			row3.createCell(37).setCellValue(stu.getXs_zixunshibeizhu() == null ? "" : stu.getXs_zixunshibeizhu());
		}
		// ���Excel�ļ�
		OutputStream output = response.getOutputStream();
		response.reset();
		response.setHeader("Content-disposition", "attachment; filename="+new String("ѧ����Ϣ.xls".getBytes("GB2312"),"ISO8859-1"));
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
