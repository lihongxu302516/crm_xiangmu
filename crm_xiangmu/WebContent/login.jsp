<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>CRM登录</title>
<script src="js/gonggong.js" type="text/javascript" charset="utf-8"></script>
<style type="text/css">
body {
	background-image: url(img/login_beijing.jpg);
	background-repeat: no-repeat;
	background-size: cover;
}

#denglu_panel_fu {
	margin-top: 15%;
	margin-left: 35%;
}

#denglu_panel_zi {
	margin-top: 5%;
	margin-left: 26%;
}

#h1 {
	float: left;;
	color: white;
	margin-top: -120px;
	margin-left: 37%;
}
</style>
</head>
<body>
	<h1 id="h1">C R M 客 户 资 源 管 理 系 统</h1>
	<div id="denglu_panel_fu">
		<div id="denglu_panel">
			<div id="denglu_panel_zi">
				<form id="denglu_form">
					<table>
						<tr>
							<td>用户名 :</td>
							<td><input type="text" id="us_name" name=""
								class="easyui-textbox"></td>
						</tr>
						<tr>
							<td>密码 :</td>
							<td><input type="password" id="us_password" name=""
								class="easyui-textbox"></td>
						</tr>
						<tr>
							<td>验证码 :</td>
							<td><input type="text" id="yanzhengma" name=""
								class="easyui-textbox"></td>
						</tr>
						<tr>
							<td></td>
							<td><img id="yzm_img"
								style="cursor: pointer; width: 100px; height: 36px; margin: 5px 0 0 5px; border-radius: 3px;"
								title="点击刷新验证码" src="" /> <a href="javascript:void(0)"
								onclick="test()">看不清楚？立马刷新！</a></td>
						</tr>
						<tr>
							<td></td>
							<td>
								<p></p> <a id="denglu" href="javascript:void(0)"
								class="easyui-linkbutton" onclick="denglu()"> &nbsp;&nbsp;登
									陆&nbsp;&nbsp;</a>&nbsp;&nbsp;&nbsp;&nbsp;<a id="chongzhi"
								href="javascript:void(0)" class="easyui-linkbutton"
								onclick="chongzhi()"> &nbsp;&nbsp;重 置 &nbsp;&nbsp;</a>
							</td>
						</tr>
					</table>
				</form>
			</div>
			<span id="czmm_span"><a id="chongzhi_mima"
				href="javascript:void(0)" onclick="chongzhi_mima()">
					&nbsp;&nbsp;忘记密码？点击重置！</a></span>
		</div>
	</div>
	<div id="cz_win" class="easyui-window" title="重置密码"
		style="width: 400px; height: 200px"
		data-options="iconCls:'icon-save',modal:true">
		<form id="czmm_form">
			<table>
				<tr>
					<td>用户名：</td>
					<td><input class="easyui-textbox" data-options="required:true"
						id="cz_us_name" value="" style="width: 300px"></td>
				</tr>
				<tr>
					<td>手机验证码：</td>
					<td><input class="easyui-textbox" data-options="required:true"
						id="us_sj_yzm" value="" validType="length['6','6']"
						style="width: 300px"></td>
				</tr>
				<tr>
					<td colspan="2"><a
						style="margin-left: 130px; margin-top: 10px" id="czmm_btn"
						href="javascript:void(0)" onclick="shoujiyanzhengma()"
						class="easyui-linkbutton"> 获取手机验证码 </a></td>
				</tr>
			</table>
			<a style="margin-left: 155px; margin-top: 10px" id="czmm_btn"
				href="javascript:void(0)" onclick="cz_mima()"
				class="easyui-linkbutton" data-options="iconCls:'icon-save'"> 保存
			</a>
		</form>
	</div>
