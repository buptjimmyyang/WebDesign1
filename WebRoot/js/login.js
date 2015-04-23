 
function refresh(){
    var img=document.getElementById("img_validation_code");
    img.src="validate_code.action?"+Math.random();
    }
    
    function putid(){
    v=new XMLHttpRequest();
   
 v.onreadystatechange=function(){
 if(v.readyState==4&&v.status==200)
 {
 x=v.responseXML.getElementsByTagName("date");
 txt="-"
 for(i=0;i<x.length;i++)
 {
 txt=txt+"-"+x[i].firstChild.data;
 }
   //res=v.responseXML.getElementsByTagName("date")[1].firstChild.data;    //获取xml数组值 
     //out="sss"+"sss"+res;
     //v.responseXML.getElementsByTagName("date")[0].childNodes[0].nodeValue
     //v.responseText;
     // request.getSession().getAttribute("backid");
   window.alert(txt);}
 
  
  }   
    v.open("get", "validate_id.action?id=1111",true);
     v.send();
    }
  
   
   
   function unfocusId(){
 var x=document.getElementById("uid");
  
   element=document.getElementById("validateid");
   if(element.length==0)
   element.innerHTML="请输入用户名";
   else
   {
     v=new XMLHttpRequest();
   
 v.onreadystatechange=function(){
 if(v.readyState==4&&v.status==200)
 {out=v.responseText;
 
 element.innerHTML=out;

 }
 
  
  }   
  var action="validate_id.action?id="+x.value;
    v.open("get", action,true);
     v.send();
   }
   }
   
   function onfucusid(){
     element=document.getElementById("validateid");
   element.innerHTML="";
   }
   
     function onfucusid1(){
     element=document.getElementById("validatetxt");
   element.innerHTML="";
   }
     
   function validatecode1(){
   input=document.getElementById("validateinput").value;
   out=document.getElementById("validatetxt");
  v=new XMLHttpRequest();
   
 v.onreadystatechange=function(){
 if(v.readyState==4&&v.status==200)
 {
 
 out.innerHTML=v.responseText;
}   
 }
  var action="validate_input.action?input="+input;
    v.open("get", action,true);
     v.send();
   
   }
 
   