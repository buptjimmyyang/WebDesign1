<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="bean.reply" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    </head>
  
  <body>
  
  <%
    int i=0;
    ArrayList<reply> reply=null;
    try{
    reply= (ArrayList<reply>)session.getAttribute("essay_content") ;
    }
    catch(Exception e){}
    int essay_id=(Integer)session.getAttribute("essay_id");
   %>
  
   <%out.print("<a href=\"add_reply.jsp\" style=\"text-align:right;\">");
   out.print("添加回复");
  out.print("</a>");
   %>
  
  <% for(i=0;i<reply.size();i++)
  {
  %>
  <%out.print(" <hr size=\"1\" width=\"100%\" color=\"green\" noshade=\"noshade\" />"); %>
 
  
  <%
  if(reply.get(i).getType().equals("老师"))
  {
  out.print("<div style=\"color:red; \">");
  out.println("教师号:"+reply.get(i).getId());
  %>
  
 <br>
<br>
  内容:<br>
 <h3><%out.print("  "+reply.get(i).getContent()+"<br>"); %></h3>
 
  <%
  out.print("<p style=\"text-align:right;\">");
  out.print("发表时间:"+reply.get(i).getDatetime()+"<br>");
   out.print("</p>");
  
  out.print("</div>");
  }
  else
  {out.print("<div style=\" \">");
  out.println("学生号:"+reply.get(i).getId());
  %>
  <br>
<br>
  内容:<br>
 <h3><%out.print("  "+reply.get(i).getContent()+"<br>"); %></h3>
 
  <%
  out.print("<p style=\"text-align:right;\">");
  out.print("发表时间:"+reply.get(i).getDatetime()+"<br>");
   out.print("</p>");
  
  out.print("</div>");
  }
  }
  
  %>
   <hr size="1" width="100%" color="green" noshade="noshade" /><!-- 添加横线 -->
  <br>
   <div style="position:absolute;bottom:60px;left:450px;">
    <s:iterator id="page" value="{1,2,3,4,5}">
 <a href="essay_content.action?&essay_id=<s:property value="#session.essay_id"/>&currentpage=<s:property value="#page"/>">
 <s:property value="#page"/>
 </a>&nbsp;
 
  </s:iterator>
  </div>
  </body>
</html>
