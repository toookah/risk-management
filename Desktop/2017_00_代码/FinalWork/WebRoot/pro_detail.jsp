<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="ouc.sms.entity.Projects"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'pro_detail.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
 <link rel="stylesheet" type="text/css" href="css/new.css">
  </head>
  
  <body>
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
     <h1 align="center">检查单详情</h1>
     <br>
      <br>

  <div>
    <% 
      Map<Object, Projects> map=(Map<Object, Projects>)request.getAttribute("waitProjects");       
//       Object obj=request.getAttribute("mngDepNo");
//       int mngno=Integer.parseInt(String.valueOf(obj));
  
      Object obj1=request.getAttribute("prono");
      int prono=Integer.parseInt(String.valueOf(obj1));

      if(map==null||map.size()==0){
   %>
    	<h1>查无数据</h1>
   <% 	
      }
      else{
   %>

   <form action="submitProServlet" method = "post">
   <% 
      for(Projects pro : map.values()){
          if(pro.getProNo()==prono){
   %>
   <table border="0" align="center">
   <tr>
	
		<td width="30%" align="right">项目编号</td>
		<td><input type="text" name="prono" value=<%=pro.getProNo()%> size="10" readonly="readonly" /></td>
	</tr>
	<tr>
	
		<td width="30%" align="right">项目名称</td>
		<td><input type="text" name="proname" value=<%=pro.getProName()%> size="10" readonly="readonly" /></td>
	</tr>
	<tr>
	
		<td width="30%" align="right">风险编号</td>
		<td><input type="text" name="riskno" value=<%=pro.getRsNo()%> size="10" readonly="readonly" /></td>
	</tr>
	<tr>
		<td align="right">负责部门</td>
		<td ><input type="text" name="department" value=<%=pro.getProNo()%> size="10" readonly="readonly" /></td>
	</tr>
	<tr>
		<td width="30%" align="right">创建时间</td>
		<td><input type="text" name="date" value=<%=pro.getProTime()%> size="10" readonly="readonly" /></td>
	</tr>
	<tr>
		<td width="30%" align="right">项目描述</td>
		<td><textarea name="demmand" style="width:200px;height:80px;" readonly="readonly"><%=pro.getProDesc()%></textarea></td>
	</tr>
	<tr>
		<td width="30%" align="right">项目措施</td>
		
		<td ><textarea name="method" style="width:200px;height:80px;" >负责部门填写</textarea></td>

	</tr>
	<tr>
		<td align="right">项目要求</td>
		<td><textarea name="demmand" style="width:200px;height:80px;" readonly="readonly">监管部门填写</textarea></td>

	</tr>	
	<tr>
		<td align="right"></td>

		<td><input type="submit" value="提交"></td>

	</tr>	
</table>
      
    <% 	    
    	  }else{
    	  }
      }
    %>
     </form>
    <%
      }
    %>
   </div>
   <br>
      <br>
    <br>
    <br>
    <br>
  <div align="center">
  <%@include file="/Tree.jsp" %>
  </div>
  </body>
  </body>
</html>
