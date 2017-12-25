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
    
    <title>My JSP 'showMyProfeedback.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <div>
  <% Map<Object,Projects> map=(Map<Object,Projects>)request.getAttribute("myPro"); 
      if(map==null||map.size()==0){
      %>
      <h1>查无数据</h1>
  <%
      }
      else{
   %>
  <h1>我的反馈</h1>
  <table border="1">
  <tr><td>项目编号</td><td>项目名称</td><!-- <td>反馈时间</td> --><td>操作</td></tr>
  <%for(Projects project : map.values()){ %>
  <tr>
  <td><%=project.getProNo() %></td>
  <td><%=project.getProName() %></td>
<%--   <td><%=project.getProTime() %></td> --%>
  <td><a href="/FinalWork/findProServlet?proNo=<%=project.getProNo() %>">查看</a></td>
  <%
  }
  %>
  <%
  }
  %>
  </table>
  </div>
  <div class="left">
  <%@include file="/Tree.jsp" %>
  </div>
  </body>
  
</html>











