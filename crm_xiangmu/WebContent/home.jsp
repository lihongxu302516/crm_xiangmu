<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>主页</title>
<script src="js/gonggong.js" type="text/javascript" charset="utf-8"></script>
<style type="text/css">
div {
	border: none;
}
</style>
</head>
<body>
	<div class="easyui-layout" style="width: 100%; height: 730px;">
		<div data-options="region:'north'" style="height: 100px;">
			<span id="yonghu"
				style="text-align: left; display: block; margin-top: 70px; float: left; font-size: 14px;">云时代CRM系统
				欢迎您 ${user.us_name}</span> <span
				style="text-align: left; display: block; margin-top: 70px; float: left; font-size: 14px;"><a
				href="javascript:void(0)" onclick="tuichu()"
				style="text-decoration: none; color: black;">&nbsp;&nbsp;&nbsp;安全退出</a></span>
			<c:choose>
				<c:when test="${user!=null and user.us_isdaka==2}">
					<span
						style="text-align: left; display: block; margin-top: 70px; float: left; font-size: 14px;">
						<a href="javascript:void(0)" onclick="dk_daka()"
						style="text-decoration: none; color: black;">&nbsp;&nbsp;&nbsp;还未打卡？立马打卡！</a>
					</span>
				</c:when>
				<c:otherwise>
					<span
						style="text-align: left; display: block; margin-top: 70px; float: left; font-size: 14px;">
						&nbsp;&nbsp;&nbsp;今天已打卡！好棒棒！ </span>
				</c:otherwise>
			</c:choose>
			<h1 style="float: left; margin-left: 15%;">云 时 代 欢 迎 您 ! ! !</h1>
			<span
				style="display: block; text-align: right; margin-top: 20px; margin-right: 30px;">
				语言: <select id="yuyan" data-options="editable:false"
				class="easyui-combobox" name="yuyan" style="width: 200px;">
					<option value="">---请选择语言---</option>
					<option value="easyui-lang-zh_CN.js">简体中文</option>
					<option value="easyui-lang-zh_TW.js">繁体中文</option>
					<option value="easyui-lang-af.js">未知语言1</option>
					<option value="easyui-lang-am.js">未知语言2</option>
					<option value="easyui-lang-ar.js">未知语言3</option>
					<option value="easyui-lang-bg.js">未知语言4</option>
					<option value="easyui-lang-ca.js">未知语言5</option>
					<option value="easyui-lang-cs.js">未知语言6</option>
					<option value="easyui-lang-cz.js">未知语言7</option>
					<option value="easyui-lang-da.js">未知语言8</option>
					<option value="easyui-lang-de.js">未知语言9</option>
					<option value="easyui-lang-el.js">未知语言10</option>
					<option value="easyui-lang-en.js">未知语言11</option>
					<option value="easyui-lang-es.js">未知语言12</option>
					<option value="easyui-lang-fr.js">未知语言13</option>
					<option value="easyui-lang-it.js">未知语言14</option>
					<option value="easyui-lang-jp.js">未知语言15</option>
					<option value="easyui-lang-nl.js">未知语言16</option>
					<option value="easyui-lang-pl.js">未知语言17</option>
					<option value="easyui-lang-pt_BR.js">未知语言18</option>
					<option value="easyui-lang-ru.js">未知语言19</option>
					<option value="easyui-lang-sv_SE.js">未知语言20</option>
					<option value="easyui-lang-tr.js">未知语言21</option>
			</select>
			</span> <span
				style="display: block; text-align: right; margin-top: 20px; margin-right: 30px;">
				主题: <select id="zhuti" data-options="editable:false"
				class="easyui-combobox" name="zhuti" style="width: 200px;">
					<option value="">---请选择主题颜色---</option>
					<option value="default">标准</option>
					<option value="black">酷炫黑</option>
					<option value="bootstrap">亮丽白</option>
					<option value="gray">奶奶灰</option>
					<option value="metro">透明白</option>
					<option value="metro-blue">温暖蓝</option>
					<option value="metro-gray">黯淡灰</option>
					<option value="metro-green">护眼绿</option>
					<option value="metro-orange">热情红</option>
					<option value="metro-red">高贵紫</option>
					<option value="ui-cupertino">海洋蓝</option>
					<option value="ui-dark-hive">极致黑</option>
					<option value="ui-pepper-grinder">双灰白</option>
					<option value="ui-sunny">双粉黑</option>
			</select>
			</span>
		</div>
		<div data-options="region:'west',split:true" title="导航应用"
			style="width: 150px;">
			<div id="menuTree">
				<!--这个地方显示树状结构-->
			</div>
		</div>
		<div id="centerTabs" data-options="region:'center',iconCls:'icon-ok'"
			style="width: 530px;">
			<div id="tt" class="easyui-tabs">
				<!--这个地方采用tabs控件进行布局-->
			</div>
		</div>
	</div>

	<div id="daka_win" class="easyui-window" title="打卡签到"
		style="width: 300px; height: 150px">
		<h3 style="margin-left: 30px">当前未打卡签到，是否立马打卡签到?</h3>
		<a style="margin-left: 70px" id="dk_btn" href="javascript:void(0)" onclick="dk_daka()"
			class="easyui-linkbutton">打卡签到</a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a
			id="dk_btn" href="javascript:void(0)" onclick="dk_deng()"
			class="easyui-linkbutton">稍等一会</a>
	</div>
