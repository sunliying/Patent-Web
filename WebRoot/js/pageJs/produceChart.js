$(function(){
	var type = "histogram";
	var elementId = "histogramChart";
	var filePath = "./jsondata/applicant_city.json";
	var ConfigObj = {};
	callChart.drawChart(type,elementId,filePath,ConfigObj);
});
$(function(){
	$(".histogramForm input[type='submit']").click(function(e){
	  var $dataText = $(".config_plan .histogramForm input[name='dataText']").val();
	  if (!$dataText || $dataText.trim()=="") {
	  	return false;
	  }
	  var $title = $(".config_plan .histogramForm input[name='title']").val();
	  var $XAxis = $(".config_plan .histogramForm input[name='XAxis']").val();
	  var $YAxis = $(".config_plan .histogramForm input[name='YAxis']").val();
	  var ConfigObj = {
	  	"title": $title,
	  	"XAxis" : $XAxis,
	  	"YAxis" : $YAxis
	  };
	  var type = "histogram";
  var elementId = "histogramChart";

  $("#histogramChart").empty();
	  autoChart.drawChart(type,elementId,$dataText,ConfigObj);
	  return false;
	});
});
$(function(){
	var type = "pie";
	var elementId = "pieChart";
	var filePath = "./jsondata/applicant_city.json";
	var ConfigObj = {
	  		slicePoint : 10,
	  		text       : "this is the chart's title",
	 		subtext    : "this is the chart's subtext"
	  };
	callChart.drawChart(type,elementId,filePath,ConfigObj);
});
$(function(){
	$(".pieForm input[type='submit']").click(function(e){
	  var $dataText = $(".config_plan .pieForm input[name='dataText']").val();
	  if (!$dataText || $dataText.trim()=="") {
	  	return false;
	  }
	  var $title = $(".config_plan .pieForm input[name='title']").val();
	  var $subtext = $(".config_plan .pieForm input[name='subtext']").val();
	  var $count = $(".config_plan .pieForm input[name='count']").val();
	  var ConfigObj = {
	  	"text": $title,
	  	"subtext" : $subtext,
	  	"slicePoint" : $count
	  };
	  var type = "pie";
	  var elementId = "pieChart";
	  console.log($dataText);
  	$("#pieChart").empty();
	  autoChart.drawChart(type,elementId,$dataText,ConfigObj);
	  return false;
	});
});
$(function(){
	var type = "RegionalDistribution";
	var elementId = "RegionalDistributionChart";
	var filePath = "./jsondata/assignee_countrykeyValueMap.json";
	var ConfigObj = {};
	callChart.drawChart(type,elementId,filePath,ConfigObj);
});
$(function(){
	$(".worldForm input[type='submit']").click(function(e){
	  var $dataText = $(".config_plan .worldForm input[name='dataText']").val();
	  if (!$dataText || $dataText.trim()=="") {
	  	return false;
	  }
	  var $title = $(".config_plan .worldForm input[name='title']").val();
	  var $subtext = $(".config_plan .worldForm input[name='subtext']").val();
	  var $legend = $(".config_plan .worldForm input[name='legend']").val();
	  var ConfigObj = {
	  	"text": $title,
	  	"subtext" : $subtext,
	  	"legend" : $legend
	  };
	  var type = "RegionalDistribution";
  var elementId = "RegionalDistributionChart";

  $("#RegionalDistributionChart").empty();
	  autoChart.drawChart(type,elementId,$dataText,ConfigObj);
	  return false;
	});
});
$(function(){
	var type = "lifeCycle";
	var elementId = "lifeCycleChart";
	var filePath = "./jsondata/lifeCycleTest.json";
	var ConfigObj = {};
	callChart.drawChart(type,elementId,filePath,ConfigObj);
});
$(function(){
	$(".lifeCycleForm input[type='submit']").click(function(e){
	  var $dataText = $(".config_plan .lifeCycleForm input[name='dataText']").val();
	  if (!$dataText || $dataText.trim()=="") {
	  	return false;
	  }
	  var $title = $(".config_plan .lifeCycleForm input[name='title']").val();
	  var $xName = $(".config_plan .lifeCycleForm input[name='xName']").val();
	  var $yName = $(".config_plan .lifeCycleForm input[name='yName']").val();
	  var ConfigObj = {
	  	"text": $title,
	  	"xName" : $xName,
	  	"yName" : $yName
	  };
	  var type = "lifeCycle";
  var elementId = "lifeCycleChart";

  $("#lifeCycleChart").empty();
	  autoChart.drawChart(type,elementId,$dataText,ConfigObj);
	  return false;
	});
});
$(function(){
	var type = "3DHistogram";
	var elementId = "3DHistogramChart";
	var filePath = "./jsondata/testData/test3DHistogram.json";
	var ConfigObj = {
		slicePoint: 3
	};
	callChart.drawChart(type,elementId,filePath,ConfigObj);
});
$(function(){
	$(".3DHistogramForm input[type='submit']").click(function(e){
	  var $dataText = $(".config_plan .3DHistogramForm input[name='dataText']").val();
	  if (!$dataText || $dataText.trim()=="") {
	  	return false;
	  }
	  var $title = $(".config_plan .3DHistogramForm input[name='title']").val();
	  var $slicePoint = $(".config_plan .3DHistogramForm input[name='slicePoint']").val();
	  var ConfigObj = {
	  	"title": $title,
	  	"slicePoint" : $slicePoint
	  };
	  var type = "3DHistogram";
  var elementId = "3DHistogramChart";

  $("#3DHistogramChart").empty();
	  autoChart.drawChart(type,elementId,$dataText,ConfigObj);
	  return false;
	});
});

$(function(){
	var $config_butt = $(".chart_produce .data_desc ul .config_h");
	var $style_butt = $(".chart_produce .data_desc ul .style_h");
	var $config_plan = $(".chart_produce .config_plan");
	var $style_plan = $(".chart_produce .style_plan");
	$config_butt.click(function(e){
		$(this).css("color","blue");
		$style_butt.css("color","#666");
		$style_plan.css("display","none");
		$config_plan.css("display","block");
		return false;
	});
	$style_butt.click(function(e){
		$(this).css("color","blue");
		$config_butt.css("color","#666");
		$config_plan.css("display","none");
		$style_plan.css("display","block");
		return false;
	});
});