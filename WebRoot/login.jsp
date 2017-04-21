<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>patent login</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="./style/head_foot.css">
	<link rel="stylesheet" type="text/css" href="./style/login.css">

  </head>
<body>
<nav class="nav"></nav>
	<div class="contentbox">
		<div class="header">
			<h3>XPatent登录界面</h3>
		</div>
		<form class="loginbox" action="ParentsSearcher?service=login" method="post">
			<h4>XPatent login</h4>
			<p class="number" ><button></button><input required="required" placeholder="email" type="email" name="emails"></p>
			<p class="passwd" ><button></button><input required="required" type="password" name="password"></p>
			
			<input type="submit" value="submit" name="submit">
			<p>
				<a href="./register.jsp" class="signin">free register</a>
			</p>
			<%
			  	String message = (String)request.getAttribute("message");
			  	if(message!=null){
			   %>
			<p class="info"><%=message %></p>
			<% } %>
		</form>
		<footer>
			<p>
			<span>关于XPatent | </span>
			<span>联系我们 | </span>
			<span>华中师范大学 | </span>
			<span>信息管理学院</span>
			</p>
		</footer>
	</div>
</body>
</html>
