<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
    <title>My JSP 'fileup.jsp' starting page</title>
 </head>
  
  <body>
    
  
  
  <center> 
  选择课程: <select name="f_course">
<%ArrayList<String> l1=null;
  try{
 
  l1=(ArrayList<String>)session.getAttribute("course");}
   catch(Exception e)
   {
   out.print("错误");
   }
for(int i=0;i<l1.size();i++)
{
 %>
 <option>
 <% out.print(l1.get(i));%>
 </option>
 <% }%>
  </select>
  选择老师: <select name="f_teacher">
 <%ArrayList<String> l2=null;
  try{
 
  l2=(ArrayList<String>)session.getAttribute("teacher");}
   catch(Exception e)
   {
   out.print("错误");
   }
for(int i=0;i<l2.size();i++)
{
 %>
 <option>
 <% out.print(l2.get(i));%>
 </option>
 <% }%> 
  
  </select>
  选择题目: <select name="f_title">
  <%ArrayList<String> l3=null;
  try{
 
  l3=(ArrayList<String>)session.getAttribute("title");}
   catch(Exception e)
   {
   out.print("错误");
   }
for(int i=0;i<l3.size();i++)
{
 %>
 <option>
 <% out.print(l3.get(i));%>
 </option>
 <% }%></select>
  </center>
    文件上传页面. <br>
  </body>
</html>
