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
			<span><a id="chongzhi_mima" href="javascript:void(0)"
				class="easyui-linkbutton" onclick="chongzhi_mima()">
					&nbsp;&nbsp;忘记密码？重置密码！</a></span>
		</div>
	</div>
</body>
<script type="text/javascript">
	$(function() {
		denglu_panel_f();
		test();
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
</script>
</html>