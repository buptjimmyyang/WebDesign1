<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   <title>登录成功</title>
 </head>
  
  <body>
  管理员
  <s:property value="#request.id"/>
   <s:property value="#request.password"/>
 
  <s:property value="#request.validatecode"/>
  <s:property value="#validatecode"/>
  <%
  
  //String val=(String)session.getValue("backid");
     out.print("sss"+"sss"+request.getSession().getAttribute("backid"));
   %>
    This is my JSP page. <br>
  </body>
</html>
