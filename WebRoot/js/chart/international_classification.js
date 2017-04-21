$(function(){
	var myChart = echarts.init(document.getElementById('international_classification'));
    myChart.showLoading();
    $.getJSON('./jsondata/international_classification.json', function (data) {
    	console.log(data);
        myChart.hideLoading();
        var slicePoint  =10;
        var topTenName = data.name.slice(0,slicePoint);
        var topTenCount = data.count.slice(0,slicePoint);
        var otherName = "others";
        var otherCount = 0;
        for (var i = slicePoint; i < data.count.length; i++) {
        	otherCount += data.count[i];
        }
        // 注意 concat是不能改变现有数组的	
        topTenName = topTenName.concat(otherName);
        topTenCount = topTenCount.concat(otherCount);
        console.log(topTenName);
        var countryCount = [];
        for ( i = 0; i < topTenName.length; i++) {
        	var perCountryCount = {};
        	perCountryCount.name = topTenName[i];
        	perCountryCount.value = topTenCount[i];
        	countryCount[i] = perCountryCount;
        }
        console.log(topTenName);
        console.log(countryCount);
        myChart.setOption(option = {
	    title : {
	        text: '不同分类专利申请数统计（国际分类号）',
	        subtext: '截取前十个分类并将其他放入other中',
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
	});
    });
})