<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<script src="js/gonggong.js" type="text/javascript" charset="utf-8"></script>
<script src="js/yincang.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">
	$(function() {
		$("#nr_gzrz_win").window("close");
		$('#gz_user').combobox({
			url : 'chakan_all_zixunshu',
			valueField : 'us_id',
			textField : 'us_name'
		});
		student_guanli();
	})
	function student_guanli() {
		$("#ck_gzrz_tt")
				.datagrid(
						{
							url : 'selectGengzongrizhi_xs_id',
							method : 'post',
							pagination : true,
							singleSelect : true,
							queryParams : {
								xs_name : $("#gz_xuesheng").val(),
								gz_user : $("#gz_user").combobox("getValue") == "---请选择---" ? ""
										: $("#gz_user").combobox("getValue"),
								gz_exe1 : $("#gz_genzongneirong").combobox(
										"getValue") == "---请选择---" ? "" : $(
										"#gz_genzongneirong").combobox(
										"getValue"),
								gz_genzongfangshi : $("#gz_genzongfangshi")
										.val(),
								min_gz_genzongtime : $("#min_gz_genzongtime")
										.datetimebox('getValue'),
								max_gz_genzongtime : $("#max_gz_genzongtime")
										.datetimebox('getValue')
							}

						});
	}
	function formattergenzong(value, row, index) {
		return "<a href='javascript:void(0)' class='easyui-linkbutton' onclick='genzong("
				+ index
				+ ")' > 跟踪 </a>&nbsp;&nbsp;<a href='javascript:void(0)' class='easyui-linkbutton' onclick='ck_genzong("
				+ index + ")' > 查看跟踪 </a>"
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

	function nr_gzrz_gb() {
		$("#nr_gzrz_win").window("close");
	}

	function gz_xuesheng(value, row, index) {
		return row.stu == null ? "" : row.stu.xs_name;
	}
	function gz_user(value, row, index) {
		return row.us == null ? "" : row.us.us_name;
	}
</script>
</head>
<body>

	<table id="ck_gzrz_tt" class="easyui-datagrid"
		data-options="toolbar:'#genzongToo'">
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

	<div id="genzongToo">
		<label>学生名称:</label> <input class="easyui-textbox" id="gz_xuesheng"
			name="gz_xuesheng" style="width: 100px"> <label>跟踪者:</label>
		<select id="gz_user" class="easyui-combobox" name="gz_user"
			data-options="editable:false" style="width: 159px;">
			<option>---请选择---</option>
		</select> <label>跟踪开始时间:</label> <input class="easyui-datetimebox"
			id="min_gz_genzongtime" name="min_gz_genzongtime"
			style="width: 100px"> <label>跟踪结束时间:</label> <input
			class="easyui-datetimebox" id="max_gz_genzongtime"
			name="max_gz_genzongtime" style="width: 100px"> <label>回访情况:</label>
		<select id="gz_genzongneirong" class="easyui-combobox"
			name="gz_genzongneirong" data-options="editable:false"
			style="width: 159px;">
			<option value="">---请选择---</option>
			<option value="已回访">已回访</option>
			<option value="未回访">未回访</option>
		</select> <label>跟踪方式:</label> <input class="easyui-textbox"
			id="gz_genzongfangshi" name="gz_genzongfangshi" style="width: 100px">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			onclick="student_guanli()" data-options="iconCls:'icon-search'">搜索</a>
	</div>
</body>
</html>