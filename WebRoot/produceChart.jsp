<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE>
<html>
  <head>
    
    <title>图片添加页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="自动生成统计图">
	<meta http-equiv="description" content="生成统计图">
	
	<link rel="stylesheet" type="text/css" href="./dist/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="./style/head_foot.css">
	<link rel="stylesheet" type="text/css" href="./style/produChart.css">
	<script type = "text/javascript" src="./js/jquery1.11.1.min.js"> </script>
	<script type="text/javascript" src="./js/echarts.min.js"></script>
	<script type="text/javascript" src="./js/map/world.js"></script>
    <script type="text/javascript" src="./js/map/countryMap.js"></script>
	<script type = "text/javascript" src="./dist/js/bootstrap.min.js"> </script>
	<script type="text/javascript" src="./js/chart/dataPUtil.js"></script>
	<script type="text/javascript" src="./js/chart/chartFunction.js"></script>
	<script type="text/javascript" src="./js/chart/callChart.js"></script>
	<script type="text/javascript" src="./js/chart/autoChart.js"></script>
	<script type="text/javascript" src="./js/pageJs/produceChart.js"></script>

  </head>
  
  <body>
  	<div class="header">
		<h3>图片生成页面</h3>
		<a href="./index.jsp" class="search">返回搜索</a>
	</div>
	  <div class="content_box">
		<div class="body">
			<div class="chart_nav">
				<div class="chart_choice">
					<h3>图形选择</h3>
					<ul class="nav nav-tabs nav-stacked" id="myTab">
					  <li class="active">
					  	<a href="#histogram">
							<label for="radio-choice-1">直方图</label>
					  	</a>
					  </li>
					  <li>
					  	<a href="#pie">
					  		<label for="radio-choice-2">饼图</label>
					  	</a>
					  </li>
					  <li>
					  	<a href="#worldChart">
					  		<label for="radio-choice-2">地域分布图</label>
					  	</a>
					  </li>
					  <li>
					  	<a href="#lifeCycle">
					  		<label for="radio-choice-2">LCD技术生命周期图</label>
					  	</a>
					  </li>
					  <li>
					  	<a href="#3DHistogram">
					  		<label for="radio-choice-2">三维直方图</label>
					  	</a>
					  </li>
					</ul>
				</div>
			</div>
			<div class="chart_produce">
				<div class="tab-content">
				  <div class="tab-pane active" id="histogram">
			  		<div class="data_desc">
				  		<ul>
				  			<li class="config_h">选项配置</li>
				  			<li class="style_h">数据格式</li>
				  		</ul>
			  			<div class="plan config_plan">
			  				<div class="histogramForm">
			  					<div class = "formStatistic">
			  						<label for="name">数据：</label>
			  						<textarea cols="40" rows="6" name="dataText" required="required" id="dataText" value="" tabindex="1"></textarea>
			  					</div>
			  					<div>
			  						<label for="name">标题：</label>
			  						<input type="text" name="title" id="title" value="" tabindex="1" />
			  					</div>
			  					<div>
			  						<label for="name">XAxis:</label>
			  						<input type="text" name="XAxis" id="XAxis" value="" tabindex="1" />
			  					</div>
			  					<div>
			  						<label for="name">YAxis:</label>
			  						<input type="text" name="YAxis" id="YAxis" value="" tabindex="1" />
			  					</div>
			  					<div>
			  						<input type="submit" value="Run" />
			  					</div>
			  				</div>
			  				
			  			</div>
			  			<div class="plan style_plan">
<pre class="desc">
data = {
	"name" :["name1","name2","name3"],
	"count":["count1","count2","count3"]
}</pre>			  				
			  			</div>
			  		</div>
			  		<div class="chart_exam">
			  			<div class="chart" id="histogramChart"   style="width: 650px; height: 350px" ></div>
			  		</div>
				  </div>
				  
				  <div class="tab-pane" id="pie">
				  	<div class="data_desc">
				  		<ul>
				  			<li class="config_h">选项配置</li>
				  			<li class="style_h">数据格式</li>
				  		</ul>
			  			<div class="plan config_plan">
			  				<div class="pieForm" >
			  					<div class = "formStatistic">
			  						<label for="name">数据：</label>
			  						<textarea cols="40" rows="6" name="dataText" required="required" id="dataText" value="" tabindex="1"></textarea>
			  					</div>
			  					<div>
			  						<label for="name">标题：</label>
			  						<input type="text" name="title" id="title" value="" tabindex="1" />
			  					</div>
			  					<div>
			  						<label for="name">subtext:</label>
			  						<input type="text" name="subtext" id="subtext" value="" tabindex="1" />
			  					</div>
			  					<div>
			  						<label for="name">slicePoint:</label>
			  						<input type="number" name="count" id="count" value="" tabindex="1" />
			  					</div>
			  					<div>
			  						<input type="submit" value="Run" />
			  					</div>
			  				</div>
			  			</div>
			  			<div class="plan style_plan">
