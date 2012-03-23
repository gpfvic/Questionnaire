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
    <base href="<%=basePath%>">
    
    <title>Register process</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>

<%
String uname=request.getParameter("uname");
String pwd=request.getParameter("pwd");
String age="100";
String sex="Male";

boolean result = link.register(uname, pwd, age, sex);
if(result){
	session.setAttribute("regResult", "");
	response.sendRedirect("login.jsp");
}
else{
	session.setAttribute("regResult", "The user name has been registered!");
	response.sendRedirect("register.jsp");
}
%>
  
  <body>
  <form action="register">
  	
  
  </form>
  </body>
</html>
