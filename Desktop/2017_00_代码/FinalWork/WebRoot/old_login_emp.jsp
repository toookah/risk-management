<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    <title>My JSP 'loginuser.jsp' starting page</title>
	
  </head>
  
  <body>
	<% Object msg=request.getAttribute("msg"); 
	   Object empty=request.getAttribute("empty");
	%><%--传参返回登陆失败原因 --%>
	<h1><%=(msg==null)?"":msg %></h1><br>

	<h1>SMS安全信息管理系统</h1>
	<form action="/FinalWork/loginEmpServlet" method="post">
	用户昵称：<input type="text" name="ncName"><br><br>
	用户密码：<input type="password" name="pwd"><br>
	<h1><%=(empty==null)?"":empty %></h1>
	<input type="submit" value="登录"> 
    </form>
    
    <p align="right">
    <em><a href="/FinalWork/save_register.jsp" target="_blank">还没注册？</a></em>
    </p>
  </body>
</html>