<pre class="desc">
 data = {
		"name" :["name1","name2","name3"],
		"count":["count1","count2","count3"]
}
count 指的是去要确定分类的个数</pre>		  				
			  			</div>
			  		</div>
			  		<div class="chart_exam">
			  			<div class="chart" id="pieChart"  style="width: 650px; height: 350px" ></div>
			  		</div>
				  </div>
				  <div class="tab-pane" id="worldChart">
				  	<div class="data_desc">
				  		<ul>
				  			<li class="config_h">选项配置</li>
				  			<li class="style_h">数据格式</li>
				  		</ul>
			  			<div class="plan config_plan">
			  				<div class="worldForm" >
			  					<div class = "formStatistic">
			  						<label for="name">数据：</label>
			  						<textarea cols="40" rows="6" name="dataText" required="required" id="dataText" value="" tabindex="1"></textarea>
			  					</div>
			  					<div>
			  						<label for="name">标题：</label>
			  						<input type="text" name="title" id="title" value="" tabindex="1" />
			  					</div>
			  					<div>
			  						<label for="name">subtext:</label>
			  						<input type="text" name="subtext" id="subtext" value="" tabindex="1" />
			  					</div>
			  					<div>
			  						<label for="name">legend:</label>
			  						<input type="text" name="legend" id="legend" value="" tabindex="1" />
			  					</div>
			  					<div>
			  						<input type="submit" value="Run" />
			  					</div>
			  				</div>

			  			</div>
			  			<div class="plan style_plan">
<pre class="desc">
data = {
	"keyValueMap": {
		"JP": 8664,
		...
		"KR": 2071
	}
}
</pre>		  				
			  			</div>
			  		</div>
			  		<div class="chart_exam">
			  			<div class="chart" id="RegionalDistributionChart"  style="width: 650px; height: 350px" ></div>
			  		</div>
				  </div>
				  <div class="tab-pane" id="lifeCycle">
				  	<div class="data_desc">
				  		<ul>
				  			<li class="config_h">选项配置</li>
				  			<li class="style_h">数据格式</li>
				  		</ul>
			  			<div class="plan config_plan">
			  				<div class="lifeCycleForm" >
			  					<div class = "formStatistic">
			  						<label for="name">数据：</label>
			  						<textarea cols="40" rows="6" name="dataText" required="required" id="dataText" value="" tabindex="1"></textarea>
			  					</div>
			  					<div>
			  						<label for="name">标题：</label>
			  						<input type="text" name="title" id="title" value="" tabindex="1" />
			  					</div>
			  					<div>
			  						<label for="name">xName:</label>
			  						<input type="text" name="xName" id="xName" value="" tabindex="1" />
			  					</div>
			  					<div>
			  						<label for="name">yName:</label>
			  						<input type="text" name="yName" id="yName" value="" tabindex="1" />
			  					</div>
			  					<div>
			  						<input type="submit" value="Run" />
			  					</div>
			  				</div>
			  			</div>
			  			<div class="plan style_plan">
<pre class="desc">
//  XCount,YCount,Year
data = {
	"series": [
		[815, 34, 2013],
		...
		[1399, 56, 2016]
	]
}</pre>		  				
			  			</div>
			  		</div>
			  		<div class="chart_exam">
			  			<div class="chart" id="lifeCycleChart"  style="width: 650px; height: 350px" ></div>
			  		</div>
				  </div>
				  <div class="tab-pane" id="3DHistogram">
				  	<div class="data_desc">
				  		<ul>
				  			<li class="config_h">选项配置</li>
				  			<li class="style_h">数据格式</li>
				  		</ul>
			  			<div class="plan config_plan">
			  				<div class="3DHistogramForm" >
			  					<div class = "formStatistic">
			  						<label for="name">数据：</label>
			  						<textarea cols="40" rows="6" name="dataText" required="required" id="dataText" value="" tabindex="1"></textarea>
			  					</div>
			  					<div>
			  						<label for="name">标题：</label>
			  						<input type="text" name="title" id="title" value="" tabindex="1" />
			  					</div>
			  					<div>
			  						<label for="name">slicePoint:</label>
			  						<input type="number" name="slicePoint" id="slicePoint" value="" tabindex="1" />
			  					</div>
			  					<div>
			  						<input type="submit" value="Run" />
			  					</div>
			  				</div>
			  			</div>
			  			<div class="plan style_plan">
<pre class="desc">
{
	"year" : [1978,1979,1980,2014,2015,2016],
	"name" : ["country1","country2","country3"],
	//"count": [323,245,134],
	"series":{
		"country1" : [0,2,5,78,90,144],
		"country2" : [2,4,6,80,134,189],
		"country3" : [1,3,6,90,100,167]
	}
}
</pre>		  				
			  			</div>
			  		</div>
			  		<div class="chart_exam 3Dchart">
			  			<div class="chart" id="3DHistogramChart"  style="width: 650px; height: 400px" ></div>
			  		</div>
				  </div>
				</div>
				 
				<script>
				  $('#myTab a').click(function (e) {
				    e.preventDefault();
				    $(this).tab('show');
				  });
				</script>
			</div>
		</div>

	  </div>
  </body>
</html>

