<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>员工打卡</title>
<script src="js/gonggong.js" type="text/javascript" charset="utf-8"></script>
<script src="js/yincang.js" type="text/javascript" charset="utf-8"></script>
</head>
<body>
	<table class="easyui-datagrid" id="dg" title="用户列表"
		data-options="rownumbers:true,pagination:true,fitColumns:true,method:'post',toolbar:'#usertb',pageSize:10">
		<thead>
			<tr>
				
				<th data-options="field:'checkbox',sortable:true,checkbox:true">用户ID</th>
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
			权重: <input class="easyui-textbox" id="us_quanzhongMIN"
				style="width: 80px"> ~~~ <input class="easyui-textbox"
				id="us_quanzhongMAX" style="width: 80px"> 是否打卡: <select
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
				iconCls="icon-search" onclick="searchUserInfo()">查找</a>
		</div>
	</div>
</body>
<script type="text/javascript">
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

	
	$(function() {
		searchUserInfo();
	});
	function us_issuoding(value, row, index) {
		return row.us_issuoding == 2 ? '未锁定' : '已锁定';
	}
	function caozuo(value, row, index) {
		return "<a href='javascript:void(0)' class='easyui-linkbuton' onclick='yg_qiantui("
				+ index + ")'>签退</a>";
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
	function yg_qiantui(index){
		
		
		
	}

	
</script>
</html>
