<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'new_report.jsp' starting page</title>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312"> 
      <link rel="stylesheet" type="text/css" href="css/new.css">
    <style> 
body,select 
{ 
font-size:9pt; 
font-family:Verdana; 
} 
a 
{ 
color:red; 
text-decoration:none; 
} 
a:hover{ 
text-decoration:underline; 
} 
</style> 

<SCRIPT LANGUAGE="JavaScript"> 
<!-- 
function Dsy() 
{ 
this.Items = {}; 
} 
Dsy.prototype.add = function(id,iArray) 
{ 
this.Items[id] = iArray; 
} 
Dsy.prototype.Exists = function(id) 
{ 
if(typeof(this.Items[id]) == "undefined") return false; 
return true; 
} 

function change(v){ 
var str="0"; 
for(i=0;i<v;i++){ str+=("_"+(document.getElementById(s[i]).selectedIndex-1));}; 
var ss=document.getElementById(s[v]); 
with(ss){ 
length = 0; 
options[0]=new Option(opt0[v],opt0[v]); 
if(v && document.getElementById(s[v-1]).selectedIndex>0 || !v) 
{ 
if(dsy.Exists(str)){ 
ar = dsy.Items[str]; 
for(i=0;i<ar.length;i++)options[length]=new Option(ar[i],ar[i]); 
if(v)options[1].selected = true; 
} 
} 
if(++v<s.length){change(v);} 
} 
} 

var dsy = new Dsy(); 

dsy.add("0",["1部","2部","3部","4部"]);//部门名称

dsy.add("0_0",["MNG001","MNG002","MNG003"]); 
dsy.add("0_1",["MNG004","MNG005","MNG006"]); 
dsy.add("0_2",["MNG007","MNG008","MNG009"]); 
dsy.add("0_3",["MNG010","MNG011","MNG012"]); 

//--> 
</SCRIPT> 
<SCRIPT LANGUAGE = JavaScript> 

var s=["s1","s2"]; 
var opt0 = ["负责部门","负责人"]; 
function setup() 
{ 
for(i=0;i<s.length-1;i++) 
document.getElementById(s[i]).onchange=new Function("change("+(i+1)+")"); 
change(0); 
} 
//--> 
</SCRIPT> 

<script type="text/javascript" src="My97DatePicker/WdatePicker.js">
</script> 

  </head>
  
  <body align="center" onload="setup()">
   <% session.setAttribute("newPro",true);  %> <!-- 存入令牌  -->
   	<br>
	<br>
	
	<br>
	<br>
		<br>
	<br>
	
	<br>
	<br>
  <div>
  <% Object msg=request.getAttribute("msg"); %>
	<h1><%=(msg==null)?"":msg %></h1><br>

  <h1>检查单</h1>
  <form action="/FinalWork/saveProServlet" method="post">
  <table border="0" align="center" width="500" height="200">
  <p>
  <tr>
  <td width="70%" align="right" >风险类型：</td>
  <td>
     <select name="rsNo">
        <option value="1">各种应急设备的规范使用</option>
        <option value="2">各种服务设备、尤其是餐车的归为锁定、电器设备的规范使用</option>
        <option value="3">各类安全设备、应急设备和服务设备的数量</option>
        <option value="4">各类安全设备存放位置的检查</option>
     </select>
  </td>
  </tr></p>
  <p>
  <tr>
  <td align="right">负责方：</td>
  <td>
  <select id="s1" name="depno"><option></option></select> 
  <select id="s2" name="mngno"><option></option></select> 
  </td>
  </tr></p>
  <p>
  <tr>
  <td align="right">整改项目名称：</td>
  <td><input type="text" name="proname"></td>
  </tr></p>
    <p>
  <p>
  <tr>
  <td>创建时间:</td>
  <td><input id="endDate" name="protime" readonly="readonly" onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'2008-03-08 11:30:00',maxDate:'2100-03-10 20:59:30'})"
 /></td>
  </tr>
  </p>

  <p>
  <tr>
    <td align="right">整改项目描述：</td>
    <td>
    <textarea rows="8" cols="40" name="prodesc"></textarea>
  </tr></p>
  <tr>
  <td align="right"></td>
  <td><input type="submit" value="创建"></td>
  </form>
  </div>
<%@include file="/Tree.jsp" %>
  </div>
  </tr>

  </table>
  </div>
  </body>
</html>
<%--  <select id="printSelect" onchange="selectPrint()">
    <option select_Print="1" value=""></option>
    <option select_Print="2" value=""></option>
    <option select_Print="3" value=""></option>
  </select>
  <SCRIPT language="javascript">
function selectPrint(form_id,abmfldid,workid){  
  var objS = document.getElementByIdx_xx("printSelect");
  var selectid = objS.options[objS.selectedIndex].select_Print;         
  if(selectid==1){
    openDataReport();
  }else if(selectid==2){     
    printForm();  
  }
}                                                         
</SCRIPT> --%>