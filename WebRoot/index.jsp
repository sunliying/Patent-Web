<%@ page language="java" import="java.util.*,systemVo.UserVo" pageEncoding="utf-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Patent Search</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="patent,technology pager">
	<meta http-equiv="description" content="This is a search webset about the patent information in recent years">

	<link rel="stylesheet" type="text/css" href="./dist/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="./style/banner.css">
	<link rel="stylesheet" type="text/css" href="./style/index.css">
	<script type = "text/javascript" src="./js/banner.js"> </script>
	<script type = "text/javascript" src="./js/jquery1.11.1.min.js"> </script>
	<script type = "text/javascript" src="./dist/js/bootstrap.min.js"> </script>
	<script type="text/javascript" src="./js/bower_components/requirejs/require.js"></script>
	
	

  </head>
  
  <body>
  <%
  		UserVo user = new UserVo();
  		user = (UserVo)session.getAttribute("user");
  		if(user==null){
  			response.sendRedirect("login.jsp");
  			return;
  		}
  		String name = user.getName();
  		String email = user.getEmail();

  	 %>
	<div class="header">
		<span class="name">欢迎你！<%=name %></span>
		<h3>XPatent</h3>
		<div class="statistics">
			<a href="./summaryChart.jsp" class="st_1">综合数据统计</a>
			<a href="./produceChart.jsp" class="pc_1">生成图片</a>
		</div>
	</div>
  	<form id="searchForm" class="searchForm" name = "keywd" action="ParentsSearcher?service=search" method="post" >	
	  <div class="col-lg-6 inputbox">
	    <div class="input-group">
	      <input type="text" class="form-control" required="required" name="keywords" id="input" placeholder="please input the keywords" />
	      <span class="input-group-btn">
	        <button class="btn btn-default" type="submit">Search</button>
	      </span>
	    </div><!-- /input-group -->
	  </div><!-- /.col-lg-6 -->
	</form>
	<!-- 
	<div class="banner">
        <div id="images" class="images">
            <img class="image" src="img/{{img}}"  alt="yupain">
        </div>
        <script type="text/javascript">
        $(function(){
        	var images = document.getElementById("images");
        	var imagesContent = images.innerHTML;
        	var imgurl = ["pic2.jpg","pic3.jpg","pic1.jpg","pic4.jpg","pic5.jpg","pic6.jpg"];
        	var html = [];
        	for(var i = 0;i<6;i++){
        		var _content = imagesContent.replace("{{img}}",imgurl[i]);
        		html.push(_content);
        	}
        	images.innerHTML = html.join('');
        	
        });
        </script>
         <div class="swhich prev">&lt;</div>  
         <div class="swhich next" >&gt;</div>  
        <ul class="dots">
        <li></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
        </ul>    
    </div>
    
    <script type="text/javascript">
    $(function(){
    	require(["js/banner"], function (b) {
             b.init();
     	});
    }); 
    </script>
     -->
  </body>
</html>
