<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   </head>
  
  <body>
  <center>
  <form action="finish_value_score" method="post">
  <table border="1" width="350" style="text-align:center;align:center;">
  <%ArrayList<Integer> l=(ArrayList<Integer>)session.getAttribute("All_Grade_Id"); 
  int i=0;
  for(i=0;i<l.size();i++)
  {
  %>
  <tr><td><%out.print(i+1); %></td><td>学生学号:<%out.print(l.get(i)) ;%></td><td ><input name="score"style="width:25px" value="0">分</td></tr>
  <%} %>
  
  </table>
  <button type="submit">提交分数</button>
 </form>
  </center>
  </body>
</html>
