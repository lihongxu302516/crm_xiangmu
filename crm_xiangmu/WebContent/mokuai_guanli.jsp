<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>模块管理</title>
<script src="js/gonggong.js" type="text/javascript" charset="utf-8"></script>
<script src="js/yincang.js" type="text/javascript" charset="utf-8"></script>
<style type="text/css">
div {
	border: none;
}
</style>
</head>
<body>
	<a id="btn" href="javascript:void(0)" class="easyui-linkbutton"
		onclick="shutianjia()" data-options="iconCls:'icon-add'">添加</a>
	<a id="btn1" href="javascript:void(0)" class="easyui-linkbutton"
		onclick="shuxiugai()" data-options="iconCls:'icon-edit'">修改</a>
	<a id="btn2" href="javascript:void(0)" class="easyui-linkbutton"
		onclick="shushanchu()" data-options="iconCls:'icon-cancel'">删除</a>
	<div id="mkdiv" class="easyui-panel" style="padding: 5px">
		<ul id="tt" class="easyui-tree"
			data-options="iconCls:'icon-save',collapsible:true"></ul>
	</div>

	<div id="xiutab" class="easyui-window" title="修改"
		style="width: 300px; height: 400px; text-align: right; padding-right: 30px;"
		data-options="iconCls:'icon-save',modal:true">
		<form id="xiuform">
			<br /> 模块名称：<input class="easyui-validatebox" required="true"
				type="text" name="mk_name" id="xgmk_name" /><br /> <br /> URI：<input
				class="easyui-validatebox" type="text"
				name="mk_lujing" id="xgmk_lujing" /><br /> <br />权重：<input
				class="easyui-validatebox" validType="quanzhong" required="true" type="text"
				name="mk_exe1" id="xgmk_exe1" /><br /> <br /> 是否默认选中： <select
				class="easyui-combobox" id="xgmk_checked" name="mk_checked"
				style="width: 160px;">
				<option value="1">否</option>
				<option value="2">是</option>

			</select> <a id="btn1" href="javascript:void(0)" class="easyui-linkbutton"
				onclick="mkxiugai()" data-options="iconCls:'icon-ok'">修改</a>
		</form>
	</div>

	<div id="mkadddiv" class="easyui-window" title="添加"
		style="width: 300px; height: 400px; text-align: right; padding-right: 30px;"
		data-options="iconCls:'icon-save',modal:true">
		<form id="mkaddform">
			<br /> 模块名称：<input class="easyui-validatebox" required="true"
				type="text" name="addmk_name" id="addmk_name" /><br /> <br />
			URI：<input class="easyui-validatebox" type="text"
				name="addmk_lujing" id="addmk_lujing" /><br /> <br />权重：<input
				class="easyui-validatebox" validType="quanzhong" required="true" type="text"
				name="mk_exe1" id="addmk_exe1" /><br /> <br /> 是否默认选中： <select
				class="easyui-combobox" id="addmk_checked" name="addmk_checked"
				style="width: 160px;">
				<option value="1">否</option>
				<option value="2">是</option>

			</select> <a id="btn1" href="javascript:void(0)" class="easyui-linkbutton"
				onclick="mktianjia()" data-options="iconCls:'icon-ok'">添加</a>
		</form>
	</div>
	<div id="mm" class="easyui-menu" data-options="onClick:menuHandler"
		style="width: 120px;">
		<div data-options="iconCls:'icon-add',name:'add'">添加</div>
		<div data-options="iconCls:'icon-edit',name:'edit'">修改</div>
		<div data-options="iconCls:'icon-remove',name:'remove'">删除</div>
	</div>
