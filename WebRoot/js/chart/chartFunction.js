/**
* Draw chart
* Contains 2D and 3D drawing functions
* author Sunly
**/
var chartMethod = (function(){
		//--------------BEGIN PUBLIC METHODS----------------------
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
	 * 		subtext    : "this is the chart's subtext"
	 * }
	**/
	function drawPieChart(data,ConfigObj){
		if (!ConfigObj.text) {
			ConfigObj.text = "this is title";
		}
		if (!ConfigObj.subtext) {
			ConfigObj.subtext = "subtext";
		}
		if (!ConfigObj.slicePoint) {
			ConfigObj.slicePoint = 10;
		}
        var slicePoint  =ConfigObj.slicePoint;
        var topTenName = (data.name.length>slicePoint)?data.name.slice(0,slicePoint):data.name;
        var topTenCount = (data.count.length>slicePoint)?data.count.slice(0,slicePoint):data.count;
        var otherName = "others";
        var otherCount = 0;
        for (var i = slicePoint; i < data.count.length; i++) {
            otherCount += data.count[i];
        }
        // 注意 concat是不能改变现有数组的  
        topTenName = topTenName.concat(otherName);
        topTenCount = topTenCount.concat(otherCount);
        var countryCount = [];
        for ( i = 0; i < topTenName.length; i++) {
            var perCountryCount = {};
            perCountryCount.name = topTenName[i];
            perCountryCount.value = topTenCount[i];
            countryCount[i] = perCountryCount;
        }

        var option = {
        title : {
            text: ConfigObj.text,
            subtext: ConfigObj.subtext,
            x:'center'
        },
        tooltip : {
            trigger: 'item',
            formatter: "{a} <br/>{b} : {c} ({d}%)"
        },
        legend: {
            orient: 'vertical',
            left: 'left',
            data: topTenName
        },
        series : [
            {
                name: 'nameCount',
                type: 'pie',
                radius : '55%',
                center: ['50%', '60%'],
                data:countryCount,
                itemStyle: {
                    emphasis: {
                        shadowBlur: 10,
                        shadowOffsetX: 0,
                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                    }
                }
            }
        ]
    	};
    	return option;
	}
	/**
	 * 绘制直方图和折线图，针对专利数量做统计
	 * 传入参数： 
	 * 		filepath: 数据获取路径	
	 * 		elementId: 绘图所占元素
	 * 获取数据格式：
	 * data = {
	 * 		"name" :["name1","name2","name3"],
	 * 		"count":["count1","count2","count3"]
	 * }
	 * ConfigObj = {
		title: "示例标题",
		XAxis: "",
		YAxis: "",
	 }
	**/
	function drawHistogram(data,ConfigObj){
		if (!ConfigObj.title) {
			ConfigObj.title = "示例标题";
		}
		if (!ConfigObj.XAxis) {
			ConfigObj.XAxis = "Patent Number";
		}
		if (!ConfigObj.YAxis) {
			ConfigObj.YAxis = "patentNum";
		}
        var option = {
        	title: {
                    text: ConfigObj.title,
                    textAlign: "left",
                    textBaseline: "middle",
                    padding: [5,10,5,10,],
                    left: "2%",
                    top: "2%"
                },
            tooltip : {
                trigger: 'item'
            },
            toolbox: {
                show : true,
                feature : {
                    mark : {show: true},
                    dataView : {show: true, readOnly: false},
                    magicType: {show: true, type: ['line', 'bar']},
                    restore : {show: true},
                    saveAsImage : {show: true}
                }
            },
            calculable : true,
            legend: {
                data:[ConfigObj.XAxis],
                itemGap: 5
            },
            grid: {
                top: '20%',
                left: '1%',
                right: '10%',
                containLabel: true
            },
            xAxis: [
                {
                    type : 'category',
                    data : data.name
                }
            ],
            yAxis: [
                {
                    type : 'value',
                    name : ConfigObj.YAxis
                }
            ],
            dataZoom: [
                {
                    show: true,
                    start: 0,
                    end: 100
                },
                {
                    type: 'inside',
                    start: 0,
                    end: 100
                },
                {
                    show: true,
                    yAxisIndex: 0,
                    filterMode: 'empty',
                    width: 30,
                    height: '80%',
                    showDataShadow: false,
                    left: '96%'
                }
            ],
            series : [
                {
                    name: ConfigObj.XAxis,
                    type: 'bar',
                    data: data.count
                }]
        };
        return option;
	}

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
	function drawLifeCycle(data,ConfigObj){
	    var option = {
	        title: {
	            show: true,
	            text: "LCD技术生命周期分析"
	        },
	        grid: {
	            left: 0,
	            bottom: 0,
	            containLabel: true,
	            top: 80
	        },
	        xAxis: {
	            name: "申请人",
	            type: 'value'
	        },
	        yAxis: {
	            name: "申请量",
	            type: 'value',
	            scale: true
	        },
	        toolbox: {
	            feature: {
	                dataZoom: {}
	            }
	        },
	        dataZoom: {
	            type: 'inside'
	        },
	        series: []
	    };

        var series = data.series;
        data = series.map(function (yearData) {
                return {
                    name: yearData[2],
                    value: yearData
                };
            });
        var links = data.map(function (item, idx) {
            return {
                source: idx,
                target: idx + 1
            };
        });
        links.pop();
        option.series.push({
            name: "china",
            type: 'graph',
            coordinateSystem: 'cartesian2d',
            data: data,
            links: links,
            edgeSymbol: ['none', 'arrow'],
            edgeSymbolSize: 5,
            legendHoverLink: false,
            lineStyle: {
                normal: {
                    color: '#333'
                }
            },
            itemStyle: {
                normal: {
                    borderWidth: 1,
                    borderColor: '#333'
                }
            },
            label: {
                normal: {
                    textStyle: {
                        color: '#333'
                    },
                    position: 'right'
                }
            },
            symbolSize: 10,
            animationDelay: function (idx) {
                return idx * 100;
            }
        });
        return option;
	}

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
	function drawRegionalDistribution(data,ConfigObj){
		if (!ConfigObj.text) {
			ConfigObj.text = "1976年到2016年专利申请量地域分布图";
		}
		if(!ConfigObj.subtext){
			ConfigObj.subtext = "详情请参考 中国统计网统计网"; 
		}
		if (!ConfigObj.legend) {
			ConfigObj.legend = "assignName";
		}
		console.log("text");
	    console.log(ConfigObj.text);
	    var countryPaperCount = data.keyValueMap;

	    var convertData = function (_data) {
	        var res = [];
	        for (var i = 0; i < countryMap.length; i++) {
	            var key = countryMap[i].name;
	            var coordinate = [countryMap[i].longitude,countryMap[i].latitude,countryMap[i].EnglishName];
	            try{
	                res.push({
	                    name: key,
	                    value: coordinate.concat(_data[key])
	                });
	            }catch(e){

	            }           
	        }
	        return res;
	    };

	    var option = {
	    	backgroundColor: '#fff',
	        title: {
	            text: ConfigObj.text,
	            //subtext: ConfigObj.subtext,
	            // sublink: 'http://www.pm25.in',
	            top: '0',
	            left: 'center',
	            textStyle: {
	                color: '#111'
	            }
	        },
	        tooltip : {
	            trigger: 'item'
	        },
	        legend: {
	            // orient: 'vertical',
	            y: 'bottom',
	            x:'right',
	            data:['country',ConfigObj.legend],
	            textStyle: {
	                color: '#111'
	            }
	        },
	        geo: {
	            map: 'world',
	            label: {
	                emphasis: {
	                    show: false
	                }
	            },
	            roam: true,
	            itemStyle: {
	                normal: {
	                    areaColor: '#323c45',
	                    borderColor: '#111'
	                },
	                emphasis: {
	                    areaColor: '#2a333d'
	                }
	            }
	        },
	        series : [
	            {
	                name: ConfigObj.legend,
	                type: 'scatter',
	                radius: [0, '30%'],
	                center: ['75%', '75%'],
	                coordinateSystem: 'geo',
	                data: convertData(countryPaperCount),
	                symbolSize: function (val) {
	                    return val[3]/700+6;
	                },
	                label: {
	                    normal: {
	                        formatter: '{b}',
	                        position: 'right',
	                        show: false
	                    },
	                    emphasis: {
	                        show: true
	                    }
	                },
	                itemStyle: {
	                    normal: {
	                        color: '#ddb926'
	                    }
	                }
	            },
	            {
	                name: ConfigObj.legend,
	                type: 'effectScatter',
	                coordinateSystem: 'geo',
	                radius: [0, '30%'],
	                center: ['75%', '75%'],
	                data: convertData(countryPaperCount).sort(function (a, b) {
	                    var first = a.value[3];
	                    var second = b.value[3];
	                    return second - first;
	                }).slice(0, 11),
	                symbolSize: function (val) {
	                    return val[3]/700+6;
	                },
	                showEffectOn: 'render',
	                rippleEffect: {
	                    brushType: 'stroke'
	                },
	                hoverAnimation: true,
	                label: {
	                    normal: {
	                        formatter: '{b}',
	                        position: 'right',
	                        show: true
	                    }
	                },
	                itemStyle: {
	                    normal: {
	                        color: '#f4e925',
	                        shadowBlur: 10,
	                        shadowColor: '#333'
	                    }
	                },
	                zlevel: 1
	            }
	        ]
	    };
	    return option;
	}
	/**
	* 绘制三维折线图
	**/
	function draw3DHistogram (data,ConfigObj){
		if (!ConfigObj.title) {
			ConfigObj.title = "示例标题";
		}
		if (!ConfigObj.slicePoint) {
			ConfigObj.slicePoint = 10;
		}
		var slicePoint = ConfigObj.slicePoint ;
		var name = (data.name.length>slicePoint)?data.name.slice(0,slicePoint):data.name;
        option = {
        	title:{
        		text: ConfigObj.title,
        		top: "2%"
        	},
            tooltip : {
                trigger: 'item'
            },
            toolbox: {
                show : true,
                feature : {
                    mark : {show: true},
                    magicType: {show: true, type: ['line', 'bar']},
                    saveAsImage : {show: true}
                }
            },
            calculable : true,
            legend: {
            	top: "10%",
                data:['Country'].concat(name),
                itemGap: 5
            },
            grid: {
                top: '25%',
                left: '2%',
                right: '10%',
                containLabel: true
            },
            xAxis: [
                {
                    type : 'category',
                    data : data.year
                }
            ],
            yAxis: [
                {
                    type : 'value',
                    name : 'patentNum'
                }
            ],
            dataZoom: [
                {
                    show: true,
                    start: 60,
                    end: 100
                },
                {
                    type: 'inside',
                    start: 94,
                    end: 100
                },
                {
                    show: true,
                    yAxisIndex: 0,
                    filterMode: 'empty',
                    width: 30,
                    height: '80%',
                    showDataShadow: false,
                    left: '93%'
                }
            ],
            series : []
        };
        var seriesList = new Array();
        
        for(var i=0;i<name.length;i++){
        	seriesList.push({
        		name: name[i],
                type: 'bar',
                data: data.series[name[i]]
            }) ;
        }
        option.series = seriesList;
        return option;
	}	
		//--------------END PUBLIC METHODS----------------------
	return {
		drawPieChart: drawPieChart,
		drawHistogram : drawHistogram,
		drawLifeCycle : drawLifeCycle,
		drawRegionalDistribution: drawRegionalDistribution,
		draw3DHistogram: draw3DHistogram
	};
})();


