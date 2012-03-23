<%@ page language="java" import="java.util.*" import="java.sql.*"  pageEncoding="UTF-8"%>

<jsp:useBean id="link" scope="application" class = "org.afelo.questionnaire.db.DBDao" />
<jsp:setProperty name="link" property="*" />

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  
<%
String uname = request.getParameter("uname");
String pwd = request.getParameter("pwd");

//boolean result = link.login(uname, pwd);
String username = new String("admin");
String password = new String("sfqryrwxws"); 

boolean result = false;

if (uname.equals(username) && pwd.equals(password)){
	result = true;
}

session.setAttribute("status", result);
if(result){
	session.setAttribute("uname", uname);
	response.sendRedirect("checkstatus.jsp");
}
else{
	response.sendRedirect("login.jsp");
}

%>
  
  
    
    <title></title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  
  </body>
</html>
