<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType= "text/html; charset = utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
    <meta charset="utf-8">
	<title>XPatent注册界面</title>   
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    

	<link rel="stylesheet" type="text/css" href="dist/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="./style/head_foot.css">
	<link rel="stylesheet" type="text/css" href="style/register.css">
	<script type="text/javascript" src="js/jquery1.11.1.min.js"></script>
	<script type="text/javascript" src="js/pageJs/register.js"></script>

  </head>
  <body>
  	<div class="header">
		<h3>XPatent注册界面</h3>
	</div>
	<div class="content">
		<div class="login-box">
		<hr>
		<form id="form1" class="form1" autocomplete="on" method = "post" >
			<div class="input-group">
			  <span class="input-group-addon">name    ：</span>
			  <input required="required" autofocus="on" type="text" name="name" class="form-control">
			</div>
			<div class="input-group">
			  <span class="input-group-addon">email   ：</span>
			  <input required="required" type="email"  name="email" class="form-control" >
			</div>

			<div class="input-group">
			  <span class="input-group-addon">password：</span>
			  <input required="required" pattern="[a-zA-Z0-9_]{3,20}" type="password" name="password" class="form-control password" placeholder="letter Or number Or _">
			</div>
			<div class="input-group">
			  <span class="input-group-addon">password：</span>
			  <input required="required" type="password" class="form-control identify_password" placeholder="identify password">
			</div>
			<div><p class="pwdiff" ></p></div>
			<div class="input-group">
			  <span class="input-group-addon">gender  ：</span>
			  <input required="required" type="radio" value="male" name="gender"  ><label>male</label>
			  <input required="required" type="radio" value ="female" name="gender" ><label>female</label>
			</div>
			<p class="submit">
			<button type="submit" class="btn btn-primary">register</button>
			<button type="reset" class="btn btn-primary">cancle</button>
			</p>
			<a class="back" href="./login.jsp">back to login</a>
		</form>
		</div>
	</div>
  </body>
</html>
