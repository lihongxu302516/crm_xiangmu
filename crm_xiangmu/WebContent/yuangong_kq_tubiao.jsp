<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>考勤统计</title>
<script src="js/gonggong.js" type="text/javascript" charset="utf-8"></script>
<script src="http://echarts.baidu.com/build/dist/echarts-all.js"></script>
</head>
<body>
	<div id="quanbu_bing" style="height: 400px;"></div>
	<div id="benyue_bing" style="height: 400px;"></div>
	<div id="jingri_bing" style="height: 400px;"></div>
</body>
<script type="text/javascript">
	$.post("yuangong_kq_tubiao_bingtu", {}, function(res) {
		// 基于准备好的dom，初始化echarts图表
		var quanbu_bing = echarts.init(document.getElementById('quanbu_bing'));
		var benyue_bing = echarts.init(document.getElementById('benyue_bing'));
		var jingri_bing = echarts.init(document.getElementById('jingri_bing'));
		
		var quanbu_bing_option = bing(res[0],"全部统计");
		var benyue_bing_option = bing(res[1],"本月统计");
		var jingri_bing_option = bing(res[2],"今日统计");

		quanbu_bing.setOption(quanbu_bing_option);
		benyue_bing.setOption(benyue_bing_option);
		jingri_bing.setOption(jingri_bing_option);

	}, "json");

	function bing(shuju,biaoti) {
		var option = {
			title : {
				text : biaoti,
				x : 'center'
			},
			tooltip : {
				trigger : 'item',
				formatter : "{a} <br/>{b} : {c} ({d}%)"
			},
			legend : {
				orient : 'vertical',
				x : 'left',
				data : shuju.list
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
						type : [ 'pie', 'funnel' ],
						option : {
							funnel : {
								x : '25%',
								width : '50%',
								funnelAlign : 'left',
								max : 1548
							}
						}
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
			series : [ {
				name : '统计内容',
				type : 'pie',
				radius : '55%',
				center : [ '50%', '60%' ],
				data : shuju.bing
			} ]
		};
		return option;
	}
</script>
</html>