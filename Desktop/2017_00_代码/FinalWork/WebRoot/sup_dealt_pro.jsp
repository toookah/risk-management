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
		Map<Object, Projects> waitMap_2=new HashMap();
	    ProDao pd=new ProDao();
		waitMap=pd.findWaitPro(3);
		waitMap_2=pd.findWaitPro(4);
		for(Projects pj:waitMap_2.values()){
		    waitMap.put(waitMap.size()+1, pj);
		}
		
	   if(waitMap==null||waitMap.size()==0){
	   
    %>
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
    
    <h1 >检查单</h1>
    <table border="1" width="600px" align="center"> 
    <tr><td>项目编号</td> <td>项目名称</td>
        <td>风险类型</td> <td>风险数值</td>
        <td>项目描述</td> <td>项目状态</td>
        <td>项目方法</td>
    <%  for(Projects pro : waitMap.values()){ 
    %> 
    
    		<tr>
    		<td><%=pro.getProNo() %></td> 
    		<td><%=pro.getProName() %></td> 
    		<td><%=pro.getRsNo() %></td>
    		<td><%=pro.getProScore()%></td> 
    		<td><%=pro.getProDesc() %></td> 
    		<td><%=pro.getProSta() %></td> 
    		<td><%=pro.getProMethod() %></td> 

    <% 
            
        }   	
    }
    %>
     </div>
  <div class="left">
  <%@include file="/Tree.jsp" %>
  </div>
  </body>
  </body>
</html>
