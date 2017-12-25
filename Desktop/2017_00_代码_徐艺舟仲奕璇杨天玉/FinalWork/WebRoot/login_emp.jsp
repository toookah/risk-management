<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'loginuser.jsp' starting page</title>
    
    
	<!-- Meta-Tags -->
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

		<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
	<!-- //Meta-Tags -->


	<link rel="stylesheet" type="text/css" href="csss.css"/>


  </head>
  
  <body>
  
	<% Object msg=request.getAttribute("msg"); %><%--传参返回登陆失败原因 --%>

	<h1>SMS安全信息管理系统</h1>
	<div class="container w3layouts agileits">
		
		<div class="login w3layouts agileits">
	<h2>登录</h2>
		<h3 style="color:white"><%=(msg==null)?"":msg %></h3>
	<form action="/FinalWork/loginEmpServlet" method="post">
	<input type="text" name="ncName" placeholder="用户名"required="">
	<input type="password" name="pwd" placeholder="密码" required=""><br> 
 
    <ul class="tick w3layouts agileits">
				<li>
					<input type="checkbox" id="brand1" value="">
					<label for="brand1"><span></span>记住我</label>
				</li>
			</ul>
			<div class="send-button w3layouts agileits">
				
					<input type="submit" value="登 录">
				
			</div>
			</form>
			<a href="#">记住密码?</a>

			<div class="social-icons w3layouts agileits">
				<p>- 其他方式登录 -</p>
				<ul>
					<li class="qq"><a href="#">
					<span class="icons w3layouts agileits"></span>
					<span class="text w3layouts agileits">QQ</span></a></li>
					<li class="weixin w3ls"><a href="#">
					<span class="icons w3layouts"></span>
					<span class="text w3layouts agileits">微信</span></a></li>
					<li class="weibo aits"><a href="#">
					<span class="icons agileits"></span>
					<span class="text w3layouts agileits">微博</span></a></li>
					<div class="clear"> </div>
				</ul>
			</div>
			<div class="clear"></div>
	</div>
	<div class="clear"></div>
	</div>
	
    <em><a href="/FinalWork/save_register.jsp" target="_blank">还没注册？</a></em>
  
    
  </body>
  
  
</html> 









