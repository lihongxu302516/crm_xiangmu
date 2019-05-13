<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="js/jquery-easyui-1.4.3/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="js/jquery-easyui-1.4.3/themes/icon.css">
<script type="text/javascript"
	src="js/jquery-easyui-1.4.3/jquery.min.js"></script>
<script type="text/javascript"
	src="js/jquery-easyui-1.4.3/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="js/jquery-easyui-1.4.3/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
	$(function() {
		student_guanli();
	})
	function student_guanli() {
		$("#StudentTab").datagrid({
			url:'student_xianshi',
			method:'post',
			toolbar:'#StudentToo',
			pagination:true,
			singleSelect:true,
			queryParams: {
				xs_name:$("#xs_name").val(),
				xs_dianhua:$("#xs_dianhua").val(),
				xs_zixunshi:$("#xs_zixunshi").val(),
				xs_isjiaofei:$("#xs_isjiaofei").combobox("getValue"),
				xs_isyouxiao:$("#xs_isyouxiao").combobox("getValue"),
				xs_ishuifang:$("#xs_ishuifang").combobox("getValue"),
				xs_qq:$("#xs_qq").val(),
				xs_chuangjiantime:$("#xs_chuangjiantime").val(),
				xs_shangmentime:$("#xs_shangmentime").val(),
				xs_shuocihuifangtime:$("#xs_shuocihuifangtime").val(),
				xs_jiaofeitime:$("#xs_jiaofeitime").val(),
				xs_jinbantime:$("#xs_jinbantime").val(),
			}

		})
	}
	function formattercaozuo(value,row,index){
		return "<a href='javascript:void(0)' class='easyui-linkbutton' onclick='updateU("+index+")' > 修改 </a>  <a href='javascript:void(0)' class='easyui-linkbutton' onclick='deleteD("+index+")' > 删除 </a>";
	}
</script>
</head>
<body>
	<table id="StudentTab" class="easyui-datagrid">
		<thead>
			<tr>
				<th data-options="field:'xs_id'">学生编号</th>
				<th data-options="field:'xs_name' ">姓名</th>
				<th data-options="field:'xs_xingbie' ">性别</th>
				<th data-options="field:'xs_nianling' ">年龄</th>
				<th data-options="field:'xs_dianhua' ">电话</th>
				<th data-options="field:'xs_chuangjiantime' ">创建时间</th>
				<th data-options="field:'xs_xueli' ">学历</th>
				<th data-options="field:'xs_zhuangtai' ">个人状态</th>
				<th data-options="field:'xs_laiyuanqudao' ">来源渠道</th>
				<th data-options="field:'xs_laiyuanwangzhi' ">来源网址</th>
				<th data-options="field:'xs_guanzhu' ">学生关注</th>
				<th data-options="field:'xs_liyuanguanjianzi' ">来源关键字</th>
				<th data-options="field:'xs_namezixun' ">姓名质询</th>
				<th data-options="field:'xs_suozaiquyu' ">所在区域</th>
				<th data-options="field:'xs_weixin' ">微信</th>
				<th data-options="field:'xs_qq' ">qq</th>
				<th data-options="field:'xs_laiyuanbumen' ">来源部门</th>
				<th data-options="field:'xs_isbaobei' ">是否备注</th>
				<th data-options="field:'xs_kecheng' ">课程方向</th>
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
				<th data-options="field:'xs_dingjintime' ">定金时间</th>
				<th data-options="field:'xs_zixunshi' ">咨询师</th>
				<th data-options="field:'xs_lururen' ">录入人</th>
				<th data-options="field:'xs_zixunshibeizhu' ">咨询师备注</th>
				<th data-options="field:'xs_caozuo',formatter:formattercaozuo ">操作</th>
			</tr>
		</thead>
	</table>
	<div id="StudentToo">
		<form id="frm">

			<label >姓名:</label> <input class="easyui-validatebox"
				type="text" id="xs_name" name="xs_name" />
			<label >电话:</label> <input class="easyui-validatebox"
				type="text" id="xs_dianhua" name="xs_dianhua" />
			<label >咨询师:</label> <input class="easyui-validatebox"
				type="text" id="xs_zixunshi" name="xs_zixunshi" />
			<label >是否缴费:</label> 
			  <select id="xs_isjiaofei" class="easyui-combobox" name="xs_isjiaofei" style="width:200px;">   
                  <option value="">— —请输入— —</option>   
                  <option value="1">是</option>   
                  <option value="2">否</option>     
              </select> 

			<label >是否有效:</label> 
			   <select id="xs_isyouxiao" class="easyui-combobox" name="xs_isyouxiao" style="width:200px;">   
                  <option value="">— —请输入— —</option>   
                  <option value="1">是</option>   
                  <option value="2">否</option>     
               </select> 
			
			<label >是否回访:</label>
			  <select id="xs_ishuifang" class="easyui-combobox" name="xs_ishuifang" style="width:200px;">   
                  <option value="">— —请输入— —</option>   
                  <option value="1">是</option>   
                  <option value="2">否</option>     
               </select> 
			<label >QQ:</label> <input class="easyui-validatebox"
				type="text" id="xs_qq" name="xs_qq" />
			<label >创建时间:</label> <input class="easyui-validatebox"
				type="text" id="xs_chuangjiantime" name="xs_chuangjiantime" />
			<label >上门时间:</label> <input class="easyui-validatebox"
				type="text" id="xs_shangmentime" name="xs_shangmentime" />
			<label >首次回访时间:</label> <input class="easyui-validatebox"
				type="text" id="xs_shuocihuifangtime" name="xs_shuocihuifangtime" />
			<label >缴费时间:</label> <input class="easyui-validatebox"
				type="text" id="xs_jiaofeitime" name="xs_jiaofeitime" />
			<label >进班时间:</label> <input class="easyui-validatebox"
				type="text" id="xs_jinbantime" name="xs_jinbantime" />
			<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true">搜索</a>
            <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">添加</a>
			
			
				

		</form>
	</div>
</body>
</html>