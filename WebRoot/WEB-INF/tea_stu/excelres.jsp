<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   </head>
  
  <body>
   <h1><s:property value="excelWorkSheet.sheetName" /> </h1>  
  <p>  
    <s:iterator value="excelWorkSheet.columns">  
        <s:property />  ||   
    </s:iterator>  
  </p>  
    
  <s:iterator var="user" value="excelWorkSheet.data">  
    <p>  
        <s:property value="#user.id"/>     
        <s:property value="#user.type"/>     
        <s:property value="#user.password"/>     
            
    </p>  
  </s:iterator>  
  </body>
</html>
