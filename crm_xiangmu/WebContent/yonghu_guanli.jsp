<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户</title>
<script src="js/gonggong.js" type="text/javascript" charset="utf-8"></script>
<script src="js/yincang.js" type="text/javascript" charset="utf-8"></script>
<style type="text/css">
div {
	border: none;
}

#jsmokuai>div {
	float: left;
	height: 500px;
	margin-top: 50px;
}

#jsdiv_1 {
	margin-left: 45px;
	width: 210px;
}

#jsdiv_3 {
	width: 210px;
}

#jsdiv_2 {
	width: 80px;
}

#yc_div {
	margin-left: 28%;
	margin-top: 10%;
	width: 200px;
}
</style>
</head>
<body>
	<table class="easyui-datagrid" id="dg" title="用户列表"
		data-options="rownumbers:true,singleSelect:true,pagination:true,fitColumns:true,method:'post',toolbar:'#usertb',pageSize:10">
		<thead>
			<tr>
				<th data-options="field:'us_id',sortable:true">用户ID</th>
				<th data-options="field:'us_name',sortable:true">用户名</th>
				<th data-options="field:'us_youxiang',sortable:true">邮箱</th>
				<th data-options="field:'us_shojihao',sortable:true">手机号</th>
				<th
					data-options="field:'us_issuoding',sortable:true,formatter:us_issuoding">是否锁定</th>
				<th data-options="field:'us_suodingtime',sortable:true">锁定时间</th>
				<th data-options="field:'us_passcuowucishu',sortable:true">密码错误次数</th>
				<th data-options="field:'us_chuangjiantime',sortable:true">创建时间</th>
				<th data-options="field:'us_zuihoutime',sortable:true">最后登陆时间</th>
				<th data-options="field:'us_quanzhong',sortable:true">权重</th>
				<th data-options="field:'us_pingfen',sortable:true">评分</th>
				<th data-options="field:'us_pingfenrenshu',sortable:true">评分人数</th>
				<th data-options="field:'us_isdaka',sortable:true,formatter:ff_us_isdaka">是否打卡</th>
				<th data-options="field:'us_dakatime',sortable:true">打卡时间</th>
				<th data-options="field:'us_biezhu',sortable:true">备注</th>
				<th data-options="field:'jueseshezhi',formatter:jueseshezhi">角色设置</th>
				<th data-options="field:'suodingyonghu',formatter:suodingyonghu">锁定用户</th>
				<th data-options="field:'chongzhimima',formatter:chongzhimima">重置密码</th>
				<th data-options="field:'caozuo',formatter:caozuo">操作</th>
			</tr>
		</thead>
	</table>
	<div id="usertb" style="padding: 5px; height: auto">
		<div style="margin-bottom: 5px">
			编号: <input class="easyui-textbox" id="ss_us_id" style="width: 80px">
			名称: <input class="easyui-textbox" id="ss_us_name" style="width: 80px">
			是否锁定: <select id="ss_us_issuoding" data-options="editable:false"
				class="easyui-combobox" style="width: 200px;">
				<option value="">---请选择---</option>
				<option value="1">已锁定</option>
				<option value="2">未锁定</option>
			</select> 创建时间: <input class="easyui-datetimebox" id="ss_us_chuangjiantimeMIN"
				data-options="showSeconds:false" style="width: 150px"> ~~~ <input
				class="easyui-datetimebox" id="ss_us_chuangjiantimeMAX"
				data-options="showSeconds:false" style="width: 150px">
			最后登陆时间: <input class="easyui-datetimebox" id="ss_us_zuihoutimeMIN"
				data-options="showSeconds:false" style="width: 150px"> ~~~ <input
				class="easyui-datetimebox" id="ss_us_zuihoutimeMAX"
				data-options="showSeconds:false" style="width: 150px"> <br>
			权重: <input class="easyui-textbox" id="ss_us_quanzhongMIN"
				style="width: 80px"> ~~~ <input class="easyui-textbox"
				id="ss_us_quanzhongMAX" style="width: 80px"> 是否打卡: <select
				id="ss_us_isdaka" data-options="editable:false"
				class="easyui-combobox" style="width: 200px;">
				<option value="">---请选择---</option>
				<option value="1">已打卡</option>
				<option value="2">未打卡</option>
			</select> 打卡时间: <input class="easyui-datetimebox" id="ss_us_dakatimeMIN"
				data-options="showSeconds:false" style="width: 150px"> ~~~ <input
				class="easyui-datetimebox" id="ss_us_dakatimeMAX"
				data-options="showSeconds:false" style="width: 150px"> 排序规则:
			<select id="ss_paixuguize" data-options="editable:false"
				class="easyui-combobox" style="width: 98px;">
				<option value="">---请选择---</option>
				<option value="asc">正序</option>
				<option value="desc">倒序</option>
			</select> 排序字段名称: <select id="ss_paixuziduan" data-options="editable:false"
				class="easyui-combobox" style="width: 180px;">
				<option value="">---请选择(默认正序)---</option>
				<option value="us_name">用户名</option>
				<option value="us_suodingtime">锁定时间</option>
				<option value="us_passcuowucishu">密码错误次数</option>
				<option value="us_chuangjiantime">创建时间</option>
				<option value="us_zuihoutime">最后登陆时间</option>
				<option value="us_pingfen">评分</option>
				<option value="us_dakatime">打卡时间</option>
			</select> <br> <a href="javascript:void(0)" class="easyui-linkbutton"
				iconCls="icon-search" onclick="searchUserInfo()">查找</a>&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="javascript:void(0)" class="easyui-linkbutton"
				iconCls="icon-add" onclick="addInfo()">新增</a>
			<!-- &nbsp;&nbsp;&nbsp;&nbsp; <a
				href="javascript:void(0)" iconCls="icon-clear" class="easyui-linkbutton"
				onclick="yincang()">隐藏</a> -->
		</div>
	</div>
	<div id="win" class="easyui-window" title="编辑"
		style="width: 300px; height: 400px; text-align: right; padding-right: 30px;"
		data-options="iconCls:'icon-save',modal:true">
		<form id="ff">
		<input type="text" style="display: none;" name="us_id" id="us_id" />
			<br /> 姓名： <input class="easyui-validatebox"
				required="true" validType="minLength['3']" type="text"
				name="us_name" id="us_name" /> <br />
			<br /> 邮箱： <input class="easyui-validatebox"
				required="true" validType="msn" type="text"
				name="us_youxiang" id="us_youxiang" /> <br />
			<br /> 手机号： <input class="easyui-validatebox"
				required="true" validType="mobile" type="text"
				name="us_shojihao" id="us_shojihao" /> <br />
			<br /> 权重： <input class="easyui-validatebox"
				required="true" validType="intPlus" type="text"
				name="us_quanzhong" id="us_quanzhong" /> <br />
			<br /> 备注： <input class="easyui-validatebox" type="text"
				name="us_biezhu" id="us_biezhu" /> <br />
			<br /> <a id="btn" href="javascript:void(0)"
				class="easyui-linkbutton" onclick="bianji()"
				data-options="iconCls:'icon-ok'">编辑</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="javascript:void(0)" class="easyui-linkbutton"
				onclick="$('#ff').form('reset')" data-options="iconCls:'icon-clear'">清空</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="javascript:void(0)" class="easyui-linkbutton"
				onclick="quxiao()" data-options="iconCls:'icon-no'">取消</a>
		</form>
	</div>
	<div id="addyh" class="easyui-window" title="添加"
		style="width: 300px; height: 400px; text-align: right; padding-right: 30px;"
		data-options="iconCls:'icon-save',modal:true">
		<form id="addform">
			<br /> 姓名： <input class="easyui-validatebox"
				required="true" validType="minLength['3']" type="text"
				name="addus_name" id="addus_name" /> <br />
			<br /> 邮箱： <input class="easyui-validatebox"
				required="true" validType="msn" type="text"
				name="addus_youxiang" id="addus_youxiang" /> <br />
			<br /> 手机号： <input class="easyui-validatebox"
				required="true" validType="mobile" type="text"
				name="addus_shojihao" id="addus_shojihao" /> <br />
			<br /> 权重： <input class="easyui-validatebox"
				required="true" validType="intPlus" type="text"
				name="addus_quanzhong" id="addus_quanzhong" /> <br />
			<br /> 备注： <input class="easyui-validatebox" type="text"
				name="addus_biezhu" id="addus_biezhu" /> <br />
			<br /> <a id="btn1" href="javascript:void(0)"
				class="easyui-linkbutton" onclick="tianjia()"
				data-options="iconCls:'icon-ok'">添加</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="javascript:void(0)" class="easyui-linkbutton"
				onclick="$('#addform').form('reset')"
				data-options="iconCls:'icon-clear'">清空</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="javascript:void(0)" class="easyui-linkbutton"
				onclick="quxiao()" data-options="iconCls:'icon-no'">取消</a>
		</form>
	</div>
	<div id="jsmokuai" class="easyui-window"
		style="width: 600px; height: 600px; text-align: right; padding-right: 30px;"
		data-options="iconCls:'icon-save',modal:true">
		<div id="jsdiv_1">
			<table name="center" class="easyui-datagrid" id="js_left"
				data-options="rownumbers:true,singleSelect:true,fitColumns:true,method:'post'">
				<thead>
					<tr>
						<th data-options="field:'js_id',width:280,hidden:true">用户ID</th>
						<th data-options="field:'js_name',width:100">可分配角色</th>
					</tr>
				</thead>
			</table>
		</div>
		<div id="jsdiv_2">
			<a style="margin-top: 150px; float: left; margin-left: 25px;"
				id="jsbtn_fenpei" onclick="fenpei()" href="javascript:void(0)"
				class="easyui-linkbutton"> > > </a> <a
				style="margin-top: 20px; float: left; margin-left: 25px;"
				id="jsbtn_yichu" onclick="yichu()" href="javascript:void(0)"
				class="easyui-linkbutton"> < < </a>
		</div>
		<div id="jsdiv_3">
			<table name="center" class="easyui-datagrid" id="js_right"
				data-options="rownumbers:true,singleSelect:true,fitColumns:true,method:'post'">
				<thead>
					<tr>
						<th data-options="field:'js_id',width:280,hidden:true">用户ID</th>
						<th data-options="field:'js_name',width:200">当前用户角色</th>
					</tr>
				</thead>
			</table>
		</div>
	</div>


	<div id="yc_window" class="easyui-window" title="隐藏"
		style="width: 400px; height: 400px"
		data-options="iconCls:'icon-save',modal:true">
		<div id="yc_div">
			<h3>请选择需要隐藏的列名</h3>
			<form id="yc_form">
				<table>
					<tr>
						<td><input name="yc_yc_leiming" type="checkbox"
							value="us_name" /></td>
						<td>用户名</td>

						<td><input name="yc_leiming" type="checkbox"
							value="us_youxiang" /></td>
						<td>邮箱</td>
					</tr>
					<tr>
						<td><input name="yc_leiming" type="checkbox"
							value="us_shojihao" /></td>
						<td>手机号</td>

						<td><input name="yc_leiming" type="checkbox"
							value="us_issuoding" /></td>
						<td>是否锁定</td>
					</tr>
					<tr>
						<td><input name="yc_leiming" type="checkbox"
							value="us_suodingtime" /></td>
						<td>锁定时间</td>

						<td><input name="yc_leiming" type="checkbox"
							value="us_passcuowucishu" /></td>
						<td>密码错误次数</td>
					</tr>
					<tr>
						<td><input name="yc_leiming" type="checkbox"
							value="us_chuangjiantime" /></td>
						<td>创建时间</td>

						<td><input name="yc_leiming" type="checkbox"
							value="us_zuihoutime" /></td>
						<td>最后登陆时间</td>
					</tr>
					<tr>
						<td><input name="yc_leiming" type="checkbox"
							value="us_quanzhong" /></td>
						<td>权重</td>

						<td><input name="yc_leiming" type="checkbox"
							value="us_pingfen" /></td>
						<td>评分</td>
					</tr>
					<tr>
						<td><input name="yc_leiming" type="checkbox"
							value="us_pingfenrenshu" /></td>
						<td>评分人数</td>

						<td><input name="yc_leiming" type="checkbox"
							value="us_isdaka" /></td>
						<td>是否打卡</td>
					</tr>
					<tr>
						<td><input name="yc_leiming" type="checkbox"
							value="us_isdakatime" /></td>
						<td>打卡时间</td>

						<td><input name="yc_leiming" type="checkbox"
							value="us_biezhu" /></td>
						<td>备注</td>
					</tr>
				</table>
			</form>
			<br> <a id="yc_btn1" href="javascript:void(0)"
				onclick="yc_yincang()" class="easyui-linkbutton"> 隐藏选中 </a>
			&nbsp;&nbsp;&nbsp; &nbsp;&nbsp; <a id="yc_btn2"
				href="javascript:void(0)" onclick="yc_guanbi()"
				class="easyui-linkbutton"> 关闭 </a>
		</div>
	</div>
