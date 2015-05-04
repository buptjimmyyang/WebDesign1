<%@ page language="java" import="java.util.*"  pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <%
 /* 文本框失去焦点事件、获得焦点事件 

onBlur:当失去输入焦点后产生该事件 
onFocus:当输入获得焦点后，产生该文件 
Onchange:当文字值改变时，产生该事件 
Onselect:当文字加亮后，产生该文件 
onpropertychange 当属性改变发生该事件 */
%>
   <title>用户登录</title>
	<script type="text/javascript" src="js/login.js">
   
   </script>
<link type="text/css" href="css/login.css" rel="stylesheet"/>

  </head>
  
  <body >
  <div >
  <h1 align="center" >学生作业管理系统</h1>
  </div>
  <div >
  <table>
  <tr>
  <td width="600px">
  <div>
  <h3 align="center">使用说明</h3>
  <h6>
  <br >
  一、学生端功能：<br><br>
  <blockquote>
1.学生注册模块
<br><br>
<blockquote>
1)	学生注册，只有注册后的学生才能使用本系统<br><br>
2)	学生登陆，利用注册后的账号，密码学生可以登录到本系统<br><br>
3)	修改密码，注册用户可以修改密码<br><br>
</blockquote>

2.作业上传模块<br><br>
<blockquote>
   1)作业上传，学生可以利用此模块上传近期完成的作业<br><br>
   2)批改情况查看，学生可以查看老师对自己作业的批改结果<br><br>
   3)提问作业问题，老师可以通过此模块向教师留言提问关于作业的问题<br><br>
   </blockquote>
   
3.模拟考试模块<br><br>
<blockquote>
   学生可以利用此模块进行模拟测试，模拟考试内容，为管理员添加
   </blockquote>
  </blockquote> 
  
   
  </h6>
<h6>
  
  二、教师端功能：<br><br>
  <blockquote>
1.批改作业模块
<br><br>
<blockquote>
 1)查看作业，老师可以利用此功能查看学生近期上传的专业<br><br>
 2)批改作业，对学生上传的作业进行评分<br><br>

</blockquote>

2.发布公告<br><br>
<blockquote>
   1)发布作业，发布近期作业<br><br>
    2)问题解答，对于近期问题进行回答<br><br>
 
   </blockquote>
   
3.成绩统计<br><br>
<blockquote>
   利用此功能可以统计本次作业的提交情况，以及各个班级同学的分数
   </blockquote>
  </blockquote> 
  
   <br><br>
  </h6><br>
  </div>
  </td>
  <td width="400px">
  <div>
  <form action="login" method="post">
  <table>
  <tr><td width="50px"></td>
  <td id="two"><h6>用户登录</h6></td>
  <td id="three"></td>
   </tr>
  <tr>
  <td width="70px" >账号:</td>
  <td class="two"><input type="text" name="id" id="uid" onblur="unfocusId()" onfocus="onfucusid()"/></td>
  <td class="three"><div id="validateid" style="color:red;"></div></td></tr>
  <tr>
  <td width="70px" >密码:</td>
  <td class="two"><input type="password" name="password"/></td>
  <td class="three"></td></tr>
  <tr>
  <td width="70px">类型:</td>
  <td class="two"><select name="type" >
      <option value="学生" >学生</option>
      <option value="老师" >老师</option>
      <option value="管理员" >管理员</option>
      </select>    </td>
  <td class="three"></td></tr>
  <tr>
  <td width="70px">验证码:</td>
  <td ><input type="text" name="validatecode" id="validateinput" onblur="validatecode1()" onfocus="onfucusid1()"></td>
  <td class="three"><div id="validatetxt" style="color:red;"></div></td></tr>
  
  <tr>
  <td width="70px"></td>
  <td> <img id="img_validation_code" src="validate_code.action" onClick="refresh()"/></td>
  <td class="three"></td></tr>
  <tr>
  <td width="70px"></td>
  <td class="two"> <button type="submit" value="登录" style="width:80px;">登录</button></td>
  </tr>
  </table>
   </form>
  </div>
  </td>
  </tr>
  
  </table>
 
  </div>
  
  
   
  </body>
</html>
