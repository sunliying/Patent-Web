/**
* 主要用于调用响应的图形绘制方法
* 根据基础数据调用数据处理函数进行数据的处理
* 介绍绘制不同图形需要的数据格式以及参数设置
**/

var callChart = (function(){
	/**
	* 传入参数： 
	*		type     : 选择绘图类型
	* 		filepath : 数据获取路径	
	* 		elementId: 绘图所占元素
	*		ConfigObj：根据不同的图有不同的配置要求
	**/
	function drawChart(type,elementId,filePath,ConfigObj){
		var myChart = echarts.init(document.getElementById(elementId));
	    myChart.showLoading();
	    $.getJSON(filePath, function (data) {
	        myChart.hideLoading();
	        var prsdData;
	        var option;

			switch (type){
				/**
				 * 绘制饼图
				 * 获取数据格式：
				 * data = {
				 * 		"name" :["name1","name2","name3"],
				 * 		"count":["count1","count2","count3"]
				 * }
				 * ConfigObj 是一个javaScript对象:
				 * var ConfigObj = {
				 * 		slicePoint : 10,
				 * 		text       : "this is the chart's title",
				 * 		subject    : "this is the chart's subtext"
				 * }
				**/
				case "pie" : 
					prsdData = data;
					option = chartMethod.drawPieChart(prsdData,ConfigObj);
					break;
				/**
				 * 绘制直方图和折线图，针对专利数量做统计
				 * 获取数据格式：
				 * data = {
				 * 		"name" :["name1","name2","name3"],
				 * 		"count":["count1","count2","count3"]
				 * }
				**/
				case "histogram" :
					prsdData = data;
					option = chartMethod.drawHistogram(prsdData,ConfigObj);
					break;
				case "dateCumulateHistogram":
					prsdData = chartUtil.cumulateData(data);
					option = chartMethod.drawHistogram(prsdData,ConfigObj);
					break;
				case "dateRateHistogram":
					prsdData = chartUtil.rateData(data);
					option = chartMethod.drawHistogram(prsdData,ConfigObj);
					break;
				case "name3D":
				case "country3D":
				case "subject3D": 
				case "3DHistogram":
					prsdData = data;
					option = chartMethod.draw3DHistogram(prsdData,ConfigObj);
					break;
				/**
				* 绘制技术生命周期图
				* 传入参数： ConfigObj = {
				*		"text" : "LCD技术生命周期图",
				*		"xName": "申请人",
				*       "yName": "申请量"
				*	}
				* 数据格式： XCount,YCount,Year
				*	data = {
						"series": [
							[815, 34.05, 1800],
							[834, 34.05, 1810],
							[853, 34.05, 1820],
							[1399, 34.05, 1830],
							[2269, 34.05, 1840],
							[3267, 34.05, 1850],
							[4795, 34.05, 1860]
						]
				*	}
				*/
				case "lifeCycle" :
					prsdData = data;
					option = chartMethod.drawLifeCycle(prsdData,ConfigObj);
					break;
				/**
				* 绘制地域分布图
				* 传入参数： ConfigObj = {
				*		"text" : "1976年到2016年专利申请量地域分布图",
				*		"subtest": "详情请参考 中国统计网统计网",
				*       "legend": "assignName"
				*	}
				* 数据格式： 
				*	{
						"keyValueMap": {
							"JP": 8664,
							...
							"KR": 2071
						}
					}
				**/
				case "RegionalDistribution" :
					console.log(data);
					prsdData = data;
					option = chartMethod.drawRegionalDistribution(prsdData,ConfigObj);
					break;
				default:

			}

		myChart.setOption(option);

	    });
	}

	return {
		drawChart : drawChart
	};
})();