
	$(function(){
	var chart = echarts.init(document.getElementById('applicantCountry'));
	var countryMap = [{
	  name: "HK",
	  longitude: 114.109497,
	  latitude: 22.396428,
	  nameAb: "HK",
	  chineseName: "中国香港特别行政区",
	  EnglishName: "Hong Kong SAR China"
	}, {
	  name: "LU",
	  longitude: 6.129583,
	  latitude: 49.815273,
	  nameAb: "LU",
	  chineseName: "卢森堡",
	  EnglishName: "Luxembourg"
	}, {
	  name: "ZA",
	  longitude: 22.937506,
	  latitude: -30.559482,
	  nameAb: "ZA",
	  chineseName: "南非",
	  EnglishName: "South Africa"
	}, {
	  name: "VN",
	  longitude: 108.277199,
	  latitude: 14.058324,
	  nameAb: "VN",
	  chineseName: "越南",
	  EnglishName: "Vietnam"
	}, {
	  name: "DT",
	  longitude: null,
	  latitude: null,
	  nameAb: null,
	  chineseName: null,
	  EnglishName: null
	}, {
	  name: "RO",
	  longitude: 24.96676,
	  latitude: 45.943161,
	  nameAb: "RO",
	  chineseName: "罗马尼亚",
	  EnglishName: "Romania"
	}, {
	  name: "HU",
	  longitude: 19.503304,
	  latitude: 47.162494,
	  nameAb: "HU",
	  chineseName: "匈牙利",
	  EnglishName: "Hungary"
	}, {
	  name: "ID",
	  longitude: 113.921327,
	  latitude: -0.789275,
	  nameAb: "ID",
	  chineseName: "印度尼西亚",
	  EnglishName: "Indonesia"
	}, {
	  name: "DE",
	  longitude: 10.451526,
	  latitude: 51.165691,
	  nameAb: "DE",
	  chineseName: "德国",
	  EnglishName: "Germany"
	}, {
	  name: "MC",
	  longitude: 7.412841,
	  latitude: 43.750298,
	  nameAb: "MC",
	  chineseName: "摩纳哥",
	  EnglishName: "Monaco"
	}, {
	  name: "DK",
	  longitude: 9.501785,
	  latitude: 56.26392,
	  nameAb: "DK",
	  chineseName: "丹麦",
	  EnglishName: "Denmark"
	}, {
	  name: "IE",
	  longitude: -8.24389,
	  latitude: 53.41291,
	  nameAb: "IE",
	  chineseName: "爱尔兰",
	  EnglishName: "Ireland"
	}, {
	  name: "AT",
	  longitude: 14.550072,
	  latitude: 47.516231,
	  nameAb: "AT",
	  chineseName: "奥地利",
	  EnglishName: "Austria"
	}, {
	  name: "AR",
	  longitude: -63.616672,
	  latitude: -38.416097,
	  nameAb: "AR",
	  chineseName: "阿根廷",
	  EnglishName: "Argentina"
	}, {
	  name: "US",
	  longitude: -95.712891,
	  latitude: 37.09024,
	  nameAb: "US",
	  chineseName: "美国",
	  EnglishName: "United States"
	}, {
	  name: "MX",
	  longitude: -102.552784,
	  latitude: 23.634501,
	  nameAb: "MX",
	  chineseName: "墨西哥",
	  EnglishName: "Mexico"
	}, {
	  name: "IL",
	  longitude: 34.851612,
	  latitude: 31.046051,
	  nameAb: "IL",
	  chineseName: "以色列",
	  EnglishName: "Israel"
	}, {
	  name: "MY",
	  longitude: 101.975766,
	  latitude: 4.210484,
	  nameAb: "MY",
	  chineseName: "马来西亚",
	  EnglishName: "Malaysia"
	}, {
	  name: "IN",
	  longitude: 78.96288,
	  latitude: 20.593684,
	  nameAb: "IN",
	  chineseName: "印度",
	  EnglishName: "India"
	}, {
	  name: "AU",
	  longitude: 133.775136,
	  latitude: -25.274398,
	  nameAb: "AU",
	  chineseName: "澳大利亚",
	  EnglishName: "Australia"
	}, {
	  name: "MN",
	  longitude: 103.846656,
	  latitude: 46.862496,
	  nameAb: "MN",
	  chineseName: "蒙古",
	  EnglishName: "Mongolia"
	}, {
	  name: "IS",
	  longitude: -19.020835,
	  latitude: 64.963051,
	  nameAb: "IS",
	  chineseName: "冰岛",
	  EnglishName: "Iceland"
	}, {
	  name: "IT",
	  longitude: 12.56738,
	  latitude: 41.87194,
	  nameAb: "IT",
	  chineseName: "意大利",
	  EnglishName: "Italy"
	}, {
	  name: "MO",
	  longitude: 113.543873,
	  latitude: 22.198745,
	  nameAb: "MO",
	  chineseName: "中国澳门特别行政区",
	  EnglishName: "Macau SAR China"
	}, {
	  name: "BA",
	  longitude: 17.679076,
	  latitude: 43.915886,
	  nameAb: "BA",
	  chineseName: "波斯尼亚和黑塞哥维那",
	  EnglishName: "Bosnia & Herzegovina"
	}, {
	  name: "PT",
	  longitude: -8.224454,
	  latitude: 39.399872,
	  nameAb: "PT",
	  chineseName: "葡萄牙",
	  EnglishName: "Portugal"
	}, {
	  name: "ES",
	  longitude: -3.74922,
	  latitude: 40.463667,
	  nameAb: "ES",
	  chineseName: "西班牙",
	  EnglishName: "Spain"
	}, {
	  name: "JA",
	  longitude: null,
	  latitude: null,
	  nameAb: null,
	  chineseName: null,
	  EnglishName: null
	}, {
	  name: "NL",
	  longitude: 5.291266,
	  latitude: 52.132633,
	  nameAb: "NL",
	  chineseName: "荷兰",
	  EnglishName: "Netherlands"
	}, {
	  name: "EG",
	  longitude: 30.802498,
	  latitude: 26.820553,
	  nameAb: "EG",
	  chineseName: "埃及",
	  EnglishName: "Egypt"
	}, {
	  name: "TW",
	  longitude: 120.960515,
	  latitude: 23.69781,
	  nameAb: "TW",
	  chineseName: "台湾",
	  EnglishName: "Taiwan"
	}, {
	  name: "JP",
	  longitude: 138.252924,
	  latitude: 36.204824,
	  nameAb: "JP",
	  chineseName: "日本",
	  EnglishName: "Japan"
	}, {
	  name: "NZ",
	  longitude: 174.885971,
	  latitude: -40.900557,
	  nameAb: "NZ",
	  chineseName: "新西兰",
	  EnglishName: "New Zealand"
	}, {
	  name: "JM",
	  longitude: -77.297508,
	  latitude: 18.109581,
	  nameAb: "JM",
	  chineseName: "牙买加",
	  EnglishName: "Jamaica"
	}, {
	  name: "BR",
	  longitude: -51.92528,
	  latitude: -14.235004,
	  nameAb: "BR",
	  chineseName: "巴西",
	  EnglishName: "Brazil"
	}, {
	  name: "TH",
	  longitude: 100.992541,
	  latitude: 15.870032,
	  nameAb: "TH",
	  chineseName: "泰国",
	  EnglishName: "Thailand"
	}, {
	  name: "GB",
	  longitude: -3.435973,
	  latitude: 55.378051,
	  nameAb: "GB",
	  chineseName: "英国",
	  EnglishName: "United Kingdom"
	}, {
	  name: "TN",
	  longitude: 9.537499,
	  latitude: 33.886917,
	  nameAb: "TN",
	  chineseName: "突尼斯",
	  EnglishName: "Tunisia"
	}, {
	  name: "CA",
	  longitude: -106.346771,
	  latitude: 56.130366,
	  nameAb: "CA",
	  chineseName: "加拿大",
	  EnglishName: "Canada"
	}, {
	  name: "TR",
	  longitude: 35.243322,
	  latitude: 38.963745,
	  nameAb: "TR",
	  chineseName: "土耳其",
	  EnglishName: "Turkey"
	}, {
	  name: "NO",
	  longitude: 8.468946,
	  latitude: 60.472024,
	  nameAb: "NO",
	  chineseName: "挪威",
	  EnglishName: "Norway"
	}, {
	  name: "BF",
	  longitude: -1.561593,
	  latitude: 12.238333,
	  nameAb: "BF",
	  chineseName: "布基纳法索",
	  EnglishName: "Burkina Faso"
	}, {
	  name: "OM",
	  longitude: 55.923255,
	  latitude: 21.512583,
	  nameAb: "OM",
	  chineseName: "阿曼",
	  EnglishName: "Oman"
	}, {
	  name: "SU",
	  longitude: null,
	  latitude: null,
	  nameAb: null,
	  chineseName: null,
	  EnglishName: null
	}, {
	  name: "BG",
	  longitude: 25.48583,
	  latitude: 42.733883,
	  nameAb: "BG",
	  chineseName: "保加利亚",
	  EnglishName: "Bulgaria"
	}, {
	  name: "FR",
	  longitude: 2.213749,
	  latitude: 46.227638,
	  nameAb: "FR",
	  chineseName: "法国",
	  EnglishName: "France"
	}, {
	  name: "SW",
	  longitude: null,
	  latitude: null,
	  nameAb: null,
	  chineseName: null,
	  EnglishName: null
	}, {
	  name: "BE",
	  longitude: 4.469936,
	  latitude: 50.503887,
	  nameAb: "BE",
	  chineseName: "比利时",
	  EnglishName: "Belgium"
	}, {
	  name: "FI",
	  longitude: 25.748151,
	  latitude: 61.92411,
	  nameAb: "FI",
	  chineseName: "芬兰",
	  EnglishName: "Finland"
	}, {
	  name: "CZ",
	  longitude: 15.472962,
	  latitude: 49.817492,
	  nameAb: "CZ",
	  chineseName: "捷克共和国",
	  EnglishName: "Czech Republic"
	}, {
	  name: "KP",
	  longitude: 127.510093,
	  latitude: 40.339852,
	  nameAb: "KP",
	  chineseName: "朝鲜",
	  EnglishName: "North Korea"
	}, {
	  name: "KR",
	  longitude: 127.766922,
	  latitude: 35.907757,
	  nameAb: "KR",
	  chineseName: "韩国",
	  EnglishName: "South Korea"
	}, {
	  name: "SE",
	  longitude: 18.643501,
	  latitude: 60.128161,
	  nameAb: "SE",
	  chineseName: "瑞典",
	  EnglishName: "Sweden"
	}, {
	  name: "SG",
	  longitude: 103.819836,
	  latitude: 1.352083,
	  nameAb: "SG",
	  chineseName: "新加坡",
	  EnglishName: "Singapore"
	}, {
	  name: "SI",
	  longitude: 14.995463,
	  latitude: 46.151241,
	  nameAb: "SI",
	  chineseName: "斯洛文尼亚",
	  EnglishName: "Slovenia"
	}, {
	  name: "CS",
	  longitude: null,
	  latitude: null,
	  nameAb: null,
	  chineseName: null,
	  EnglishName: null
	}, {
	  name: "KW",
	  longitude: 47.481766,
	  latitude: 29.31166,
	  nameAb: "KW",
	  chineseName: "科威特",
	  EnglishName: "Kuwait"
	}, {
	  name: "KY",
	  longitude: -80.566956,
	  latitude: 19.513469,
	  nameAb: "KY",
	  chineseName: "开曼群岛",
	  EnglishName: "Cayman Islands"
	}, {
	  name: "PL",
	  longitude: 19.145136,
	  latitude: 51.919438,
	  nameAb: "PL",
	  chineseName: "波兰",
	  EnglishName: "Poland"
	}, {
	  name: "CH",
	  longitude: 8.227512,
	  latitude: 46.818188,
	  nameAb: "CH",
	  chineseName: "瑞士",
	  EnglishName: "Switzerland"
	}, {
	  name: "RU",
	  longitude: 105.318756,
	  latitude: 61.52401,
	  nameAb: "RU",
	  chineseName: "俄罗斯",
	  EnglishName: "Russia"
	}, {
	  name: "GR",
	  longitude: 21.824312,
	  latitude: 39.074208,
	  nameAb: "GR",
	  chineseName: "希腊",
	  EnglishName: "Greece"
	}, {
	  name: "PH",
	  longitude: 121.774017,
	  latitude: 12.879721,
	  nameAb: "PH",
	  chineseName: "菲律宾",
	  EnglishName: "Philippines"
	}, {
	  name: "LI",
	  longitude: 9.555373,
	  latitude: 47.166,
	  nameAb: "LI",
	  chineseName: "列支敦士登",
	  EnglishName: "Liechtenstein"
	}, {
	  name: "LK",
	  longitude: 80.771797,
	  latitude: 7.873054,
	  nameAb: "LK",
	  chineseName: "斯里兰卡",
	  EnglishName: "Sri Lanka"
	}, {
	  name: "CM",
	  longitude: 12.354722,
	  latitude: 7.369722,
	  nameAb: "CM",
	  chineseName: "喀麦隆",
	  EnglishName: "Cameroon"
	}, {
	  name: "CN",
	  longitude: 104.195397,
	  latitude: 35.86166,
	  nameAb: "CN",
	  chineseName: "中国",
	  EnglishName: "China"
	}, {
	  name: "SA",
	  longitude: 45.079162,
	  latitude: 23.885942,
	  nameAb: "SA",
	  chineseName: "沙特阿拉伯",
	  EnglishName: "Saudi Arabia"
	}, {
	  name: "CL",
	  longitude: -71.542969,
	  latitude: -35.675147,
	  nameAb: "CL",
	  chineseName: "智利",
	  EnglishName: "Chile"
	}];
    // 异步加载数据
    chart.showLoading();
    $.getJSON('./jsondata/applicant_countrykeyValueMap.json').done(function (data) {
    	$.getJSON('./jsondata/assignee_countrykeyValueMap.json').done(function (assignee_data) {
        chart.hideLoading();
        var countryPaperCount = data.keyValueMap;
        var assigneeCount = assignee_data.keyValueMap;

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

	option = {
	    backgroundColor: '#404a59',
	    title: {
	        text: '1972年~2016年专利申请国家分布',
	        subtext: '关于 applicant Country',
	        // sublink: 'http://www.pm25.in',
	        left: 'center',
	        textStyle: {
	            color: '#fff'
	        }
	    },
	    tooltip : {
	        trigger: 'item'
	    },
	    legend: {
	        // orient: 'vertical',
	        y: 'bottom',
	        x:'right',
	        data:['country',"applicantCount","assigneeCount"],
	        textStyle: {
	            color: '#fff'
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
	                areaColor: '#323c48',
	                borderColor: '#111'
	            },
	            emphasis: {
	                areaColor: '#2a333d'
	            }
	        }
	    },
	    series : [
	        {
	            name: 'applicantCount',
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
	            name: 'applicantCount',
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
	        },
	        {
	            name: 'assigneeCount',
	            type: 'scatter',
	            radius: [0, '30%'],
        		center: ['75%', '75%'],
	            coordinateSystem: 'geo',
	            data: convertData(assigneeCount),
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
	                    color: '#E40C75'
	                }
	            }
	        },
	        {
	            name: 'assigneeCount',
	            type: 'effectScatter',
	            coordinateSystem: 'geo',
	            radius: [0, '30%'],
        		center: ['75%', '75%'],
	            data: convertData(assigneeCount).sort(function (a, b) {
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
	                    color: '#F833D2',
	                    shadowBlur: 10,
	                    shadowColor: '#333'
	                }
	            },
	            zlevel: 1
	        }
	    ]
	};
	chart.setOption(option);
	});
 });
});
