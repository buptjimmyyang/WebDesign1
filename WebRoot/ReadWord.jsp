<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>



<html>
  <head>
  <meta http-equiv="content-type" content="text/html;charset=UTF-8" />
   
  <script type="text/javascript" src="js/easyui/jquery-easyui-1.4.2/jquery.min.js">
 </script>
   <link rel="stylesheet" type="text/css" href="js/easyui/jquery-easyui-1.4.2/themes/default/easyui.css"> 
   <link rel="stylesheet" type="text/css" href="js/easyui/jquery-easyui-1.4.2/themes/icon.css">
   <script type="text/javascript" src="js/easyui/jquery-easyui-1.4.2/jquery.easyui.min.js">
 </script> 
   <script language="JavaScript">  
    function addTab(title, url) {  
        if ($('#home').tabs('exists', title)) {  
            $('#home').tabs('select', title);  
        } else {  
            var content = '<iframe scrolling="auto" frameborder="0" src="'  
                    + url + '" style="width:100%;height:100%;"></iframe>';  
            $('#home').tabs('add', {  
                title : title,  
                content : content,  
                closable : true  
            });  
        }  
    }  
  
    $(document).ready(function() {  
  
    });  
</script>  
<style>  
.footer {  
    width: 100%;  
    text-align: center;  
    line-height: 35px;  
}  
  
.top-bg {  
    background-color: #d8e4fe;  
    height: 80px;  
}  
</style>  
  
  </head>
  
  
  <body class="easyui-layout">
  
  <form action="userup1" method="post" enctype="multipart/form-data">
   <input type="file" name="userup"/>
   <button type="submit">导入</button>
   </form>
    <br>
    
    
    
  
  </body>
</html>
