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
padding:10px;
text-decoration:none;
text-transform:uppercase;
}
a:hover,a:active
{
background-color:#cc0000;
}
</style>
<link type="text/css" href="css/date.css" rel="stylesheet"/>
	
</head>

<body>
<ul>
<li><a href="fileup.action" target="right">上传作业</a></li>
<li><a href="#news">查看上传历史</a></li>
<li><a href="#contact">作业问答</a></li>
<li><a href="#about">查看作业分数</a></li>
<li><a href="#about">修改密码</a></li>
<li><a href="#about">退出登录</a></li>
</ul>

<div id="CalendarMain">
			<div id="title"><a class="selectBtn month" href="javascript:" onclick="CalendarHandler.CalculateLastMonthDays();"><</a><a class="selectBtn selectYear" href="javascript:" onClick="CalendarHandler.CreateSelectYear();">2014年</a><a class="selectBtn selectMonth" onClick="CalendarHandler.CreateSelectMonth()">6月</a> <a class="selectBtn nextMonth" href="javascript:" onClick="CalendarHandler.CalculateNextMonthDays();">></a><a class="selectBtn currentDay" href="javascript:" onClick="CalendarHandler.CreateCurrentCalendar(0,0,0);">今天</a></div>
			<div id="context">
				<div class="week">
					<h3> 一 </h3>
					<h3> 二 </h3>
					<h3> 三 </h3>
					<h3> 四 </h3>
					<h3> 五 </h3>
					<h3> 六 </h3>
					<h3> 日 </h3>
				</div>
				<div id="center">
					<div id="centerMain">
						<div id="selectYearDiv"></div>
						<div id="centerCalendarMain">
							<div id="Container"></div>
						</div>
						<div id="selectMonthDiv"></div>
					</div>
				</div>
				<!--<div class="item"><a>1</a></div> <div class="item"><a>2</a></div> <div class="item currentItem"><a>3</a></div> <div class="item"><a>4</a></div> <div class="item"><a>5</a></div> <div class="item"><a>6</a></div> <div class="item"><a>7</a></div>--></div>
			<div id="foot"><a id="footNow">19:14:34</a></div>
		</div>
		
		
	
</body>
<!--<script src="http://www.pengyaou.com/jquery-1.4.min.js">
		</script>  -->
<script type="text/javascript" src="js/date1.js">

</script>
		<script type="text/javascript" src="js/date.js">
		
		</script>
</html>