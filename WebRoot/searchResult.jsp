<%@ page language="java" import="java.util.*,com.alibaba.fastjson.JSON,
com.alibaba.fastjson.JSONArray,com.alibaba.fastjson.JSONObject,systemVo.*" pageEncoding="utf-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Search Result</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	
	<link rel="stylesheet" type="text/css" href="./dist/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="./style/head_foot.css">
	<link rel="stylesheet" type="text/css" href="./style/result.css">
	
	<script type = "text/javascript" src="./js/jquery1.11.1.min.js"> </script>
	<script type = "text/javascript" src="./dist/js/bootstrap.min.js"> </script>

  </head>
  
  <body>
  <!-- <img class="background_img" src="img/shuimo.jpg" alt="background"> -->
  <div class="content_box">
	<div class="header">
		<a href="./searchChartStatistics.jsp" class="word_statistics">查询词数据统计</a>
		<div class="search_box">
		  	<form id="searchForm" name = "keywd" action="ParentsSearcher?service=search" method="post" >	
			  <div class="col-lg-8 inputbox">
			    <div class="input-group">
			      <input type="text" class="form-control" name="keywords" id="input" placeholder="please input the keywords" />
			      <span class="input-group-btn">
			        <button class="btn btn-default" type="submit">Search</button>
			      </span>
			    </div><!-- /input-group -->
			  </div><!-- /.col-lg-6 -->
			</form>
		</div>
	</div>
	<div class="body">
  	<% 
	request.setCharacterEncoding("utf-8");
	List<RobotVo> result = (List<RobotVo>)session.getAttribute("pageResult");
	// list 不同直接判断为空，应判断是否长度为0
	if(result!=null && result.size()!=0){
		int pageIndex;
		if(request.getAttribute("pageIndex")==null){
			pageIndex=1;
		}else{
			pageIndex = Integer.parseInt(request.getAttribute("pageIndex").toString());
		}
		int totelNum = Integer.parseInt(session.getAttribute("totalNumOfPat").toString());
		String field = session.getAttribute("inTheFiled").toString();
		String keywd = session.getAttribute("keywords").toString();
		%>
		<div class="search_summary">
			<p>About <%=totelNum%> results<span class="verline">|</span> the keywords are <%=keywd%><span class="verline">|</span> in the filed of <%=field%></p>
		</div>
		<hr class="search_line">
		<div class="search_result">
		<%
		Iterator<RobotVo> iter = result.iterator();
		RobotVo robot;
		int i = 0;
		while(iter.hasNext()){
			robot = (RobotVo)iter.next();
			
	   	%>
	   	
		     <div class="one_result">
				<a href="SpicificServlet?objectNo=<%=i%>">
					<h4 class="result_title">
						 <%=robot.getTitle() %>
					</h4>
				</a>
				<p class="result_numbers">
				<b> patern number:</b><span> <%=robot.getId() %> </span>
				<span class="verline">|</span>
				<b>inventor name:</b><span><%=robot.getInventorName() %></span>
				<span class="verline">|</span>
				<b> US Classification:</b><span><%=robot.getUsClassficationMain() %>  </span>
				</p>
				<p><b>orgnization:</b><%=robot.getAssigneeName() %></p>
				
				<!-- <p class="abstract"><b>abstract:</b><%=robot.getAbst() %></p> -->
				<p class="abstract">
				<b>abstract:</b>System for visually determining position in space 
					and/or orientation in~space and apparatus employing same.
					System for visually determining position in space 
					and/or orientation in~space and apparatus employing same
					System for visually determining position in space 
					and/or orientation in~space and apparatus employing same
					System for visually determining position in space 
					and/or orientation in~space and apparatus employing same
				</p>
			</div>
		<%
			i++;
	   	}

		%>

		<div class="paging">
			<nav>
			  <ul class="pagination">
			  	<li class = "pageIndexhid" style ="display:none"><%=pageIndex%></li>
			  	<li class = "totalNumber" style ="display:none"><%=totelNum%></li>
			    <li ><a href="ParentsSearcher?service=search&&pageIndex=<%=1%>&&keywords=<%=keywd%>">first page</a></li>
			    <li ><a href="ParentsSearcher?service=search&&pageIndex=<%=((pageIndex-1)/5)*5%>&&keywords=<%=keywd%>">&laquo;</a></li>
			    <li><a href="ParentsSearcher?service=search&&pageIndex=<%=((pageIndex-1)/5)*5+1%>&&keywords=<%=keywd%>"><%=((pageIndex-1)/5)*5+1 %></a></li>
			    <li><a href="ParentsSearcher?service=search&&pageIndex=<%=((pageIndex-1)/5)*5+2%>&&keywords=<%=keywd%>"><%=((pageIndex-1)/5)*5+2 %></a></li>
		       	<li><a href="ParentsSearcher?service=search&&pageIndex=<%=((pageIndex-1)/5)*5+3%>&&keywords=<%=keywd%>"><%=((pageIndex-1)/5)*5+3 %></a></li>
		       	<li><a href="ParentsSearcher?service=search&&pageIndex=<%=((pageIndex-1)/5)*5+4%>&&keywords=<%=keywd%>"><%=((pageIndex-1)/5)*5+4 %></a></li>
		       	<li><a href="ParentsSearcher?service=search&&pageIndex=<%=((pageIndex-1)/5)*5+5%>&&keywords=<%=keywd%>"><%=((pageIndex-1)/5)*5+5 %></a></li>
		        <li><a href="ParentsSearcher?service=search&&pageIndex=<%=((pageIndex-1)/5)*5+6%>&&keywords=<%=keywd%>">&raquo;</a></li>
			  </ul>
			</nav>
		</div>
		<script type="text/javascript">
			$(function(){
				$(".paging .pagination li").click(function(){
					$(".paging .pagination li").removeClass("active");
					$(this).addClass("active");
				});
				var pageIndex = $(".paging .pagination li.pageIndexhid").text();
				var totalNum = $(".paging .pagination li.totalNumber").text();
				var list = $(".paging .pagination li a");
				var ulbox = $(".paging .pagination");
				console.log(pageIndex);
				for(var i=0;i<list.length;i++){
					if((list[i].text-1)*20>totalNum){
						list[i].parentElement.style.display="none";
						list[list.length-1].style.display= "none";
					}
					if(list[i].text == pageIndex){
						list[i].parentElement.className="active";
					}else{
						list[i].parentElement.className=" ";
					}
				}
			});
		</script>
	<%
		}else{
	%>
			<h2>there is no result !!!</h2>
	<%	
		}
	%>
		</div>
	</div>
	<div class="footer">
		<p>专利搜索引擎@信息管理学院</p>	
	</div>	
</div>
	<script type="text/javascript">
	$(document).ready(function(){
		var keywd = $("#input")[0];
		var form = $("#searchForm")[0];
		form.onsubmit = function(){
			if (!keywd.value || keywd.value.trim()=="") {
				return false;
			}
		};
	});
	</script>
  </body>
</html>
