<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--[if lte IE 9]><html class="no-js is-ie"><![endif]-->
<!--[if gt IE 8]><!--><html class=no-js><!--<![endif]-->
<head>
	<meta charset="utf-8">
	<meta name="description" content="BlackTie Free Bootstrap Theme">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">

	

	<title>Appi - Free Bootstrap Theme</title>
	<link rel=stylesheet href="css/main.css">
	<!--[if lte IE 8]>
	<link rel=stylesheet href="css/ie.css">
	<![endif]-->
		<script src="js/vendor/modernizr.js"></script>

		<script src="js/vendor/respond.min.js"></script>

</head>

<body>
 	<%
 	Object msg=request.getAttribute("msg"); 
       String empNo=request.getParameter("empNo");
       %><%--传参返回登陆失败原因 --%>
	<h1><%=(msg==null)?"":msg %></h1><br>
	<div class="level-hero hero-home has-hint" style="text—align:center">


		<div class="hero-overlay  visible-lg" style="text—align:center"></div>
<!-- 
class="container full-height" -->
		<div  style="text—align:center">
			<div class=v-align-parent style="text—align:center">
				<div class="v-center" style="text—align:center">
					<div class="row" style="text—align:center">
						<div class="col-xs-10 col-sm-6" style="text—align:center">
							<h1 class="mb-10 heading">Welcome<span></span></h1>
							
							<br>
							<br>
						</div>
					</div>
					<div>
						<a class="btn btn-prepend btn-launch-video" href="/FinalWork/new_project.jsp">
							<i class="prepended icon-append-play"></i>新增检查单
						</a>
						<a class="btn btn-prepend" href="/FinalWork/show_fead_back.jsp?empNo=<%=empNo %>">
							<i class="prepended icon-append-iphone"></i>我的反馈		
								</a>
							<a class="btn btn-prepend" href="/FinalWork/waitAuditProServlet">
							<i class="prepended icon-append-iphone"></i>待监检查单<br>	
							</a>
							<a class="btn btn-prepend" href="/FinalWork/sup_dealt_pro.jsp">
							<i class="prepended icon-append-iphone"></i>已发检查单
							</a>
							<a class="btn btn-prepend" href="/FinalWork/sup_finish_pro.jsp">
							<i class="prepended icon-append-iphone"></i>合格检查单</a>
		
									<br>
							<br>
									<br>
							<br>
									<br>
							<br>
									<br>
							<br>
									<br>
							<br>
									<br>
							<br>
									<br>
							<br>
					</div>
					 <%@include file="/Tree.jsp" %>
				</div>
			</div>

			<div class=hint-arrow></div>
		</div>
	</div>
	
	

</body>
</html>
