<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
  </head>
  
  <body>
   <center>
   <form action="s_commit_update.action" method="post">
   <table>
   <tr>
   <td>请输入原密码:</td>
   <td><input type="password" name="password1"></td>
   </tr>
   <tr>
   <td>输入新密码:</td>
   <td><input type="password" name="password2"></td>
   </tr>
   <tr>
   <td>再次输入密码:</td>
   <td><input type="password" name="password3"></td>
   </tr>
   <br>
   <tr >
   <td colspan="2" ><center><button type="submit"  style="width:80px;">提交</button></center></td></tr>
   </table>
   </form>
   </center><br>
  </body>
</html>
