$(function(){
	var myChart = echarts.init(document.getElementById('timeRegion'));
        myChart.showLoading();
        var country = ["JP", "US", "KR", "DE", "FR", "CA", "TW", "SE", "CN"];
        $.getJSON('./jsondata/application_dateassignee_country.json', function (applicationCountry) {
            myChart.hideLoading();

            option = {
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
                    data:['Country'].concat(country),
                    itemGap: 5
                },
                grid: {
                    top: '12%',
                    left: '2%',
                    right: '10%',
                    containLabel: true
                },
                xAxis: [
                    {
                        type : 'category',
                        data : applicationCountry.years
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
                series : [
                    {
                        name: country[0],
                        type: 'bar',
                        data: applicationCountry[country[0]]
                    },
                    {
                        name: country[1],
                        type: 'bar',
                        data: applicationCountry[country[1]]
                    },
                    {
                        name: country[2],
                        type: 'bar',
                        data: applicationCountry[country[2]]
                    },
                    {
                        name: country[3],
                        type: 'bar',
                        data: applicationCountry[country[3]]
                    },
                    {
                        name: country[4],
                        type: 'bar',
                        data: applicationCountry[country[4]]
                    },
                    {
                        name: country[5],
                        type: 'bar',
                        data: applicationCountry[country[5]]
                    },
                    {
                        name: country[6],
                        type: 'bar',
                        data: applicationCountry[country[6]]
                    },
                    {
                        name: country[7],
                        type: 'bar',
                        data: applicationCountry[country[7]]
                    },
                    {
                        name: country[8],
                        type: 'bar',
                        data: applicationCountry[country[8]]
                    }
                ]
            };

            myChart.setOption(option);

        });
})