</body>
<script type="text/javascript">
	var mokuai = null;
	$(function() {
		$('#xiutab').window('close');
		$('#mkadddiv').window('close');
		$('#tt').tree({
			url : "mokuai_xianshi",
			onContextMenu : function(e, node) {
				e.preventDefault();
				// 查找节点
				$('#tt').tree('select', node.target);
				// 显示快捷菜单
				$('#mm').menu('show', {
					left : e.pageX,
					top : e.pageY
				});
			}

		});

	});

	function menuHandler(item) {
		if (item.name == "add") { //添加
			shutianjia();
		} else if (item.name == "edit") { //修改
			shuxiugai();
		} else if (item.name == "remove") { //删除
			shushanchu();
		} else {
			$.messager.show({
				title : '我的消息',
				msg : '操作失败,请重试！',
				timeout : 1000,
				showType : 'slide',
				style : {
					top : document.body.scrollTop
							+ document.documentElement.scrollTop,
				}
			});
		}
	}

	function shuxiugai() {
		var nodes = $('#tt').tree('getSelected');
		$.post("mokuai_xianshi_xiugai", {
			mk_id : nodes.id,
			mk_exe1 : $("#addmk_exe1").val()
		}, function(res) {
			//var sss = eval("(" + res.message + ")")
			if (res != null) {
				mokuai = null;
				mokuai = res;
				$('#xiuform').form('load', mokuai);
				$('#xiutab').window('open');
			}
		}, "json");
	}

	function mkxiugai() {
		if ($("#xiuform").form('validate')) {
			$.post("mokuai_xiugai", {
				mk_id : mokuai.mk_id,
				mk_name : $("#xgmk_name").val(),
				mk_fuid : mokuai.mk_fuid,
				mk_lujing : $("#xgmk_lujing").val(),
				mk_checked : $("#xgmk_checked").combobox("getValue"),
				mk_exe1 : $("#xgmk_exe1").val()
			}, function(res) {
				if (res == 1) {
					$('#xiutab').window('close');
					$("#tt").tree("reload");
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
				} else if (res == -1) {
					$.messager.show({
						title : '我的消息',
						msg : '模块名称重复',
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

	function shutianjia() {
		var nodes = $('#tt').tree('getSelected');
		/* if (nodes == null || nodes == "" || nodes == "null") {
			$.messager.show({
				title : '我的消息',
				msg : '不好意思，请点击选择父节点！',
				timeout : 1000,
				showType : 'slide',
				style : {
					top : document.body.scrollTop
							+ document.documentElement.scrollTop,
				}
			});
		} else { */
		$('#mkaddform').form('reset');
		$('#mkadddiv').window('open');
		/* } */
	}

	function mktianjia() {
		if ($("#mkaddform").form('validate')) {
			var nodes = $('#tt').tree('getSelected');
			var id = 0;
			if (nodes != null) {
				if (nodes.id != "") {
					id = nodes.id;
				}
			}
			$.post("mokuai_tianjia", {
				mk_name : $("#addmk_name").val(),
				mk_fuid : id,
				mk_lujing : $("#addmk_lujing").val(),
				mk_checked : $("#addmk_checked").combobox("getValue")
			}, function(res) {
				if (res == 1) {
					$('#mkadddiv').window('close');
					$("#tt").tree("reload");
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
				} else if (res == -1) {
					$.messager.show({
						title : '我的消息',
						msg : '模块名称重复',
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

	function shushanchu() {
		$.messager.confirm('确认', '您确认想要删除记录吗？', function(r) {
			if (r) {
				$.post("mokuai_shanchu", {
					mk_id : $('#tt').tree('getSelected').id
				}, function(res) {
					if (res == 1) {
						$("#tt").tree("reload");
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
					} else if (res == -2) {
						$.messager.show({
							title : '我的消息',
							msg : '该模块的子模块正在被角色使用，请先释放资源',
							timeout : 1000,
							showType : 'slide',
							style : {
								top : document.body.scrollTop
										+ document.documentElement.scrollTop,
							}
						});
					} else if (res == -1) {
						$.messager.show({
							title : '我的消息',
							msg : '该模块正在被角色使用，请先释放资源',
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
</script>
</html>