<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <script type="text/javascript" src="js/easyui/jquery-easyui-1.4.2/jquery.min.js"></script>
   <link rel="stylesheet" type="text/css" href="js/easyui/jquery-easyui-1.4.2/themes/default/easyui.css"> 
   <link rel="stylesheet" type="text/css" href="js/easyui/jquery-easyui-1.4.2/themes/icon.css">
   <script type="text/javascript" src="js/easyui/jquery-easyui-1.4.2/jquery.easyui.min.js"></script> 
    <script type="text/javascript" src="js/easyui/jquery-easyui-1.4.2/locale/easyui-lang-zh_CN.js"></script> 
    <title>管理员登录成功</title>
    <style type="text/css">
    a{
    font-size:17px;
    text-decoration:none;;
    }</style>
    <script type="text/javascript">
    $(function(){                                  //页面刚加载完全显示的页面
     $('a').click(function(){                       //console.info(src);在浏览器控制台输出信息
    var src=$(this).attr('title');
    if(src=='student')                    //打开各自的对话框
    $('#add1').dialog('open');
    else if(src=='s_course')
     $('#add2').dialog('open');
      else if(src=='teacher')
      $('#add3').dialog('open');
      else if(src=='course')
        $('#add4').dialog('open');
        else if(src=='search')
        $('#search').dialog('open');
     });
     //提交编辑学生数据
     $('#submit_edit_student').click(function(){
     $('#edit_student_form').form('submit',{
     success:function(data){
     $('#edit_student').dialog('close');
     $('#main_content').datagrid('reload');
     }
     });
     });//提交编辑学生数据
     //提交教师学生数据
     $('#submit_edit_teacher').click(function(){
     $('#edit_teacher_form').form('submit',{
     success:function(data){
     $('#edit_teacher').dialog('close');
     $('#main_content').datagrid('reload');
     }
     });
     });//提交教师学生数据
     //提交查询学生信息
     $('#submit_search').click(function(){
     $('#search_form').form('submit',{
    success:function(data){
    console.info(data);
    $('#search').dialog('close');
    if(data=='student')
    $('#main_content').datagrid({
    url:'search_student.action',
      // fitColumns:true,
       title:'学生信息表',
       
       iconCls:'icon-man',
       toolbar:[{
		iconCls: 'icon-edit',
		text:'修改',
		handler: function(){
		var rowdata=$('#main_content').datagrid('getSelections');
		if(rowdata.length!=1)
		$.messager.show({
		title:'提示信息',
		msg:'不能同时修改多行!!!',
		iconCls: 'icon-tip'
		});
		else
		{
		$('#edit_student').dialog('open');
		$('#edit_student_form').get(0).reset();
		$('#edit_student_form').form('load',{
		id:rowdata[0].id,
		name:rowdata[0].name,
		type:rowdata[0].type,
		grade:rowdata[0].grade
		});
		
		}
		
		}
		},
		{
		iconCls: 'icon-cancel',
		text:'删除',
		handler: function(){
		var rowdata=$('#main_content').datagrid('getSelections');
		if(rowdata.length>0)
		{var ids='';
		for(var i=0;i<rowdata.length;i++)
		{
		ids+=rowdata[i].id+',';
		}
		ids=ids.substring(0, ids.length-1);
		$.post('delete_student.action',{ids:ids},function(data){
		 $('#main_content').datagrid('reload');
		});
		}
		else
		
		$.messager.show({
		title:'提示信息',
		msg:'必须选择一行或者多行删除!!!',
		iconCls: 'icon-tip'
		});
		
		}
		}],
		
		striped:true,//是否显示斑马线
       pagination:true,//是否显示分页工具栏
       rownumbers:true,//是否显示行号
       pagePosition:'bottom',//定义分页工具栏的位置
       pageSize:'5',//设置一页大小
       pageList:[5,10,20,30,40,50],//可供选择的分页
		//singleSelect:true,        //只供单选
      columns:[[
      { field:'ck',
      checkbox:true},{
     
      field:'id',
       title:'用户名',
       width:200,
       align:'center'
       },
       {
       field:'name',
       title:'姓名',
       width:200,
       align:'center'
       }
       ,{
       field:'type',
       title:'类型',
       width:200,
       align:'center'
       }
       ,{
       field:'grade',
       title:'班级',
       width:200,
       align:'center'
       }
       ]]
    });
    else if(data=='teacher')
      $('#main_content').datagrid({
    url:'search_teacher.action',
      // fitColumns:true,
       title:'教师信息表',
       
       iconCls:'icon-man',
       toolbar:[{
		iconCls: 'icon-edit',
		text:'修改',
		handler: function(){
		var rowdata=$('#main_content').datagrid('getSelections');
		if(rowdata.length!=1)
		$.messager.show({
		title:'提示信息',
		msg:'不能同时修改多行!!!',
		iconCls: 'icon-tip'
		});
		else
		{
		$('#edit_teacher').dialog('open');
		$('#edit_teacher_form').get(0).reset();
		$('#edit_teacher_form').form('load',{
		id:rowdata[0].id,
		name:rowdata[0].name,
		type:rowdata[0].type,
		institute:rowdata[0].institute
		});
		
		}
		
		}
		},
		{
		iconCls: 'icon-cancel',
		text:'删除',
		handler: function(){
		var rowdata=$('#main_content').datagrid('getSelections');
		if(rowdata.length>0)
		{var ids='';
		for(var i=0;i<rowdata.length;i++)
		{
		ids+=rowdata[i].id+',';
		}
		ids=ids.substring(0, ids.length-1);
		$.post('delete_teacher.action',{ids:ids},function(data){
		 $('#main_content').datagrid('reload');
		});
		}
		else
		
		$.messager.show({
		title:'提示信息',
		msg:'必须选择一行或者多行删除!!!',
		iconCls: 'icon-tip'
		});
		
		}
		}],
		
		striped:true,//是否显示斑马线
       pagination:true,//是否显示分页工具栏
       rownumbers:true,//是否显示行号
       pagePosition:'bottom',//定义分页工具栏的位置
       pageSize:'5',//设置一页大小
       pageList:[5,10,20,30,40,50],//可供选择的分页
		//singleSelect:true,        //只供单选
      columns:[[
      { field:'ck',
      checkbox:true},{
     
      field:'id',
       title:'用户名',
       width:200,
       align:'center'
       },
       {
       field:'name',
       title:'姓名',
       width:200,
       align:'center'
       }
       ,{
       field:'type',
       title:'类型',
       width:200,
       align:'center'
       }
       ,{
       field:'institute',
       title:'所属学院',
       width:200,
       align:'center'
       }
       ]]
    
    });
    else if(data=='s_course')
      $('#main_content').datagrid({
      url:'search_s_course.action',
      // fitColumns:true,
       title:'学生课程信息信息表',
       
       iconCls:'icon-man',
       toolbar:[{
		iconCls: 'icon-edit',
		text:'修改',
		handler: function(){
		
		
		$.messager.show({
		title:'提示信息',
		msg:'暂不提供对学生课程信息的修改!!!',
		iconCls: 'icon-tip'
		});
		
		
		}
		},
		{
		iconCls: 'icon-cancel',
		text:'删除',
		handler: function(){
		var rowdata=$('#main_content').datagrid('getSelections');
		if(rowdata.length>0)
		{var s_ids='';
		var c_ids='';
		for(var i=0;i<rowdata.length;i++)
		{
		s_ids+=rowdata[i].s_id+',';
		c_ids+=rowdata[i].c_id+',';
		}
		
		s_ids=s_ids.substring(0, s_ids.length-1);
		c_ids=c_ids.substring(0, c_ids.length-1);
		console.info(s_ids);
		$.post('delete_s_course.action',{'s_ids':s_ids,'c_ids':c_ids},function(data){//$.post通过键值对的形式向后台传递数据
		 $('#main_content').datagrid('reload');
		});
		}
		else
		
		$.messager.show({
		title:'提示信息',
		msg:'必须选择一行或者多行删除!!!',
		iconCls: 'icon-tip'
		});
		
		}
		}],
		
		striped:true,//是否显示斑马线
       pagination:true,//是否显示分页工具栏
       rownumbers:true,//是否显示行号
       pagePosition:'bottom',//定义分页工具栏的位置
       pageSize:'5',//设置一页大小
       pageList:[5,10,20,30,40,50],//可供选择的分页
		//singleSelect:true,        //只供单选
      columns:[[
      { field:'ck',
      checkbox:true},{
     
      field:'s_id',
       title:'学生号',
       width:200,
       align:'center'
       },
       {
       field:'c_id',
       title:'课程号',
       width:200,
       align:'center'
       }
      
       ]]
    
    });
    else if(data=='course')
      $('#main_content').datagrid({
    url:'search_course.action',
      // fitColumns:true,
       title:'教师课程信息信息表',
       
       iconCls:'icon-man',
       toolbar:[{
		iconCls: 'icon-edit',
		text:'修改',
		handler: function(){
		
		
		$.messager.show({
		title:'提示信息',
		msg:'暂不提供对教师课程信息的修改!!!',
		iconCls: 'icon-tip'
		});
		
		
		}
		},
		{
		iconCls: 'icon-cancel',
		text:'删除',
		handler: function(){
		var rowdata=$('#main_content').datagrid('getSelections');
		if(rowdata.length>0)
		{var c_ids='';
		
		for(var i=0;i<rowdata.length;i++)
		{
		c_ids+=rowdata[i].c_id+',';
		
		}
		
		c_ids=c_ids.substring(0, c_ids.length-1);
		
		
		$.post('delete_course.action',{'c_ids':c_ids},function(data){
		 $('#main_content').datagrid('reload');
		});
		}
		else
		
		$.messager.show({
		title:'提示信息',
		msg:'必须选择一行或者多行删除!!!',
		iconCls: 'icon-tip'
		});
		
		}
		}],
		
		striped:true,//是否显示斑马线
       pagination:true,//是否显示分页工具栏
       rownumbers:true,//是否显示行号
       pagePosition:'bottom',//定义分页工具栏的位置
       pageSize:'5',//设置一页大小
       pageList:[5,10,20,30,40,50],//可供选择的分页
		//singleSelect:true,        //只供单选
      columns:[[
      { field:'ck',
      checkbox:true},{
     
      field:'c_id',
       title:'课程号',
       width:200,
       align:'center'
       },
       {
       field:'t_id',
       title:'教师号',
       width:200,
       align:'center'
       },
        {
       field:'c_name',
       title:'课程名称',
       width:200,
       align:'center'
       }
      
       ]]
    });
    }
    
    
     });
     
     });
     //提交查询信息
     $('#btn1').click(function(){//处理上传student
   $('#form1').form('submit',{
   
   success:function(data){
   //var data=$.parseJSON(data);
   console.info(data+'heheh');
    $('#add1').dialog('close');
     
      
        $('#main_content').datagrid({ //显示数据表格
       url:'huixian.action?table=student',
      // fitColumns:true,
       title:'学生信息表',
       iconCls:'icon-man',
       toolbar:[{
		iconCls: 'icon-add',
		text:'确认添加',
		handler: function(){
		$.ajax({
		url:'excel_Db.action?table=student',
		method:'post',
		success:function(){
		 $.messager.show({
      title:'提示信息',
      content:'添加数据成功',
      iconCls:'icon-ok'
      });
		},
		error:function(data){
       $.messager.show({
      title:'提示信息',
      content:'导入数据失败,部分数据已经存在',
      iconCls:'icon-no'
      });
     }
		
		});
		}
		
		}],//toolbar
	
       striped:true,//是否显示斑马线
       pagination:true,//是否显示分页工具栏
       rownumbers:true,//是否显示行号
       pagePosition:'bottom',//定义分页工具栏的位置
       pageSize:'5',//设置一页大小
       pageList:[5,10,20,30,40,50],
       columns:[[{
       field:'id',
       title:'用户名',
       width:200,
       align:'center'
       },
       {
       field:'name',
       title:'姓名',
       width:200,
       align:'center'
       }
       ,{
       field:'type',
       title:'类型',
       width:200,
       align:'center'
       }
       ,{
       field:'grade',
       title:'班级',
       width:200,
       align:'center'
       }
       ]]
       });         
   },
     error:function(data){
      $('#add1').dialog('close');
     $.messager.show({
      title:'提示信息',
      content:'导入数据失败',
      iconCls:'icon-no'
      });
     }
   });
   });//处理上传学生
   /*$.ajax({
     type:'post',
     url:'add_excel.action',
     cache:false,
     enctype:'multipart/form-data',
     data: $('#form1').serialize(),
     
     dataType:'text',
     success:function(data){
      $('#add1').dialog('close');
      //console.info(data);
      var data=$.parseJSON(data);
      $.messager.show({
      title:'提示信息',
      content:'添加数据成功',
      iconCls:'icon-ok'
      });
      $('#main_content').datagrid({ //显示数据表格
       url:'add_excel.action?table=datagrid',
      // fitColumns:true,
       title:'学生信息表',
       iconCls:'icon-man',
       
       striped:true,//是否显示斑马线
       pagination:true,//是否显示分页工具栏
       rownumbers:true,//是否显示行号
       pagePosition:'bottom',//定义分页工具栏的位置
       columns:[[{
       field:'id',
       title:'用户名',
       width:200,
       align:'center'
       },
       {
       field:'type',
       title:'类型',
       width:200,
       align:'center'
       }
       ,{
       field:'password',
       title:'密码',
       width:200,
       align:'center'
       }]]
       });                 
     },
     error:function(data){
     $.messager.show({
      title:'提示信息',
      content:'添加数据失败',
      iconCls:'icon-no'
      });
     }
     });*/
     //处理上传老师信息
     $('#btn3').click(function(){
   $('#form3').form('submit',{
   
   success:function(data){
   //var data=$.parseJSON(data);
   console.info(data+'heheh');
    $('#add3').dialog('close');
     
      
        $('#main_content').datagrid({ //显示数据表格
       url:'huixian.action?table=teacher',
      // fitColumns:true,
       title:'教师信息表',
       iconCls:'icon-man',
       toolbar:[{
		iconCls: 'icon-add',
		text:'确认添加',
		handler: function(){
		$.ajax({
		url:'excel_Db.action?table=teacher',
		method:'post',
		success:function(){
		 $.messager.show({
      title:'提示信息',
      content:'添加数据成功',
      iconCls:'icon-ok'
      });
		},
		error:function(data){
       $.messager.show({
      title:'提示信息',
      content:'导入数据失败,部分数据已经存在',
      iconCls:'icon-no'
      });
     }
		
		});
		}
		
		}],//toolbar
	
       striped:true,//是否显示斑马线
       pagination:true,//是否显示分页工具栏
       rownumbers:true,//是否显示行号
       pagePosition:'bottom',//定义分页工具栏的位置
       pageSize:'5',//设置一页大小
       pageList:[5,10,20,30,40,50],
       columns:[[{
       field:'id',
       title:'用户名',
       width:200,
       align:'center'
       },
       {
       field:'name',
       title:'姓名',
       width:200,
       align:'center'
       }
       ,{
       field:'type',
       title:'类型',
       width:200,
       align:'center'
       }
       ,{
       field:'institute',
       title:'学院',
       width:200,
       align:'center'
       }
       ]]
       });         
   },
     error:function(data){
      $('#add3').dialog('close');
     $.messager.show({
      title:'提示信息',
      content:'导入数据失败',
      iconCls:'icon-no'
      });
     }
   });
   }); 
      //处理上传老师信息
      
      //教师课程表
      $('#btn4').click(function(){
   $('#form4').form('submit',{
   
   success:function(data){
   //var data=$.parseJSON(data);
   console.info(data+'heheh');
    $('#add4').dialog('close');
     
      
        $('#main_content').datagrid({ //显示数据表格
       url:'huixian.action?table=course',
      // fitColumns:true,
       title:'教师课程信息表',
       iconCls:'icon-man',
       toolbar:[{
		iconCls: 'icon-add',
		text:'确认添加',
		handler: function(){
		$.ajax({
		url:'excel_Db.action?table=course',
		method:'post',
		success:function(){
		 $.messager.show({
      title:'提示信息',
      content:'添加数据成功',
      iconCls:'icon-ok'
      });
		},
		error:function(data){
       $.messager.show({
      title:'提示信息',
      content:'导入数据失败,部分数据已经存在',
      iconCls:'icon-no'
      });
     }
		
		});
		}
		
		}],//toolbar
	
       striped:true,//是否显示斑马线
       pagination:true,//是否显示分页工具栏
       rownumbers:true,//是否显示行号
       pagePosition:'bottom',//定义分页工具栏的位置
       pageSize:'5',//设置一页大小
       pageList:[5,10,20,30,40,50],
       columns:[[{
       field:'c_id',
       title:'课程号',
       width:200,
       align:'center'
       },
       {
       field:'t_id',
       title:'教师号',
       width:200,
       align:'center'
       }
       ,{
       field:'c_name',
       title:'课程名',
       width:200,
       align:'center'
       }
      ]]
       });         
   },
     error:function(data){
      $('#add4').dialog('close');
     $.messager.show({
      title:'提示信息',
      content:'导入数据失败',
      iconCls:'icon-no'
      });
     }
   });
   }); 
      //教师课程表
      //学生选课信息表
       $('#btn2').click(function(){
   $('#form2').form('submit',{
   
   success:function(data){
   //var data=$.parseJSON(data);
   console.info(data+'heheh');
    $('#add2').dialog('close');
     
      
        $('#main_content').datagrid({ //显示数据表格
       url:'huixian.action?table=s_course',
      // fitColumns:true,
       title:'学生选课信息表',
       iconCls:'icon-man',
       toolbar:[{
		iconCls: 'icon-add',
		text:'确认添加',
		handler: function(){
		$.ajax({
		url:'excel_Db.action?table=s_course',
		method:'post',
		success:function(){
		 $.messager.show({
      title:'提示信息',
      content:'添加数据成功',
      iconCls:'icon-ok'
      });
		},
		error:function(data){
       $.messager.show({
      title:'提示信息',
      content:'导入数据失败,部分数据已经存在',
      iconCls:'icon-no'
      });
     }
		
		});
		}
		
		}],//toolbar
	
       striped:true,//是否显示斑马线
       pagination:true,//是否显示分页工具栏
       rownumbers:true,//是否显示行号
       pagePosition:'bottom',//定义分页工具栏的位置
       pageSize:'5',//设置一页大小
       pageList:[5,10,20,30,40,50],
       columns:[[{
       field:'s_id',
       title:'学生号',
       width:200,
       align:'center'
       },
       {
       field:'c_id',
       title:'课程号',
       width:200,
       align:'center'
       }
       
      ]]
       });         
   },
     error:function(data){
      $('#add2').dialog('close');
     $.messager.show({
      title:'提示信息',
      content:'导入数据失败',
      iconCls:'icon-no'
      });
     }
   });
   });  
    //学生选课信息表
     });
  
    </script>
  </head>
      
 <body>
 
   <div id="cc" class="easyui-layout" style="width:100%;height:100%;">   
   <div region="north"  height="100px" collapsible=false title="标题"><h1 style="text-align:center">作业管理系统</h1></div>   
   <div region="west" title="功能菜单" width="20%" collapsible=false iconCls="icon-ok">
   <div class="easyui-accordion" width="100%"  >
				<div title="查看并修改数据" overflow="flase" padding="10px" height="80px"
					iconCls="icon-search" display="none">
					<ul class="easyui-tree" width="100%">
						<li iconCls="icon-man"><a href="#" title="search">按条件查找数据</a></li>
					</ul>
				</div>
				<div title="添加数据" width="100%" overflow="auto" padding="50px"
					height="200px" iconCls="icon-add">
					<ul class="easyui-tree">
						<li iconCls="icon-man"><a href="#" title="student">添加学生数据</a></li>
						<li iconCls="icon-man"><a href="#" title="s_course">添加学生课程数据</a></li>
						<li iconCls="icon-man"><a href="#" title="teacher">添加教师数据</a></li>
						<li iconCls="icon-man"><a href="#" title="course">添加教师课程数据</a></li>
					</ul>
				</div>
				<div title="系统信息" width="100%" overflow="auto" padding="50px"
					height="200px" iconCls="icon-more">
					<ul class="easyui-tree">
						<li iconCls="icon-lock"><a href="login.jsp" >退出系统</a></li>
						
					</ul>
				</div>
			</div>
    </div>   
  <div id="main" region="center" title="主页面" collapsible=false>
   <table id="main_content"></table>
       <div id="search" class="easyui-dialog" title="按条件查找信息"style="width:400px;height:200px;"
				data-options="iconCls:'icon-search',resizable:false,modal:true,closed:true">
               <form id="search_form" action="search" method="post">
               <center>
               </br> </br>
               需查询的表:<select name="table">
               <option value="student">学生表</option>
               <option value="s_course">学生选课表</option>
               <option value="teacher">教师表</option>
               <option value="course">教师课程表</option>
               </select>
               </br> </br>
          输入用户ID:<input name="id"/> 
          </br> </br>
          <a class="easyui-linkbutton" id="submit_search">提交查询</a>   
               </center>
               </form>       
       </div>

			<div id="edit_student" class="easyui-dialog" title="修改学生信息"
				iconCls="icon-edit" style="width:400px;height:200px;" closed="true">
				<form action="updata_student" id="edit_student_form" method="post">
					<table>
						<tr>
							<td>用户名:</td>
							<td><input name="id" type="hidden" /></td>
						</tr>
						<tr>
							<td>姓名:</td>
							<td><input name="name" /></td>
						</tr>
						<tr>
							<td>类型:</td>
							<td><input name="type" /></td>
						</tr>
						<tr>
							<td>班级:</td>
							<td><input name="grade" /></td>
						</tr>
						<tr>
							<td colspan="2"><center>
									<a class="easyui-linkbutton" iconCls="icon-save"
										id="submit_edit_student">保存修改</a>
								</center></td>
						</tr>
					</table>

				</form>
			</div>
			<div id="edit_teacher" class="easyui-dialog" title="修改教师信息"
				iconCls="icon-edit" style="width:400px;height:200px;" closed="true">
				<form action="updata_teacher" id="edit_teacher_form" method="post">
					<table>
						<tr>
							<td>用户名:</td>
							<td><input name="id" type="hidden" /></td>
						</tr>
						<tr>
							<td>姓名:</td>
							<td><input name="name" /></td>
						</tr>
						<tr>
							<td>类型:</td>
							<td><input name="type" /></td>
						</tr>
						<tr>
							<td>所在学院:</td>
							<td><input name="institute" /></td>
						</tr>
						<tr>
							<td colspan="2"><center>
									<a class="easyui-linkbutton" iconCls="icon-save"
										id="submit_edit_teacher">保存修改</a>
								</center></td>
						</tr>
					</table>

				</form>
			</div>

			<div id="add1" class="easyui-dialog" title="添加学生信息"
				style="width:400px;height:200px;"
				data-options="iconCls:'icon-add',resizable:false,modal:true,closed:true">
				<center>
					<form id="form1" action="add_excel.action?table=student"
						method="post" enctype="multipart/form-data">
						<br> <input type="file" name="userup" /> <br> <br>
						<a class="easyui-linkbutton" id="btn1">提交</a>
					</form>
				</center>
			</div>
			<div id="add2" class="easyui-dialog" title="添加学生选课信息"
				style="width:400px;height:200px;"
				data-options="iconCls:'icon-add',resizable:false,modal:true,closed:true">
				<center>
					<form id="form2" action="add_excel.action?table=s_course"
						method="post" enctype="multipart/form-data">
						<br> <input type="file" name="userup" /> <br> <br>
						<a class="easyui-linkbutton" id="btn2">提交</a>
					</form>
				</center>
			</div>
			<div id="add3" class="easyui-dialog" title="添加老师信息"
				style="width:400px;height:200px;"
				data-options="iconCls:'icon-add',resizable:false,modal:true,closed:true">
				<center>
					<form id="form3" action="add_excel.action?table=teacher"
						method="post" enctype="multipart/form-data">
						<br> <input type="file" name="userup" /> <br> <br>
						<a class="easyui-linkbutton" id="btn3">提交</a>
					</form>
				</center>
			</div>
			<div id="add4" class="easyui-dialog" title="添加老师课程信息"
				style="width:400px;height:200px;"
				data-options="iconCls:'icon-add',resizable:false,modal:true,closed:true">
				<center>
					<form id="form4" action="add_excel.action?table=course"
						method="post" enctype="multipart/form-data">
						<br> <input type="file" name="userup" /> <br> <br>
						<a class="easyui-linkbutton" id="btn4">提交</a>
					</form>
				</center>
			</div>
		</div>   
</div>  

  </body>
</html>
