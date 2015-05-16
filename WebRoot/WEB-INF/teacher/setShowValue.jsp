<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   </head>
  
  <body>
  <center>
   <form action="showvalue" method="post">
   </br> </br> </br>
   选择班级:<select name="grade">
   <%ArrayList<String> grades=(ArrayList<String>)session.getAttribute("grade") ;
   int i;
   for( i=0;i<grades.size();i++)
   {
   %>
   <option><%out.print(grades.get(i)); %></option>
   <%} %>
   </select>
   <button type="submit">提交查询</button>
   </form>
   </center>
  </body>
</html>
