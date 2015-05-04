<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   <title>登录成功</title>
 </head>

 <frameset rows="15%,*"  >

<frame src="t_login.action?dis=0" name="top">

<frameset cols="20%,*">
<frame src="t_login.action?dis=1" name="left">
<frame src="t_login.action?dis=2" name="right">
</frameset>

</frameset>
 
</html>