</body>
<script type="text/javascript">
	//树形结构显示
	$(function() {
		dongtaixueshengrizhi();
		$('#daka_win').window('close');
		$.post("hometree", {
			treeUlId : "treeUlId"
		}, function(res) { //res是返回的html代码
			$("#menuTree").html(res);
			$("#treeUlId").tree(); //让easyUI引擎重新将treeUIId中的html代码转变成树并显示
		});
		$('#zhuti').combobox({
			onSelect : function(param) {
				var zhuti = $("#zhuti").combobox("getValue");
				localStorage.setItem("zhuti", zhuti);
				window.location.reload();
			}
		});
		$('#yuyan').combobox({
			onSelect : function(param) {
				var yuyan = $("#yuyan").combobox("getValue");
				localStorage.setItem("yuyan", yuyan);
				window.location.reload();
			}
		});
	});
	//树状结构的节点是否已在中部显示，参数re是标题，html 是路径
	function navTab(re, html) {
		var flag = $("#tt").tabs('exists', re);
		$('#treeUlId')
				.tree(
						{ //和前边加载数据的代码中的"treeUIId"参数,保持一致即可
							onSelect : function(node) {
								var isLeaf = $('#treeUlId').tree('isLeaf',
										node.target); //是否是叶子节点
								if (isLeaf) { //只有叶子节点才会在选项卡中创建选项页（每个选项页对应1个功能）
									if (!flag) {
										$('#tt')
												.tabs(
														'add',
														{ //在选项卡中，创建1个选项页
															title : re, //选项卡中，选项页的标题（在同一个选项卡中，选项页需要保持一致）。
															closable : true,
															content : "<iframe src='"
																	+ html
																	+ "' style='width:99%;height:590px' />" //此处做了调整，推荐使用iframe的方式实现
														});
									} else {
										$("#tt").tabs('select', re); //直接选中title对应的选项卡
									}
								}
							}
						});
	}

	function tuichu() {
		$.messager.confirm('确认', '您确认想要退出吗？', function(r) {
			if (r) {
				window.location.href = "tuichu";
			}
		});
	}
	function dk_daka() {
		$.post("user_daka", {}, function(res) {
			if (res == 1) {
				$('#daka_win').window('close');
				history.go(0);
				$.messager.show({
					title : '我的消息',
					msg : '打卡签到成功',
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
					msg : '打卡签到失败',
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
	function dk_deng() {
		$('#daka_win').window('close');
	}
	function dongtaixueshengrizhi(){
		$.post("dongtaixueshengrizhi",{},function(res){
			if(res!="1" && res!="2" && res!=""){
				$.messager.show({
					title:'我的消息',
					msg:'你的学生：'+res+"有动态信息，请及时查看！",
					timeout:0,
					showType:'slide',
					width:"400px",
					height:"200px"
				});
			}	
		});
		
	}
</script>
<c:if test="${user!=null and user.us_isdaka==2}">
		<script type="text/javascript">
			$(function(){
				$('#daka_win').window('open');
			});
		</script>
</c:if>
	
	
</html>