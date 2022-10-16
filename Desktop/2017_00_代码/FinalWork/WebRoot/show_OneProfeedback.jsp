<%@page import="ouc.sms.entity.Projects"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'showOneProfeedback.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
<body align="center">
<% Projects project=(Projects)request.getAttribute("onePro"); %>

  <h1>反馈单</h1>
  整改项目编号：<input type="text" value="<%=project.getProNo() %>" readonly="readonly"> <br>
  整改项目名称：<input type="text" value="<%=project.getProName() %>" readonly="readonly"> <br>
  创建时间：<input type="text" value="<%=project.getProTime() %>" readonly="readonly"> <br>
  风险类型：<input type="text" value="<%=project.getRsNo() %>" readonly="readonly"> <br>
  风险评分：<input type="text" value="<%=project.getProScore() %>" readonly="readonly"> <br>
  项目负责人：<input type="text" value="<%=project.getMngNo() %>" readonly="readonly"> <br>
  整改项目描述：<input type="text" value="<%=project.getProDesc() %>" readonly="readonly"> <br>
  隐患整改措施：<input type="text" value="<%=project.getProMethod() %>" readonly="readonly"> <br>
  整改项目评价：<input type="text" value="<%=project.getProDmd() %>" readonly="readonly"> <br>  

  </body>
</html>
