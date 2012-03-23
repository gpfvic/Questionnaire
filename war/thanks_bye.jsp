<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%
   if (session.isNew()) {
       session.setAttribute("error_msg", "Please enter the correct Questionnaire Code!");
       response.sendRedirect("/welcome_info.jsp");
   }else{
       Long questionnaireID = (Long)session.getAttribute("questionnaireID");
       if (questionnaireID > 4 || questionnaireID<1){
           response.sendRedirect("/welcome_info.jsp");
       }
   }

%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>General information</title>
    
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">    
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <link rel="stylesheet" type="text/css" href="./index.css">

    <iframe name="neepage" marginwidth="0" marginheight="0" src="./head.html" width="100%" height="80"></iframe>
    
  </head>
  
  <body style= "margin:0;">
  <h1 align="center"><b>Thank you for taking the time to complete this questionnaire!</b></h1>
  <p align="center">
    <input type="button" value="Return back" onClick="location.href='/'">
  </p>
  </body>
</html>
