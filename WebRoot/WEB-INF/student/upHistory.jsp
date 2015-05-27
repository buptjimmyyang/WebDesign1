<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@  page import="bean.s_job" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
  </head>
  
  <body>
  <h2 style="text-align:center;">我的上传历史</h2>
    <br>
    <center>
    <%
    int i=0;
    ArrayList<s_job> l=null;
    try{
    l= (ArrayList<s_job>)session.getAttribute("s_upHistory") ;
    }
    catch(Exception e){}
   %>
   <table  border="1" width="650" style="text-align:center;align:center;">
   <tr>
   <td>文件名</td>
   <td>课程名</td>
   <td width="125px">作业题目</td>
   <td width="150px">下载</td>
   <td>上传时间</td>
   </tr>
   <%for(i=0;i<l.size();i++){ %>
   <tr>
   <td><%out.print(l.get(i).getTitle()); %></td>
   <td><%out.print(l.get(i).getC_name()); %></td>
   <td><%out.print(l.get(i).getTopic()); %></td>
   <%String des=l.get(i).getReal_title();
    String title=l.get(i).getS_id()+"_"+l.get(i).getTitle();
    %>
   <td width="30px"><%out.print("<a href=\"download.action?filepath="+des+"&filename="+title+"\">"); 
   out.print("点击下载文件");
   
   %></a></td>
   <td><%out.print(l.get(i).getDatetime().toLocaleString()); %></td>
   </tr>
   <%} %>
    </table>
    </center>
    <br>
    <br>
    <div style="align:bottom;text-align:center;">
 <s:iterator id="page" value="{1,2,3,4,5}">
 <a href="upHistory.action?currentrows=<s:property value="#page"/>">
 <s:property value="#page"/>
 </a>&nbsp;
  </s:iterator>
 </div>
  </body>
</html>
