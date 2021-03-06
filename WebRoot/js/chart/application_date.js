$(function(){
	var myChart = echarts.init(document.getElementById('application_date'));
        myChart.showLoading();

        $.getJSON('./jsondata/application_date.json', function (data) {
            myChart.hideLoading();

            option = {
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
                    data:['Patent Number'],
                    itemGap: 5
                },
                grid: {
                    top: '12%',
                    left: '1%',
                    right: '10%',
                    containLabel: true
                },
                xAxis: [
                    {
                        type : 'category',
                        data : data.years
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
                        name: 'Patent Number',
                        type: 'bar',
                        data: data.yearCount
                    }]
            };

            myChart.setOption(option);

        });
    });