</body>
<script type="text/javascript">



var yonghuid=null;
	function fenpei() {
		var js = $("#js_left").datagrid("getSelections")[0];
		$.post("user_juese_tianjia", {
			uj_userid : yonghuid,
			uj_jueseid : js.js_id
		}, function(res) {
			if (res==1) {
				$("#js_left").datagrid("reload");
				$("#js_right").datagrid("reload");
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
				$("#js_left").datagrid("reload");
				$("#js_right").datagrid("reload");
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
	}

	function yichu() {
		var js = $("#js_right").datagrid("getSelections")[0];
		$.post("user_juese_shanchu", {
			uj_userid : yonghuid,
			uj_jueseid : js.js_id
		}, function(res) {
			if (res==1) {
				$("#js_left").datagrid("reload");
				$("#js_right").datagrid("reload");
				$.messager.show({
					title : '我的消息',
					msg : '移除成功',
					timeout : 1000,
					showType : 'slide',
					style : {
						top : document.body.scrollTop
								+ document.documentElement.scrollTop,
					}
				});
			} else {
				$("#js_left").datagrid("reload");
				$("#js_right").datagrid("reload");
				$.messager.show({
					title : '我的消息',
					msg : '移除失败',
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

	function searchUserInfo() {
		$("#dg").datagrid(
				{
					url : "yonghuxianshi", //数据接口的地址
					queryParams : { //要发送的参数列表
						us_id : $("#ss_us_id").val(),
						us_name : $("#ss_us_name").val(),
						us_issuoding : $("#ss_us_issuoding").combobox(
								"getValue"),
						us_chuangjiantimeMIN : $("#ss_us_chuangjiantimeMIN")
								.datebox("getValue"),
						us_chuangjiantimeMAX : $("#ss_us_chuangjiantimeMAX")
								.datebox("getValue"),
						us_zuihoutimeMIN : $("#ss_us_zuihoutimeMIN").datebox(
								"getValue"),
						us_zuihoutimeMAX : $("#ss_us_zuihoutimeMAX").datebox(
								"getValue"),
						us_quanzhongMIN : $("#ss_us_quanzhongMIN").val(),
						us_quanzhongMAX : $("#ss_us_quanzhongMAX").val(),
						us_isdaka : $("#ss_us_isdaka").combobox("getValue"),
						us_dakatimeMIN : $("#ss_us_dakatimeMIN").datebox(
								"getValue"),
						us_dakatimeMAX : $("#ss_us_dakatimeMAX").datebox(
								"getValue"),
						paixuguize : $("#ss_paixuguize").combobox("getValue"),
						paixuziduan : $("#ss_paixuziduan").combobox("getValue")
					}
				});
	}

	function shezhi(index) {
		var data = $("#dg").datagrid("getData");
		var row = data.rows[index];
		$("#js_left").datagrid({
			url : "chakan_user_jueseall", //数据接口的地址	
			queryParams: {
				us_id : row.us_id
			}
		});
		$("#js_right").datagrid({
			url : "chakan_user_juese_us_id", //数据接口的地址
			queryParams: {
				us_id : row.us_id
			}
		});
		yonghuid = null;
		yonghuid = row.us_id;
		$('#jsmokuai').window({
			title : "您正在设置" + row.LoginName + "的角色信息"
		});

		$('#jsmokuai').window('open');
	}

	function quxiao() {
		$('#win').window('close');
		$('#addyh').window('close');
	}
	$(function() {
		$('#win').window('close');
		$('#addyh').window('close');
		$('#jsmokuai').window('close');
		$('#yc_window').window('close');
		searchUserInfo();
	});
	function us_issuoding(value, row, index) {
		return row.us_issuoding == 2 ? '未锁定' : '已锁定';
	}

	function jueseshezhi(value, row, index) {
		return "<a href='javascript:void(0)' class='easyui-linkbuton' onclick='shezhi("
				+ index + ")'>设置</a>";
	}

	function caozuo(value, row, index) {
		return "<a href='javascript:void(0)' class='easyui-linkbuton' onclick='chakan("
				+ index
				+ ")'>编辑</a>&nbsp;&nbsp;<a href='javascript:void(0)' class='easyui-linkbuton' onclick='shanchu("
				+ index + ")'>删除</a>";
	}

	function chongzhimima(value, row, index) {
		return "<a href='javascript:void(0)' class='easyui-linkbuton' onclick='chongzhi("
				+ index + ")'>重置密码</a>";
	}

	function suodingyonghu(value, row, index) {
		return "<a href='javascript:void(0)' class='easyui-linkbuton' onclick='suo_jie("
				+ index
				+ ",1)'>锁定用户</a>&nbsp;&nbsp;<a href='javascript:void(0)' class='easyui-linkbuton' onclick='suo_jie("
				+ index + ",2)'>解锁用户</a>";
	}
	function ff_us_isdaka(value, row, index){
		if(row.us_isdaka==1){
			return "已打卡";
		}else if(row.us_isdaka==2){
			return "未打卡";
		}else if(row.us_isdaka==3){
			return "迟到";
		}else{
			return "未知状态";
		}
	}

	function chongzhi(index) {
		$.messager.confirm('确认', '您确认想要重置密码吗？', function(r) {
			if (r) {
				var data = $("#dg").datagrid("getData");
				var row = data.rows[index];
				$.post("chongzhimima", {
					us_id : row.us_id
				}, function(res) {
					if (res == 1) {
						$("#dg").datagrid("reload");
						$.messager.show({
							title : '我的消息',
							msg : '重置密码成功',
							timeout : 1000,
							showType : 'slide',
							style : {
								top : document.body.scrollTop
										+ document.documentElement.scrollTop,
							}
						});
					} else {
						$("#dg").datagrid("reload");
						$.messager.show({
							title : '我的消息',
							msg : '重置密码失败',
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
		});

	}

	function suo_jie(index, us_issuoding) {
		var suodings = "";
		if (us_issuoding == 1) {
			suodings = "锁定"
		} else {
			suodings = "解锁"
		}
		$.messager
				.confirm(
						'确认',
						'您确认想要' + suodings + '用户吗？',
						function(r) {
							if (r) {
								var data = $("#dg").datagrid("getData");
								var row = data.rows[index];
								if (us_issuoding != row.us_issuoding) {
									$
											.post(
													"suodingyonghu",
													{
														us_id : row.us_id,
														us_issuoding : us_issuoding
													},
													function(res) {
														if (res == 1) {
															$("#dg").datagrid(
																	"reload");
															$.messager
																	.show({
																		title : '我的消息',
																		msg : suodings
																				+ '用户成功',
																		timeout : 1000,
																		showType : 'slide',
																		style : {
																			top : document.body.scrollTop
																					+ document.documentElement.scrollTop,
																		}
																	});
														} else {
															$("#dg").datagrid(
																	"reload");
															$.messager
																	.show({
																		title : '我的消息',
																		msg : suodings
																				+ '用户失败',
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
									$.messager
											.show({
												title : '我的消息',
												msg : '用户已被' + suodings
														+ '，无法再次' + suodings,
												timeout : 1000,
												showType : 'slide',
												style : {
													top : document.body.scrollTop
															+ document.documentElement.scrollTop,
												}
											});
								}
							}
						});

	}

	function chakan(index) {
		var data = $("#dg").datagrid("getData");
		var row = data.rows[index];
		$('#ff').form('clear');
		$('#ff').form('load', row);
		$('#win').window('open');
	}

	function bianji() {
		if ($("#ff").form('validate')) {
			$.post("user_xiugai", {
				us_id : $("#us_id").val(),
				us_name : $("#us_name").val(),
				us_youxiang : $("#us_youxiang").val(),
				us_shojihao : $("#us_shojihao").val(),
				us_quanzhong : $("#us_quanzhong").val(),
				us_us_biezhuname : $("#us_biezhu").val()
			}, function(res) {
				if (res==1) {
					$('#win').window('close');
					$("#dg").datagrid("reload");
					$.messager.show({
						title : '我的消息',
						msg : '更新成功',
						timeout : 1000,
						showType : 'slide',
						style : {
							top : document.body.scrollTop
									+ document.documentElement.scrollTop,
						}
					});
				} else if(res==-1) {
					$.messager.show({
						title : '我的消息',
						msg : '用户名已存在',
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
						msg : '更新失败',
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
				msg : '对不起！您输入的内容不符合我们的要求，无法为您创建！！',
				timeout : 1000,
				showType : 'slide',
				style : {
					top : document.body.scrollTop
							+ document.documentElement.scrollTop,
				}
			});
		}
	}

	function shanchu(index) {
		$.messager.confirm('确认', '您确认想要删除吗？', function(r) {
			if (r) {
				var data = $("#dg").datagrid("getData");
				var row = data.rows[index];
				$.post("user_shanchu", {
					us_id : row.us_id
				}, function(res) {
					if (res==1) {
						$("#dg").datagrid("reload");
						$.messager.show({
							title : '我的消息',
							msg : '删除成功',
							timeout : 1000,
							showType : 'slide',
							style : {
								top : document.body.scrollTop
										+ document.documentElement.scrollTop,
							}
						});
					} else {
						$("#dg").datagrid("reload");
						$.messager.show({
							title : '我的消息',
							msg : '删除失败',
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
		});
	}

	function addInfo() {
		$("#addform").form("reset");
		$('#addyh').window('open');
	}

	function tianjia() {
		if ($("#addyh").form('validate')) {
			$.post("user_tianjia", {
				us_name : $("#addus_name").val(),
				us_youxiang : $("#addus_youxiang").val(),
				us_shojihao : $("#addus_shojihao").val(),
				us_quanzhong : $("#addus_quanzhong").val(),
				us_us_biezhuname : $("#addus_biezhu").val()
			}, function(res) {
				if (res==1) {
					$('#addyh').window('close');
					$("#dg").datagrid("reload");
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
				} else if(res==-1) {
					$.messager.show({
						title : '我的消息',
						msg : '用户已存在',
						timeout : 1000,
						showType : 'slide',
						style : {
							top : document.body.scrollTop
									+ document.documentElement.scrollTop,
						}
					});
				}else{
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
			}, "json");
		} else {
			$.messager.show({
				title : '我的消息',
				msg : '对不起！您输入的内容不符合我们的要求，无法为您创建！！',
				timeout : 1000,
				showType : 'slide',
				style : {
					top : document.body.scrollTop
							+ document.documentElement.scrollTop,
				}
			});
		}
	}

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
			$('#dg').datagrid('hideColumn', '' + xuanzhong[i] + '');
		}
		for (var i = 0; i < weixuan.length; i++) {
			$('#dg').datagrid('showColumn', '' + weixuan[i] + '');
		}
		$('#yc_window').window('close');
	}
	function yc_guanbi() {
		$('#yc_window').window('close');
	}
</script>
</html>
