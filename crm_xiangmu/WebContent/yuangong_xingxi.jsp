<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>员工信息</title>
<script src="js/gonggong.js" type="text/javascript" charset="utf-8"></script>
<script src="js/yincang.js" type="text/javascript" charset="utf-8"></script>
<style type="text/css">
#ygxx_div {
	margin-left: 20px;
	font-size: 14px;
}
</style>
</head>
<body>
	<div id="ygxx_div">
		<form id="ygxx_form">
			<table>
				<tr>
					<td>编号：</td>
					<td><input class="easyui-textbox" id="us_id"
						disabled="disabled" value="${user.us_id}" style="width: 300px"></td>
				</tr>
				<tr>
					<td>姓名：</td>
					<td><input class="easyui-textbox" id="us_name"
						value="${user.us_name}" style="width: 300px"></td>
				</tr>
				<tr>
					<td>手机号：</td>
					<td><input class="easyui-textbox" id="us_shojihao"
						value="${user.us_shojihao}" style="width: 300px"></td>
				</tr>
				<tr>
					<td>邮箱：</td>
					<td><input class="easyui-textbox" id="us_youxiang"
						value="${user.us_youxiang}" style="width: 300px"></td>
				</tr>
				<tr>
					<td>是否锁定：</td>
					<td><input class="easyui-textbox" id="us_issuoding"
						disabled="disabled" value="${user.us_issuoding==2 ? '未锁定':'锁定'}"
						style="width: 300px"></td>
				</tr>
				<tr>
					<td>锁定时间：</td>
					<td><input class="easyui-textbox" id="us_suodingtime"
						disabled="disabled" value="${user.us_suodingtime}"
						style="width: 300px"></td>
				</tr>
				<tr>
					<td>密码错误次数：</td>
					<td><input class="easyui-textbox" id="us_passcuowucishu"
						disabled="disabled" value="${user.us_passcuowucishu}"
						style="width: 300px"></td>
				</tr>
				<tr>
					<td>账户创建时间：</td>
					<td><input class="easyui-textbox" id="us_chuangjiantime"
						disabled="disabled" value="${user.us_chuangjiantime}"
						style="width: 300px"></td>
				</tr>
				<tr>
					<td>最后登陆时间：</td>
					<td><input class="easyui-textbox" id="us_zuihoutime"
						disabled="disabled" value="${user.us_zuihoutime}"
						style="width: 300px"></td>
				</tr>
				<tr>
					<td>权重：</td>
					<td><input class="easyui-textbox" id="us_quanzhong"
						disabled="disabled" value="${user.us_quanzhong}"
						style="width: 300px"></td>
				</tr>
				<tr>
					<td>评分：</td>
					<td><input class="easyui-textbox" id="us_pingfen"
						disabled="disabled" value="${user.us_pingfen}"
						style="width: 300px"></td>
				</tr>
				<tr>
					<td>评分人数：</td>
					<td><input class="easyui-textbox" id="us_pingfenrenshu"
						disabled="disabled" value="${user.us_pingfenrenshu}"
						style="width: 300px"></td>
				</tr>
				<tr>
					<td>是否签到：</td>
					<td><input class="easyui-textbox" id="us_isdaka"
						disabled="disabled" value="${user.us_isdaka==2 ? '未签到':'已签到'}"
						style="width: 300px"></td>
				</tr>
				<tr>
					<td>签到时间：</td>
					<td><input class="easyui-textbox" id="us_dakatime"
						disabled="disabled" value="${user.us_dakatime}"
						style="width: 300px"></td>
				</tr>
				<tr>
					<td>备注：</td>
					<td><input class="easyui-textbox" id="us_biezhu"
						value="${user.us_biezhu}" style="width: 300px"></td>
				</tr>
			</table>
			<a style="margin-left: 120px; margin-top: 10px" id="btn"
				href="javascript:vodi(0)" onclick="baocun_xinxi()"
				class="easyui-linkbutton" data-options="iconCls:'icon-save'">保存信息</a>
			<a style="margin-left: 10px; margin-top: 10px" id="btn"
				href="javascript:vodi(0)" onclick="dk_xgmm()"
				class="easyui-linkbutton">修改密码</a>
		</form>
	</div>
	<div id="xgmm_win" class="easyui-window" title="修改密码"
		style="width: 450px; height: 250px"
		data-options="iconCls:'icon-save',modal:true">

		<form id="xgmm_form">
			<table>
				<tr>
					<td>原密码：</td>
					<td><input class="easyui-textbox" data-options="required:true" type="password"
						id="us_yan_pas" value="" style="width: 300px"></td>
				</tr>
				<tr>
					<td>新密码：</td>
					<td><input class="easyui-textbox" data-options="required:true" validType="length['3','20']"
						type="password" name="us_xin_pas1" id="us_xin_pas1"
						 value="" style="width: 300px"></td>
				</tr>
				<tr>
					<td>重复新密码：</td>
					<td><input class="easyui-textbox" data-options="required:true" type="password"
						name="us_xin_pas2" id="us_xin_pas2" value=""
						validType="equals['us_xin_pas1']" style="width: 300px"></td>
				</tr>
				<tr>
					<td>手机验证码：</td>
					<td><input class="easyui-textbox" data-options="required:true" id="us_sj_yzm"
						 value="" validType="length['6','6']"
						style="width: 300px"></td>
				</tr>
				<tr>
					<td colspan="2"><a
						style="margin-left: 130px; margin-top: 10px" id="xgmm_btn"
						href="javascript:vodi(0)" onclick="shoujiyanzhengma()"
						class="easyui-linkbutton"> 获取手机验证码 </a></td>
				</tr>
			</table>
