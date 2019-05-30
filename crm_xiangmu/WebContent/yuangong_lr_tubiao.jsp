<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>录入统计</title>
<script src="js/gonggong.js" type="text/javascript" charset="utf-8"></script>
<script src="http://echarts.baidu.com/build/dist/echarts-all.js"></script>
</head>
<body>
	<div id="lrtj" style="height: 400px"></div>
</body>
<script type="text/javascript">
	$.post("selectStudent_tianjia_shuliang_map", {}, function(res) {
		// 基于准备好的dom，初始化echarts图表
		var myChart = echarts.init(document.getElementById('lrtj'));

		var option = {
				title : {
					text : '每日录入学生数量',
					subtext:'未显示的日期录入次数为零'
				},
			    tooltip : {
			        trigger: 'axis'
			    },
			    legend: {
			        data:['录入次数']
			    },
			    toolbox: {
			        show : true,
			        feature : {
			            mark : {show: true},
			            dataView : {show: true, readOnly: false},
			            magicType : {show: true, type: ['line', 'bar', 'stack', 'tiled']},
			            restore : {show: true},
			            saveAsImage : {show: true}
			        }
			    },
			    calculable : true,
			    xAxis : [
			        {
			            type : 'category',
			            boundaryGap : false,
			            data : res.sj
			        }
			    ],
			    yAxis : [
			        {
			            type : 'value'
			        }
			    ],
			    series : [
			        {
			            name:'录入次数',
			            type:'line',
			            stack: '次数',
			            data:res.cs
			        }
			    ]
			};
			                    
		// 为echarts对象加载数据 
		myChart.setOption(option);
	}, "json");
</script>
</html>