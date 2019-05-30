<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>跟踪统计</title>
<script src="js/gonggong.js" type="text/javascript" charset="utf-8"></script>
<script src="http://echarts.baidu.com/build/dist/echarts-all.js"></script>
</head>
<body>
	<div id="gzcs" style="height: 400px"></div>
</body>
<script type="text/javascript">
	$.post("yuangong_genzongcishu", {}, function(res) {
		// 基于准备好的dom，初始化echarts图表
		var myChart = echarts.init(document.getElementById('gzcs'));

		var option = {
			title : {
				text : '员工对客户每月的跟踪次数'
			},
			tooltip : {
				trigger : 'axis'
			},
			legend : {
				data : [ '跟踪次数' ]
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
				data : res.name
			} ],
			yAxis : [ {
				type : 'value'
			} ],
			series : [ {
				name : '跟踪次数次数',
				type : 'bar',
				data : res.cs,
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
	}, "json");
</script>
</html>