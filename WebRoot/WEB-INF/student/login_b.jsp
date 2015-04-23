<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<head>
<style>
ul
{
list-style-type:none;
margin:0;
padding:0;
}
a:link,a:visited
{

display:block;
font-weight:bold;
color:blue;
background-color:#bebebe;
width:300px;
text-align:center;
padding:30px;
text-decoration:none;
text-transform:uppercase;
}
a:hover,a:active
{
background-color:#cc0000;
}
</style>
</head>

<body>
<ul>
<li><a href="#home">上传作业</a></li>
<li><a href="#news">查看上传历史</a></li>
<li><a href="#contact">作业问答</a></li>
<li><a href="#about">查看作业分数</a></li>
<li><a href="#about">修改密码</a></li>
<li><a href="#about">退出登录</a></li>
</ul>
</body>
</html>