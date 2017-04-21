<%@ page language="java" import="java.util.*,com.alibaba.fastjson.JSON,
com.alibaba.fastjson.JSONArray,com.alibaba.fastjson.JSONObject,systemVo.*" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>result</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="./dist/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="./style/head_foot.css">
	<link rel="stylesheet" type="text/css" href="./style/perResult.css">
	<script type = "text/javascript" src="./js/jquery1.11.1.min.js"> </script>
	<script type = "text/javascript" src="./dist/js/bootstrap.min.js"> </script>
	
  </head>
  
  <body>
  <%
  	request.setCharacterEncoding("utf-8");
	List<RobotVo> result = (List<RobotVo>)session.getAttribute("Result");	
	int index = Integer.parseInt(request.getParameter("objectNo"));
	RobotVo oneResult = result.get(index);
	String BeIndexed = (String) oneResult.getReferencePatentId();
	
	%>
  	<div class="content_box">
		<div class="header">
			<h3>搜索结果显示</h3>
		</div>
		<div class= "body content_height">
			<h3 class="title"><%=oneResult.getTitle() %></h3>
			<div class="summary">
				<p><span>[Patent ID] </span><%=oneResult.getId() %>
				<p><span>[Inventor] </span><%=oneResult.getInventorName() %>
				<p><span>[Inventor City] </span><%=oneResult.getInventorCity() %>
				<p><span>[Inventor State] </span><%=oneResult.getInventorState() %>
				<p><span>[Inventor Country] </span><%=oneResult.getInventorCountry() %>
				<p><span>[Assignee Name] </span><%=oneResult.getAssigneeName() %>
				<p><span>[Assignee City] </span><%=oneResult.getAssigneeCity() %>
				<p><span>[Assignee State] </span><%=oneResult.getAssigneeState() %>
				<p><span>[Issued Date] </span><%=oneResult.getIssuedDate() %>
				<p><span>[Abstract] </span><%=oneResult.getAbst() %>
			</div>
			<div class="summary_number">
				<p>
					<span>[US Classfication Main] </span><%=oneResult.getUsClassficationMain() %>
					<span>[US Classification Further] </span><%=oneResult.getUsClassificationFurther() %>
				</p>
					<p><span>[international Classification] </span><%=oneResult.getInternationalClassification() %>
					<p><span>[cooperative Patent Classification] </span><%=oneResult.getCooperativePatentClassification() %>
				<%
				if(BeIndexed!=null&&!BeIndexed.equals("")){
					String[] IndexPapers = BeIndexed.split("~");
				    int CitedNumber = IndexPapers.length;
				%>	
					<p><span>[Cited Number] </span><%=CitedNumber %>
				<%} %>
				
			</div>
	 	</div>
	 	<div class="footer">
			<p>专利搜索引擎@信息管理学院</p>	
		</div>	
 	</div>
 	<script type="text/javascript">
 		$(function(){
 			window.onresize = function(){
	 			var bodyHeight = document.body.clientHeight;
	 			var windowHeight = window.innerHeight;
	 			var footer = $(".footer");
				if (bodyHeight<windowHeight) {			
					footer.css("position","absolute");
					footer.css("bottom","0px");
				}else{
					footer.css("position","static");
				}
 			};
 			
		});
 	</script>
  </body>
</html>
