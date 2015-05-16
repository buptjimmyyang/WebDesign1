<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="bean.r_score" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
     </head>
  
  <body>
  <% ArrayList<r_score> datas=(ArrayList<r_score>)session.getAttribute("r_score");%>
  <center>
  <table border="1" width="550" style="text-align:center;align:center;">
 
  <tr><td>行号</td><td>学号</td><td>班级</td><td>课程</td><td>题目</td><td>分数</td></tr>
 <%for(int i=0;i<datas.size();i++){ %>
 <tr><td><%out.print(i+1); %></td><td><%out.print(datas.get(i).getS_id()); %></td>
 <td><%out.print(datas.get(i).getGrade()); %></td><td><%out.print(datas.get(i).getC_name()); %></td>
 <td><%out.print(datas.get(i).getTitle()); %></td><td><%out.print(datas.get(i).getScore()); %></td></tr>
 <%} %>
  </table>
  </center>
  </body>
</html>