</body>
<script type="text/javascript">
	$(function() {
		denglu_panel_f();
		test();
		$('#cz_win').window('close');
	});
	function denglu_panel_f() {
		$('#denglu_panel').panel({
			width : 500,
			height : 280,
			title : '登陆',
		});
	}
	function test() {
		$("#yzm_img").prop('src', 'yanzhengma?a=' + new Date().getTime());
		var url = 'yanzhengma?a=' + new Date().getTime();
	}
	function chongzhi() {
		$('#denglu_form').form('reset');
	}
	function denglu() {
		$.post("denglu", {
			us_name : $("#us_name").val(),
			us_password : $("#us_password").val(),
			yanzhengma : $("#yanzhengma").val()
		}, function(res) {
			if (res == 1) {
				$.messager.show({
					title : '我的消息',
					msg : '验证码错误',
					timeout : 1000,
					showType : 'slide',
					style : {
						top : document.body.scrollTop
								+ document.documentElement.scrollTop,
					}
				});
			} else if (res == 2) {
				$.messager.show({
					title : '我的消息',
					msg : '用户名错误',
					timeout : 1000,
					showType : 'slide',
					style : {
						top : document.body.scrollTop
								+ document.documentElement.scrollTop,
					}
				});
			} else if (res == 3) {
				$.messager.show({
					title : '我的消息',
					msg : '密码错误',
					timeout : 1000,
					showType : 'slide',
					style : {
						top : document.body.scrollTop
								+ document.documentElement.scrollTop,
					}
				});
			} else if (res == 4) {
				$.messager.show({
					title : '我的消息',
					msg : '账户已被锁定，请联系管理员解除锁定！',
					timeout : 1000,
					showType : 'slide',
					style : {
						top : document.body.scrollTop
								+ document.documentElement.scrollTop,
					}
				});
			} else if (res == 5) {
				$.messager.show({
					title : '我的消息',
					msg : '今日密码错误次数超出3次，账户已被锁定！',
					timeout : 1000,
					showType : 'slide',
					style : {
						top : document.body.scrollTop
								+ document.documentElement.scrollTop,
					}
				});
			} else if (res == 0) {
				$.messager.show({
					title : '我的消息',
					msg : '登陆成功',
					timeout : 1000,
					showType : 'slide',
					style : {
						top : document.body.scrollTop
								+ document.documentElement.scrollTop,
					}
				});
				window.location.href = "home";
			}
		}, "json");
	}

	function shoujiyanzhengma() {
		var us_name = $("#cz_us_name").val();
		if(us_name!=null && us_name!=""){
			$.post("cz_shoujihaoyanzheng", {us_name:us_name}, function(res) {
				if (res == 1) {
					$.messager.show({
						title : '我的消息',
						msg : '用户名为空！',
						timeout : 1000,
						showType : 'slide',
						style : {
							top : document.body.scrollTop
									+ document.documentElement.scrollTop,
						}
					});
				} else if (res == 2) {
					$.messager.show({
						title : '我的消息',
						msg : '没有该用户或该用户没有绑定手机号',
						timeout : 1000,
						showType : 'slide',
						style : {
							top : document.body.scrollTop
									+ document.documentElement.scrollTop,
						}
					});
				} else if (res == 3) {
					$.messager.show({
						title : '我的消息',
						msg : '该用户绑定的手机号不符合格式',
						timeout : 1000,
						showType : 'slide',
						style : {
							top : document.body.scrollTop
									+ document.documentElement.scrollTop,
						}
					});
				}else if(res ==4 ){
					$.messager.show({
						title : '我的消息',
						msg : '验证码已发送',
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
				msg : '请先输入用户名',
				timeout : 1000,
				showType : 'slide',
				style : {
					top : document.body.scrollTop
							+ document.documentElement.scrollTop,
				}
			});
		}
	}
	function cz_mima(){
		if ($("#czmm_form").form('validate')) {
			$.post("user_cz_mima", {us_sj_yzm : $("#us_sj_yzm").val()}, function(res) {
				if (res == 1) {
					$.messager.show({
						title : '我的消息',
						msg : '密码重置成功！',
						timeout : 1000,
						showType : 'slide',
						style : {
							top : document.body.scrollTop
									+ document.documentElement.scrollTop,
						}
					});
					$('#cz_win').window('close');
				} else if (res == 2) {
					$.messager.show({
						title : '我的消息',
						msg : '验证码为空',
						timeout : 1000,
						showType : 'slide',
						style : {
							top : document.body.scrollTop
									+ document.documentElement.scrollTop,
						}
					});
				} else if (res == 3) {
					$.messager.show({
						title : '我的消息',
						msg : '验证码错误',
						timeout : 1000,
						showType : 'slide',
						style : {
							top : document.body.scrollTop
									+ document.documentElement.scrollTop,
						}
					});
				}else if(res ==0 ){
					$.messager.show({
						title : '我的消息',
						msg : '密码重置失败',
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
	}
	function chongzhi_mima(){
		$('#cz_win').window('open');
	}
</script>
</html>