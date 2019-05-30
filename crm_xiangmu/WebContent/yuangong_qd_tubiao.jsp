<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>员工签到图</title>
<script src="js/gonggong.js" type="text/javascript" charset="utf-8"></script>
<script src="http://echarts.baidu.com/build/dist/echarts-all.js"></script>
</head>
<body>
	<div id="ygqdt" style="height: 400px"></div>
</body>
<script type="text/javascript">
	$.post("yuangong_qd_cd_wq_cishutongji",{},function(res){
		// 基于准备好的dom，初始化echarts图表
		var myChart = echarts.init(document.getElementById('ygqdt'));

		var option = {
			title : {
				text : '员工的签到次数，迟到次数，未签次数，请假次数'
			},
			tooltip : {
				trigger : 'axis'
			},
			legend : {
				data : [ '签到次数', '迟到次数' , '未签次数', '请假次数']
			},
			toolbox : {
				show : true,
				feature : {
					mark : {
						show : true
					},
					dataView : {
						show : true,
						readOnly : false
					},
					magicType : {
						show : true,
						type : [ 'line', 'bar' ]
					},
					restore : {
						show : true
					},
					saveAsImage : {
						show : true
					}
				}
			},
			calculable : true,
			xAxis : [ {
				type : 'category',
				data : res.us_name
			} ],
			yAxis : [ {
				type : 'value'
			} ],
			series : [
					{
						name : '签到次数',
						type : 'bar',
						data : res.qd_cs,
						markLine : {
							data : [ {
								type : 'average',
								name : '平均值'
							} ]
						}
					},
					{
						name : '迟到次数',
						type : 'bar',
						data : res.cd_cs,
						markLine : {
							data : [ {
								type : 'average',
								name : '平均值'
							} ]
						}
					},
					{
						name : '未签次数',
						type : 'bar',
						data : res.wq_cs,
						markLine : {
							data : [ {
								type : 'average',
								name : '平均值'
							} ]
						}
					},
					{
						name : '请假次数',
						type : 'bar',
						data : res.qj_cs,
						markLine : {
							data : [ {
								type : 'average',
								name : '平均值'
							} ]
						}
					} ]
		};

		// 为echarts对象加载数据 
		myChart.setOption(option);
	},"json");
	
</script>
</html>