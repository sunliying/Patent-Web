<%@ page language="java" import="java.util.*,systemVo.*" pageEncoding="UTF-8" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE>
<html>
  <head>
    
    <title>图片展示页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="图片生成">
	<meta http-equiv="description" content="生成搜索结果图片页面">
	
	<link rel="stylesheet" type="text/css" href="./dist/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="./style/head_foot.css">
	<link rel="stylesheet" type="text/css" href="./style/seachChartStatis.css">
	<script type = "text/javascript" src="./js/jquery1.11.1.min.js"> </script>
	<script type="text/javascript" src="./js/echarts.min.js"></script>
	<script type="text/javascript" src="./js/map/world.js"></script>
    <script type="text/javascript" src="./js/map/countryMap.js"></script>
	<script type = "text/javascript" src="./dist/js/bootstrap.min.js"> </script>
	<script type="text/javascript" src="./js/chart/dataPUtil.js"></script>
	<script type="text/javascript" src="./js/chart/chartFunction.js"></script>
	<script type="text/javascript" src="./js/chart/callChart.js"></script>
	<script type="text/javascript" src="./js/pageJs/searchChartStatistics.js"></script>

  </head>
  
  <body>
  	<% 
	request.setCharacterEncoding("utf-8");
	List<RobotVo> result = (List<RobotVo>)session.getAttribute("allResult");
	// list 不同直接判断为空，应判断是否长度为0
	if(result==null){
		response.sendRedirect("./index.jsp");
	}
		%>
		<div class="header">
			<h3>动态查询结果数据统计</h3>
			<a href="./searchResult.jsp" class="search">返回查询</a>
		</div>
	  <div class="content_box">
		<div class="body">
			<div class="chartBox">
				
				<ul class="nav nav-tabs nav-stacked" id="myTab">
				  <li class="active"><a href="#countTrend">申请量趋势</a></li>
				  <li><a href="#cumulativeAmount">累积申请量</a></li>
				  <li><a href="#technicalGrowthRate">技术增长率</a></li>
				  <li><a href="#geographicalDistribution">地域分布图</a></li>
				  <li><a href="#subjectDistribution">学科分布图</a></li>
				  <li><a href="#applicantDistribution">申请人分布</a></li>
				  <li><a href="#lifeCycle">LCD技术生命周期</a></li>
				  <li><a href="#subject3D">subject3D</a></li>
				  <li><a href="#name3D">name3D</a></li>
				  <li><a href="#country3D">country3D</a></li>
				</ul>
				 
				<div class="tab-content">
				  <div class="tab-pane active" id="countTrend">
					<div class="img date" id="date" style="width: 700px;height:480px;"></div>
				  </div>
				  <div class="tab-pane" id="cumulativeAmount">
					<div class="img date" id="dateCumulate" style="width: 700px;height:480px;"></div>
				  </div>
				  <div class="tab-pane" id="technicalGrowthRate">
				  	<div class="img date" id="dateRate" style="width: 700px;height:480px;"></div>
				  </div>
				  <div class="tab-pane" id="geographicalDistribution">
				  	<div class="img date" id="inventorCountry" style="width: 700px;height:480px;"></div>
				  </div>
				  <div class="tab-pane" id="subjectDistribution">
				  	<div class="img date" id="usClassficationMain" style="width: 700px;height:480px;"></div>
				  </div>
				  <div class="tab-pane" id="applicantDistribution">
				  	<div class="img date" id="assigneeName" style="width: 700px;height:480px;"></div>
				  </div>
				  <div class="tab-pane" id="lifeCycle">
				  	<div class="img date" id="LCDLifeCycle" style="width: 700px;height:480px;"></div>
				  </div>
				  <div class="tab-pane" id="subject3D">
				  	<div class="img date" id="subject3DChart" style="width: 700px;height:480px;"></div>
				  </div>
				  <div class="tab-pane" id="name3D">
				  	<div class="img date" id="name3DChart" style="width: 700px;height:480px;"></div>
				  </div>
				  <div class="tab-pane" id="country3D">
				  	<div class="img date" id="country3DChart" style="width: 700px;height:480px;"></div>
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
