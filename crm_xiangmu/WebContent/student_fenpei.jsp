<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>学生分配</title>
<script src="js/gonggong.js" type="text/javascript" charset="utf-8"></script>
<script src="js/yincang.js" type="text/javascript" charset="utf-8"></script>
</head>
<body>
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
				<!-- <th data-options="field:'xs_xueli' ">学历</th>
				<th data-options="field:'xs_zhuangtai' ">个人状态</th>
				<th data-options="field:'xs_laiyuanqudao' ">来源渠道</th>
				<th data-options="field:'xs_laiyuanwangzhi' ">来源网址</th>
				<th data-options="field:'xs_guanzhu' ">学生关注</th> -->
				<th data-options="field:'xs_liyuanguanjianzi' ">来源关键字</th>
				<!-- <th data-options="field:'xs_namezixun' ">姓名咨询</th>
				<th data-options="field:'xs_suozaiquyu' ">所在区域</th> -->
				<th data-options="field:'xs_weixin' ">微信</th>
				<th data-options="field:'xs_qq' ">qq</th>
				<!-- <th data-options="field:'xs_laiyuanbumen' ">来源部门</th> -->
				<th data-options="field:'xs_isbaobei',formatter:xs_isbaobei">是否报备</th>
				<!-- <th data-options="field:'xs_kecheng' ">课程方向</th>
				<th data-options="field:'xs_isyouxiao' ">是否有效</th>
				<th data-options="field:'xs_dafen' ">打分</th>
				<th data-options="field:'xs_ishuifang' ">是否回访</th>
				<th data-options="field:'xs_shuocihuifangtime' ">首次回访时间</th>
				<th data-options="field:'xs_isshangmen' ">是否上门</th>
				<th data-options="field:'xs_shangmentime' ">上门时间</th>
				<th data-options="field:'xs_wuxiaoyuanyin' ">无效原因</th>
				<th data-options="field:'xs_isjiaofei' ">是否缴费</th>
				<th data-options="field:'xs_jiaofeitime' ">缴费时间</th>
				<th data-options="field:'xs_jine' ">金额</th>
				<th data-options="field:'xs_istuifei' ">是否退费</th>
				<th data-options="field:'xs_isjinban' ">是否进班</th>
				<th data-options="field:'xs_jinbantime' ">进班时间</th>
				<th data-options="field:'xs_jinbanbeizhu' ">进班备注</th>
				<th data-options="field:'xs_tuifeiyuanyin' ">退费原因</th>
				<th data-options="field:'xs_dingjinjine' ">定金金额</th>
				<th data-options="field:'xs_dingjintime' ">定金时间</th> -->
				<th data-options="field:'xs_zixunshi',formatter:xs_zixunshi_xianshi">咨询师</th>
				<th data-options="field:'zxs',formatter:xs_zixunshi">分配</th>
				<th data-options="field:'xs_lururen',formatter:xs_lururen">录入人</th>
				<!-- <th data-options="field:'xs_zixunshibeizhu' ">咨询师备注</th> -->
			</tr>
		</thead>
	</table>
	<div id="StudentToo" style="padding: 5px; height: auto">
		<div style="margin-bottom: 5px">
			<form id="frm">

				<label>姓名:</label><input class="easyui-textbox" id="xs_name"
					name="xs_name" style="width: 100px"> <label>电话:</label><input
					class="easyui-textbox" id="xs_dianhua" name="xs_dianhua"
					style="width: 100px"> <label>QQ:</label><input
					class="easyui-textbox" id="xs_qq" name="xs_qq" style="width: 100px">
				<label>创建时间:</label><input class="easyui-datetimebox"
					id="minxs_chuangjiantime" name="minxs_chuangjiantime" value=""
					style="width: 150px">~~~<input class="easyui-datetimebox"
					id="maxxs_chuangjiantime" name="maxxs_chuangjiantime" value=""
					style="width: 150px"> <select id="sousuo_cc"
					class="easyui-combobox" name="dept" onchange="" style="width: 200px;">
					<option value="-1">未分配</option>
					<option value="">已分配</option>

				</select><a href="javascript:void(0)"
					class="easyui-linkbutton" onclick="student_guanli()"
					data-options="iconCls:'icon-search',plain:true">搜索</a> <a
					href="javascript:void(0)" class="easyui-linkbutton"
					onclick="insertDakai()"
					data-options="iconCls:'icon-add',plain:true">添加</a>  <a href="javascript:void(0)" class="easyui-linkbutton"
					onclick="piliang_fenpei_zixuxuenshi_dakai()"> 批 量 分 配 </a> <label>是否自动分配
					: </label><a href="javascript:void(0)" onclick="fenpei()"><input
					id="iskq" name="iskq" class="easyui-switchbutton"
					data-options="onText:'开启',offText:'关闭'"></a>
			</form>
		</div>
	</div>
	<div id="fenpei_zxs_win" class="easyui-window" title="分配咨询师"
		style="width: 270px; height: 100px; text-align: center;"
		data-options="iconCls:'icon-save',modal:true">
		<form id="fenpei_zxs_ff">
			<input style="display: none;" id="fenpei_zxs_xs_id" name="xs_id">
			咨询师：<select id="fenpei_zxs_id" data-options="editable:false"
				class="easyui-combobox" name="dept" style="width: 200px;">
				<option>---请选择---</option>
			</select> <br>
			<a href="javascript:void(0)" class="easyui-linkbutton"
				onclick="fenpei_zixuxuenshi()" data-options="iconCls:'icon-save'">
				分 配 </a>
		</form>
	</div>

	<div id="pl_fenpei_zxs_win" class="easyui-window" title="分配咨询师"
		style="width: 270px; height: 100px; text-align: center;"
		data-options="iconCls:'icon-save',modal:true">
		<form id="pl_fenpei_zxs_ff">
			<input style="display: none;" id="fenpei_zxs_xs_id" name="xs_id">
			咨询师：<select id="pl_fenpei_zxs_id" data-options="editable:false"
				class="easyui-combobox" name="dept" style="width: 200px;">
				<option>---请选择---</option>
			</select> <br>
			<a href="javascript:void(0)" class="easyui-linkbutton"
				onclick="pl_fenpei_zixuxuenshi()" data-options="iconCls:'icon-save'">
				分 配 </a>
		</form>
	</div>

