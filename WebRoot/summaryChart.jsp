<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>summary chart</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="chart">
	<meta http-equiv="description" content="This is summary chart page">
	
	<link rel="stylesheet" type="text/css" href="./dist/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="./style/head_foot.css">
	<link rel="stylesheet" type="text/css" href="./style/summaryChart.css">
	<script type = "text/javascript" src="./js/jquery1.11.1.min.js"> </script>
	<script type="text/javascript" src="./js/echarts.min.js"></script>
	<script type="text/javascript" src="./js/map/world.js"></script>
    <script type="text/javascript" src="./js/map/countryMap.js"></script>
	<script type = "text/javascript" src="./dist/js/bootstrap.min.js"> </script>
	<script type="text/javascript" src="./js/chart/chartFunction.js"></script>

  </head>
  
  <body>
 	<div class="header">
		<h3>XPatent总体专利数据统计</h3>
		<a href="./index.jsp" class="search">返回搜索</a>
	</div>
    <div class="chartList">
	    <div class="Geographical_statistics">
	    	<h3 class="class_summ">按地域划分专利申请数量统计</h3>
	    	<div class="perlist byCity">
				<script type="text/javascript" src="./js/chart/applicant_city.js"></script>
				<div class="summary">
					<h4 class="title">城市</h4>
					<p class="desc">这一组图片根据不同城市的专利申请数量进行统计</p>
					
				</div>
				<div class="detail">
					<div class="img applicate_city" id="applicate_city"></div>
				</div>
			</div>
			<div class="perlist byCountry">
				<script type="text/javascript" src="./js/chart/applicantCountry.js"></script>
				<div class="summary">
					<h4 class="title">国家</h4>
					<p class="desc">这一组图片主要根据不同国家的专利申请数量进行统计</p>
					
				</div>
				<div class="detail">
					<div class="img time" id="applicantCountry"></div>
				</div>
			</div>
	    </div>
	    <hr>
		<div class="Time_statistics">
	    	<h3 class="class_summ">按时间划分专利申请数量统计</h3>
	    	<div class="perlist byCity">
				<script type="text/javascript" src="./js/chart/application_date.js"></script>
				<div class="summary">
					<h4 class="title">城市</h4>
					<p class="desc">这一组图片根据不同城市的专利申请数量进行统计</p>
					
				</div>
				<div class="detail">
					<div class="img application_date" id="application_date"></div>
				</div>
			</div>
	    </div>
	    <hr>
	    <div class="Name_statistics">
	    	<h3 class="class_summ">按申请机构名划分专利申请数量统计</h3>
	    	<div class="perlist byName">
				<script type="text/javascript" src="./js/chart/assignee_name.js"></script>
				<div class="summary">
					<h4 class="title">申请机构名</h4>
					<p class="desc">这一组图片主要根据申请机构来进行专利数据统计</p>
					</div>
				<div class="detail">
					<div class="img name" id="assignee_name"></div>
				</div>
			</div>
	    </div>
	    <hr>
	    <div class="Classfication_statistics">
	    	<h3 class="class_summ">按分类划分专利申请数量统计</h3>
	    	<div class="perlist byClass">
				<script type="text/javascript" src="./js/chart/international_classification.js"></script>
				<div class="summary">
					<h4 class="title">分类</h4>
					<p class="desc">这一组图片主要根据不同的分类号来统计申请数量</p>
					
				</div>
				<div class="detail">
					<div class="img classx" id="international_classification"></div>
				</div>
			</div>
	    </div>
	    <hr>
	    <div class="Time_region_statistics">
	    	<h3 class="class_summ">按时间和地域划分专利申请数量统计</h3>
	    	<div class="perlist byTimeRegion">
				<script type="text/javascript" src="./js/chart/application_dateassignee_country.js"></script>
				<div class="summary">
					<h4 class="title">地域和时间</h4>
					<p class="desc">这一组图片主要描述申请数量在不同时间段关于申请国家和申请地区的统计</p>
					
				</div>
				<div class="detail">
					<div class="img timeRegion" id="timeRegion"></div>
				</div>
			</div>
	    </div>
	</div>
  </body>
</html>
