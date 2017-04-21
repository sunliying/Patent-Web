/**
* 主要用于用户传入数据然后进行图形绘制方法
**/

var autoChart = (function(){
	/**
	* 传入参数： 
	*		type     : 选择绘图类型
	* 		filepath : 数据获取路径	
	* 		elementId: 绘图所占元素
	*		ConfigObj：根据不同的图有不同的配置要求
	**/
	function drawChart(type,elementId,data,ConfigObj){
		var myChart = echarts.init(document.getElementById(elementId));
		
		try{
			data=eval('('+data+')');
		}catch(e){
			console.log(elementId);
			$("#"+elementId).text("数据输入格式错误，请确认格式后重新输入！");
			$("#"+elementId).css("font-size","24");
			return false;
		}

        var option;

		switch (type){
			case "pie" : 
				option = chartMethod.drawPieChart(data,ConfigObj);
				break;
			case "histogram" :
				option = chartMethod.drawHistogram(data,ConfigObj);
				break;
			case "lifeCycle" :
				option = chartMethod.drawLifeCycle(data,ConfigObj);
				break;
			case "RegionalDistribution" :
				option = chartMethod.drawRegionalDistribution(data,ConfigObj);
				break;
			case "3DHistogram":
				option = chartMethod.draw3DHistogram(data,ConfigObj);
				break;
			default:

		}

		myChart.setOption(option);
		return false;
	}

	return {
		drawChart : drawChart
	};
})();