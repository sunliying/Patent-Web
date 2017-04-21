$(function(){
    var filePath = 'SearchAnalysis?service=date';
    var elementId = 'date';
    var type = "histogram";
    var ConfigObj = {};
    callChart.drawChart(type,elementId,filePath,ConfigObj);
});
$(function(){
    var filePath = 'SearchAnalysis?service=date';
    var elementId = 'dateCumulate';
    var type = "dateCumulateHistogram";
    var ConfigObj = {};
    callChart.drawChart(type,elementId,filePath,ConfigObj);
});
$(function(){
    var filePath = 'SearchAnalysis?service=date';
    var elementId = 'dateRate';
    var type = "dateRateHistogram";
    var ConfigObj = {};
    callChart.drawChart(type,elementId,filePath,ConfigObj);
});
$(function(){
	var type = "pie";
    var filePath = 'SearchAnalysis?service=inventorCountry';
    var elementId = 'inventorCountry';
    var ConfigObj = {
    	slicePoint: 10,
    	text: "cooperative Patent Classification",
    	subtext:"这是subtext"
    };

    callChart.drawChart(type,elementId,filePath,ConfigObj);
});
$(function(){
	var type = "pie";
    var filePath = 'SearchAnalysis?service=usClassficationMain';
    var elementId = 'usClassficationMain';
    var ConfigObj = {
    	slicePoint: 10,
    	text: "usClassficationMain",
    	subtext:"这是subtext"
    };

    callChart.drawChart(type,elementId,filePath,ConfigObj);
});
$(function(){
	var type = "pie";
    var filePath = 'SearchAnalysis?service=assigneeName';
    var elementId = 'assigneeName';
    var ConfigObj = {
    	slicePoint: 10,
    	text: "assigneeName",
    	subtext:"这是subtext"
    };

    callChart.drawChart(type,elementId,filePath,ConfigObj);
});
$(function(){
	var type = "lifeCycle";
    var filePath = 'SearchAnalysis?service=lifeCycle';
    var elementId = 'LCDLifeCycle';
    var ConfigObj = {
    	};

    callChart.drawChart(type,elementId,filePath,ConfigObj);
});
$(function(){
	var type = "name3D";
    var filePath = 'SearchAnalysis?service=name3D';
    var elementId = 'name3DChart';
    var ConfigObj = {
    	};

    callChart.drawChart(type,elementId,filePath,ConfigObj);
});
$(function(){
	var type = "country3D";
    var filePath = 'SearchAnalysis?service=country3D';
    var elementId = 'country3DChart';
    var ConfigObj = {
    	};

    callChart.drawChart(type,elementId,filePath,ConfigObj);
});
$(function(){
	var type = "subject3D";
    var filePath = 'SearchAnalysis?service=subject3D';
    var elementId = 'subject3DChart';
    var ConfigObj = {
    	};

    callChart.drawChart(type,elementId,filePath,ConfigObj);
});