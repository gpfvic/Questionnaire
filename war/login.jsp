<%@ page language="java" import="java.util.*" import="java.sql.*" pageEncoding="UTF-8"%>

<jsp:useBean id="link" scope="application" class = "org.afelo.questionnaire.db.DBDao" />
<jsp:setProperty name="link" property="*" />


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  
<script language="javascript"> 
function register(){
	location.href = "register.jsp";
}
</script>
  
    
    <title>Login page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="/index.css">

  </head>
  
  <body style= "margin:0;">
  <iframe name="neepage" marginwidth="0" marginheight="0" src="../head.html" width="100%" height="80"></iframe>
  	<form method="post" action="logProcess.jsp">
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
				<td></td>
				
				<td><input type="submit" value="Sign in">
				<%if(session.getAttribute("status")!=null){%>
				<font color="red"><%= session.getAttribute("status") %></font>
				<% } %>
				</td>

			</tr>
    	</table>
    	</div>
    </form>
  </body>
</html>
