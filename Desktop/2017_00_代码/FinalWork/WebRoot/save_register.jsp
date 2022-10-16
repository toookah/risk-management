<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'save_register.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

   <link rel="stylesheet" type="text/css" href="css/new.css"/>


  </head>
  
  <body>
  <br>
    <br>
    
      <br>
      
        <br>
        
          <br>
            <br>
  <%Object msg=request.getAttribute("msg"); %>
   <h1><%=(msg==null)?"":msg %></h1>
  <h1 align="center">SMS安全信息管理系统用户注册</h1>
  <h2 align="center">个人信息</h2>
  <form action="/FinalWork/saveRegisterServlet" method="post">
  <table border="0" align="center">
    <tr>
		<td width="30%" align="right">姓名：</td>
		<td><input type="text" name="empName" size="10" /></td>
	</tr>
	<tr>
		<td width="30%" align="right">身份证号:</td>
		<td><input type="text" name="empId" size="20" /></td>
	</tr>
	<tr>
		<td width="30%" align="right">联系方式:</td>
		<td><input type="text" name="phNo"size="20" value="请输入常用联系电话"
		    onfocus="if(value=='请输入常用联系电话'){value=''}"   
            onblur="if(value==''){value='请输入常用联系电话'}" /></td>
	</tr>
    <tr>
		<td width="30%" align="right">邮箱：</td>
		<td><input type="text" name="email" size="20" value="请输入常用邮箱" 
		    onfocus="if(value=='请输入常用邮箱'){this.style='color:gray';value=''}"   
            onblur="if(value==''){value='请输入常用邮箱'}"/></td>
	</tr>
	</table>
	
	<h2 align="center">登录信息</h2>

	<table border="0" align="center">
	<tr>
		<td width="30%" align="right">用户名：</td>
		<td><input type="text" name="ncName" size="10" /></td>
	</tr>
	<tr>
		<td width="30%" align="right">密码：</td>
		<td><input type="password" name="pwd" size="20" /></td>
	</tr>
	</table>
	
	<h2 align="center">职务信息</h2>

	<table border="0" align="center">
    <tr>
		<td width="30%" align="right">职位:</td>
		<td>
		    <select name="eprvl">
	
				<option value="EMP">普通员工</option>
				<option value="MNG">部门负责人</option>
				<option value="SUP">监管人</option>
				<option value="BOS">上级</option>
		</select>
		</td>
	</tr>
	<tr>
		<td width="30%" align="right">部门:</td>
		<td><input type="text" name="depNo" size="10" /></td>
	</tr>
	<tr>
		<td width="30%" align="right">经理:</td>
		<td><input type="text" name="mngNo"  size="10" /></td>
	</tr>
	<tr>
		<td width="30%" align="right"></td>
		<td><input type="submit" name="mngNo" value="注册" size="10" /></td>
	</tr>
  	</table>
  	</form> 	
 
  </body>
</html>