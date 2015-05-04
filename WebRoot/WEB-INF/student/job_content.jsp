<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@  page import="bean.t_job" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
  </head>
  
  <body>
  <%
  t_job job=(t_job)session.getAttribute("job_content");
   %>
   <center>作业题目:<%out.print(job.getTitle()); %></center>
   <br>
   作业内容为:
   <br><br>
   <div style="position:absolute;left:50px;">
   <%out.print(job.getContent()); %>
   </div>
   <div style="position:absolute;bottom:20px;left:3px;">
   <br>
   <%if(!job.getReal_title().equals("no")){ 
   out.print("<a href=\"download.action?filepath="+job.getReal_title()+"&filename="+job.getC_name()+"_"+job.getTitle()+"\">"); 
   out.print("点击下载附件");
   out.print("</a>");
   } %>
   </div>
   <br>
  </body>
</html>
