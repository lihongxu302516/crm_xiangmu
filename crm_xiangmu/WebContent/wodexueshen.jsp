<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="com.crm.entity.*"%>
<%@ page import="java.util.List"%>
<%
	User user = (User) request.getSession().getAttribute("user");
%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<script src="js/gonggong.js" type="text/javascript" charset="utf-8"></script>
<script src="js/yincang.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">
	$(function() {
		$("#tj_dtrz_win").window("close");
		$("#ck_dtrz_win").window("close");
		$("#nr_dtrz_win").window("close");
		$("#nr_gzrz_win").window("close");
		$("#ck_gzrz_win").window("close");
		$('#yc_window').window('close');
		$('#xs_zixunshi').combobox({
			url : 'chakan_all_zixunshu',
			valueField : 'us_id',
			textField : 'us_name'
		});
		student_guanli();
	})
	function student_guanli() {
		$("#StudentTab")
				.datagrid(
						{
							url : 'student_xianshi',
							method : 'post',
							toolbar : '#StudentToo',
							pagination : true,
							queryParams : {
								xs_name : $("#xs_name").val(),
								xs_dianhua : $("#xs_dianhua").val(),
								xs_zixunshi : $("#xs_zixunshi").combobox(
										"getValue") == "---请选择---" ? "" : $(
										"#xs_zixunshi").combobox("getValue"),
								xs_isjiaofei : $("#xs_isjiaofei").combobox(
										"getValue") == "---请选择---" ? "" : $(
										"#xs_isjiaofei").combobox("getValue"),
								xs_isyouxiao : $("#xs_isyouxiao").combobox(
										"getValue") == "---请选择---" ? "" : $(
										"#xs_isyouxiao").combobox("getValue"),
								xs_ishuifang : $("#xs_ishuifang").combobox(
										"getValue") == "---请选择---" ? "" : $(
										"#xs_ishuifang").combobox("getValue"),
								xs_qq : $("#xs_qq").val(),
								minxs_chuangjiantime : $(
										"#minxs_chuangjiantime").datetimebox(
										'getValue'),
								maxxs_chuangjiantime : $(
										"#maxxs_chuangjiantime").datetimebox(
										'getValue'),
								minxs_shangmentime : $("#minxs_shangmentime")
										.datetimebox('getValue'),
								maxxs_shangmentime : $("#maxxs_shangmentime")
										.datetimebox('getValue'),
								minxs_shuocihuifangtime : $(
										"#minxs_shuocihuifangtime")
										.datetimebox('getValue'),
								maxxs_shuocihuifangtime : $(
										"#maxxs_shuocihuifangtime")
										.datetimebox('getValue'),
								minxs_jiaofeitime : $("#minxs_jiaofeitime")
										.datetimebox('getValue'),
								maxxs_jiaofeitime : $("#maxxs_jiaofeitime")
										.datetimebox('getValue'),
								minxs_jinbantime : $("#minxs_jinbantime")
										.datetimebox('getValue'),
								maxxs_jinbantime : $("#maxxs_jinbantime")
										.datetimebox('getValue')
							},
							onDblClickRow : function(index, field, value) {
								updateUU(index);
							}

						})
		$("#frm").form("reset");
	}
	function formattercaozuo(value, row, index) {
		return "<a href='javascript:void(0)' class='easyui-linkbutton' onclick='updateU("
				+ index
				+ ")' > 编辑 </a>  <a href='javascript:void(0)' class='easyui-linkbutton' onclick='deleteD("
				+ index
				+ ")' > 无效 </a>  <a href='javascript:void(0)' class='easyui-linkbutton' onclick='updateUU("
				+ index + ")' > 查看 </a> ";
	}
	function formatterxingbie(value, row, index) {
		return row.xs_xingbie == 2 ? '女' : (row.xs_xingbie == 1 ? '男' : '');
	}

	/*  判断是否有效*/
	function deleteD(index) {
		$.messager.confirm('确认', '您确认要将该学生无效吗？', function(r) {
			if (r) {
				var data = $("#StudentTab").datagrid("getData");
				var row = data.rows[index];
				var xs_id = row.xs_id;
				$.post('updateisyouxiao', {
					xs_id : xs_id
				}, function(res) {
					if (res == 1) {
						$("#StudentTab").datagrid("reload");
						$.messager.show({
							title : '我的消息',
							msg : '设置无效成功',
							timeout : 1000,
							showType : 'slide',
							style : {
								top : document.body.scrollTop
										+ document.documentElement.scrollTop,
							}
						});
					} else {
						alert('设置无效失败');
					}
				}, 'json')
			}
		});
	}

	/*修改 在线录入,咨询师录入  */
	function updateU(index) {
		$('#xs_zixunshi1').combobox({
			url : 'chakan_all_zixunshu',
			valueField : 'us_id',
			textField : 'us_name'
		});
		$('#xs_lururen1').combobox({
			url : 'chakan_all_wl_zixunshu',
			valueField : 'us_id',
			textField : 'us_name'
		});
		var data = $("#StudentTab").datagrid("getData");
		var row = data.rows[index];
		$("#frm1_zai").form("load", row);
		$("#frm1_zi").form("load", row);
		//$("#xs_zixunshi1").textbox("setValue", row.us_zixunshi.us_id);
		$("#xs_zixunshi1").combobox("setValue", row.us_zixunshi.us_id);
		$("#xs_lururen1").combobox("setValue", row.us_wangluozixunshi.us_id);
<%List<Juese> juese1 = user.getJuese();
			int zxs = 0;
			int wlzxs = 0;
			for (int i = 0; i < juese1.size(); i++) {
				if (juese1.get(i).getJs_name().equals("咨询师")) {
					zxs++;
				} else if (juese1.get(i).getJs_name().equals("网络咨询师")) {
					wlzxs++;
				} else if (juese1.get(i).getJs_name().equals("咨询经理")) {
					zxs++;
					wlzxs++;
				}
			}
			if (zxs == 0 && wlzxs == 0) {%>
	$('input,select,textarea', $('form[name="frm1_zi"]')).prop('disabled',
				true);
		$('input,select,textarea', $('form[name="frm1_zai"]')).prop('disabled',
				true);
<%} else if (zxs == 0) {%>
	$('input,select,textarea', $('form[name="frm1_zi"]')).prop('disabled',
				true);
<%} else if (wlzxs == 0) {%>
	$('input,select,textarea', $('form[name="frm1_zai"]')).prop('disabled',
				true);
<%}%>
	$("#updateStuYuan").dialog("open");
	}
	function updateGuanbi() {
		$("#updateStuYuan").dialog("close");
	}
	function updateStuYuanBao() {
		if ($("#frm1_zai").form('validate')) {
			$.post("updateStudnet", {
				xs_id : $("#xs_id_xiugai").val(),
				xs_name : $("#xs_name1").val(),
				xs_xingbie : $("#xs_xingbie1").combobox("getValue"),
				xs_nianling : $("#xs_nianling1").val(),
				xs_dianhua : $("#xs_dianhua1").val(),
				xs_xueli : $("#xs_xueli1").combobox("getValue"),
				xs_zhuangtai : $("#xs_zhuangtai1").combobox("getValue"),
				xs_laiyuanwangzhi : $("#xs_laiyuanwangzhi1").combobox(
						"getValue"),
				xs_laiyuanqudao : $("#xs_laiyuanqudao1").combobox("getValue"),
				xs_liyuanguanjianzi : $("#xs_liyuanguanjianzi1").val(),
				xs_suozaiquyu1 : $("#xs_suozaiquyu1").combobox("getValue"),
				xs_guanzhu : $("#xs_guanzhu1").combobox("getValue"),
				xs_laiyuanbumen : $("#xs_laiyuanbumen1").val(),
				xs_qq : $("#xs_qq1").val(),
				xs_weixin : $("#xs_weixin1").val(),
				xs_isbaobei : $("#xs_isbaobei1").combobox("getValue"),
				xs_zixunshi : $("#xs_zixunshi1").combobox("getValue"),
				xs_lururen : $("#xs_lururen1").combobox("getValue"),
				xs_namezixun : $("#xs_namezixun1").val(),
				xs_kecheng : $("#xs_kecheng1").combobox("getValue"),
				xs_dafen : $("#xs_dafen1").combobox("getValue"),
				xs_isyouxiao : $("#xs_isyouxiao1").combobox("getValue"),
				xs_wuxiaoyuanyin : $("#xs_wuxiaoyuanyin1").val(),
				xs_ishuifang : $("#xs_ishuifang1").combobox("getValue"),
				xs_shuocihuifangtime : $("#xs_shuocihuifangtime1").datetimebox(
						'getValue'),
				xs_isshangmen : $("#xs_isshangmen1").combobox("getValue"),
				xs_shangmentime : $("#xs_shangmentime1")
						.datetimebox('getValue'),
				xs_dingjinjine : $("#xs_dingjinjine1").val(),
				xs_dingjintime : $("#xs_dingjintime1").datetimebox('getValue'),
				xs_isjiaofei : $("#xs_isjiaofei1").combobox("getValue"),
				xs_jiaofeitime : $("#xs_jiaofeitime1").datetimebox('getValue'),
				xs_jine : $("#xs_jine1").val(),
				xs_istuifei : $("#xs_istuifei1").combobox("getValue"),
				xs_tuifeiyuanyin : $("#xs_tuifeiyuanyin1").val(),
				xs_isjinban : $("#xs_isjinban1").combobox("getValue"),
				xs_jinbantime : $("#xs_jinbantime1").datetimebox('getValue'),
				xs_jinbanbeizhu : $("#xs_jinbanbeizhu1").val(),
				xs_zixunshibeizhu : $("#xs_zixunshibeizhu1").val()
			}, function(res) {
				if (res > 0) {
					//alert('修改成功');
					$.messager.show({
						title : '我的消息',
						msg : '修改成功',
						timeout : 1000,
						showType : 'slide',
						style : {
							top : document.body.scrollTop
									+ document.documentElement.scrollTop,
						}
					});
					$("#updateStuYuan").dialog("close");
					$("#StudentTab").datagrid("reload");
				} else {
					//alert('修改失败');
					$.messager.show({
						title : '我的消息',
						msg : '修改成功',
						timeout : 1000,
						showType : 'slide',
						style : {
							top : document.body.scrollTop
									+ document.documentElement.scrollTop,
						}
					});
					$("#updateStuYuan").dialog("close");
				}
			}, 'json');
		} else {
			$.messager.show({
				title : '我的消息',
				msg : '你输入的数据不符合要求，请重新输入',
				timeout : 1000,
				showType : 'slide',
				style : {
					top : document.body.scrollTop
							+ document.documentElement.scrollTop,
				}
			});
		}
	}

	/*查看  */
	function updateUU(index) {
		var data = $("#StudentTab").datagrid("getData");
		var row = data.rows[index];
		$("#frm2").form("load", row);
		$("#chakanStudent").dialog("open");
	}
	function updateUUGuanbi() {
		$("#chakanStudent").dialog("close");
	}
	function updateUUBao() {
		$.post("updateStudnet", {
			xs_id : ("#xs_id2").val(),
			xs_name : $("#xs_name2").val(),
			xs_xingbie : $("#xs_xingbie2").combobox("getValue"),
			xs_nianling : $("#xs_nianling2").val(),
			xs_dianhua : $("#xs_dianhua2").val(),
			xs_xueli : $("#xs_xueli2").val(),
			xs_zhuangtai : $("#xs_zhuangtai2").val(),
			xs_laiyuanwangzhi : $("#xs_laiyuanwangzhi2").val(),
			xs_laiyuanqudao : $("#xs_laiyuanqudao2").val(),
			xs_liyuanguanjianzi : $("#xs_liyuanguanjianzi2").val(),
			xs_suozaiquyu1 : $("#xs_suozaiquyu2").val(),
			xs_guanzhu : $("#xs_guanzhu2").val(),
			xs_laiyuanbumen : $("#xs_laiyuanbumen2").val(),
			xs_qq : $("#xs_qq2").val(),
			xs_weixin : $("#xs_weixin2").val(),
			xs_isbaobei : $("#xs_isbaobei2").combobox("getValue"),
			xs_zixunshi : $("#xs_zixunshi2").combobox("getValue"),
			xs_lururen : $("#xs_lururen2").val(),

			xs_namezixun : $("#xs_namezixun2").val(),
			xs_kecheng : $("#xs_kecheng2").val(),
			xs_dafen : $("#xs_dafen2").val(),
			xs_isyouxiao : $("#xs_isyouxiao2").combobox("getValue"),
			xs_wuxiaoyuanyin : $("#xs_wuxiaoyuanyin2").val(),
			xs_ishuifang : $("#xs_ishuifang2").combobox("getValue"),
			xs_shuocihuifangtime : $("#xs_shuocihuifangtime2").val(),
			xs_isshangmen : $("#xs_isshangmen2").combobox("getValue"),
			xs_shangmentime : $("#xs_shangmentime2").val(),
			xs_dingjinjine : $("#xs_dingjinjine2").val(),
			xs_dingjintime : $("#xs_dingjintime2").val(),
			xs_isjiaofei : $("#xs_isjiaofei2").combobox("getValue"),
			xs_jiaofeitime : $("#xs_jiaofeitime2").val(),
			xs_jine : $("#xs_jine2").val(),
			xs_istuifei : $("#xs_istuifei2").combobox("getValue"),
			xs_tuifeiyuanyin : $("#xs_tuifeiyuanyin2").val(),
			xs_isjinban : $("#xs_isjinban2").combobox("getValue"),
			xs_jinbantime : $("#xs_jinbantime2").val(),
			xs_jinbanbeizhu : $("#xs_jinbanbeizhu2").val(),
			xs_zixunshibeizhu : $("#xs_zixunshibeizhu2").val()
		}, function(res) {

		}, 'json')
	}
	/*  添加*/
	function insertDakai() {
		$("#frm3").form("reset");
		$("#insertStudent").dialog("open");
	}
	function inserGuanbi() {
		$("#insertStudent").dialog("close");
	}
	function inserStudent() {
		if ($("#frm3").form('validate')) {
			$.post("insertStudnet", {
				xs_name : $("#xs_name3").val(),
				xs_xingbie : $("#xs_xingbie3").combobox("getValue"),
				xs_nianling : $("#xs_nianling3").val(),
				xs_dianhua : $("#xs_dianhua3").val(),
				xs_xueli : $("#xs_xueli3").val(),
				xs_zhuangtai : $("#xs_zhuangtai3").val(),
				xs_laiyuanwangzhi : $("#xs_laiyuanwangzhi3").val(),
				xs_laiyuanqudao : $("#xs_laiyuanqudao3").val(),
				xs_liyuanguanjianzi : $("#xs_liyuanguanjianzi3").val(),
				xs_qq : $("#xs_qq3").val(),
				xs_weixin : $("#xs_weixin3").val(),
				xs_isbaobei : $("#xs_isbaobei3").combobox("getValue"),
			}, function(res) {
				if (res > 0) {
					//alert('添加成功');
					$.messager.show({
						title : '我的消息',
						msg : '添加成功',
						timeout : 1000,
						showType : 'slide',
						style : {
							top : document.body.scrollTop
									+ document.documentElement.scrollTop,
						}
					});
					$("#insertStudent").dialog("close");
					$("#StudentTab").datagrid("reload");
					$("#frm3").form("reset");
				} else {
					//alert('添加失败');
					$.messager.show({
						title : '我的消息',
						msg : '添加失败',
						timeout : 1000,
						showType : 'slide',
						style : {
							top : document.body.scrollTop
									+ document.documentElement.scrollTop,
						}
					});
				}
			}, 'json')
		} else {
			$.messager.show({
				title : '我的消息',
				msg : '你输入的数据不符合要求，请重新输入',
				timeout : 1000,
				showType : 'slide',
				style : {
					top : document.body.scrollTop
							+ document.documentElement.scrollTop,
				}
			});
		}
	}
	function xs_zixunshi(value, row, index) {
		if (row.us_zixunshi != null && row.us_zixunshi != "") {
			return row.us_zixunshi.us_name;
		} else {
			return "暂无咨询师";
		}
	}
	function xs_lururen(value, row, index) {
		return row.us_wangluozixunshi.us_name;
	}
	function xs_isbaobei(value, row, index) {
		return row.xs_isbaobei == 1 ? "是" : "否";
	}
	function xs_isyouxiao(value, row, index) {
		return row.xs_isyouxiao == 1 ? "有效" : (row.xs_isyouxiao == 2 ? "无效"
				: "待定");
	}
	function xs_ishuifang(value, row, index) {
		return row.xs_ishuifang == 1 ? "已回访" : "未回访";
	}
	function xs_isshangmen(value, row, index) {
		return row.xs_isshangmen == 1 ? "已上门" : "未上门";
	}
	function xs_isjiaofei(value, row, index) {
		return row.xs_isjiaofei == 1 ? "已缴费" : "未缴费";
	}
	function xs_istuifei(value, row, index) {
		return row.xs_istuifei == 1 ? "已退费" : "未退费";
	}
	function xs_isjinban(value, row, index) {
		return row.xs_isjinban == 1 ? "已进班" : "未进班";
	}
	/* 添加跟踪信息 */
	function genzong(index) {
		$("#frm4").form("reset");
		//tj_genzong_xs_id
		$("#tj_genzong_xs_id").val(
				$("#StudentTab").datagrid("getData").rows[index].xs_id);
		$("#genzongStudent").dialog("open");
	}
	function genzongGuanbi() {
		$("#genzongStudent").dialog("close");
	}
	function genzongBaoCun() {
		$.post("insertGenZong", {
			gz_xuesheng : $("#tj_genzong_xs_id").val(),
			gz_genzongtime : $("#gz_genzongtime").datetimebox("getValue"),
			gz_genzongneirong : $("#gz_genzongneirong").val(),
			gz_genzongfangshi : $("#gz_genzongfangshi").textbox("getValue"),
			gz_beizhu : $("#gz_beizhu").val(),
			gz_xiacigenzongtime : $("#gz_xiacigenzongtime").datetimebox(
					"getValue")
		}, function(res) {
			if (res == 1) {
				//alert('添加成功');
				$.messager.show({
					title : '我的消息',
					msg : '添加跟踪成功',
					timeout : 1000,
					showType : 'slide',
					style : {
						top : document.body.scrollTop
								+ document.documentElement.scrollTop,
					}
				});
				$("#genzongStudent").dialog("close");
				$("#StudentTab").datagrid("reload");
				$("#frm4").form("reset");
			} else {
				//alert('添加失败');
				$.messager.show({
					title : '我的消息',
					msg : '添加跟踪失败',
					timeout : 1000,
					showType : 'slide',
					style : {
						top : document.body.scrollTop
								+ document.documentElement.scrollTop,
					}
				});
				$("#genzongStudent").dialog("close");
				$("#frm4").form("reset");
			}
		}, 'json')
	}
	function daochuexcel() {
		var row = $("#StudentTab").datagrid("getSelections");
		if (row != null && row != "") {
			var xs_ids = "";
			for (var i = 0; i < row.length; i++) {
				if (i == 0) {
					xs_ids = xs_ids + row[i].xs_id;
				} else {
					xs_ids = xs_ids + "," + row[i].xs_id;
				}
			}
			$.messager.confirm('确认', '您确认想要把当前数据导出Excel吗？', function(r) {
				if (r) {
					window.location.href = "daochuexcel?xs_ids=" + xs_ids;
				}
			});

		} else {
			$.messager.show({
				title : '我的消息',
				msg : '还未选择学生，请选择！',
				timeout : 1000,
				showType : 'slide',
				style : {
					top : document.body.scrollTop
							+ document.documentElement.scrollTop,
				}
			});
		}
	}
	function dongtai(value, row, index) {
<%List<Juese> juese = user.getJuese();
			int zx = 0;
			int jl = 0;
			for (int i = 0; i < juese.size(); i++) {
				if (juese.get(i).getJs_name().equals("咨询师")) {
					zx++;
				} else if (juese.get(i).getJs_name().equals("咨询经理") || juese.get(i).getJs_name().equals("管理员")) {
					zx++;
					jl++;
				} else if (juese.get(i).getJs_name().equals("网络咨询师")) {
					jl++;
				}
			}
			if (zx > 0 && jl > 0) {%>
	return "<a href='javascript:void(0)' class='easyui-linkbutton' onclick='ck_dtrz("
				+ index
				+ ")' > 查看动态日志 </a>&nbsp;&nbsp;<a href='javascript:void(0)' class='easyui-linkbutton' onclick='tj_dtrz("
				+ index + ")' > 添加动态日志 </a>";
<%} else if (zx > 0) {%>
	return "<a href='javascript:void(0)' class='easyui-linkbutton' onclick='ck_dtrz("
				+ index + ")' > 查看动态日志 </a>";
<%} else if (jl > 0) {%>
	return "<a href='javascript:void(0)' class='easyui-linkbutton' onclick='tj_dtrz("
				+ index + ")' > 添加动态日志 </a>";
<%}%>
	}

	function tj_dtrz(index) {
		$("#tj_dtrz_ff").form("reset");
		$("#tj_dtrz_xs_id").val(
				$("#StudentTab").datagrid("getData").rows[index].xs_id);
		dt_us_name = null;
		dt_us_name = $("#StudentTab").datagrid("getData").rows[index].us_zixunshi.us_name;
		dt_xs_name = null;
		dt_xs_name = $("#StudentTab").datagrid("getData").rows[index].xs_name;
		dt_xs_id = null;
		dt_xs_id = $("#StudentTab").datagrid("getData").rows[index].xs_id;
		$("#tj_dtrz_us_id")
				.val(
						$("#StudentTab").datagrid("getData").rows[index].us_zixunshi.us_name);
		$("#tj_dtrz_win").window("open");
	}
	var dt_us_name = null;
	var dt_xs_name = null;
	var dt_xs_id = null;
	function tj_dtrz_bc() {
		$.post("tianjia_dongtairizhi", {
			dt_student : $("#tj_dtrz_xs_id").val(),
			dt_neirong : $("#tj_dt_neirong").val()
		}, function(res) {
			if (res == 1) {
				$("#tj_dtrz_ff").form("reset");
				$("#tj_dtrz_win").window("close");
				$.messager.show({
					title : '我的消息',
					msg : '添加动态信息成功',
					timeout : 1000,
					showType : 'slide',
					style : {
						top : document.body.scrollTop
								+ document.documentElement.scrollTop,
					}
				});
				send(dt_us_name + "&" + dt_xs_name + "&" + dt_xs_id);

			} else {
				$.messager.show({
					title : '我的消息',
					msg : '添加动态信息失败',
					timeout : 1000,
					showType : 'slide',
					style : {
						top : document.body.scrollTop
								+ document.documentElement.scrollTop,
					}
				});
			}
		}, "json");
	}

	function ck_dtrz(index) {

		$("#dtxx_tt")
				.datagrid(
						{
							url : 'student_dtrz_xs',
							method : 'post',
							pagination : true,
							queryParams : {
								dt_student : $("#StudentTab").datagrid(
										"getData").rows[index].xs_id
							}

						});
		$("#ck_dtrz_win").window("open");
	}
	function ck_dtrz_gb() {
		$("#ck_dtrz_win").window("close");
	}
	function dt_student(value, row, index) {
		return row.stu.xs_name;
	}
	function dt_tianjiaren(value, row, index) {
		return row.us.us_name;
	}
	function dt_neirong(value, row, index) {
		return "<a href='javascript:void(0)' class='easyui-linkbutton' onclick='dt_neirong_chankan("
				+ index + ")' > 查看 </a>";
	}
	function dt_neirong_chankan(index) {
		$("#nr_dt_neirong").val(
				$("#dtxx_tt").datagrid("getData").rows[index].dt_neirong);
		$("#nr_dtrz_win").window("open");
	}
	function nr_dtrz_gb() {
		$("#nr_dtrz_win").window("close");
	}
	/*  查看跟踪日志*/
	function formattergenzong(value, row, index) {
		return "<a href='javascript:void(0)' class='easyui-linkbutton' onclick='genzong("
				+ index
				+ ")' > 跟踪 </a>&nbsp;&nbsp;<a href='javascript:void(0)' class='easyui-linkbutton' onclick='ck_genzong("
				+ index + ")' > 查看跟踪 </a>"
	}
	function ck_genzong(index) {
		$("#ck_gzrz_tt")
				.datagrid(
						{
							url : 'selectGengzongrizhi_xs_id',
							method : 'post',
							pagination : true,
							queryParams : {
								gz_xuesheng : $("#StudentTab").datagrid(
										"getData").rows[index].xs_id
							}

						});
		$("#ck_gzrz_win").window("open");
	}
	function gz_xuesheng(value, row, index) {
		return row.stu == null ? "" : row.stu.xs_name;
	}
	function gz_user(value, row, index) {
		return row.us == null ? "" : row.us.us_name;
	}
	function ck_gz_genzongneirong(value, row, index) {
		return "<a href='javascript:void(0)' class='easyui-linkbutton' onclick='ck_gz_genzongneirong_a("
				+ index + ")' > 查看 </a>";
	}
	function ck_gz_genzongneirong_a(index) {
		$("#nr_gz_neirong")
				.val(
						$("#ck_gzrz_tt").datagrid("getData").rows[index].gz_genzongneirong);
		$("#nr_gzrz_win").window("open");
	}
	function ck_gzrz_gb() {
		$("#ck_gzrz_win").window("close");
	}
	function nr_gzrz_gb() {
		$("#nr_gzrz_win").window("close");
	}

	var us_name = "${user.us_name}";
	var websocket = null;
	//判断当前浏览器是否支持WebSocket
	if ('WebSocket' in window) {
		websocket = new WebSocket(
				"ws://${pageContext.request.getServerName()}:${pageContext.request.getServerPort()}${pageContext.request.contextPath}/dongtaitongxing/"
						+ us_name);
	} else {
		alert('当前浏览器 Not support websocket')
	}

	//连接发生错误的回调方法
	websocket.onerror = function() {
		//setMessageInnerHTML("WebSocket连接发生错误");
	};

	//连接成功建立的回调方法
	websocket.onopen = function() {
		//setMessageInnerHTML("您已进入聊天室！");
		//websocket.send("您已进入聊天室！");
		//send();

	}

	//接收到消息的回调方法
	websocket.onmessage = function(event) {
		//alert("111")
		// setMessageInnerHTML(event.data);
	}

	//连接关闭的回调方法
	websocket.onclose = function() {
		// setMessageInnerHTML("您已离开入聊天室！");
	}

	//监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。
	window.onbeforeunload = function() {
		closeWebSocket();
	}

	//将消息显示在网页上
	function setMessageInnerHTML(innerHTML) {
		document.getElementById('message').innerHTML += innerHTML + '<br/>';
	}

	//关闭WebSocket连接
	function closeWebSocket() {
		websocket.close();
	}
	//发送消息
	function send(jsr) {
		//var message = $("#nr_lt_neirong").val();
		websocket.send(jsr);
	}
	$(function() {
		$('#xs_shuocihuifangtime1').datetimebox({
			value : '3/4/2010 2:3',
			showSeconds : false
		});
		$('#xs_shangmentime1').datetimebox({
			value : '3/4/2010 2:3',
			showSeconds : false
		});
		$('#xs_dingjintime1').datetimebox({
			value : '3/4/2010 2:3',
			showSeconds : false
		});
		$('#xs_jiaofeitime1').datetimebox({
			value : '3/4/2010 2:3',
			showSeconds : false
		});
		$('#xs_jinbantime1').datetimebox({
			value : '3/4/2010 2:3',
			showSeconds : false
		});
	});
	function yincang() {
		$('#yc_window').window('open');
	}
	function yc_yincang() {
		var obj = document.getElementsByName("yc_leiming");
		var xuanzhong = [];
		var weixuan = [];
		for (var i = 0; i < obj.length; i++) {
			if (obj[i].checked) {
				xuanzhong.push(obj[i].value);
			} else {
				weixuan.push(obj[i].value);
			}
		}
		for (var i = 0; i < xuanzhong.length; i++) {
			$('#StudentTab').datagrid('hideColumn', '' + xuanzhong[i] + '');
		}
		for (var i = 0; i < weixuan.length; i++) {
			$('#StudentTab').datagrid('showColumn', '' + weixuan[i] + '');
		}
		$('#yc_window').window('close');
	}
	function yc_guanbi() {
		$('#yc_window').window('close');
	}
