<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>  
    <script type="text/javascript" src="./fckeditor/fckeditor.js"></script>
    <script type="text/javascript">
    window.onload=function(){
        var oFCKeditor = new FCKeditor('content') ;
        oFCKeditor.BasePath = "fckeditor/";
        //oFCKeditor.BasePath   = "/FCKEditTest/fckeditor/";
        oFCKeditor.ReplaceTextarea();
         oFCKeditor.
       oFCKeditor.Height = "350px";
        }
    </script>
  </head>  
  <body> 
  <s:if test="hasFieldErrors()">
  <p style="color:red;"><%out.println("文件超出大小限制，请重新上传"); %></p>
  </s:if>
  <form action="publish_job"  method="post" enctype="multipart/form-data">
  <center>
  所授课程:<select name="c_name">
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
 发布班级:<select name="grade">
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
  </center>
  <br>
  <center>
   标题:
  <input name="title"> 
  </center>
 
  <br>
  内容:
  <br>
   <textarea  style="height:350px;width:90%;" name="content">请输入内容</textarea> 
   <br>
   
   <div style="position:absolute;left:20px;bottom:30px;">
   是否添加附件:<br>
   <input type="file" value="添加附件" name="myFile"> 
   </div>
   <br>
   <div style="position:absolute;right:140px;bottom:10px;">
   <button type="submit">发布作业</button> 
   </div> 
   </form>
  </body>  
    
</html>
