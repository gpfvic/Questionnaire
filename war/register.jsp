<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<jsp:useBean id="link" scope="application" class = "org.afelo.questionnaire.db.DBDao" />
<jsp:setProperty name="link" property="*" />


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<script language="javascript"> 
 function ischeckNum()
 {
  var num = document.getElementById('age').value;
  if( num )
  {
   if( !isNaN( num ) ){
   	// document.form.action = "/poll/vote/regProcess.jsp";
   	// document.form.submit();
    // alert('是数字');
    return true;
   }
   else{
    alert('你输入的数据不是数字');
    document.form1.age.focus();
    return false;
   }
  }
  else
  {
   alert('需输入内容');
   document.form1.age.focus();
   return false;
  }
 }
</script>
  
  
    <base href="<%=basePath%>">
    
    <title>Register page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="/index.css">

  </head>
  
  <body style= "margin:0;">
  <iframe name="neepage" marginwidth="0" marginheight="0" src="./head.html" width="100%" height="80"></iframe>
     <form name="form1" method="post" action="regProcess.jsp">
     <div align="center" valign="middle"> 
    	<table>
			<tr>
				<br><br><br><br><br>
				<td>User name: </td>
				<td><input type="text" name="uname"></input></td>
			</tr>
    		<tr>
				<td>Password: </td>
				<td><input type="password" name="pwd"></input></td>
			</tr>
			<tr>
				<td>Age: </td>
				<td><input type="text" id="age" name="age"></input></td>
			</tr>
			<tr>
				<td>Sex: </td>
				<td><input type="radio" name="sex" value="Male"></input>Male
				<input type="radio" name="sex" value="Female"></input>Female</td>
			</tr>
			<tr>
				<td><input type="submit" value="Register"></td>
				<td>
				<%
				if(session.getAttribute("regResult")!=null){
					if(!session.getAttribute("regResult").equals("")){
						String result = session.getAttribute("regResult").toString();%>
					<%=result %>
				<%
					}
				}
				%>
				<div id="d1" style="display:none"><font color='red'>The user name has been registered!</font></div>
				</td>
			</tr>
    	</table>
    	</div>
    </form>
  </body>
</html>