<a style="margin-left: 155px; margin-top: 10px" id="xgmm_btn"
				href="javascript:vodi(0)" onclick="xiugai_mima()"
				class="easyui-linkbutton" data-options="iconCls:'icon-save'"> 保存 </a>
		</form>

	</div>
</body>
<script type="text/javascript">
$(function(){
	$('#xgmm_win').window('close');
})
	function baocun_xinxi() {
		$.post("updateUser_ygxx", {
			us_id : $("#us_id").val(),
			us_name : $("#us_name").val(),
			us_shojihao : $("#us_shojihao").val(),
			us_youxiang : $("#us_youxiang").val(),
			us_biezhu : $("#us_biezhu").val()

		}, function(res) {
			if (res == 1) {
				$.messager.show({
					title : '我的消息',
					msg : '保存成功',
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
					msg : '保存失败',
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
	function dk_xgmm(){
		$('#xgmm_win').window('open');
	}
	function xiugai_mima() {
		if ($("#xgmm_form").form('validate')) {
			$.post("updateUser_password", {
				us_yan_pas : $("#us_yan_pas").val(),
				us_xin_pas2 : $("#us_xin_pas2").val(),
				yanzhengma : $("#us_sj_yzm").val()
			}, function(res) {
				if (res == 1) {
					$('#xgmm_win').window('close');
					$.messager.show({
						title : '我的消息',
						msg : '修改密码成功',
						timeout : 1000,
						showType : 'slide',
						style : {
							top : document.body.scrollTop
									+ document.documentElement.scrollTop,
						}
					});
					history.go(0);
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
				} else if (res == 4) {
					$.messager.show({
						title : '我的消息',
						msg : '旧密码错误',
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
						msg : '修改密码失败',
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
				msg : '对不起，你输入的信息不符合格式！',
				timeout : 1000,
				showType : 'slide',
				style : {
					top : document.body.scrollTop
							+ document.documentElement.scrollTop,
				}
			});
		}

	}

	function shoujiyanzhengma() {
		$.post("shoujihaoyanzheng", {}, function(res) {
			if (res == 1) {
				$.messager.show({
					title : '我的消息',
					msg : '对不起，你未绑定手机号！',
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
					msg : '手机号不符合格式',
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
	}
</script>
</html>