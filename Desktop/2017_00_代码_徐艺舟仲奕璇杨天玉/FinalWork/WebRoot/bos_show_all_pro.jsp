<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="ouc.sms.entity.Projects"%>
<%@page import="ouc.sms.dao.ProDao"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'sup_dealt_pro.jsp' starting page</title>
    
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
  <div>
    <% 
		Map<Object, Projects> waitMap=new HashMap();
		Map<Integer, Projects> waitMap_2=new HashMap();
	    ProDao pd=new ProDao();
	    String choiceStr=request.getParameter("choice");
	    int choice=Integer.valueOf(choiceStr).intValue();
		waitMap=pd.findWaitPro(choice);
		
	   if(waitMap==null||waitMap.size()==0){
	   
    %>
     <br>
    <br>
    <br>
    <br>
    <br>
      <br>
    <br>
    <br>
    <br>
    	<h1>查无数据</h1>
    <% 	
    	}
    	else{
    %>
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
   
    <h1>检查单</h1>
 <br>
 <br>
  <br>
   <br>
    <table border="1" width="600px" align="center"> 
    <tr><td>项目编号</td> <td>项目名称</td>
        <td>风险类型</td> <td>风险数值</td>
        <td>项目描述</td> <td>项目状态</td>
        <td>项目方法</td>
        <td colspan="2" align="center">项目操作</td></tr>
    <%for(Projects pro : waitMap.values()){ %> 
    		<tr>
    		<td><%=pro.getProNo() %></td> 
    		<td><%=pro.getProName() %></td> 
    		<td><%=pro.getRsNo() %></td>
    		<td><%=pro.getProScore()%></td> 
    		<td><%=pro.getProDesc() %></td> 
    		<td><%=pro.getProSta() %></td> 
    		<td><%=pro.getProMethod() %></td> 
    		<td><a href="/FinalWork/proDetailServlet?proNo=<%=pro.getProNo()%>">查看</a></td>
    		</tr>
    <% }   	
    }
    %>
    
    </table>
    </div>
 <div>
  <%@include file="/Tree.jsp" %>
  </div>
  </body>
  </body>
</html>
