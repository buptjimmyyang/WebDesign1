<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
    <form action="add_reply" method="post">
    添加评论:<br>
     <textarea  style="height:350px;width:90%;" name="content">请输入内容</textarea> 
   <br>
     <div style="position:absolute;right:140px;bottom:10px;">
   <button type="submit">发表</button> 
   </div> 
    </form> <br>
  </body>
</html>
