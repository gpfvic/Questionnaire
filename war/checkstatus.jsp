

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*" %>
<%@ page import="javax.jdo.PersistenceManager" %>
<%@ page import="com.google.appengine.api.users.User" %>
<%@ page import="com.google.appengine.api.users.UserService" %>
<%@ page import="com.google.appengine.api.users.UserServiceFactory" %>
<%@ page import="org.afelo.questionnaire.db.PMF" %>
<%@ page import="org.afelo.questionnaire.db.DBDao" %>
<%@ page import="org.afelo.questionnaire.db.Choice" %>
<%@ page import="javax.jdo.Query" %>



<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">    
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <link rel="stylesheet" type="text/css" href="/index.css">


<script language="javascript">
   function quit(){
    if(confirm("Log off??")){
     window.location.href="logout.jsp";
    }
   }
   function delete_data(){
	   if(confirm("Are you really sure to delete all ")){
		   if(confirm("If deleted, data can't recover again!!!")){
			   
			   window.location.href="deleteKLSDJFOIWJFOSLKDJICVX.jsp;"
			}
		   
	   }
	   
   }
</script>
  </head>
  
<%

   if (session.isNew()) {
       response.sendRedirect("/login.jsp");
   }else{
       Boolean status = (Boolean)session.getAttribute("status");
       if (!status){
           response.sendRedirect("/login.jsp");
       }
   }

%>

  
  <body style= "margin:0;">
  <iframe name="neepage" marginwidth="0" marginheight="0" src="/head.html" width="100%" height="80"></iframe>
 
    
    <input type="button" name="download" value="Download Questionnaire" onclick="location.href = '/fetch_all_data.jsp'">
    <input type="button" name="clear" value="Delete all data" onclick="delete_data();"> 
    
    <form action="/logout.jsp" method="post">
      <div><input type="button" value="Logout"  onclick="quit();"/></div>
    </form>

  </body>
</html>