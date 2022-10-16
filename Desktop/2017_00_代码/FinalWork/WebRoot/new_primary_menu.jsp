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
 	<% Object msg=request.getAttribute("msg"); %><%--传参返回登陆失败原因 --%>
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
							<h1 class="mb-10 heading">Your App. <span>Reinvented.</span></h1>
							<div class="subheading mb-20">Lorem Ipsum is simply dummy text of the <br class=hidden-xs>printing and typesetting industry. </div>
						</div>
					</div>
					<div>
						<a class="btn btn-prepend btn-launch-video" href="/FinalWork/new_project.jsp">
							<i class="prepended icon-append-play"></i>新增检查单
						</a>
						<a class="btn btn-prepend" href="/FinalWork/new_project.jsp">
							<i class="prepended icon-append-iphone"></i>我的反馈			
							<a class="btn btn-prepend" href="/FinalWork/new_project.jsp">
							<i class="prepended icon-append-iphone"></i>待办检查单<br>	
							<a class="btn btn-prepend" href=" ">
							<i class="prepended icon-append-iphone"></i>待监检查单	
							<a class="btn btn-prepend" href="/FinalWork/new_project.jsp">
							<i class="prepended icon-append-iphone"></i>复查单	
							<a class="btn btn-prepend" href="/FinalWork/new_project.jsp">
							<i class="prepended icon-append-iphone"></i>合格检查单			</a>
					</div>
					 <%@include file="/Tree.jsp" %>
				</div>
			</div>

			<div class=hint-arrow></div>
		</div>
	</div>
	
	

</body>
</html>
