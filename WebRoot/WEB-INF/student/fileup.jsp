<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
 
 
 </head>
  
  <body>
 <center> 
  <s:if test="hasFieldErrors()">
  <p style="color:red;"><%out.println("文件超出大小限制，请重新上传"); %></p>
  </s:if>
 <form action="stu_up" method="post" enctype="multipart/form-data">
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
    <br>
    
   <div style="position:absolute;top:180px;left:300px;">
    上传文件:
    <input type="file" name="myFile">
   
    <input type="submit" value="确认上传"> 
   </div>
  </form> 
  </body>
</html>