</script>
</head>
<body>
<jsp:include page="stu_yingcang.jsp"></jsp:include>
	<table id="StudentTab" class="easyui-datagrid">
		<thead>
			<tr>
				<th data-options="field:'checkbox',sortable:true,checkbox:true">用户ID</th>
				<th data-options="field:'xs_id'">学生编号</th>
				<th data-options="field:'xs_name' ">姓名</th>
				<th data-options="field:'xs_xingbie',formatter:formatterxingbie">性别</th>
				<th data-options="field:'xs_nianling' ">年龄</th>
				<th data-options="field:'xs_dianhua' ">电话</th>
				<th data-options="field:'xs_chuangjiantime' ">创建时间</th>
				<th data-options="field:'xs_xueli' ">学历</th>
				<th data-options="field:'xs_zhuangtai' ">个人状态</th>
				<th data-options="field:'xs_laiyuanqudao' ">来源渠道</th>
				<th data-options="field:'xs_laiyuanwangzhi' ">来源网址</th>
				<th data-options="field:'xs_guanzhu' ">学生关注</th>
				<th data-options="field:'xs_liyuanguanjianzi' ">来源关键字</th>
				<th data-options="field:'xs_namezixun' ">姓名咨询</th>
				<th data-options="field:'xs_suozaiquyu' ">所在区域</th>
				<th data-options="field:'xs_weixin' ">微信</th>
				<th data-options="field:'xs_qq' ">qq</th>
				<th data-options="field:'xs_laiyuanbumen' ">来源部门</th>
				<th data-options="field:'xs_isbaobei',formatter:xs_isbaobei">是否报备</th>
				<th data-options="field:'xs_kecheng' ">课程方向</th>
				<th data-options="field:'xs_isyouxiao',formatter:xs_isyouxiao">是否有效</th>
				<th data-options="field:'xs_dafen' ">打分</th>
				<th data-options="field:'xs_ishuifang',formatter:xs_ishuifang">是否回访</th>
				<th data-options="field:'xs_shuocihuifangtime' ">首次回访时间</th>
				<th data-options="field:'xs_isshangmen',formatter:xs_isshangmen ">是否上门</th>
				<th data-options="field:'xs_shangmentime' ">上门时间</th>
				<th data-options="field:'xs_wuxiaoyuanyin' ">无效原因</th>
				<th data-options="field:'xs_isjiaofei',formatter:xs_isjiaofei ">是否缴费</th>
				<th data-options="field:'xs_jiaofeitime' ">缴费时间</th>
				<th data-options="field:'xs_jine' ">金额</th>
				<th data-options="field:'xs_istuifei',formatter:xs_istuifei ">是否退费</th>
				<th data-options="field:'xs_isjinban',formatter:xs_isjinban ">是否进班</th>
				<th data-options="field:'xs_jinbantime' ">进班时间</th>
				<th data-options="field:'xs_jinbanbeizhu' ">进班备注</th>
				<th data-options="field:'xs_tuifeiyuanyin' ">退费原因</th>
				<th data-options="field:'xs_dingjinjine' ">定金金额</th>
				<th data-options="field:'xs_dingjintime' ">定金时间</th>
				<th data-options="field:'xs_zixunshi',formatter:xs_zixunshi">咨询师</th>
				<th data-options="field:'xs_lururen',formatter:xs_lururen">录入人</th>
				<th data-options="field:'xs_zixunshibeizhu' ">咨询师备注</th>
				<th data-options="field:'xs_caozuo',formatter:formattercaozuo ">操作</th>
				<th data-options="field:'xs_genzong',formatter:formattergenzong ">跟踪</th>
				<th data-options="field:'dongtai',formatter:dongtai">动态</th>
			</tr>
		</thead>
	</table>
	<div id="StudentToo" style="padding: 5px; height: auto">
		<div style="margin-bottom: 5px">
			<form id="frm" class="easyui-form">

				<label>姓名:</label><input class="easyui-textbox" id="xs_name"
					name="xs_name" style="width: 100px"> <label>电话:</label><input
					class="easyui-textbox" id="xs_dianhua" name="xs_dianhua"
					style="width: 100px"> <label>咨询师:</label> <select
					id="xs_zixunshi" data-options="editable:false"
					class="easyui-combobox" name="xs_zixunshi" style="width: 159px;">
					<option>---请选择---</option>
				</select> <label>是否缴费:</label> <select id="xs_isjiaofei"
					class="easyui-combobox" name="xs_isjiaofei"
					data-options="editable:false" style="width: 159px;">
					<option value="---请选择---">---请选择---</option>
					<option value="1">已缴费</option>
					<option value="2">未缴费</option>
				</select> <label>是否有效:</label> <select id="xs_isyouxiao"
					class="easyui-combobox" name="xs_isyouxiao"
					data-options="editable:false" style="width: 159px;">
					<option value="---请选择---">---请选择---</option>
					<option value="1">是</option>
					<option value="2">否</option>
					<option value="3">待定</option>
				</select> <label>是否回访:</label> <select id="xs_ishuifang"
					class="easyui-combobox" name="xs_ishuifang"
					data-options="editable:false" style="width: 159px;">
					<option value="---请选择---">---请选择---</option>
					<option value="1">已回访</option>
					<option value="2">未回访</option>
				</select> <label>QQ:</label><input class="easyui-textbox" id="xs_qq"
					name="xs_qq" style="width: 100px"><br> <label>创建时间:</label><input
					class="easyui-datetimebox" id="minxs_chuangjiantime"
					name="minxs_chuangjiantime" value="" style="width: 150px">~~~<input
					class="easyui-datetimebox" id="maxxs_chuangjiantime"
					name="maxxs_chuangjiantime" value="" style="width: 150px">

				<label>上门时间:</label><input class="easyui-datetimebox"
					id="minxs_shangmentime" name="minxs_shangmentime" value=""
					style="width: 150px">~~~<input class="easyui-datetimebox"
					id="maxxs_shangmentime" name="maxxs_shangmentime" value=""
					style="width: 150px"> <label>首次回访时间:</label><input
					class="easyui-datetimebox" id="minxs_shuocihuifangtime"
					name="minxs_shuocihuifangtime" value="" style="width: 157px">~~~<input
					class="easyui-datetimebox" id="maxxs_shuocihuifangtime"
					name="maxxs_shuocihuifangtime" value="" style="width: 157px">
				<br> <label>缴费时间:</label><input class="easyui-datetimebox"
					id="minxs_jiaofeitime" name="minxs_jiaofeitime" value=""
					style="width: 150px">~~~<input class="easyui-datetimebox"
					id="maxxs_jiaofeitime" name="maxxs_jiaofeitime" value=""
					style="width: 150px"> <label>进班时间:</label><input
					class="easyui-datetimebox" id="minxs_jinbantime"
					name="minxs_jinbantime" value="" style="width: 150px">~~~<input
					class="easyui-datetimebox" id="maxxs_jinbantime"
					name="maxxs_jinbantime" value="" style="width: 150px"> <a
					href="javascript:void(0)" class="easyui-linkbutton"
					onclick="student_guanli()" data-options="iconCls:'icon-search'">搜索</a>
				<a href="javascript:void(0)" class="easyui-linkbutton"
					onclick="insertDakai()" data-options="iconCls:'icon-add'">添加</a> <a
					href="javascript:void(0)" class="easyui-linkbutton"
					onclick="daochuexcel()" data-options="iconCls:'icon-redo'">导出Excel</a>

				<a href="javascript:void(0)" iconCls="icon-clear"
					class="easyui-linkbutton" onclick="yincang()">隐藏</a>

			</form>
		</div>
	</div>

	<!--  编辑-->
	<div id="updateStuYuan" class="easyui-dialog"
		style="width: 700px; height: 550px"
		data-options="title:' 编辑 ',modal:true,closed:true,
			buttons:[{
				text:'保存',
				handler:function(){
				updateStuYuanBao();
				}
			},{
				text:'关闭',
				handler:function(){
				 updateGuanbi();
				}
			}]">


		<div style="float: left;">
			<form id="frm1_zai" name="frm1_zai" class="easyui-form">
				<input disabled="disabled" type="text" id="xs_id_xiugai"
					name="xs_id" style="display: none;" />
				<table>
					<tr>
						<td>
							<h3>在线录入</h3>
						</td>
					</tr>
					<tr>
						<td>姓名:</td>
						<td><input class="easyui-textbox" required="true" type="text"
							id="xs_name1" name="xs_name" /></td>
					</tr>
					<tr>
						<td>性别:</td>
						<td><select id="xs_xingbie1" class="easyui-combobox"
							name="xs_xingbie" data-options="editable:false"
							style="width: 159px;">
								<option value="">---请选择---</option>
								<option value="1">男</option>
								<option value="2">女</option>
						</select></td>
					</tr>
					<tr>
						<td>年龄:</td>
						<td><input class="easyui-textbox" type="text"
							id="xs_nianling1" name="xs_nianling" /></td>
					</tr>
					<tr>
						<td>电话:</td>
						<td><input class="easyui-textbox" type="text"
							id="xs_dianhua1" required="true" validType="mobile"
							name="xs_dianhua" /></td>
					</tr>
					<tr>
						<td>学历:</td>
						<td><select id="xs_xueli1" class="easyui-combobox"
							name="xs_xueli" data-options="editable:false"
							style="width: 159px;">
								<option value="">---请选择---</option>
								<option value="未知">未知</option>
								<option value="大专">大专</option>
								<option value="高中">高中</option>
								<option value="中专">中专</option>
								<option value="初中">初中</option>
								<option value="本科">本科</option>
								<option value="其他">其他</option>
						</select></td>
					</tr>
					<tr>
						<td>状态:</td>
						<td><select id="xs_zhuangtai1" class="easyui-combobox"
							name="xs_zhuangtai" data-options="editable:false"
							style="width: 159px;">
								<option value="">---请选择---</option>
								<option value="未知">未知</option>
								<option value="待业">待业</option>
								<option value="在职">在职</option>
								<option value="在读">在读</option>
						</select></td>
					</tr>
					<tr>
						<td>来源渠道:</td>
						<td><select id="xs_laiyuanqudao1" required="true"
							class="easyui-combobox" name="xs_laiyuanqudao"
							data-options="editable:false" style="width: 159px;">
								<option value="">---请选择---</option>
								<option value="未知">未知</option>
								<option value="百度">百度</option>
								<option value="百度移动端">百度移动端</option>
								<option value="360">360</option>
								<option value="360移动端">360移动端</option>
								<option value="搜狗">搜狗</option>
								<option value="搜狗移动端">搜狗移动端</option>
								<option value="UC移动端">UC移动端</option>
								<option value="直接输入">直接输入</option>
								<option value="自然流量">自然流量</option>
								<option value="直电">直电</option>
								<option value="微信">微信</option>
								<option value="qq">qq</option>
						</select></td>
					</tr>
					<tr>
						<td>来源网站:</td>
						<td><select id="xs_laiyuanwangzhi1" required="true"
							class="easyui-combobox" name="xs_laiyuanwangzhi"
							data-options="editable:false" style="width: 159px;">
								<option value="">---请选择---</option>
								<option value="其他">其他</option>
								<option value="职英B站">职英B站</option>
								<option value="高考站">高考站</option>
								<option value="职英A站">职英A站</option>
						</select></td>
					</tr>
					<tr>
						<td>来源关键字:</td>
						<td><input class="easyui-textbox" required="true" type="text"
							id="xs_liyuanguanjianzi1" name="xs_liyuanguanjianzi" /></td>
					</tr>
					<tr>
						<td>所在区域:</td>
						<td><select id="xs_suozaiquyu1" class="easyui-combobox"
							name="xs_suozaiquyu" data-options="editable:false"
							style="width: 159px;">
								<option value="">---请选择---</option>
								<option value="未知">未知</option>
								<option value="其他">其他</option>
								<option value="郑州">郑州</option>
								<option value="开封">开封</option>
								<option value="洛阳">洛阳</option>
								<option value="南阳">南阳</option>
								<option value="漯河">漯河</option>
								<option value="三门峡">三门峡</option>
								<option value="平定山">平定山</option>
								<option value="周口">周口</option>
								<option value="驻马店">驻马店</option>
								<option value="新乡">新乡</option>
								<option value="鹤壁">鹤壁</option>
								<option value="焦作">焦作</option>
								<option value="濮阳">濮阳</option>
								<option value="安阳">安阳</option>
								<option value="商丘">商丘</option>
								<option value="信阳">信阳</option>
								<option value="济源">济源</option>

						</select></td>
					</tr>
					<tr>
						<td>学员关注:</td>
						<td><select id="xs_guanzhu1" class="easyui-combobox"
							name="xs_guanzhu" data-options="editable:false"
							style="width: 159px;">
								<option value="">---请选择---</option>
								<option value="课程">课程</option>
								<option value="学费">学费</option>
								<option value="学时">学时</option>
								<option value="学历">学历</option>
								<option value="师资">师资</option>
								<option value="就业">就业</option>
								<option value="环境">环境</option>
								<option value="其他">其他</option>
						</select></td>
					</tr>
					<tr>
						<td>来源部门:</td>
						<td><select id="xs_laiyuanbumen1" class="easyui-combobox"
							name="xs_laiyuanbumen" data-options="editable:false"
							style="width: 159px;">
								<option value="">---请选择---</option>
								<option value="网络">网络</option>
								<option value="市场">市场</option>
								<option value="教质">教质</option>
								<option value="学术">学术</option>
								<option value="就业">就业</option>
						</select></td>
					</tr>
					<tr>
						<td>学员QQ:</td>
						<td><input class="easyui-textbox" type="text" id="xs_qq1"
							name="xs_qq" /></td>
					</tr>
					<tr>
						<td>微信号:</td>
						<td><input class="easyui-textbox" type="text" id="xs_weixin1"
							name="xs_weixin" /></td>
					</tr>
					<tr>
						<td>是否报备(是,否):</td>
						<td><select id="xs_isbaobei1" data-options="editable:false"
							class="easyui-combobox" name="xs_isbaobei" style="width: 159px;">
								<option value="">— —请选择— —</option>
								<option value="1">是</option>
								<option value="2">否</option>
						</select></td>
					</tr>
					<tr>
						<td>咨询师:</td>
						<td><select id="xs_zixunshi1" disabled="disabled"
							data-options="editable:false" class="easyui-combobox"
							name="xs_zixunshi" style="width: 159px;">
								<option>---请选择---</option>
						</select>
					</tr>
					<tr>
						<td>录入人:</td>
						<td><select id="xs_lururen1" disabled="disabled"
							data-options="editable:false" class="easyui-combobox"
							name="xs_zixunshi" style="width: 159px;">
								<option>---请选择---</option>
						</select>
					</tr>
				</table>
			</form>

		</div>


		<div style="float: right;">
			<form id="frm1_zi" name="frm1_zi" class="easyui-form">
				<table>
					<tr>
						<td>
							<h3>咨询师录入</h3>
						</td>
					</tr>
					<tr>
						<td>姓名咨询:</td>
						<td><input class="easyui-textbox" type="text"
							id="xs_namezixun1" name="xs_namezixun" /></td>
					</tr>
					<tr>
						<td>课程方向:</td>
						<td><select id="xs_kecheng1" class="easyui-combobox"
							name="xs_kecheng" data-options="editable:false"
							style="width: 159px;">
								<option value="">---请选择---</option>
								<option value="软件开发">软件开发</option>
								<option value="软件设计">软件设计</option>
								<option value="网络营销">网络营销</option>
						</select></td>
					</tr>
					<tr>
						<td>打分:</td>
						<td><select id="xs_dafen1" class="easyui-combobox"
							name="xs_dafen" data-options="editable:false"
							style="width: 159px;">
								<option value="">---请选择---</option>
								<option value="近期可报名">近期可报名</option>
								<option value="一个月内可报名">一个月内可报名</option>
								<option value="长期跟踪">长期跟踪</option>
								<option value="无效">无效</option>
						</select></td>
					</tr>
					<tr>
						<td>是否有效(是,否):</td>
						<td><select id="xs_isyouxiao1" class="easyui-combobox"
							name="xs_isyouxiao" data-options="editable:false"
							style="width: 159px;">
								<option value="">---请选择---</option>
								<option value="1">是</option>
								<option value="2">否</option>
								<option value="3">待定</option>
						</select></td>
					</tr>
					<tr>
						<td>无效原因:</td>
						<td><input class="easyui-textbox" type="text"
							id="xs_wuxiaoyuanyin1" name="xs_wuxiaoyuanyin" /></td>
					</tr>
					<tr>
						<td>是否回访(是,否):</td>
						<td><select id="xs_ishuifang1" data-options="editable:false"
							class="easyui-combobox" name="xs_ishuifang" style="width: 159px;">
								<option value="">---请选择---</option>
								<option value="1">已回访</option>
								<option value="2">未回访</option>
						</select></td>
					</tr>
					<tr>
						<td>首访时间:</td>
						<td><input class="easyui-textbox" type="text"
							id="xs_shuocihuifangtime1" style="width: 159px"
							name="xs_shuocihuifangtime" /></td>
					</tr>
					<tr>
						<td>是否上门(是,否):</td>
						<td><select id="xs_isshangmen1" data-options="editable:false"
							class="easyui-combobox" name="xs_isshangmen"
							style="width: 159px;">
								<option value="">---请选择---</option>
								<option value="1">已上门</option>
								<option value="2">未上门</option>
						</select></td>
					</tr>
					<tr>
						<td>上门时间:</td>
						<td><input class="easyui-textbox" style="width: 159px"
							type="text" id="xs_shangmentime1" name="xs_shangmentime" /></td>
					</tr>
					<tr>
						<td>定金金额:</td>
						<td><input class="easyui-textbox" type="text"
							id="xs_dingjinjine1" name="xs_dingjinjine" /></td>
					</tr>
					<tr>
						<td>定金时间:</td>
						<td><input class="easyui-textbox" style="width: 159px"
							type="text" id="xs_dingjintime1" name="xs_dingjintime" /></td>
					</tr>
					<tr>
						<td>是否缴费(是,否):</td>
						<td><select id="xs_isjiaofei1" data-options="editable:false"
							class="easyui-combobox" name="xs_isjiaofei" style="width: 159px;">
								<option value="">---请选择---</option>
								<option value="1">已缴费</option>
								<option value="2">未缴费</option>
						</select></td>
					</tr>
					<tr>
						<td>缴费时间:</td>
						<td><input class="easyui-textbox" style="width: 159px"
							type="text" id="xs_jiaofeitime1" name="xs_jiaofeitime" /></td>
					</tr>
					<tr>
						<td>缴费金额:</td>
						<td><input class="easyui-textbox" type="text" id="xs_jine1"
							name="xs_jine" /></td>
					</tr>
					<tr>
						<td>是否退费(是,否):</td>
						<td><select id="xs_istuifei1" data-options="editable:false"
							class="easyui-combobox" name="xs_istuifei" style="width: 159px;">
								<option value="">---请选择---</option>
								<option value="1">已退费</option>
								<option value="2">未退费</option>
						</select></td>
					</tr>
					<tr>
						<td>退费原因:</td>
						<td><input class="easyui-textbox" type="text"
							id="xs_tuifeiyuanyin1" name="xs_tuifeiyuanyin" /></td>
					</tr>
					<tr>
						<td>是否进班(是,否):</td>
						<td><select id="xs_isjinban1" data-options="editable:false"
							class="easyui-combobox" name="xs_isjinban" style="width: 159px;">
								<option value="">---请选择---</option>
								<option value="1">已进班</option>
								<option value="2">未进班</option>
						</select></td>
					</tr>
					<tr>

						<td>进班时间:</td>
						<td><input class="easyui-textbox" style="width: 159px"
							type="text" id="xs_jinbantime1" name="xs_jinbantime" /></td>
					</tr>
					<tr>

						<td>进班备注:</td>
						<td><input class="easyui-textbox" type="text"
							id="xs_jinbanbeizhu1" name="xs_jinbanbeizhu" /></td>
					</tr>
					<tr>
						<td>咨询师 备注:</td>
						<td><input class="easyui-textbox" type="text"
							id="xs_zixunshibeizhu1" name="xs_zixunshibeizhu" /></td>
					</tr>
				</table>
			</form>
		</div>
	</div>

	<!--查看  -->
	<div id="chakanStudent" class="easyui-dialog"
		style="width: 700px; height: 550px"
		data-options="title:' 查看 ',modal:true,closed:true,
			buttons:[{
				text:'关闭',
				handler:function(){
				updateUUGuanbi();
				}
			}]">

		<form id="frm2" class="easyui-form">

			<div style="float: left;">
				<table>
					<tr>
						<td>编号:</td>
						<td><input disabled="disabled" class="easyui-textbox"
							type="text" id="xs_id2" name="xs_id" /></td>
					</tr>
					<tr>
						<td>姓名:</td>
						<td><input disabled="disabled" class="easyui-textbox"
							type="text" id="xs_name2" name="xs_name" /></td>
					</tr>
					<tr>
						<td>性别:</td>
						<td><select disabled="disabled" id="xs_xingbie2"
							class="easyui-combobox" name="xs_xingbie" style="width: 159px;">
								<option value="">— —请选择— —</option>
								<option value="1">男</option>
								<option value="2">女</option>
						</select></td>
					</tr>
					<tr>
						<td>年龄:</td>
						<td><input disabled="disabled" class="easyui-textbox"
							type="text" id="xs_nianling2" name="xs_nianling" /></td>
					</tr>
					<tr>
						<td>电话:</td>
						<td><input disabled="disabled" class="easyui-textbox"
							type="text" id="xs_dianhua2" name="xs_dianhua" /></td>
					</tr>
					<tr>
						<td>学历:</td>
						<td><input disabled="disabled" class="easyui-textbox"
							type="text" id="xs_xueli2" name="xs_xueli" /></td>
					</tr>
					<tr>
						<td>状态:</td>
						<td><input disabled="disabled" class="easyui-textbox"
							type="text" id="xs_zhuangtai2" name="xs_zhuangtai" /></td>
					</tr>
					<tr>
						<td>来源渠道:</td>
						<td><input disabled="disabled" class="easyui-textbox"
							type="text" id="xs_laiyuanqudao2" name="xs_laiyuanqudao" /></td>
					</tr>
					<tr>
						<td>来源网站:</td>
						<td><input disabled="disabled" class="easyui-textbox"
							type="text" id="xs_laiyuanwangzhi2" name="xs_laiyuanwangzhi" /></td>
					</tr>
					<tr>
						<td>来源关键字:</td>
						<td><input disabled="disabled" class="easyui-textbox"
							type="text" id="xs_liyuanguanjianzi2" name="xs_liyuanguanjianzi" /></td>
					</tr>
					<tr>
						<td>所在区域:</td>
						<td><input disabled="disabled" class="easyui-textbox"
							type="text" id="xs_suozaiquyu2" name="xs_suozaiquyu" /></td>
					</tr>
					<tr>
						<td>学员关注:</td>
						<td><input disabled="disabled" class="easyui-textbox"
							type="text" id="xs_guanzhu2" name="xs_guanzhu" /></td>
					</tr>
					<tr>
						<td>来源部门:</td>
						<td><input disabled="disabled" class="easyui-textbox"
							type="text" id="xs_laiyuanbumen2" name="xs_laiyuanbumen" /></td>
					</tr>
					<tr>
						<td>学员QQ:</td>
						<td><input disabled="disabled" class="easyui-textbox"
							type="text" id="xs_qq2" name="xs_qq" /></td>
					</tr>
					<tr>
						<td>微信号:</td>
						<td><input disabled="disabled" class="easyui-textbox"
							type="text" id="xs_weixin2" name="xs_weixin" /></td>
					</tr>
					<tr>
						<td>是否报备(是,否):</td>
						<td><select disabled="disabled" id="xs_isbaobei2"
							class="easyui-combobox" name="xs_isbaobei" style="width: 159px;">
								<option value="">— —请选择— —</option>
								<option value="1">是</option>
								<option value="2">否</option>
						</select></td>
					</tr>
					<tr>
						<td>咨询师:</td>
						<td><input disabled="disabled" class="easyui-textbox"
							type="text" id="xs_zixunshi2" name="xs_zixunshi" /></td>
					</tr>
					<tr>
						<td>录入人:</td>
						<td><input disabled="disabled" class="easyui-textbox"
							type="text" id="xs_lururen2" name="xs_lururen" /></td>
					</tr>
				</table>

			</div>

			<div style="float: right;">
				<table>
					<tr>
						<td>姓名咨询:</td>
						<td><input disabled="disabled" class="easyui-textbox"
							type="text" id="xs_namezixun2" name="xs_namezixun" /></td>
					</tr>
					<tr>
						<td>课程方向:</td>
						<td><input disabled="disabled" class="easyui-textbox"
							type="text" id="xs_kecheng2" name="xs_kecheng" /></td>
					</tr>
					<tr>
						<td>打分:</td>
						<td><input disabled="disabled" class="easyui-textbox"
							type="text" id="xs_dafen2" name="xs_dafen" /></td>
					</tr>
					<tr>
						<td>是否有效(是,否):</td>
						<td><select disabled="disabled" id="xs_isyouxiao2"
							class="easyui-combobox" name="xs_isyouxiao" style="width: 159px;">
								<option value="">— —请选择— —</option>
								<option value="1">是</option>
								<option value="2">否</option>
								<option value="3">待定</option>
						</select></td>
					</tr>
					<tr>
						<td>无效原因:</td>
						<td><input disabled="disabled" class="easyui-textbox"
							type="text" id="xs_wuxiaoyuanyin2" name="xs_wuxiaoyuanyin" /></td>
					</tr>
					<tr>
						<td>是否回访(是,否):</td>
						<td><select disabled="disabled" id="xs_ishuifang2"
							class="easyui-combobox" name="xs_ishuifang" style="width: 159px;">
								<option value="">— —请选择— —</option>
								<option value="1">已回访</option>
								<option value="2">未回访</option>
						</select></td>
					</tr>
					<tr>
						<td>首访时间:</td>
						<td><input disabled="disabled" class="easyui-textbox"
							type="text" id="xs_shuocihuifangtime2"
							name="xs_shuocihuifangtime" /></td>
					</tr>
					<tr>
						<td>是否上门(是,否):</td>
						<td><select disabled="disabled" id="xs_isshangmen2"
							class="easyui-combobox" name="xs_isshangmen"
							style="width: 159px;">
								<option value="">— —请选择— —</option>
								<option value="1">已上门</option>
								<option value="2">未上门</option>
						</select></td>
					</tr>
					<tr>
						<td>上门时间:</td>
						<td><input disabled="disabled" class="easyui-textbox"
							type="text" id="xs_shangmentime2" name="xs_shangmentime" /></td>
					</tr>
					<tr>
						<td>定金金额:</td>
						<td><input disabled="disabled" class="easyui-textbox"
							type="text" id="xs_dingjinjine2" name="xs_dingjinjine" /></td>
					</tr>
					<tr>
						<td>定金时间:</td>
						<td><input disabled="disabled" class="easyui-textbox"
							type="text" id="xs_dingjintime2" name="xs_dingjintime" /></td>
					</tr>
					<tr>
						<td>是否缴费(是,否):</td>
						<td><select disabled="disabled" id="xs_isjiaofei2"
							class="easyui-combobox" name="xs_isjiaofei" style="width: 159px;">
								<option value="">— —请选择— —</option>
								<option value="1">已缴费</option>
								<option value="2">未缴费</option>
						</select></td>
					</tr>
					<tr>
						<td>缴费时间:</td>
						<td><input disabled="disabled" class="easyui-textbox"
							type="text" id="xs_jiaofeitime2" name="xs_jiaofeitime" /></td>
					</tr>
					<tr>
						<td>缴费金额:</td>
						<td><input disabled="disabled" class="easyui-textbox"
							type="text" id="xs_jine2" name="xs_jine" /></td>
					</tr>
					<tr>
						<td>是否退费(是,否):</td>
						<td><select disabled="disabled" id="xs_istuifei2"
							class="easyui-combobox" name="xs_istuifei" style="width: 159px;">
								<option value="">— —请选择— —</option>
								<option value="1">已退费</option>
								<option value="2">未退费</option>
						</select></td>
					</tr>
					<tr>
						<td>退费原因:</td>
						<td><input disabled="disabled" class="easyui-textbox"
							type="text" id="xs_tuifeiyuanyin2" name="xs_tuifeiyuanyin" /></td>
					</tr>
					<tr>
						<td>是否进班(是,否):</td>
						<td><select id="xs_isjinban2" disabled="disabled"
							class="easyui-combobox" name="xs_isjinban" style="width: 159px;">
								<option value="">— —请选择— —</option>
								<option value="1">已进班</option>
								<option value="2">未进班</option>
						</select></td>
					</tr>
					<tr>

						<td>进班时间:</td>
						<td><input disabled="disabled" class="easyui-textbox"
							type="text" id="xs_jinbantime2" name="xs_jinbantime" /></td>
					</tr>
					<tr>

						<td>进班备注:</td>
						<td><input disabled="disabled" class="easyui-textbox"
							type="text" id="xs_jinbanbeizhu2" name="xs_jinbanbeizhu" /></td>
					</tr>
					<tr>
						<td>咨询师 备注:</td>
						<td><input disabled="disabled" class="easyui-textbox"
							type="text" id="xs_zixunshibeizhu2" name="xs_zixunshibeizhu" /></td>
					</tr>
				</table>
			</div>
		</form>
	</div>

	<!--  添加-->
	<div id="insertStudent" class="easyui-dialog"
		style="width: 400px; height: 400px"
		data-options="title:' 添加 ',modal:true,closed:true,
			buttons:[{
				text:'保存',
				handler:function(){
				inserStudent();
				}
			},{
				text:'关闭',
				handler:function(){
				 inserGuanbi();
				}
			}]">

		<form id="frm3" class="easyui-form">
			<input disabled="disabled" type="text" id="xs_id1" name="xs_id"
				style="text-align: center; display: none;" />
			<div style="float: left;">
				<table>

					<tr>
						<td>姓名:</td>
						<td><input class="easyui-textbox" required="true" type="text"
							id="xs_name3" name="xs_name" /></td>
					</tr>

					<tr>
						<td>性别:</td>
						<td><select id="xs_xingbie3" class="easyui-combobox"
							name="xs_xingbie" data-options="editable:false"
							style="width: 159px;">
								<option value="">---请选择---</option>
								<option value="1">男</option>
								<option value="2">女</option>
						</select></td>
					</tr>
					<tr>
						<td>年龄:</td>
						<td><input class="easyui-textbox" required="true"
							validType="age" type="text" id="xs_nianling3" name="xs_nianling" /></td>
					</tr>
					<tr>
						<td>电话:</td>
						<td><input class="easyui-textbox" type="text"
							id="xs_dianhua3" required="true" validType="mobile"
							name="xs_dianhua" /></td>
					</tr>
					<tr>
						<td>学历:</td>
						<td><select id="xs_xueli3" class="easyui-combobox"
							data-options="editable:false" name="xs_isjinban"
							style="width: 159px;">
								<option value="">---请选择---</option>
								<option value="大专">大专</option>
								<option value="高中">高中</option>
								<option value="中专">中专</option>
								<option value="初中">初中</option>
								<option value="本科">本科</option>
								<option value="其他">其他</option>
						</select></td>
					</tr>
					<tr>
						<td>状态:</td>
						<td><select id="xs_zhuangtai3" class="easyui-combobox"
							data-options="editable:false" name="xs_zhuangtai"
							style="width: 159px;">
								<option value="">---请选择---</option>
								<option value="未知">未知</option>
								<option value="待业">待业</option>
								<option value="在职">在职</option>
								<option value="在读">在读</option>
						</select></td>

					</tr>
					<tr>
						<td>来源渠道:</td>
						<td><select id="xs_laiyuanqudao3" required="true"
							class="easyui-combobox" data-options="editable:false"
							name="xs_laiyuanqudao" style="width: 159px;">
								<option value="未知">未知</option>
								<option value="百度">百度</option>
								<option value="百度移动端">百度移动端</option>
								<option value="360">360</option>
								<option value="360移动端">360移动端</option>
								<option value="搜狗">搜狗</option>
								<option value="搜狗移动端">搜狗移动端</option>
								<option value="UC移动端">UC移动端</option>
								<option value="直接输入">直接输入</option>
								<option value="自然流量">自然流量</option>
								<option value="直电">直电</option>
								<option value="微信">微信</option>
								<option value="QQ">QQ</option>
						</select></td>
					</tr>
					<tr>
						<td>来源网站:</td>
						<td><select id="xs_laiyuanwangzhi3" required="true"
							class="easyui-combobox" data-options="editable:false"
							name="xs_laiyuanwangzhi" style="width: 159px;">
								<option value="其他">其他</option>
								<option value="职英B站">职英B站</option>
								<option value="高考站">高考站</option>
								<option value="职英A站">职英A站</option>
						</select></td>
					</tr>
					<tr>
						<td>来源关键字:</td>
						<td><input class="easyui-textbox" required="true" type="text"
							id="xs_liyuanguanjianzi3" name="xs_liyuanguanjianzi" /></td>
					</tr>

					<tr>
						<td>学员QQ:</td>
						<td><input class="easyui-textbox" type="text" id="xs_qq3"
							name="xs_qq" /></td>
					</tr>
					<tr>
						<td>微信号:</td>
						<td><input class="easyui-textbox" type="text" id="xs_weixin3"
							name="xs_weixin" /></td>
					</tr>
					<tr>
						<td>是否报备(是,否):</td>
						<td><select id="xs_isbaobei3" data-options="editable:false"
							class="easyui-combobox" name="xs_isbaobei" style="width: 159px;">
								<option value="">---请选择---</option>
								<option value="1">是</option>
								<option value="2">否</option>
						</select></td>
					</tr>

				</table>
			</div>
		</form>
	</div>
	<!--  跟踪-->
	<div id="genzongStudent" class="easyui-dialog"
		style="width: 400px; height: 300px"
		data-options="title:' 添加跟踪信息 ',modal:true,closed:true,
			buttons:[{
				text:'保存',
				handler:function(){
				genzongBaoCun();
				}
			},{
				text:'关闭',
				handler:function(){
				genzongGuanbi();
				}
			}]">

		<form id="frm4" class="easyui-form" style="align: center;">
			<input style="display: none;" id="tj_genzong_xs_id" name="xs_id">
			<div style="text-align: center;">
				<table style="width: 70%; margin: auto;">
					<tr>
						<td>回访时间:</td>
						<td><input class="easyui-datetimebox" type="text"
							id="gz_genzongtime" /></td>
					</tr>
					<tr>
						<td>回访情况:</td>
						<td><input class="easyui-textbox" type="text"
							id="gz_genzongneirong" /></td>
					</tr>
					<tr>
						<td>跟踪方式:</td>
						<td><input class="easyui-textbox" type="text"
							id="gz_genzongfangshi" /></td>
					</tr>
					<tr>
						<td>下次跟踪时间:</td>
						<td><input class="easyui-datetimebox" type="text"
							id="gz_xiacigenzongtime" /></td>
					</tr>
					<tr>
						<td>备注:</td>
						<td><input class="easyui-textbox" type="text" id="gz_beizhu" /></td>
					</tr>

				</table>
			</div>
		</form>
	</div>

	<div id="tj_dtrz_win" class="easyui-window" title="添加动态"
		style="width: 600px; height: 400px; text-align: center;"
		data-options="iconCls:'icon-save',modal:true">
		<form id="tj_dtrz_ff">
			<input id="tj_dtrz_xs_id" style="display: none;" name="xs_id">
			<input id="tj_dtrz_us_id" style="display: none;" value=""
				name="us_id">
			<h3>学生动态信息</h3>
			<div>
				<textarea cols="80" rows="15" id="tj_dt_neirong"
					style="OVERFLOW: hidden"></textarea>
			</div>
		</form>
		<a href="javascript:void(0)" class="easyui-linkbutton"
			onclick="tj_dtrz_bc()" data-options="iconCls:'icon-save'">保存</a>
	</div>

	<div id="ck_dtrz_win" class="easyui-window" title="查看动态"
		style="width: 600px; height: 400px; text-align: center;"
		data-options="iconCls:'icon-save',modal:true">
		<h3>学生动态信息</h3>
		<table id="dtxx_tt" class="easyui-datagrid">
			<thead>
				<tr>
					<th data-options="field:'dt_student',formatter:dt_student">学生</th>
					<th data-options="field:'dt_time'">时间</th>
					<th data-options="field:'dt_tianjiaren',formatter:dt_tianjiaren">添加人</th>
					<th data-options="field:'dt_neirong',formatter:dt_neirong">内容</th>
				</tr>
			</thead>
		</table>
		<a href="javascript:void(0)" class="easyui-linkbutton"
			onclick="ck_dtrz_gb()" data-options="iconCls:'icon-no'">关闭</a>
	</div>

	<div id="nr_dtrz_win" class="easyui-window" title="动态内容"
		style="width: 500px; height: 300px; text-align: center;"
		data-options="iconCls:'icon-save',modal:true">
		<form id="nr_dtrz_ff">
			<h3>内容</h3>
			<div>
				<textarea cols="60" disabled="disabled" rows="11" id="nr_dt_neirong"
					style="OVERFLOW: hidden"></textarea>
			</div>
		</form>
		<a href="javascript:void(0)" class="easyui-linkbutton"
			onclick="nr_dtrz_gb()" data-options="iconCls:'icon-no'">关闭</a>
	</div>


	<div id="ck_gzrz_win" class="easyui-window" title="查看跟踪日志"
		style="width: 700px; height: 450px; text-align: center;"
		data-options="iconCls:'icon-save',modal:true">
		<h3>跟踪日志</h3>
		<table id="ck_gzrz_tt" class="easyui-datagrid">
			<thead>
				<tr>
					<th data-options="field:'gz_xuesheng',formatter:gz_xuesheng">学生</th>
					<th data-options="field:'gz_genzongtime'">跟踪时间</th>
					<th data-options="field:'gz_genzongneirong'">跟踪内容</th>
					<th data-options="field:'gz_genzongfangshi'">跟踪方式</th>
					<th data-options="field:'gz_beizhu'">备注</th>
					<th data-options="field:'gz_xiacigenzongtime'">下次跟踪时间</th>
					<th data-options="field:'gz_exe1'">回访情况</th>
					<th data-options="field:'gz_user',formatter:gz_user">跟踪人</th>
					<th
						data-options="field:'ck_gz_genzongneirong',formatter:ck_gz_genzongneirong">查看详细内容</th>
				</tr>
			</thead>
		</table>
		<a href="javascript:void(0)" class="easyui-linkbutton"
			onclick="ck_gzrz_gb()" data-options="iconCls:'icon-no'">关闭</a>
	</div>

	<div id="nr_gzrz_win" class="easyui-window" title="跟踪内容"
		style="width: 500px; height: 300px; text-align: center;"
		data-options="iconCls:'icon-save',modal:true">
		<form id="nr_gzrz_ff">
			<h3>内容</h3>
			<div>
				<textarea cols="60" disabled="disabled" rows="11" id="nr_gz_neirong"
					style="OVERFLOW: hidden"></textarea>
			</div>
		</form>
		<a href="javascript:void(0)" class="easyui-linkbutton"
			onclick="nr_gzrz_gb()" data-options="iconCls:'icon-no'">关闭</a>
	</div>
</body>
</html>