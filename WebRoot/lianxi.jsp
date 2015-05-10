<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <script type="text/javascript" src="js/easyui/jquery-easyui-1.4.2/jquery.min.js">
 </script>
   <link rel="stylesheet" type="text/css" href="js/easyui/jquery-easyui-1.4.2/themes/default/easyui.css"> 
   <link rel="stylesheet" type="text/css" href="js/easyui/jquery-easyui-1.4.2/themes/icon.css">
   <script type="text/javascript" src="js/easyui/jquery-easyui-1.4.2/jquery.easyui.min.js">
 </script> 

  </head>
  
  <body>
   <table id="dg" title="My Users" class="easyui-datagrid" style="width:550px;height:250px"
		url="get_users.php"
		toolbar="#toolbar"
		rownumbers="true" fitColumns="true" singleSelect="true">
	<thead>
		<tr>
			<th field="firstname" width="50">First Name</th>
			<th field="lastname" width="50">Last Name</th>
			<th field="phone" width="50">Phone</th>
			<th field="email" width="50">Email</th>
		</tr>
	</thead>
</table>
<div id="toolbar">
	<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newUser()">New User</a>
	<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editUser()">Edit User</a>
	<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyUser()">Remove User</a>
</div>
  </body>
</html>
