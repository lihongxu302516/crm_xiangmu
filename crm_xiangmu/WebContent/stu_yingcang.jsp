<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<div id="yc_window" class="easyui-window" title="隐藏"
		style="width: 400px; height: 400px"
		data-options="iconCls:'icon-save',modal:true">
		<div id="yc_div">
			<h3>请选择需要隐藏的列名</h3>
			<form id="yc_form">
				<table>
					<tr>
						<td><input name="yc_leiming" type="checkbox" value="xs_name" /></td>
						<td>姓名</td>

						<td><input name="yc_leiming" type="checkbox" value="xs_xingbie" /></td>
						<td>性别</td>
						
						<td><input name="yc_leiming" type="checkbox" value="xs_nianling" /></td>
						<td>年龄</td>
						
						<td><input name="yc_leiming" type="checkbox" value="xs_dianhua" /></td>
						<td>电话</td>
					</tr>
					<tr>
						<td><input name="yc_leiming" type="checkbox" value="xs_chuangjiantime" /></td>
						<td>创建时间</td>

						<td><input name="yc_leiming" type="checkbox" value="xs_xueli" /></td>
						<td>学历</td>
						
						<td><input name="yc_leiming" type="checkbox" value="xs_zhuangtai" /></td>
						<td>个人状态</td>
						
						<td><input name="yc_leiming" type="checkbox" value="xs_laiyuanqudao" /></td>
						<td>来源渠道</td>
					</tr>
					<tr>
						<td><input name="yc_leiming" type="checkbox" value="xs_laiyuanwangzhi" /></td>
						<td>来源网址</td>

						<td><input name="yc_leiming" type="checkbox" value="xs_guanzhu" /></td>
						<td>学生关注</td>
						
						<td><input name="yc_leiming" type="checkbox" value="xs_liyuanguanjianzi" /></td>
						<td>学生关键字</td>
						
						<td><input name="yc_leiming" type="checkbox" value="xs_namezixun" /></td>
						<td>姓名咨询</td>
					</tr>
					<tr>
						<td><input name="yc_leiming" type="checkbox" value="xs_suozaiquyu" /></td>
						<td>所在区域</td>

						<td><input name="yc_leiming" type="checkbox" value="xs_weixin" /></td>
						<td>微信</td>
						
						<td><input name="yc_leiming" type="checkbox" value="xs_qq" /></td>
						<td>qq</td>
						
						<td><input name="yc_leiming" type="checkbox" value="xs_laiyuanbumen" /></td>
						<td>来源部门</td>
					</tr>
					<tr>
						<td><input name="yc_leiming" type="checkbox" value="xs_isbaobei" /></td>
						<td>是否报备</td>

						<td><input name="yc_leiming" type="checkbox" value="xs_kecheng" /></td>
						<td>课程方向</td>
						
						<td><input name="yc_leiming" type="checkbox" value="xs_isyouxiao" /></td>
						<td>是否有效</td>
						
						<td><input name="yc_leiming" type="checkbox" value="xs_dafen" /></td>
						<td>打分</td>
					</tr>
					<tr>
						<td><input name="yc_leiming" type="checkbox" value="xs_ishuifang" /></td>
						<td>是否回访</td>

						<td><input name="yc_leiming" type="checkbox" value="xs_shuocihuifangtime" /></td>
						<td>首次回访时间</td>
						
						<td><input name="yc_leiming" type="checkbox" value="xs_isshangmen" /></td>
						<td>是否上门</td>
						
						<td><input name="yc_leiming" type="checkbox" value="xs_shangmentime" /></td>
						<td>上门时间</td>
					</tr>
					<tr>
						<td><input name="yc_leiming" type="checkbox" value="xs_wuxiaoyuanyin" /></td>
						<td>无效原因</td>

						<td><input name="yc_leiming" type="checkbox" value="xs_isjiaofei" /></td>
						<td>是否缴费</td>
						
						<td><input name="yc_leiming" type="checkbox" value="xs_jiaofeitime" /></td>
						<td>缴费时间箱</td>
						
						<td><input name="yc_leiming" type="checkbox" value="xs_jine" /></td>
						<td>金额</td>
					</tr>
					<tr>
						<td><input name="yc_leiming" type="checkbox" value="xs_istuifei" /></td>
						<td>是否退费</td>

						<td><input name="yc_leiming" type="checkbox" value="xs_isjinban" /></td>
						<td>是否进班</td>
						
						<td><input name="yc_leiming" type="checkbox" value="xs_jinbantime" /></td>
						<td>进班时间</td>
						
						<td><input name="yc_leiming" type="checkbox" value="xs_jinbanbeizhu" /></td>
						<td>进班备注</td>
					</tr>
					<tr>
						<td><input name="yc_leiming" type="checkbox" value="xs_tuifeiyuanyin" /></td>
						<td>退费原因</td>

						<td><input name="yc_leiming" type="checkbox" value="xs_dingjinjine" /></td>
						<td>定金金额</td>
						
						<td><input name="yc_leiming" type="checkbox" value="xs_dingjintime" /></td>
						<td>定金时间</td>
						
						<td><input name="yc_leiming" type="checkbox" value="xs_zixunshi" /></td>
						<td>咨询师</td>
					</tr>
					<tr>
						<td><input name="yc_leiming" type="checkbox" value="xs_lururen" /></td>
						<td>录入人</td>

						<td><input name="yc_leiming" type="checkbox" value="xs_zixunshibeizhu" /></td>
						<td>咨询师备注</td>
						
						<td><input name="yc_leiming" type="checkbox" value="xs_id" /></td>
						<td>学生编号</td>
						
					</tr>
				
				</table>
			</form>
			<br> 
			<input name="is_quanxuan" id="is_quanxuan" onchange="checkAll()" type="checkbox" value="" />全选
			<a id="yc_btn1" href="javascript:void(0)"
				onclick="yc_yincang()" class="easyui-linkbutton"> 隐藏选中 </a>
			&nbsp;&nbsp;&nbsp; &nbsp;&nbsp; <a id="yc_btn2"
				href="javascript:void(0)" onclick="yc_guanbi()"
				class="easyui-linkbutton"> 关闭 </a>
		</div>
	</div>
</body>
<script type="text/javascript">
function checkAll(){
	//1.获取编号前面的复选框
	var checkAllEle = document.getElementById("is_quanxuan");
	//2.对编号前面复选框的状态进行判断
	if(checkAllEle.checked==true){
		//3.获取下面所有的复选框
		var checkOnes = document.getElementsByName("yc_leiming");
		//4.对获取的所有复选框进行遍历
		for(var i=0;i<checkOnes.length;i++){
			//5.拿到每一个复选框，并将其状态置为选中
			checkOnes[i].checked=true;
		}
	}else{
		//6.获取下面所有的复选框
		var checkOnes = document.getElementsByName("yc_leiming");
		//7.对获取的所有复选框进行遍历
		for(var i=0;i<checkOnes.length;i++){
			//8.拿到每一个复选框，并将其状态置为未选中
			checkOnes[i].checked=false;
		}
	}
}
</script>
</html>