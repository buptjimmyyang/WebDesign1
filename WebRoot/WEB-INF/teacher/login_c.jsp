<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import="bean.t_job" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    
    <title></title>
   
	
  </head>
  
   <body>
  <h1 align="center">作业通知</h1>
<center>
   <table border="1" width="550" style="text-align:center;align:center;">
   <tr>
   <td>题目</td>
   
   <td>内容</td>
   <td>课程</td>
   <td>布置时间</td>
   </tr>
   <s:iterator id="row" value="records">
   <tr>
   <td> <s:property value="#row.title"/></td>
    <td> <a href="" text-decoration="none">点击查看详细内容</a></td>
     <td> <s:property value="#row.c_name"/></td>
      <td> <s:property value="#row.datetime"/></td>
      </tr>
   </s:iterator>
   </table>
  </center>
  <br>
  <div style="align:bottom;text-align:center;">
 <s:iterator id="page" value="{1,2,3,4,5}">
 <a href="login_c.action?currentrows=<s:property value="#page"/>">
 <s:property value="#page"/>
 </a>&nbsp;
  </s:iterator>
 </div>
  </body>
</html>
