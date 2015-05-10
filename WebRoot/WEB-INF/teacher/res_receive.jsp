<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import="bean.s_job" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
  </head>
  
  <body>
   <%
    int i=0;
    ArrayList<s_job> job=null;
    try{
    job= (ArrayList<s_job>)session.getAttribute("s_job") ;
    }
    catch(Exception e){}
   %>
  <h2 style="text-align:center;">作业提交情况</h2>
  <br>
  <center>
   <table  border="1" width="550" style="text-align:center;align:center;">
   <tr>
   <td>课程名</td>
   <td>题目</td>
   <td>班级</td>
   <td>学生号</td>
   <td>下载</td>
   <td>提交时间</td>
   </tr>
   <%for(i=0;i<job.size();i++){ %>
   <tr>
   <td><%out.print(job.get(i).getC_name()); %></td>
   <td><%out.print(job.get(i).getTopic()); %></td>
   <td><%out.print(job.get(i).getGrade()); %></td>
   <td><%out.print(job.get(i).getS_id()); %></td>
  
   <%String des=job.get(i).getReal_title(); 
   String title=job.get(i).getS_id()+"_"+job.get(i).getTitle();
  
   %>
   <td><%out.print("<a href=\"download.action?filepath="+des+"&filename="+title+"\">"); 
   out.print(job.get(i).getTitle());
   out.print("</a>");
   
   %></td>
   <td><%out.print(job.get(i).getDatetime()); %></td>
   </tr>
   <%} %>
    </table>
    </center>
    <br>
    <br>
    
    <div style="align:bottom;text-align:center;">
 <s:iterator id="page" value="{1,2,3,4,5}">
 <a href="receive_job.action?&currentpage=<s:property value="#page"/>">
 <s:property value="#page"/>
 </a>&nbsp;
 
  </s:iterator>
 </div>
  </body>
</html>
