<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>学生删除</title>
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
				<th data-options="field:'xs_ishuifang'">是否回访</th>
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
				<th data-options="field:'xs_dingjintime' ">定金时间</th>
				<th data-options="field:'xs_zixunshi',formatter:xs_zixunshi">咨询师</th>
				<th data-options="field:'xs_lururen',formatter:xs_lururen">录入人</th>
				<th data-options="field:'xs_zixunshibeizhu' ">咨询师备注</th>
				<th data-options="field:'xs_caozuo',formatter:formattercaozuo ">操作</th>
			</tr>
		</thead>
	</table>
	<div id="StudentToo" style="padding: 5px; height: auto">
		<div style="margin-bottom: 5px">
			<form id="frm">

				<label>姓名:</label><input class="easyui-textbox" id="xs_name"
					name="xs_name" style="width: 100px"> <label>电话:</label><input
					class="easyui-textbox" id="xs_dianhua" name="xs_dianhua"
					style="width: 100px"> <label>咨询师:</label><input
					class="easyui-textbox" id="xs_zixunshi" name="xs_zixunshi"
					style="width: 100px"> <label>是否缴费:</label> <select
					id="xs_isjiaofei" class="easyui-combobox" name="xs_isjiaofei"
					style="width: 159px;">
					<option value="">---请输入---</option>
					<option value="1">是</option>
					<option value="2">否</option>
				</select> <!-- <label>是否有效:</label> <select id="xs_isyouxiao"
					class="easyui-combobox" name="xs_isyouxiao" style="width: 159px;">
					<option value="">---请输入---</option>
					<option value="1">是</option>
					<option value="2">否</option>
				</select> --> <label>是否回访:</label> <select id="xs_ishuifang"
					class="easyui-combobox" name="xs_ishuifang" style="width: 159px;">
					<option value="">---请输入---</option>
					<option value="1">是</option>
					<option value="2">否</option>
				</select> <label>QQ:</label><input class="easyui-textbox" id="xs_qq"
					name="xs_qq" style="width: 100px"> <label>创建时间:</label><input
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
					name="minxs_shuocihuifangtime" value="" style="width: 150px">~~~<input
					class="easyui-datetimebox" id="maxxs_shuocihuifangtime"
					name="maxxs_shuocihuifangtime" value="" style="width: 150px">

				<label>缴费时间:</label><input class="easyui-datetimebox"
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
					<a
					href="javascript:void(0)" class="easyui-linkbutton"
					onclick="deletestudent_duo()" data-options="iconCls:'icon-no'">删除</a>
			</form>
		</div>
	</div>
</body>
<script type="text/javascript">
	$(function() {
		student_guanli();
	})
	function student_guanli() {
		$("#StudentTab").datagrid(
				{
					url : 'student_xianshi',
					method : 'post',
					toolbar : '#StudentToo',
					pagination : true,
					queryParams : {
						xs_name : $("#xs_name").val(),
						xs_dianhua : $("#xs_dianhua").val(),
						xs_zixunshi : $("#xs_zixunshi").val(),
						xs_isjiaofei : $("#xs_isjiaofei").combobox("getValue"),
						xs_isyouxiao : 2/* $("#xs_isyouxiao").combobox("getValue") */,
						xs_ishuifang : $("#xs_ishuifang").combobox("getValue"),
						xs_qq : $("#xs_qq").val(),
						xs_chuangjiantime : $("#minxs_chuangjiantime")
								.datetimebox('getValue'),
						xs_chuangjiantime : $("#maxxs_chuangjiantime")
								.datetimebox('getValue'),
						xs_shangmentime : $("#minxs_shangmentime").datetimebox(
								'getValue'),
						xs_shangmentime : $("#maxxs_shangmentime").datetimebox(
								'getValue'),
						xs_shuocihuifangtime : $("#minxs_shuocihuifangtime")
								.datetimebox('getValue'),
						xs_shuocihuifangtime : $("#maxxs_shuocihuifangtime")
								.datetimebox('getValue'),
						xs_jiaofeitime : $("#minxs_jiaofeitime").datetimebox(
								'getValue'),
						xs_jiaofeitime : $("#maxxs_jiaofeitime").datetimebox(
								'getValue'),
						xs_jinbantime : $("#minxs_jinbantime").datetimebox(
								'getValue'),
						xs_jinbantime : $("#maxxs_jinbantime").datetimebox(
								'getValue')
					}

				})
	}
	function formattercaozuo(value, row, index) {
		return " <a href='javascript:void(0)' class='easyui-linkbutton' onclick='stu_shanchu("
				+ index + ")' > 删除 </a>";
	}
	function formatterxingbie(value, row, index) {
		return row.xs_xingbie == 2 ? '女' : '男';
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
		return row.xs_isyouxiao == 1 ? "有效" : "无效";
	}
	function stu_shanchu(index){
		$.messager.confirm('确认','您确认想要删除学生吗吗？',function(r){    
		    if (r){    
		           $.post("delectstudent_dan",{xs_id : $("#StudentTab").datagrid("getData").rows[index].xs_id},function(res){
		        	   if(res=1){
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
		   				$("#StudentTab").datagrid("reload");
		        	   }else{
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
		           },"json");
		    }    
		});
	}
	
	function deletestudent_duo() {
		var row = $("#StudentTab").datagrid("getSelections");
		if (row != null && row != "") {
			var xs_ids = "";
			var xs_names=""
			for (var i = 0; i < row.length; i++) {
				if (i == 0) {
					xs_ids = xs_ids + row[i].xs_id;
					xs_names = xs_names + row[i].xs_name;
				} else {
					xs_ids = xs_ids + "," + row[i].xs_id;
					xs_names = xs_names + "," + row[i].xs_name;
				}
			}
			$.messager
					.confirm(
							'确认',
							'您确认想要把当前选中的所有学生删除吗？',
							function(r) {
								if (r) {
									$.post("deleteStudent_duo",{xs_ids : xs_ids},function(res){
										if(res>0){
											$("#StudentTab").datagrid("reload");
											 $.messager.show({
								   					title : '我的消息',
								   					msg : '已将姓名为'+xs_names+"的学生删除！",
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
								   					msg : '删除失败',
								   					timeout : 1000,
								   					showType : 'slide',
								   					style : {
								   						top : document.body.scrollTop
								   								+ document.documentElement.scrollTop,
								   					}
								   				});
										}
									},"json");
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
</script>
</html>