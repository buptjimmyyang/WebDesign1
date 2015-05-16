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
 
<h2 style="text-align:center;">作业评分</h2>
    <br>
    <center>
    <form action="submit_evaluate_set">
    所授课程:<select name="t_course">
    <%ArrayList<String> course=null;
  try{
 
  course=(ArrayList<String>)session.getAttribute("course");}
   catch(Exception e)
   {
   out.print("错误");
   }
for(int i=0;i<course.size();i++)
{
 %>
 <option>
 <% out.print(course.get(i));%>
 </option>
 <% }%>
    </select>
    已发题目:<select name="t_title">
  <%ArrayList<String> title=null;
  try{
 
  title=(ArrayList<String>)session.getAttribute("title");}
   catch(Exception e)
   {
   out.print("错误");
   }
for(int i=0;i<title.size();i++)
{
 %>
 <option>
 <% out.print(title.get(i));%>
 </option>
 <% }%>
  </select>
  选课班级:<select name="t_grade">
  <%ArrayList<String> grade=null;
  try{
 
  grade=(ArrayList<String>)session.getAttribute("grade");}
   catch(Exception e)
   {
   out.print("错误");
   }
for(int i=0;i<grade.size();i++)
{
 %>
 <option>
 <% out.print(grade.get(i));%>
 </option>
 <% }%>
  </select>
  <button type="submit">打分</button>
  </form>
    </center>
  </body>
</html>
