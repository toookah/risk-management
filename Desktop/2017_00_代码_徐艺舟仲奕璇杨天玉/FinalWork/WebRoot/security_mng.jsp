<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'security_mng.jsp' starting page</title>

  </head>
  <body>
  <div>
  <ul>
   <%  Object empNo=request.getParameter("empNo");
  	   Object eprvl=request.getParameter("eprvl");
   %>
   <a href="/FinalWork/privilegeSelectionServlet?empNo=<%=empNo%>&eprvl=<%=eprvl%>"><li>安全信息管理</li></a>
        <a href="#"><li>风险管理</li><a>
        <a href="#"><li>不安全事件调查</li><a>
        <a href="#"><li>突然事件响应</li><a>
        <a href="#"><li>安全绩效检测与评估</li><a>
  </ul>
  </div>
   <div class="left">
  <%@include file="/Tree.jsp" %>
  </div>
  </body>
</html>
