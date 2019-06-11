<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>角色管理</title>
<script src="js/gonggong.js" type="text/javascript" charset="utf-8"></script>
<script src="js/yincang.js" type="text/javascript" charset="utf-8"></script>
</head>
<body>
	<table id="juese_tab" class="easyui-datagrid">
		<thead>
			<tr>
				<th data-options="field:'js_id'">角色编号</th>
				<th data-options="field:'js_name'">角色名称</th>
				<th data-options="field:'caozuo',formatter:caozuo">操作</th>
				<th data-options="field:'mk_shezhi',formatter:mk_shezhi">模块设置</th>
			</tr>
		</thead>
	</table>
	<div id="usertb" style="padding: 5px; height: auto">
		<div style="margin-bottom: 5px">
		角色名称: <input class="easyui-textbox" id="ss_js_name" style="width: 80px">
		<a href="javascript:void(0)" class="easyui-linkbutton"
				iconCls="icon-search" onclick="chushihua()">查找</a>
			<a href="javascript:void(0)" class="easyui-linkbutton"
				iconCls="icon-add" plain="true" onclick="addInfo()">新增</a>
		</div>
	</div>

	<div id="win" class="easyui-window" title="编辑"
		style="width: 300px; height: 400px; text-align: right; padding-right: 30px;"
		data-options="iconCls:'icon-save',modal:true">
		<form id="ff">
			<br /> <input class="easyui-validatebox" type="text" name="js_id"
				id="js_id" style="display: none;" /><br />
			<br /> 角色名： <input class="easyui-validatebox" type="text"
				name="js_name" id="js_name" /><br />
			<br /> <a id="btn" href="javascript:void(0)"
				class="easyui-linkbutton" onclick="bianji()"
				data-options="iconCls:'icon-ok'">编辑</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="javascript:void(0)" class="easyui-linkbutton"
				onclick="$('#ff').form('reset')" data-options="iconCls:'icon-clear'">清空</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="javascript:void(0)" class="easyui-linkbutton"
				onclick="quxiao()" data-options="iconCls:'icon-no'">取消</a>
		</form>
	</div>

	<div id="addjs" class="easyui-window" title="添加"
		style="width: 300px; height: 400px; text-align: right; padding-right: 30px;"
		data-options="iconCls:'icon-save',modal:true">
		<form id="ffjs">
			<br /> 角色名： <input class="easyui-validatebox" type="text"
				name="tj_js_name" id="tj_js_name" /><br />
			<br /> <a id="btn" href="javascript:void(0)"
				class="easyui-linkbutton" onclick="tianjia()"
				data-options="iconCls:'icon-ok'">添加</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="javascript:void(0)" class="easyui-linkbutton"
				onclick="$('#ffjs').form('reset')"
				data-options="iconCls:'icon-clear'">清空</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="javascript:void(0)" class="easyui-linkbutton"
				onclick="quxiao()" data-options="iconCls:'icon-no'">取消</a>
		</form>
	</div>

	<div id="quanxiantree" title="分配权限" class="easyui-window"
		style="width: 300px; height: 500px"
		data-options="iconCls:'icon-save',modal:true">
		<div class="easyui-layout" data-options="fit:true">
			<div data-options="region:'north',split:true" style="height: 435px">
				<div id="mkdiv" class="easyui-panel" style="padding: 5px">
					<ul id="tt" class="easyui-tree"
						data-options="iconCls:'icon-save',collapsible:true"></ul>
				</div>
			</div>
			<div data-options="region:'center'" style="text-align: right;">
				<a id="btn" href="javascript:void(0)" style="margin-right: 30px;"
					class="easyui-linkbutton" onclick="baocun()"
					data-options="iconCls:'icon-ok'">保存</a>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
	var jiaoseid = null;

	function shezhi(index) {
		var data = $("#juese_tab").datagrid("getData");
		var row = data.rows[index];
		$('#tt').tree({
			url : "juese_chakan_mokuaitree",
			queryParams : {
				js_id : row.js_id
			},
			checkbox : true
		});
		jiaoseid = null;
		jiaoseid = row.js_id;
		$('#quanxiantree').window('open');
	}

	function baocun() {
		var trees = $("#tt").tree("getChecked", [ "checked", "indeterminate" ]);
		var ids = "";
		for (var i = 0; i < trees.length; i++) {
			if (ids == "") {
				ids = ids + trees[i].id;
			} else {
				ids = ids + "," + trees[i].id;
			}
		}
		$.post("juese_mokuai_tianjia", {
			mkids : ids,
			js_id : jiaoseid
		}, function(res) {
			if (res>0) {
				$('#quanxiantree').window('close');
				$("#juese_tab").datagrid("reload");
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
				$('#quanxiantree').window('close');
				$("#juese_tab").datagrid("reload");
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

	function quxiao() {
		$('#win').window('close');
		$('#addjs').window('close');
	}

	function chushihua() {
		$("#juese_tab").datagrid({
			url : "juese_xianshi", //数据接口的地址
			toolbar:"#usertb",
			pagination:true,
			rownumbers:true,
			singleSelect:true,
			queryParams : { //要发送的参数列表
				js_name : $("#ss_js_name").val()
			}
		});
		$('#ss_js_name').textbox('reset');
	}
	$(function() {
		$('#win').window('close');
		$('#addjs').window('close');
		$('#quanxiantree').window('close');
		chushihua();
	});

	function caozuo(value, row, index) {
		return "<a href='javascript:void(0)' class='easyui-linkbuton' onclick='dakai_bianji("
				+ index
				+ ")'>编辑</a>&nbsp;&nbsp;<a href='javascript:void(0)' class='easyui-linkbuton' onclick='shanchu("
				+ index + ")'>删除</a>";
	}

	function mk_shezhi(value, row, index) {
		return "<a href='javascript:void(0)' class='easyui-linkbuton' onclick='shezhi("
				+ index + ")'>设置</a>";
	}

	function dakai_bianji(index) {
		var data = $("#juese_tab").datagrid("getData");
		var row = data.rows[index];
		$('#ff').form('clear');
		$('#ff').form('load', row);
		$('#win').window('open');
	}

	function bianji() {
		var js_name=$("#js_name").val();
		if(js_name!=null && js_name!=""){
			$.post("juese_xiugai", {
				js_name : js_name,
				js_id : $("#js_id").val()
			}, function(res) {
				if (res==1) {
					$('#win').window('close');
					$("#juese_tab").datagrid("reload");
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
				}else if(res==-1) {
					
					$.messager.show({
						title : '我的消息',
						msg : '用户名重复，无法更新',
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
		}else{
			$.messager.show({
				title : '我的消息',
				msg : '角色名不能为空',
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
		$.messager.confirm('确认', '您确认想要删除角色吗？', function(r) {
			if (r) {
				var data = $("#juese_tab").datagrid("getData");
				var row = data.rows[index];
				$.post("juese_shanchu", {
					js_id : row.js_id
				}, function(res) {
					if (res==1) {
						$("#juese_tab").datagrid("reload");
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
					} else if(res==-1) {
						
						$.messager.show({
							title : '我的消息',
							msg : '该角色下有用户，需要先释放资源后删除',
							timeout : 1000,
							showType : 'slide',
							style : {
								top : document.body.scrollTop
										+ document.documentElement.scrollTop,
							}
						});
					}else if(res==-2) {
						
						$.messager.show({
							title : '我的消息',
							msg : '该角色正在使用模块，需要先释放资源后删除',
							timeout : 1000,
							showType : 'slide',
							style : {
								top : document.body.scrollTop
										+ document.documentElement.scrollTop,
							}
						});
					}else {
						
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
		$("#ffjs").form("reset");
		$('#addjs').window('open');
	}

	function tianjia() {
		var js_name=$("#tj_js_name").val();
		if(js_name!=null && js_name!=""){
			$.post("juese_tianjia", {
				js_name : js_name
			}, function(res) {
				if (res==1) {
					$('#addjs').window('close');
					$("#juese_tab").datagrid("reload");
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
						msg : '角色名重复，无法添加',
						timeout : 1000,
						showType : 'slide',
						style : {
							top : document.body.scrollTop
									+ document.documentElement.scrollTop,
						}
					});
				}else {
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
		}else{
			$.messager.show({
				title : '我的消息',
				msg : '角色名不能为空',
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