/**
* 目的：进行二维数据的转换和处理方法
* 包含：累积和、技术生长率等
*
*/

var chartUtil = (function(){
	function cumulateData(data){
		var name = data.name;
		var count = data.count;
		var cumulation = new Array();
		cumulation[0] = count[0];
		for (var i = 0; i < name.length-1; i++) {
			cumulation[i+1] = count[i+1]+cumulation[i];
		}
		data.count = cumulation;
		return data;
	}
	function rateData(data){
		var name = data.name;
		var count = data.count;
		var rate = new Array();
		rate[0] = 0;
		for (var i = 0; i < name.length-1; i++) {
			rate[i+1] = (count[i+1]-count[i]).toFixed(3)/count[i];
			rate[i+1] = rate[i+1].toFixed(3);
		}
		data.count = rate;
		return data;
	}
	return {
		cumulateData: cumulateData,
		rateData : rateData
	};
})();