</body>
<script type="text/javascript">
	function xs_zixunshi_xianshi(value, row, index) {
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

	function formatterxingbie(value, row, index) {
		return row.xs_xingbie == 2 ? '女' : '男';
	}
	function xs_zixunshi(value, row, index) {
		return "<a href='javascript:void(0)' class='easyui-linkbutton' onclick='fenpei_zxs("
				+ index + ")' > 分配咨询师 </a>"
	}
	function fenpei_zxs(index) {
		/* $("#StudentTab").datagrid("clearChecked");
		$("#StudentTab").datagrid("selectRow",index); */
		$('#fenpei_zxs_id').combobox({
			url : 'zixunshi_all',
			valueField : 'us_id',
			textField : 'us_name'
		});
		$("#fenpei_zxs_xs_id").val(
				$("#StudentTab").datagrid("getData").rows[index].xs_id);
		$('#fenpei_zxs_win').window('open');
	}
	function fenpei() {
		var a = $("#iskq")[0].checked;
		var gn_iskaiqi = null;
		if (a) {
			gn_iskaiqi = 1;
		} else {
			gn_iskaiqi = 2;
		}
		$.post("updateGongneng_zdfp", {
			gn_iskaiqi : gn_iskaiqi
		}, function(res) {
			if (res != 1) {
				alert("错误！")
			}
		}, "json");
	}
	function fenpei_zixuxuenshi() {
		var zxs = $("#fenpei_zxs_id").combobox("getValue");
		//alert($("#StudentTab").datagrid("getSelected").xs_id);
		if (zxs != "---请选择---") {
			$.post("updateStudent_zixunshi", {
				xs_id : $("#fenpei_zxs_xs_id").val(),
				xs_zixunshi : zxs
			}, function(res) {
				if (res == 1) {
					$('#fenpei_zxs_win').window('close');
					$("#StudentTab").datagrid("reload");
					$.messager.show({
						title : '我的消息',
						msg : '分配成功',
						timeout : 1000,
						showType : 'slide',
						style : {
							top : document.body.scrollTop
									+ document.documentElement.scrollTop,
						}
					});
				} else {
					$.messager.show({
						title : '我的消息',
						msg : '分配失败',
						timeout : 1000,
						showType : 'slide',
						style : {
							top : document.body.scrollTop
									+ document.documentElement.scrollTop,
						}
					});
				}
			}, "json");
		} else {
			$.messager.show({
				title : '我的消息',
				msg : '未选择咨询师',
				timeout : 1000,
				showType : 'slide',
				style : {
					top : document.body.scrollTop
							+ document.documentElement.scrollTop,
				}
			});
		}
	}
	$(function() {
		student_guanli();
		$.post("Gongneng_zdfp", {}, function(res) {
			if (res == 1) {
				$("#iskq").switchbutton("check");
			} else if (res == 2) {
				$("#iskq").switchbutton("uncheck");
			}
		}, "json");
		$('#fenpei_zxs_win').window('close');
		$('#pl_fenpei_zxs_win').window('close');
	})
	function student_guanli() {
		var ss_zxs=$("#sousuo_cc").combobox("getValue");
		$("#StudentTab").datagrid(
				{
					url : 'student_xianshi',
					method : 'post',
					toolbar : '#StudentToo',
					pagination : true,
					queryParams : {
						xs_name : $("#xs_name").val(),
						xs_dianhua : $("#xs_dianhua").val(),

						xs_qq : $("#xs_qq").val(),
						xs_chuangjiantime : $("#minxs_chuangjiantime")
								.datetimebox('getValue'),
						xs_chuangjiantime : $("#maxxs_chuangjiantime")
								.datetimebox('getValue'),
						xs_zixunshi : ss_zxs

					}

				})
	}
	/* function student_guanli_all() {
		$("#StudentTab").datagrid({
			url : 'student_xianshi',
			method : 'post',
			toolbar : '#StudentToo',
			pagination : true
		})
	} */
	function piliang_fenpei_zixuxuenshi_dakai() {
		$('#pl_fenpei_zxs_id').combobox({
			url : 'zixunshi_all',
			valueField : 'us_id',
			textField : 'us_name'
		});
		$('#pl_fenpei_zxs_win').window('open');
	}

	function pl_fenpei_zixuxuenshi() {
		var zxs = $("#pl_fenpei_zxs_id").combobox("getValue");

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
			if (zxs != "---请选择---") {
				$.post("pl_updateStudent_zixunshi", {
					xs_ids : xs_ids,
					xs_zixunshi : zxs
				}, function(res) {
					if (res > 0) {
						$('#pl_fenpei_zxs_win').window('close');
						$("#StudentTab").datagrid("reload");
						$.messager.show({
							title : '我的消息',
							msg : '分配成功',
							timeout : 1000,
							showType : 'slide',
							style : {
								top : document.body.scrollTop
										+ document.documentElement.scrollTop,
							}
						});
					} else {
						$.messager.show({
							title : '我的消息',
							msg : '分配失败',
							timeout : 1000,
							showType : 'slide',
							style : {
								top : document.body.scrollTop
										+ document.documentElement.scrollTop,
							}
						});
					}
				}, "json");
			} else {
				$.messager.show({
					title : '我的消息',
					msg : '未选择咨询师',
					timeout : 1000,
					showType : 'slide',
					style : {
						top : document.body.scrollTop
								+ document.documentElement.scrollTop,
					}
				});
			}
		} else {
			$.messager.show({
				title : '我的消息',
				msg : '请选择学生',
				timeout : 1000,
				showType : 'slide',
				style : {
					top : document.body.scrollTop
							+ document.documentElement.scrollTop,
				}
			});
		}
	}
	
	
</script>
</html>